package ch.heigvd.boozify.beers.api.endpoints;


import ch.heigvd.boozify.beers.api.CompaniesApi;
import ch.heigvd.boozify.beers.entities.CompanyEntity;
import ch.heigvd.boozify.beers.model.Company;
import ch.heigvd.boozify.beers.repositories.CompanyRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-26T19:36:34.802Z")

@Controller
public class CompaniesApiController implements CompaniesApi {

    @Autowired
    CompanyRepository companyRepository;

    public ResponseEntity<Object> createCompany(@ApiParam(value = "", required = true) @Valid @RequestBody Company company) {
        CompanyEntity newCompanyEntity = toCompanyEntity(company);
        companyRepository.save(newCompanyEntity);
        Long id = newCompanyEntity.getId();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(newCompanyEntity.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    public ResponseEntity<List<Company>> getCompanies() {
        List<Company> companies = new ArrayList<>();
        for (CompanyEntity companyEntity : companyRepository.findAll()) {
            companies.add(toCompany(companyEntity));
        }
        return ResponseEntity.ok(companies);
    }

    public ResponseEntity<Company> getCompany(@ApiParam(value = "",required=true) @PathVariable("name") String name) {
        CompanyEntity companyEntity = companyRepository.findByName(name);
        Company company = toCompany(companyEntity);
        return ResponseEntity.ok(company);
    }

    private CompanyEntity toCompanyEntity(Company company) {
        CompanyEntity entity = new CompanyEntity();
        entity.setName(company.getName());
        entity.setAddress(company.getAddress());
        return entity;
    }

    private Company toCompany(CompanyEntity entity) {
        Company company = new Company();
        company.setName(entity.getName());
        company.setAddress(entity.getAddress());
        return company;
    }

}