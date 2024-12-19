package py.gov.sigor.apps.vac.backend.controller.vacunados.datos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ActaPutRequest", description = "Solicitud con los datos requeridos para registrar un acta de vacunacion que afecte el stock.")
public class VacunadosDatosGetRequest {

    @ApiModelProperty(notes = "Identificador unico del SIGOR que asocia al propietario con un establecimiento", example = "34534534")
    private Long estPropAnimId;
    @ApiModelProperty(notes = "Año", example = "2024")
    private Integer anho;

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
