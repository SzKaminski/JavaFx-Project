package classes;

import lombok.*;
import model.CarEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mechanic extends CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;

    @OneToMany(mappedBy = "mechanic")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Car> cars;

    @ManyToOne
    @ToString.Exclude
    private Orders orders;

    @ManyToOne
    @ToString.Exclude
    private CarShop carShop;

    public Mechanic(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }


}
