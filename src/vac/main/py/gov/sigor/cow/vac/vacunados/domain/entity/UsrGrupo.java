package py.gov.sigor.cow.vac.vacunados.domain.entity;

import py.gov.sigor.shared.domain.bus.event.auditoria.Auditable;

import javax.persistence.*;

@Entity
@Table(name = "USR_GRUPO")
public class UsrGrupo extends Auditable {

    @Id
    @Column(name = "USR_GRUPO_ID", nullable = false)
    private Long usrGrupoId;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "TIPO")
    private String tipo;

    public Long getUsrGrupoId() {
        return usrGrupoId;
    }

    public void setUsrGrupoId(Long usrGrupoId) {
        this.usrGrupoId = usrGrupoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
