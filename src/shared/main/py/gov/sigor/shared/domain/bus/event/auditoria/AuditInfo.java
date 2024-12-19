package py.gov.sigor.shared.domain.bus.event.auditoria;

public class AuditInfo {

    private Long auditUsuario;
    private String auditIP;
    private String auditMaqNombre;
    private String auditBrowser;
    private Long auditCU;
    private String auditMensaje;

    public Long getAuditUsuario() {
        return auditUsuario;
    }

    public void setAuditUsuario(Long auditUsuario) {
        this.auditUsuario = auditUsuario;
    }

    public String getAuditIP() {
        return auditIP;
    }

    public void setAuditIP(String auditIP) {
        this.auditIP = auditIP;
    }

    public String getAuditMaqNombre() {
        return auditMaqNombre;
    }

    public void setAuditMaqNombre(String auditMaqNombre) {
        this.auditMaqNombre = auditMaqNombre;
    }

    public String getAuditBrowser() {
        return auditBrowser;
    }

    public void setAuditBrowser(String auditBrowser) {
        this.auditBrowser = auditBrowser;
    }

    public Long getAuditCU() {
        return auditCU;
    }

    public void setAuditCU(Long auditCU) {
        this.auditCU = auditCU;
    }

    public String getAuditMensaje() {
        return auditMensaje;
    }

    public void setAuditMensaje(String auditMensaje) {
        this.auditMensaje = auditMensaje;
    }
}
