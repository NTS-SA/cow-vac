package py.gov.sigor.cow.vac.vacunados.application.datos;

import py.gov.sigor.cow.vac.vacunados.domain.VacunacionRepository;
import py.gov.sigor.shared.domain.Service;
import py.gov.sigor.shared.domain.bus.query.QueryHandler;

@Service
public class VacunadosDatosFindHandler implements QueryHandler<VacunadosDatosFind, InfoVacunados> {

    private VacunacionRepository repository;

    public VacunadosDatosFindHandler(VacunacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public InfoVacunados handle(VacunadosDatosFind query) {
        try {
            return repository.obtenerAnimalesVacunados(query);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
