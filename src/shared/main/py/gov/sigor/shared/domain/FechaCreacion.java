package py.gov.sigor.shared.domain;

import java.text.ParseException;
import java.util.Date;

public class FechaCreacion extends TimestampValueObject {
    public FechaCreacion(Date value) {
        super(value);
    }

    public FechaCreacion(String value) throws ParseException {
        super(value);
    }

    public FechaCreacion() {
        super(new Date());
    }
}
