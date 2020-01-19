package ch.heigvd.boozify.beers.entities;

import ch.heigvd.boozify.beers.entities.BeerEntity;
import ch.heigvd.boozify.beers.model.Beer;

import javax.persistence.*;
import java.io.Serializable;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "bar_entity"
)
public class BarEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bar_id;

    private String name;
    private String address;

    @ManyToMany(
            cascade={CascadeType.ALL}
    )
    @JoinTable(
            name = "bar_entity_beer_entity",
            joinColumns = {@JoinColumn(name = "bar_id")},
            inverseJoinColumns = {@JoinColumn(name = "beer_id")}
    )
    private List<BeerEntity> beers;

    public List<BeerEntity> getBeers() {     return beers;   }

    public void setBeers(List<BeerEntity> beers) {     this.beers = beers;   }
    public void addBeer(BeerEntity beer) {   this.beers.add(beer);   }

    public Long getBar_id() {
        return bar_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}