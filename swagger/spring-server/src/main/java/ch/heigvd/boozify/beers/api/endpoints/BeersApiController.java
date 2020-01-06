package ch.heigvd.boozify.beers.api.endpoints;


import ch.heigvd.boozify.beers.api.BeersApi;
import ch.heigvd.boozify.beers.entities.BeerEntity;
import ch.heigvd.boozify.beers.model.Beer;
import ch.heigvd.boozify.beers.repositories.BeerRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-26T19:36:34.802Z")

@Controller
public class BeersApiController implements BeersApi {

    @Autowired
    BeerRepository beerRepository;


    public ResponseEntity<Object> createBeer(@ApiParam(value = "", required = true) @Valid @RequestBody Beer beer) {
        BeerEntity newBeerEntity = toBeerEntity(beer);
        beerRepository.save(newBeerEntity);
        Long id = newBeerEntity.getId();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newBeerEntity.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    public ResponseEntity<List<Beer>> getBeers() {
        List<Beer> beers = new ArrayList<>();
        for (BeerEntity beerEntity : beerRepository.findAll()) {
            beers.add(toBeer(beerEntity));
        }
        /*
        Beer staticBeer = new Beer();
        staticBeer.setName("Feldschlösschen");
        staticBeer.setType("blond");
        staticBeer.setAlcohol("6");
        List<Beer> beers = new ArrayList<>();
        beers.add(staticBeer);
        */
        return ResponseEntity.ok(beers);
    }


    private BeerEntity toBeerEntity(Beer beer) {
        BeerEntity entity = new BeerEntity();
        entity.setName(beer.getName());
        entity.setType(beer.getType());
        entity.setAlcohol(beer.getAlcohol());
        return entity;
    }

    private Beer toBeer(BeerEntity entity) {
        Beer beer = new Beer();
        beer.setName(entity.getName());
        beer.setType(entity.getType());
        beer.setAlcohol(entity.getAlcohol());
        return beer;
    }

}