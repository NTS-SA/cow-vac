package py.gov.sigor.shared.domain.bus.event.auditoria;


import java.io.Serializable;

public abstract class Auditable implements Serializable {

    private static final long serialVersionUID = -1130232194915975255L;
    private Long auditUsuario = -100L;
    private String auditIP;
    private String auditMaqNombre;
    private String auditBrowser;
    private Long auditCU;
    private String auditMensaje;
    private Long idPadre;
    private String auditUserName;
    private String obs;
    private boolean auditar = true;


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

    public Long getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Long idPadre) {
        this.idPadre = idPadre;
    }

    public String getAuditUserName() {
        return auditUserName;
    }

    public void setAuditUserName(String auditUserName) {
        this.auditUserName = auditUserName;
    }

    public void setAuditInfo(AuditInfo auditInfo) {
        this.setAuditUsuario(auditInfo.getAuditUsuario());
        this.setAuditIP(auditInfo.getAuditIP());
        this.setAuditMaqNombre(auditInfo.getAuditMaqNombre());
        this.setAuditBrowser(auditInfo.getAuditBrowser());
        this.setAuditCU(auditInfo.getAuditCU());
        this.setAuditMensaje(auditInfo.getAuditMensaje());
    }

    public boolean isAuditar() {
        return auditar;
    }

    public void setAuditar(boolean auditar) {
        this.auditar = auditar;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return "Auditable [auditUsuario=" + auditUsuario + ", auditIP=" + auditIP + ", auditMaqNombre=" + auditMaqNombre
            + ", auditBrowser=" + auditBrowser + ", auditCU=" + auditCU + ", auditMensaje=" + auditMensaje
            + ", idPadre=" + idPadre + ", auditUserName=" + auditUserName + ", obs=" + obs + ", auditar=" + auditar
            + "]";
    }


}
