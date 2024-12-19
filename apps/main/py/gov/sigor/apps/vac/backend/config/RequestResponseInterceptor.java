package py.gov.sigor.apps.vac.backend.config;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestResponseInterceptor implements HandlerInterceptor {

    public static final Logger logger = Logger.getLogger(RequestResponseInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        // Se ejecuta antes de que el controlador maneje la solicitud, aquí puedes registrar el request
        logger.info("Request " + request.hashCode() + " URL: " + request.getRequestURL().toString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // Se ejecuta después de que el controlador maneje la solicitud, pero antes de que se renderice la vista (si corresponde)
        // Aquí puedes registrar la respuesta antes de enviarla
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
        throws Exception {
        // Se ejecuta después de que se haya completado la respuesta y se haya enviado al cliente
        // Aquí puedes realizar cualquier limpieza necesaria
        logger.info("Response " + request.hashCode() + " Status: " + response.getStatus());
    }

}
