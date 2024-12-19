package py.gov.sigor.shared.domain;

public class InstantParseError extends DomainError {
    public InstantParseError(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
