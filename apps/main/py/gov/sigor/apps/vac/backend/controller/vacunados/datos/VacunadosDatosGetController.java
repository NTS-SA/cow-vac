package py.gov.sigor.apps.vac.backend.controller.vacunados.datos;

import io.swagger.annotations.*;
import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.gov.sigor.cow.vac.vacunados.application.LeerVacunadosExcepcion;
import py.gov.sigor.cow.vac.vacunados.application.VacunadosNotFound;
import py.gov.sigor.cow.vac.vacunados.application.datos.InfoVacunados;
import py.gov.sigor.cow.vac.vacunados.application.datos.VacunadosDatosFind;
import py.gov.sigor.shared.domain.DomainError;
import py.gov.sigor.shared.domain.bus.command.CommandBus;
import py.gov.sigor.shared.domain.bus.query.QueryBus;
import py.gov.sigor.shared.domain.bus.query.QueryHandlerExecutionError;
import py.gov.sigor.shared.infrastructure.spring.ApiController;

import java.util.HashMap;

@RestController
@Api(value = "Vac API", tags = "Vacunados")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class VacunadosDatosGetController extends ApiController {

    public static final Logger logger = Logger.getLogger(VacunadosDatosGetController.class);

    public VacunadosDatosGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/vacunados")
    @ApiOperation(value = "Para  devolver la cantidad de animales terneros/terneras bovino y bubalinos vacunados por propietario/establecimiento del acta confirmada en UZ del periodo general.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok."),
        @ApiResponse(code = 404, message = "Registro no se encuentra."),
        @ApiResponse(code = 401, message = "No esta autorizado para ver el recurso.")})
    public ResponseEntity<?> index(@ApiParam(value = "Request para obtener cantidad de animales terneros,terneras,bovino y bubalinos vacunados por propietario/establecimiento.") @RequestBody VacunadosDatosGetRequest request) {
        logger.info("cantidad de animales terneros,terneras,bovino y bubalinos vacunados por propietario/establecimiento: " + request.getEstPropAnimId());
        try {
            InfoVacunados response = ask(new VacunadosDatosFind(request.getEstPropAnimId(), request.getAnho()));
            return ResponseEntity.ok(response);
        }catch (QueryHandlerExecutionError e) {
            if (e.getCause() instanceof LeerVacunadosExcepcion) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getCause().getMessage());
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
        }};
    }
}
