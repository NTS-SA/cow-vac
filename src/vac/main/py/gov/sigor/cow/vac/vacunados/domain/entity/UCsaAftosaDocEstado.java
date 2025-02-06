package py.gov.sigor.cow.vac.vacunados.domain.entity;

import py.gov.sigor.shared.domain.bus.event.auditoria.Auditable;

import javax.persistence.*;

@Entity
@Table(name = "CSA_AFTOSA_DOC_ESTADO")
public class UCsaAftosaDocEstado extends Auditable {

    @Id
    @Column(name = "CSA_AFTOSA_DOC_ESTADO_ID", nullable = false)
    private Long csaAftosadocEstadoId;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "CODIGO")
    private Character codigo;

    public Long getCsaAftosadocEstadoId() {
        return csaAftosadocEstadoId;
    }

    public void setCsaAftosadocEstadoId(Long csaAftosadocEstadoId) {
        this.csaAftosadocEstadoId = csaAftosadocEstadoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getCodigo() {
        return codigo;
    }

    public void setCodigo(Character codigo) {
        this.codigo = codigo;
    }
}
