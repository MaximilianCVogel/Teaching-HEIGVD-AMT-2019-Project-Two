package ch.heigvd.boozify.beers.api.endpoints;

import ch.heigvd.boozify.beers.api.InventoryApi;
import ch.heigvd.boozify.beers.entities.BarEntity;
import ch.heigvd.boozify.beers.model.Bar;
import ch.heigvd.boozify.beers.api.endpoints.BarsApiController;
import ch.heigvd.boozify.beers.api.endpoints.BeersApiController;
import ch.heigvd.boozify.beers.model.Beer;
import ch.heigvd.boozify.beers.repositories.BarRepository;
import ch.heigvd.boozify.beers.entities.BeerEntity;
import ch.heigvd.boozify.beers.repositories.BeerRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-26T19:36:34.802Z")

@Controller
public class InventoryApiController implements InventoryApi {

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    BarRepository barRepository;

    public ResponseEntity<List<Bar>> getBarsServingBeer(@ApiParam(value = "",required=true) @PathVariable("name") String name) {
        List<Bar> barsServingBeer = new ArrayList<>();

        BeerEntity beer = beerRepository.findByName(name);
        List<BarEntity> barEntities = beer.getBars();

        for (BarEntity barEntity : barEntities) {
            barsServingBeer.add(toBar(barEntity));
        }

        return ResponseEntity.ok(barsServingBeer);
    }

    public ResponseEntity<List<Beer>> getBeersServedByBar(@ApiParam(value = "",required=true) @PathVariable("name") String name) {
        List<Beer> beersServed = new ArrayList<>();

        BarEntity bar = barRepository.findByName(name);
        List<BeerEntity> beerEntities = bar.getBeers();

        for (BeerEntity beerEntity : beerEntities) {
            beersServed.add(toBeer(beerEntity));
        }

        return ResponseEntity.ok(beersServed);
    }

    public ResponseEntity<Void> addBeerToBar(@ApiParam(value = "",required=true) @PathVariable("name") String name, @ApiParam(value = "",required=true) @PathVariable("beer") String beer) {
        BarEntity barToLink = barRepository.findByName(name);
        BeerEntity beerToLink = beerRepository.findByName(beer);

        barToLink.addBeer(beerToLink);
        beerToLink.addBar(barToLink);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    private Bar toBar(BarEntity entity) {
        Bar bar = new Bar();
        bar.setName(entity.getName());
        bar.setAddress(entity.getAddress());
        return bar;
    }

    private Beer toBeer(BeerEntity entity) {
        Beer beer = new Beer();
        beer.setName(entity.getName());
        beer.setType(entity.getType());
        beer.setAlcohol(entity.getAlcohol());
        return beer;
    }

}
