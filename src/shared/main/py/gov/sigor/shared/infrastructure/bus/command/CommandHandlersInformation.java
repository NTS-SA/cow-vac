package py.gov.sigor.shared.infrastructure.bus.command;

import org.reflections.Reflections;
import py.gov.sigor.shared.domain.Service;
import py.gov.sigor.shared.domain.bus.command.Command;
import py.gov.sigor.shared.domain.bus.command.CommandHandler;
import py.gov.sigor.shared.domain.bus.command.CommandNotRegisteredError;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Set;


@Service
public final class CommandHandlersInformation {
    HashMap<Class<? extends Command>, Class<? extends CommandHandler>> indexedCommandHandlers;

    public CommandHandlersInformation() {
        Reflections reflections = new Reflections("py.gov.sigor");
        Set<Class<? extends CommandHandler>> classes = reflections.getSubTypesOf(CommandHandler.class);

        indexedCommandHandlers = formatHandlers(classes);
    }

    public Class<? extends CommandHandler> search(Class<? extends Command> commandClass) throws CommandNotRegisteredError {
        Class<? extends CommandHandler> commandHandlerClass = indexedCommandHandlers.get(commandClass);

        if (null == commandHandlerClass) {
            throw new CommandNotRegisteredError(commandClass);
        }

        return commandHandlerClass;
    }

    private HashMap<Class<? extends Command>, Class<? extends CommandHandler>> formatHandlers(
        Set<Class<? extends CommandHandler>> commandHandlers
    ) {
        HashMap<Class<? extends Command>, Class<? extends CommandHandler>> handlers = new HashMap<>();

        for (Class<? extends CommandHandler> handler : commandHandlers) {
            ParameterizedType paramType = (ParameterizedType) handler.getGenericInterfaces()[0];
            Class<? extends Command> commandClass = (Class<? extends Command>) paramType.getActualTypeArguments()[0];

            handlers.put(commandClass, handler);
        }

        return handlers;
    }
}
