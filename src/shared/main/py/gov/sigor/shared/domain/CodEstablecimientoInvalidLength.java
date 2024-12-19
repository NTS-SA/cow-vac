package py.gov.sigor.shared.domain;


public class CodEstablecimientoInvalidLength extends DomainError {
    public CodEstablecimientoInvalidLength(CodigoEstablecimiento id) {
        super("cod_invalid_length", String.format("El codigo de establecimiento tiene una longitud invalida -> <%s>.", id.value()));
    }


}
