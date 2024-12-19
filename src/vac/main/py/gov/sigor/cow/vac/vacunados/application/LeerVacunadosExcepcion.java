package py.gov.sigor.cow.vac.vacunados.application;

import py.gov.sigor.shared.domain.DomainError;

public class LeerVacunadosExcepcion extends DomainError {
    public LeerVacunadosExcepcion(String message, Exception ex) {
        super(message,ex.getMessage());
    }

    public LeerVacunadosExcepcion(String message) {
        super("ERROR_GENERICO",message);
    }
}
