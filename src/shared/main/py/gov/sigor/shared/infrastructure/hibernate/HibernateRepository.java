package py.gov.sigor.shared.infrastructure.hibernate;


import org.hibernate.SessionFactory;
import py.gov.sigor.shared.domain.Identifier;
import py.gov.sigor.shared.domain.LongValueObject;
import py.gov.sigor.shared.domain.criteria.Criteria;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public abstract class HibernateRepository<T> {
    protected final SessionFactory sessionFactory;
    protected final Class<T> aggregateClass;
    protected final HibernateCriteriaConverter criteriaConverter;

    public HibernateRepository(SessionFactory sessionFactory, Class<T> aggregateClass) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = aggregateClass;
        this.criteriaConverter = new HibernateCriteriaConverter<T>(sessionFactory.getCriteriaBuilder());
    }

    protected void persist(T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
    }


    protected Optional<T> byId(Identifier id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }

    protected Optional<T> byId(LongValueObject id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().byId(aggregateClass).load(id));
    }


    protected Optional<List<T>> executeQuery(String sql) {
        return Optional.ofNullable((List<T>) sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(aggregateClass).list());
    }

    protected List<T> byCriteria(Criteria criteria) {
        try {
            CriteriaQuery<T> hibernateCriteria = criteriaConverter.convert(criteria, aggregateClass);

            return sessionFactory.getCurrentSession().createQuery(hibernateCriteria).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

    }

    protected List<T> all() {
        CriteriaQuery<T> criteria = sessionFactory.getCriteriaBuilder().createQuery(aggregateClass);

        criteria.from(aggregateClass);

        return sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
    }

}
