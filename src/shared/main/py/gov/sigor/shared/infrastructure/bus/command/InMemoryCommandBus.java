package py.gov.sigor.shared.infrastructure.bus.command;

import org.springframework.context.ApplicationContext;
import py.gov.sigor.shared.domain.Service;
import py.gov.sigor.shared.domain.bus.command.Command;
import py.gov.sigor.shared.domain.bus.command.CommandBus;
import py.gov.sigor.shared.domain.bus.command.CommandHandler;
import py.gov.sigor.shared.domain.bus.command.CommandHandlerExecutionError;


@Service
public final class InMemoryCommandBus implements CommandBus {
    private final CommandHandlersInformation information;
    private final ApplicationContext context;

    public InMemoryCommandBus(CommandHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context = context;
    }

    @Override
    public void dispatch(Command command) throws CommandHandlerExecutionError {
        try {
            Class<? extends CommandHandler> commandHandlerClass = information.search(command.getClass());

            CommandHandler handler = context.getBean(commandHandlerClass);

            handler.handle(command);
        } catch (Throwable error) {
            throw new CommandHandlerExecutionError(error);
        }
    }
}
