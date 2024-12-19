package py.gov.sigor.cow.vac.vacunados.infrastructure.hibernate;

import py.gov.sigor.cow.vac.vacunados.application.LeerVacunadosExcepcion;
import py.gov.sigor.cow.vac.vacunados.application.datos.InfoEspecie;
import py.gov.sigor.cow.vac.vacunados.application.datos.InfoVacunados;
import py.gov.sigor.cow.vac.vacunados.application.datos.VacunadosDatosFind;
import py.gov.sigor.cow.vac.vacunados.domain.VacunacionRepository;
import py.gov.sigor.shared.domain.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
public class JpaVacunacionRepository implements VacunacionRepository {

    public JpaVacunacionRepository() {
    }

    @PersistenceContext
    private EntityManager em;

    @Override
    public <T> T getEntityBean(Class<T> entityClass, Long id) {
        return em.find(entityClass, id);
    }

    @Override
    public InfoVacunados obtenerAnimalesVacunados(VacunadosDatosFind query) {
        InfoVacunados vacunados = new InfoVacunados();

        Query q = em.createQuery(
            "SELECT " +
                "SUM( CASE WHEN csaAftosaPob.vacunada IS NULL THEN 0 ELSE csaAftosaPob.vacunada END ), " +
                "csaAftosaPob.espCategoriaNombre, " +
                "csaAftosaPob.espCategoriaId " +
            "FROM UCsaAftosa csaAftosa " +
            "JOIN csaAftosa.vacAftosa vacAftosa " +
            "JOIN UCsaAftosaPob csaAftosaPob on csaAftosaPob.csaAftosa = csaAftosa " +
            "WHERE vacAftosa.anho = :anho " +
            "AND csaAftosa.estPropAnimId = :estPropAnimId " +
            "AND csaAftosaPob.espCategoriaId IN :categorias " +
            "AND vacAftosa.vacDocEstadoId = :estadoVacDoc " +
            "GROUP BY csaAftosaPob.espCategoriaId, csaAftosaPob.espCategoriaNombre " +
            "ORDER BY csaAftosaPob.espCategoriaId"
        );

        q.setParameter("anho", query.getAnho());
        q.setParameter("estPropAnimId", query.getEstPropAnimId());
        q.setParameter("categorias", Arrays.asList(5L, 6L,7L, 10L));
        q.setParameter("estadoVacDoc", 2);

        List<Object[]> lista = (List<Object[]>) q.getResultList();

        if (lista.isEmpty()) {
            throw new LeerVacunadosExcepcion("No existen vacunados para el estPropAnimId: " + query.getEstPropAnimId() +
                ", en el año: " + query.getAnho());
        }

        for (Object[] obj : lista) {
            InfoEspecie infoEspecie = new InfoEspecie();
            infoEspecie.setCantVacunada( (Long) obj[0] );
            infoEspecie.setNombre((String) obj[1]);
            infoEspecie.setEspCatogoriaId( (Long) obj[2] );
            vacunados.getEspecies().add(infoEspecie);
        }


        return vacunados;
    }

}
