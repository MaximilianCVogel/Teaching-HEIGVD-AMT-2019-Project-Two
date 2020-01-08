package ch.heigvd.boozify.beers.repositories;

import ch.heigvd.boozify.beers.entities.CompanyEntity;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<CompanyEntity, Long>{
    CompanyEntity findByName(String name);
}