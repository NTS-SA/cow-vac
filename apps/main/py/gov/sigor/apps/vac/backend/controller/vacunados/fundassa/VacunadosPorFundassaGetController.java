package py.gov.sigor.apps.vac.backend.controller.vacunados.fundassa;

import io.swagger.annotations.*;
import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.gov.sigor.cow.vac.vacunados.application.LeerVacunadosExcepcion;
import py.gov.sigor.cow.vac.vacunados.application.fundassa.InfoVacunadosFundassa;
import py.gov.sigor.cow.vac.vacunados.application.fundassa.VacunadosFundassaFind;
import py.gov.sigor.shared.domain.DomainError;
import py.gov.sigor.shared.domain.bus.command.CommandBus;
import py.gov.sigor.shared.domain.bus.query.QueryBus;
import py.gov.sigor.shared.domain.bus.query.QueryHandlerExecutionError;
import py.gov.sigor.shared.infrastructure.spring.ApiController;

import java.util.HashMap;

@RestController
@Api(value = "Vac API", tags = "Vacunados por Fundassa")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class VacunadosPorFundassaGetController extends ApiController {

    public static final Logger logger = Logger.getLogger(VacunadosPorFundassaGetController.class);

    public VacunadosPorFundassaGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/vacunados/fundassa")
    @ApiOperation(value = "Para  devolver la cantidad de animales terneros/terneras bovino y bubalinos vacunados agrupados por fundasa del acta confirmada del periodo general.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Ok."),
        @ApiResponse(code = 404, message = "Registro no se encuentra."),
        @ApiResponse(code = 401, message = "No esta autorizado para ver el recurso.")})
    public ResponseEntity<?> index(
        @ApiParam(value = "Año", required = true) @RequestParam(value = "anho") Integer anho) {
        try {
            InfoVacunadosFundassa response = ask(new VacunadosFundassaFind(anho));
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
