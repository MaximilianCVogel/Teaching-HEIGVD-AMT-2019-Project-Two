package ch.heigvd.boozify.beers.repositories;

import ch.heigvd.boozify.beers.entities.BeerEntity;
import org.springframework.data.repository.CrudRepository;

public interface BeerRepository extends CrudRepository<BeerEntity, Long>{
    BeerEntity findByName(String name);
    void deleteByName(String name);
}