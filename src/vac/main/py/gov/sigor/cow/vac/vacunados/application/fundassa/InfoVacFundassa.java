package py.gov.sigor.cow.vac.vacunados.application.fundassa;

import py.gov.sigor.shared.domain.bus.query.Response;

public class InfoVacFundassa implements Response {

    Long csaId;

    String csa;

    Long cantPropVac;

    Long totalTernerosVac;

    public InfoVacFundassa() {
        csaId = 0l;
        csa = "";
        cantPropVac = 0l;
        totalTernerosVac = 0l;
    }

    public Long getCsaId() {
        return csaId;
    }

    public void setCsaId(Long csaId) {
        this.csaId = csaId;
    }

    public String getCsa() {
        return csa;
    }

    public void setCsa(String csa) {
        this.csa = csa;
    }

    public Long getCantPropVac() {
        return cantPropVac;
    }

    public void setCantPropVac(Long cantPropVac) {
        this.cantPropVac = cantPropVac;
    }

    public Long getTotalTernerosVac() {
        return totalTernerosVac;
    }

    public void setTotalTernerosVac(Long totalTernerosVac) {
        this.totalTernerosVac = totalTernerosVac;
    }
}
