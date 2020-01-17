package ch.heigvd.boozify.beers.repositories;

import ch.heigvd.boozify.beers.entities.BarEntity;
import org.springframework.data.repository.CrudRepository;

public interface BarRepository extends CrudRepository<BarEntity, Long>{
    BarEntity findByName(String name);
    void deleteByName(String name);
}