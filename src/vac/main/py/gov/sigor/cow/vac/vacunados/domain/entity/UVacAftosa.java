package py.gov.sigor.cow.vac.vacunados.domain.entity;

import py.gov.sigor.shared.domain.bus.event.auditoria.Auditable;

import javax.persistence.*;

@Entity
@Table(name = "VAC_AFTOSA")
public class UVacAftosa extends Auditable {

    @Id
    @Column(name = "VAC_AFTOSA_ID", nullable = false)
    private Long vacAftosaId;

    @Column(name = "ANHO")
    private Integer anho;

    @Column(name = "VAC_DOC_ESTADO_ID")
    private Integer vacDocEstadoId;

    public Long getVacAftosaId() {
        return vacAftosaId;
    }

    public void setVacAftosaId(Long vacAftosaId) {
        this.vacAftosaId = vacAftosaId;
    }

    public Integer getAnho() {
        return anho;
    }

    public void setAnho(Integer anho) {
        this.anho = anho;
    }

    public Integer getVacDocEstadoId() {
        return vacDocEstadoId;
    }

    public void setVacDocEstadoId(Integer vacDocEstadoId) {
        this.vacDocEstadoId = vacDocEstadoId;
    }
}
