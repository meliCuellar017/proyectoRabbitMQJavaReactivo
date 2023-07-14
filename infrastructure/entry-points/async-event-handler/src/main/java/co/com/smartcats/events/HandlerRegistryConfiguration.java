package co.com.smartcats.events;

import co.com.smartcats.events.handlers.CommandsHandler;
import co.com.smartcats.events.handlers.EventsHandler;
import co.com.smartcats.events.handlers.QueriesHandler;
import co.com.smartcats.model.cat.Cat;
import co.com.smartcats.model.movements.Movements;
import org.reactivecommons.async.api.HandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlerRegistryConfiguration {

    @Bean
    public HandlerRegistry handlerRegistry(CommandsHandler commands, EventsHandler events, QueriesHandler queries) {
        return HandlerRegistry.register()
                .serveQuery("create.cat", queries::createCatQuery, Cat.class)
                .serveQuery("movement.cat", queries::createMovementQuery, Movements.class)
                .serveQuery("get.cat", queries::getCatByIdQuery, Integer.class)
                .serveQuery("movement.cat", queries::getMovementsByIdCatQuery, Integer.class);
    }
}
