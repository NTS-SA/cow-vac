package py.gov.sigor.cow.vac.vacunados.domain.entity;

import py.gov.sigor.shared.domain.bus.event.auditoria.Auditable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CSA_AFTOSA")
public class UCsaAftosa extends Auditable {

    @Id
    @Column(name = "CSA_AFTOSA_ID", nullable = false)
    private Long csaAftosaId;

    @Column(name = "ANHO")
    private Integer anho;

    @Column(name = "TIPO_VACUNA_ENF")
    private String tipoVacunaEnf;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VAC_AFTOSA_ID")
    private UVacAftosa vacAftosa;

    @Column(name = "EST_PROP_ANIM_ID", nullable = false)
    private Long estPropAnimId;

    @Column(name = "VAC_PERIODO_ID", nullable = false)
    private Long vacPeriodoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COM_SALUD_ID")
    private UsrGrupo comSaludId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CSA_AFTOSA_DOC_ESTADO_ID")
    private UCsaAftosaDocEstado csaAftosaDocEstado;

    @OneToMany(mappedBy = "csaAftosa")
    private List<UCsaAftosaPob> csaAftosaPobs;

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

    public UsrGrupo getComSaludId() {return comSaludId;}

    public void setComSaludId(UsrGrupo comSaludId) {this.comSaludId = comSaludId;}

    public UCsaAftosaDocEstado getCsaAftosaDocEstado() {return csaAftosaDocEstado;}

    public void setCsaAftosaDocEstado(UCsaAftosaDocEstado csaAftosaDocEstado) {this.csaAftosaDocEstado = csaAftosaDocEstado;}

    public List<UCsaAftosaPob> getCsaAftosaPobs() {return csaAftosaPobs;}

    public void setCsaAftosaPobs(List<UCsaAftosaPob> csaAftosaPobs) {this.csaAftosaPobs = csaAftosaPobs;}

    public Integer getAnho() {return anho;}

    public void setAnho(Integer anho) {this.anho = anho;}

    public String getTipoVacunaEnf() {return tipoVacunaEnf;}

    public void setTipoVacunaEnf(String tipoVacunaEnf) {this.tipoVacunaEnf = tipoVacunaEnf;}
}
