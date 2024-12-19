package py.gov.sigor.shared.infrastructure;

import py.gov.sigor.shared.domain.Service;
import py.gov.sigor.shared.domain.UuidGenerator;

import java.util.UUID;

@Service
public final class JavaUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
