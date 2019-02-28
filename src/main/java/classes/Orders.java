package classes;

import lombok.*;
import model.CarDao;
import model.CarEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders extends CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @ToString.Exclude
    private Mechanic mechanic;

    @ManyToOne
    @ToString.Exclude
    private Car car;

    private String faultDetails;
    private boolean isSolved;

    public Orders(String faultDetails) {
        this.faultDetails = faultDetails;
    }
}
