package guru.sfg.beer.inventory.service.events.listeners.entities;


import guru.sfg.beer.inventory.service.events.listeners.models.BeerDTO;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BeerInventoryEvent extends BeerEvent {
    public BeerInventoryEvent(BeerDTO beerDto) {
        super(beerDto);
    }
}
