package py.gov.sigor.cow.vac.vacunados.domain.entity;

import py.gov.sigor.shared.domain.bus.event.auditoria.Auditable;

import javax.persistence.*;

@Entity
@Table(name = "CSA_AFTOSA_POB")
public class UCsaAftosaPob extends Auditable {

    @Id
    @Column(name = "CSA_AFTOSA_POB_ID", nullable = false)
    private Long csaAftosaPobId;

    @Column(name = "ESP_CATEGORIA_ID", nullable = false)
    private Long espCategoriaId;

    @Column(name = "ESP_CATEGORIA_NOMBRE", nullable = false)
    private String espCategoriaNombre;

    @Column(name = "VACUNADA")
    private Integer vacunada;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="CSA_AFTOSA_ID")
    private UCsaAftosa csaAftosa;

    public Long getCsaAftosaPobId() {
        return csaAftosaPobId;
    }

    public void setCsaAftosaPobId(Long csaAftosaPobId) {
        this.csaAftosaPobId = csaAftosaPobId;
    }

    public Long getEspCategoriaId() {
        return espCategoriaId;
    }

    public void setEspCategoriaId(Long espCategoriaId) {
        this.espCategoriaId = espCategoriaId;
    }

    public String getEspCategoriaNombre() {
        return espCategoriaNombre;
    }

    public void setEspCategoriaNombre(String espCategoriaNombre) {
        this.espCategoriaNombre = espCategoriaNombre;
    }

    public Integer getVacunada() {
        return vacunada;
    }

    public void setVacunada(Integer vacunada) {
        this.vacunada = vacunada;
    }

    public UCsaAftosa getCsaAftosa() {
        return csaAftosa;
    }

    public void setCsaAftosa(UCsaAftosa csaAftosa) {
        this.csaAftosa = csaAftosa;
    }
}
