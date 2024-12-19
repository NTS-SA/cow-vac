package py.gov.sigor.shared.domain;

public class InvalidBooleanValue extends DomainError {
    public InvalidBooleanValue(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
