package classes;

import lombok.*;
import model.CarEntity;

import javax.persistence.*;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarShop extends CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Mechanic> mechanics;

    public CarShop(String name) {
        this.name = name;
    }

    public void addToMechanics(Mechanic mechanic){
        mechanics.add(mechanic);
    }
}
