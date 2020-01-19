package ch.heigvd.boozify.beers.repositories;

import ch.heigvd.boozify.beers.entities.BarEntity;
import ch.heigvd.boozify.beers.entities.BeerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeerRepository extends CrudRepository<BeerEntity, Long>{
    BeerEntity findByName(String name);
    void deleteByName(String name);
}