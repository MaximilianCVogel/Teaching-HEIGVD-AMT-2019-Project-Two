package ch.heigvd.boozify.beers.entities;

import ch.heigvd.boozify.beers.entities.BarEntity;
import ch.heigvd.boozify.beers.model.Bar;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(
        name = "beer_entity"
)
public class BeerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long beer_id;

    private String name;
    private String type;
    private int alcohol;

    @ManyToMany(mappedBy = "beers")
    private List<BarEntity> bars;

    public List<BarEntity> getBars() {     return bars;   }
    public void setBars(List<BarEntity> bars) {     this.bars = bars;   }
    public void addBar(BarEntity bar) {   this.bars.add(bar);   }

    public Long getBeer_id() { return beer_id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(int alcohol) {
        this.alcohol = alcohol;
    }
}