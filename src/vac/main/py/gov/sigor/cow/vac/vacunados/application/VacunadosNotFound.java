package py.gov.sigor.cow.vac.vacunados.application;
import py.gov.sigor.shared.domain.DomainError;
public class VacunadosNotFound extends DomainError{
    public VacunadosNotFound(String errorMessage) {
        super("vacunados_not_found", errorMessage);
    }
}
