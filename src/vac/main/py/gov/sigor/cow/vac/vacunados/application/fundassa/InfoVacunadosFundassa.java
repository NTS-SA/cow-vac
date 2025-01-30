package py.gov.sigor.cow.vac.vacunados.application.fundassa;

import py.gov.sigor.cow.vac.vacunados.application.datos.InfoEspecie;
import py.gov.sigor.shared.domain.bus.query.Response;

import java.util.ArrayList;
import java.util.List;

public class InfoVacunadosFundassa implements Response {

    List <InfoVacFundassa> infoVacFundassa;

    public InfoVacunadosFundassa() {
        infoVacFundassa = new ArrayList<>();
    }

    public List<InfoVacFundassa> getInfoVacFundassa() {
        return infoVacFundassa;
    }

    public void setInfoVacFundassa(List<InfoVacFundassa> infoVacFundassa) {
        this.infoVacFundassa = infoVacFundassa;
    }
}
