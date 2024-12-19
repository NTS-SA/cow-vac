package py.gov.sigor.shared.domain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public abstract class TimestampValueObject implements Serializable {
    public static final String PATTERN = "yyyyMMdd HH:mm:ss";
    private final Date value;

    public TimestampValueObject(Date value) {
        this.value = value;
    }

    public TimestampValueObject(String value) {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
        Date dValue = null;
        try {
            dValue = sdf.parse(value);
        } catch (ParseException e) {
            throw new TimestampParseError("ERR_SHARED_002", "Fecha y hora con formato invalido. Se espera->" + PATTERN);
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
        TimestampValueObject that = (TimestampValueObject) o;
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
