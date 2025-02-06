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
    public InfoVacunados obtenerAnimalesVacunados(VacunadosDatosFind query, Long vacPeriodoId) {
        InfoVacunados vacunados = new InfoVacunados();

        Query q = em.createQuery(
            "SELECT " +
                "SUM( CASE WHEN csaAftosaPob.vacunada IS NULL THEN 0 ELSE csaAftosaPob.vacunada END ), " +
                "SUM( CASE WHEN csaAftosaPob.existente IS NULL THEN 0 ELSE csaAftosaPob.existente END ), " +
                "csaAftosaPob.espCategoriaNombre, " +
                "csaAftosaPob.espCategoriaId " +
            "FROM UCsaAftosa csaAftosa " +
            "JOIN csaAftosa.vacAftosa vacAftosa " +
            "JOIN UCsaAftosaPob csaAftosaPob on csaAftosaPob.csaAftosa = csaAftosa " +
            "WHERE csaAftosa.estPropAnimId = :estPropAnimId " +
            "AND csaAftosa.vacPeriodoId = :vacPeriodoId " +
            "AND csaAftosaPob.espCategoriaId IN :categorias " +
            "AND vacAftosa.vacDocEstadoId IN :estadoVacDoc " +
            "GROUP BY csaAftosaPob.espCategoriaId, csaAftosaPob.espCategoriaNombre " +
            "ORDER BY csaAftosaPob.espCategoriaId"
        );

        q.setParameter("estPropAnimId", query.getEstPropAnimId());
        q.setParameter("vacPeriodoId", vacPeriodoId);
        q.setParameter("categorias", Arrays.asList(7L, 10L, 17L, 18L));
        q.setParameter("estadoVacDoc", Arrays.asList(2L, 9L));

        List<Object[]> lista = (List<Object[]>) q.getResultList();

        if (lista.isEmpty()) {
            throw new LeerVacunadosExcepcion("No existen vacunados para el estPropAnimId: " + query.getEstPropAnimId() +
                ", en el año: " + query.getAnho());
        }

        for (Object[] obj : lista) {
            InfoEspecie infoEspecie = new InfoEspecie();
            infoEspecie.setCantVacunada( (Long) obj[0] );
            infoEspecie.setCantExistente( (Long) obj[1] );
            infoEspecie.setNombre((String) obj[2]);
            infoEspecie.setEspCatogoriaId( (Long) obj[3] );
            vacunados.getEspecies().add(infoEspecie);
        }


        return vacunados;
    }

    @Override
    public Long obtenerPrimerPeriodoAnho(Integer anho) {
        Query query = em.createQuery(
            "SELECT MIN(v.vacPeriodoId) " +
                "FROM UVacPeriodo v " +
                "WHERE YEAR(v.fechaIni) = :year"
        );

        query.setParameter("year", anho);
        List<Long> result = query.getResultList();

        if (!result.isEmpty() && result.get(0) != null) {
            return result.get(0);
        } else {
            throw new LeerVacunadosExcepcion("No se puede obtener el primer periodo del año " + anho);
        }
    }

}
