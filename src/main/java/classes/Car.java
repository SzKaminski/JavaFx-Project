package classes;

import lombok.*;
import model.CarEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car extends CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    private CarBodyType carBodyType;
    private LocalDate productionDate;
    private String color;
    private long km;
    private LocalDateTime modifiedDate;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Mechanic mechanic;

    @OneToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Orders> orders;

    public Car(Long id, String brand, String model, CarBodyType carBodyType, LocalDate productionDate, String color, long km, LocalDateTime modifiedDate) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.carBodyType = carBodyType;
        this.productionDate = productionDate;
        this.color = color;
        this.km = km;
        this.modifiedDate = modifiedDate;
    }

    public Car(String brand, String model, CarBodyType carBodyType, LocalDate productionDate, String color, long km) {
        this.brand = brand;
        this.model = model;
        this.carBodyType = carBodyType;
        this.productionDate = productionDate;
        this.color = color;
        this.km = km;
    }
}
