package ch.heigvd.boozify.beers.api.endpoints;


import ch.heigvd.boozify.beers.api.BarsApi;
import ch.heigvd.boozify.beers.entities.BarEntity;
import ch.heigvd.boozify.beers.model.Bar;
import ch.heigvd.boozify.beers.repositories.BarRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-26T19:36:34.802Z")

@Controller
public class BarsApiController implements BarsApi {

    @Autowired
    BarRepository barRepository;

    public ResponseEntity<Object> createBar(@ApiParam(value = "", required = true) @Valid @RequestBody Bar bar) {
        BarEntity newBarEntity = toBarEntity(bar);
        barRepository.save(newBarEntity);
        String name = newBarEntity.getName();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{name}")
                .buildAndExpand(newBarEntity.getName()).toUri();

        return ResponseEntity.created(location).build();
    }

    public ResponseEntity<List<Bar>> getBars() {
        List<Bar> bars = new ArrayList<>();
        for (BarEntity barEntity : barRepository.findAll()) {
            bars.add(toBar(barEntity));
        }
        return ResponseEntity.ok(bars);
    }

    public ResponseEntity<Bar> getBar(@ApiParam(value = "",required=true) @PathVariable("name") String name) {
        BarEntity barEntity = barRepository.findByName(name);
        Bar bar = toBar(barEntity);
        return ResponseEntity.ok(bar);
    }

    @Transactional
    public ResponseEntity<Void> updateBar(@ApiParam(value = "",required=true) @PathVariable("name") String name, @ApiParam(value = "", required = true) @Valid @RequestBody Bar bar) {
        BarEntity barEntityToChange = barRepository.findByName(name);

        barEntityToChange.setAddress(bar.getAddress());
        barEntityToChange.setName(bar.getName());

        barRepository.save(barEntityToChange);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Void> deleteBar(@ApiParam(value = "",required=true) @PathVariable("name") String name) {
        barRepository.deleteByName(name);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    private BarEntity toBarEntity(Bar bar) {
        BarEntity entity = new BarEntity();
        entity.setName(bar.getName());
        entity.setAddress(bar.getAddress());
        return entity;
    }

    private Bar toBar(BarEntity entity) {
        Bar bar = new Bar();
        bar.setName(entity.getName());
        bar.setAddress(entity.getAddress());
        return bar;
    }

}