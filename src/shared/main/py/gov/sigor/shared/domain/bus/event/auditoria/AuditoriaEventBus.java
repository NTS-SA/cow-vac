package py.gov.sigor.shared.domain.bus.event.auditoria;


import py.gov.sigor.auditoria.xsd.auditareventorequest.v1.AuditarEventoRequest;

public interface AuditoriaEventBus {
    void publish(AuditarEventoRequest events);
}
