package ch.heigvd.boozify.beers.api.endpoints;

import ch.heigvd.boozify.beers.api.EncyclopediaApi;
import ch.heigvd.boozify.beers.entities.BarEntity;
import ch.heigvd.boozify.beers.repositories.BarRepository;
import ch.heigvd.boozify.beers.entities.BeerEntity;
import ch.heigvd.boozify.beers.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-26T19:36:34.802Z")

@Controller
public class EncyclopediaApiController implements EncyclopediaApi {

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    BarRepository barRepository;

    public ResponseEntity<Void> getTest() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /*
    public ResponseEntity<List<Bar>> getBarsServingBeer() {
        List<Bar> bars = new ArrayList<>();
        for (BarEntity barEntity : barRepository.findAll()) {
            bars.add(toBar(barEntity));
        }
        return ResponseEntity.ok(bars);
    }

    public ResponseEntity<List<Beer>> getBeersServedByBar() {
        List<Beer> beers = new ArrayList<>();
        for (BeerEntity beerEntity : beerRepository.findAll()) {
            beers.add(toBeer(beerEntity));
        }
        return ResponseEntity.ok(beers);
    }*/

}
