package py.gov.sigor.cow.vac.vacunados.application.fundassa;

import py.gov.sigor.cow.vac.vacunados.application.fundassa.InfoVacunadosFundassa;
import py.gov.sigor.cow.vac.vacunados.domain.VacunacionRepository;
import py.gov.sigor.shared.domain.Service;
import py.gov.sigor.shared.domain.bus.query.QueryHandler;

@Service
public class VacunadosFundassaFindHandler implements QueryHandler<VacunadosFundassaFind, InfoVacunadosFundassa> {

    private VacunacionRepository repository;

    public VacunadosFundassaFindHandler(VacunacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public InfoVacunadosFundassa handle(VacunadosFundassaFind query) {
        try {
            Long periodoId = repository.obtenerPrimerPeriodoAnho(query.getAnho());
            return repository.obtenerVacunadosPorFundassa(periodoId, query.getAnho());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
