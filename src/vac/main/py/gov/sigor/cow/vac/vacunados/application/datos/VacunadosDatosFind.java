package py.gov.sigor.cow.vac.vacunados.application.datos;

import py.gov.sigor.shared.domain.bus.query.Query;

public class VacunadosDatosFind implements Query {

    private Long estPropAnimId;
    private Integer anho;


    public VacunadosDatosFind(Long estPropAnimId, Integer anho) {
        this.estPropAnimId = estPropAnimId;
        this.anho = anho;
    }

    public Integer getAnho() {
        return anho;
    }

    public void setAnho(Integer anho) {
        this.anho = anho;
    }

    public Long getEstPropAnimId() {
        return estPropAnimId;
    }

    public void setEstPropAnimId(Long estPropAnimId) {
        this.estPropAnimId = estPropAnimId;
    }
}


