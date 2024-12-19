package py.gov.sigor.shared.domain;

public class TimestampParseError extends DomainError {

    public TimestampParseError(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
