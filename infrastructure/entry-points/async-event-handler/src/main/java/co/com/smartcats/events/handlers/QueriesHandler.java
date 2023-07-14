package co.com.smartcats.events.handlers;

import co.com.smartcats.model.cat.Cat;
import co.com.smartcats.model.movements.Movements;
import co.com.smartcats.usecase.cats.CatsUseCase;
import co.com.smartcats.usecase.movements.MovementsUseCase;
import lombok.AllArgsConstructor;
import org.reactivecommons.async.impl.config.annotations.EnableQueryListeners;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@AllArgsConstructor
@EnableQueryListeners
public class QueriesHandler {
    private  final CatsUseCase catsUseCase;
    private  final MovementsUseCase movementsUseCase;


    public Mono<Cat> createCatQuery(Cat cat) {
        return catsUseCase.saveCat(cat);
    }

    public Mono<Movements> createMovementQuery(Movements movements) {
        return movementsUseCase.saveMovement(movements);
    }

    public Mono<Cat> getCatByIdQuery(Integer id) {
        return catsUseCase.findByIdCat(id);
    }

    public Mono<List<Movements>> getMovementsByIdCatQuery(Integer id) {
        return movementsUseCase.findByIdCatMovements(id).collectList();
    }
}
