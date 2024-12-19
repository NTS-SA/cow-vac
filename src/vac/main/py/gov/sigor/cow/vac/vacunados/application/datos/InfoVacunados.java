package py.gov.sigor.cow.vac.vacunados.application.datos;

import py.gov.sigor.shared.domain.bus.query.Response;

import java.util.ArrayList;
import java.util.List;

public class InfoVacunados implements Response {

    List <InfoEspecie> especies;

    public InfoVacunados() {
        especies = new ArrayList<>();
    }

    public List<InfoEspecie> getEspecies() {
        return especies;
    }

    public void setEspecies(List<InfoEspecie> especies) {
        this.especies = especies;
    }
}
