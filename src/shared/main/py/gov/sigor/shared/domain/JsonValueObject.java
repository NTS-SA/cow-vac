package py.gov.sigor.shared.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValueObject extends StringValueObject {

    public JsonValueObject(String value) {
        super(value);
    }

    public Object valueJson() {
        try {
            return new ObjectMapper().readTree(value());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Object putValueJson() {
        try {
            return new ObjectMapper().writeValueAsString(value());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
