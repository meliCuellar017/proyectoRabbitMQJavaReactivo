package co.com.smartcats.events.handlers;

import lombok.AllArgsConstructor;
import org.reactivecommons.api.domain.Command;
import org.reactivecommons.async.impl.config.annotations.EnableCommandListeners;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@EnableCommandListeners
public class CommandsHandler {
//    private final SampleUseCase sampleUseCase;


    public Mono<Void> handleCommandA(Command<Object/*change for proper model*/> command) {
        System.out.println("command received: " + command.getName() + " ->" + command.getData()); // TODO: Remove this line
//        return sampleUseCase.doSomething(command.getData());
        return Mono.empty();
    }
}
