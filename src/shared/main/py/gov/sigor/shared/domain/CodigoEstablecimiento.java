package py.gov.sigor.shared.domain;

public class CodigoEstablecimiento extends StringValueObject {

    public static final int CODIGO_LENGTH = 10;

    public CodigoEstablecimiento(String value) {
        super(value);
        validarCodigo(value);
    }

    public CodigoEstablecimiento() {
        super("");
    }

    private void validarCodigo(String value) {
        if (value.length() != CODIGO_LENGTH) {
            throw new CodEstablecimientoInvalidLength(this);
        }
    }
}
