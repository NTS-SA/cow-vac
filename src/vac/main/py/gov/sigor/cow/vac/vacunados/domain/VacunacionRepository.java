package py.gov.sigor.cow.vac.vacunados.domain;

import py.gov.sigor.cow.vac.vacunados.application.datos.InfoVacunados;
import py.gov.sigor.cow.vac.vacunados.application.datos.VacunadosDatosFind;

public interface VacunacionRepository {

    <T> T getEntityBean(Class<T> entityClass, Long id);

    InfoVacunados obtenerAnimalesVacunados(VacunadosDatosFind query, Long vacPeriodoId);

    Long obtenerPrimerPeriodoAnho(Integer anho);
}

