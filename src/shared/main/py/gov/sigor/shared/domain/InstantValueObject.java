package py.gov.sigor.shared.domain;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public abstract class InstantValueObject implements Serializable, Comparable<InstantValueObject> {
    public static final String PATTERN = "yyyy-MM-ddTHH:mm:ssZ";
    private final Instant value;

    public InstantValueObject(Instant value) {
        this.value = value;
    }

    public InstantValueObject(String value) {
        Instant dValue = null;
        try {
            dValue = Instant.parse(value);
        } catch (DateTimeParseException e) {
            throw new InstantParseError("instant_parse_error", "Fecha y hora con formato invalido. Se espera->" + PATTERN);
        }


        this.value = dValue;
    }

    public Instant value() {
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
        InstantValueObject that = (InstantValueObject) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(@NotNull InstantValueObject o) {
        return this.value.compareTo(o.value);
    }
}
