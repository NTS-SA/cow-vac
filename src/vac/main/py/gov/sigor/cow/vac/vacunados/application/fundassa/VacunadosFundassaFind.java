package py.gov.sigor.cow.vac.vacunados.application.fundassa;

import py.gov.sigor.shared.domain.bus.query.Query;

public class VacunadosFundassaFind implements Query {

    private Integer anho;

    public VacunadosFundassaFind(Integer anho) {
        this.anho = anho;
    }

    public Integer getAnho() {
        return anho;
    }

    public void setAnho(Integer anho) {
        this.anho = anho;
    }
}


