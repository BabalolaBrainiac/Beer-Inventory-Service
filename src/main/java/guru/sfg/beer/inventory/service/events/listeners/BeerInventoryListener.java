package guru.sfg.beer.inventory.service.events.listeners;


import guru.sfg.beer.inventory.service.config.JMSConfig;
import guru.sfg.beer.inventory.service.domain.BeerInventory;
import guru.sfg.beer.inventory.service.events.listeners.entities.BeerInventoryEvent;
import guru.sfg.beer.inventory.service.repositories.BeerInventoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class BeerInventoryListener {

    BeerInventoryRepository beerInventoryRepository;


    @JmsListener(destination = JMSConfig.NEW_INVENTORY_QUEUE)
    public void listenToEvent(BeerInventoryEvent event) {
        log.debug("listening to event " + event.toString());
        System.out.println("listening to inventory event" + event.toString());

        BeerInventory newInventory = BeerInventory.builder()
                .beerId(event.getBeerDTO().getId())
                .upc(event.getBeerDTO().getUpc())
                .quantityOnHand(event.getBeerDTO().getQuantityOnHand())
                .build();

        beerInventoryRepository.save(newInventory);

    }


}
