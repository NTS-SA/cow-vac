package py.gov.sigor.cow.vac.vacunados.domain;

import py.gov.sigor.cow.vac.vacunados.application.datos.InfoVacunados;
import py.gov.sigor.cow.vac.vacunados.application.datos.VacunadosDatosFind;
import py.gov.sigor.cow.vac.vacunados.application.fundassa.InfoVacunadosFundassa;
import py.gov.sigor.cow.vac.vacunados.application.fundassa.VacunadosFundassaFind;

public interface VacunacionRepository {

    <T> T getEntityBean(Class<T> entityClass, Long id);

    InfoVacunados obtenerAnimalesVacunados(VacunadosDatosFind query, Long vacPeriodoId);

    InfoVacunadosFundassa obtenerVacunadosPorFundassa(Long vacPeriodoId, Integer anho);

    Long obtenerPrimerPeriodoAnho(Integer anho);
}

