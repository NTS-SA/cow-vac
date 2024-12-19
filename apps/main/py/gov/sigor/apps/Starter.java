package py.gov.sigor.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ConfigurableApplicationContext;
import py.gov.sigor.apps.vac.backend.VacBackendApplication;
import py.gov.sigor.shared.infrastructure.cli.ConsoleCommand;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Starter {
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new RuntimeException("There are not enough arguments");
        }

        String applicationName = args[0];
        String commandName = args[1];
        boolean isApiCommand = commandName.equals("api");
        boolean isApiDaemon = commandName.equals("api") && args.length > 2;

        ensureApplicationExist(applicationName);
        ensureCommandExist(applicationName, commandName);

        Class<?> applicationClass = applications().get(applicationName);

        SpringApplication app = new SpringApplication(applicationClass);

        if (!isApiCommand) {
            app.setWebApplicationType(WebApplicationType.NONE);
        }

        ConfigurableApplicationContext context = app.run(args);

        if (!isApiCommand || isApiDaemon) {
            ConsoleCommand command = (ConsoleCommand) context.getBean(
                commands().get(applicationName).get(isApiDaemon ? args[2] : commandName)
            );
            command.execute(Arrays.copyOfRange(args, isApiDaemon ? 3 : 2, args.length));
        }
    }

    private static void ensureApplicationExist(String applicationName) {
        if (!applications().containsKey(applicationName)) {
            throw new RuntimeException(String.format(
                "The application <%s> doesn't exist. Valids:\n- %s",
                applicationName,
                String.join("\n- ", applications().keySet())
            ));
        }
    }

    private static void ensureCommandExist(String applicationName, String commandName) {
        if (!"api".equals(commandName) && !existCommand(applicationName, commandName)) {
            throw new RuntimeException(String.format(
                "The command <%s> for application <%s> doesn't exist. Valids (application.command):\n- api\n- %s",
                commandName,
                applicationName,
                String.join("\n- ", commands().get(applicationName).keySet())
            ));
        }
    }

    private static HashMap<String, Class<?>> applications() {
        HashMap<String, Class<?>> applications = new HashMap<>();
        applications.put("vac_api", VacBackendApplication.class);
        return applications;
    }

    private static HashMap<String, HashMap<String, Class<?>>> commands() {
        HashMap<String, HashMap<String, Class<?>>> commands = new HashMap<>();
        return commands;
    }

    private static Boolean existCommand(String applicationName, String commandName) {
        HashMap<String, HashMap<String, Class<?>>> commands = commands();

        return (Boolean) (commands.containsKey(applicationName) && commands.get(applicationName).containsKey(commandName));
    }
}
