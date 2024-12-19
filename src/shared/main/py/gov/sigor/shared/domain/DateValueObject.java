package py.gov.sigor.shared.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public abstract class DateValueObject {
    public static final String PATTERN = "yyyyMMdd";
    private final Date value;

    public DateValueObject(Date value) {
        this.value = value;
    }

    public DateValueObject(String value) {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
        Date dValue = null;
        try {
            dValue = sdf.parse(value);
        } catch (ParseException e) {
            throw new DateBadFormat("ERR_SHARED_001", "Formato invalido para la fecha. Se espera->" + PATTERN);
        }
        this.value = dValue;
    }

    public Date value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DateValueObject that = (DateValueObject) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
        return sdf.format(value);
    }
}
