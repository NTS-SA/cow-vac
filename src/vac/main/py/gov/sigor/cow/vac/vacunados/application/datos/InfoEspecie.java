package py.gov.sigor.cow.vac.vacunados.application.datos;

import py.gov.sigor.shared.domain.bus.query.Response;

public class InfoEspecie implements Response {

    Long espCatogoriaId;

    String nombre;

    Long cantVacunada;

    public InfoEspecie() {
        espCatogoriaId = 0l;
        nombre = "";
        cantVacunada = 0l;
    }

    public Long getEspCatogoriaId() {
        return espCatogoriaId;
    }

    public void setEspCatogoriaId(Long espCatogoriaId) {
        this.espCatogoriaId = espCatogoriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCantVacunada() {
        return cantVacunada;
    }

    public void setCantVacunada(Long cantVacunada) {
        this.cantVacunada = cantVacunada;
    }
}
