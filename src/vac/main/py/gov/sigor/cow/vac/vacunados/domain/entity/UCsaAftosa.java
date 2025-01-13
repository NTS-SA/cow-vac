package py.gov.sigor.cow.vac.vacunados.domain.entity;

import py.gov.sigor.shared.domain.bus.event.auditoria.Auditable;

import javax.persistence.*;

@Entity
@Table(name = "CSA_AFTOSA")
public class UCsaAftosa extends Auditable {

    @Id
    @Column(name = "CSA_AFTOSA_ID", nullable = false)
    private Long csaAftosaId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VAC_AFTOSA_ID")
    private UVacAftosa vacAftosa;

    @Column(name = "EST_PROP_ANIM_ID", nullable = false)
    private Long estPropAnimId;

    @Column(name = "VAC_PERIODO_ID", nullable = false)
    private Long vacPeriodoId;

    public Long getCsaAftosaId() {
        return csaAftosaId;
    }

    public void setCsaAftosaId(Long csaAftosaId) {
        this.csaAftosaId = csaAftosaId;
    }

    public UVacAftosa getVacAftosa() {
        return vacAftosa;
    }

    public void setVacAftosa(UVacAftosa vacAftosa) {
        this.vacAftosa = vacAftosa;
    }

    public Long getEstPropAnimId() {
        return estPropAnimId;
    }

    public void setEstPropAnimId(Long estPropAnimId) {
        this.estPropAnimId = estPropAnimId;
    }

    public Long getVacPeriodoId() {return vacPeriodoId;}

    public void setVacPeriodoId(Long vacPeriodoId) {this.vacPeriodoId = vacPeriodoId;}
}
