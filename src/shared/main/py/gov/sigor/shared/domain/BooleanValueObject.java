package py.gov.sigor.shared.domain;

import java.util.Objects;

public class BooleanValueObject {
    private final String value;

    public BooleanValueObject(String value) {
        this.value = value;

        validate(value);
    }

    public BooleanValueObject(Boolean value) {
        if (value) {
            this.value = "S";
        } else {
            this.value = "N";
        }
    }

    private void validate(String value) {
        if (!"N".equalsIgnoreCase(value) && !"S".equalsIgnoreCase(value)) {
            throw new InvalidBooleanValue("invalid_value", "Incorrecto valor. Se esperaba el valor N o S");
        }

    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooleanValueObject that = (BooleanValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
