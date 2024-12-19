package py.gov.sigor.shared.domain;

public class DateBadFormat extends DomainError {

    public DateBadFormat(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
