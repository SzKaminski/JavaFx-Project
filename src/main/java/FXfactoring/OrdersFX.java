package FXfactoring;

import classes.Car;
import classes.Mechanic;
import javafx.beans.property.*;

public class OrdersFX {

    private SimpleLongProperty id = new SimpleLongProperty();
    private SimpleObjectProperty<Car> car = new SimpleObjectProperty<>();
    private SimpleStringProperty faultDetails = new SimpleStringProperty();
    private SimpleObjectProperty<Mechanic> mechanic = new SimpleObjectProperty<>();
    private SimpleBooleanProperty isSolved = new SimpleBooleanProperty();

    public long getId() {
        return id.get();
    }

    public SimpleLongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public Car getCar() {
        return car.get();
    }

    public SimpleObjectProperty<Car> carProperty() {
        return car;
    }

    public void setCar(Car car) {
        this.car.set(car);
    }

    public String getFaultDetails() {
        return faultDetails.get();
    }

    public SimpleStringProperty faultDetailsProperty() {
        return faultDetails;
    }

    public void setFaultDetails(String faultDetails) {
        this.faultDetails.set(faultDetails);
    }

    public Mechanic getMechanic() {
        return mechanic.get();
    }

    public SimpleObjectProperty<Mechanic> mechanicProperty() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic.set(mechanic);
    }

    public boolean isIsSolved() {
        return isSolved.get();
    }

    public SimpleBooleanProperty isSolvedProperty() {
        return isSolved;
    }

    public void setIsSolved(boolean isSolved) {
        this.isSolved.set(isSolved);
    }

    @Override
    public String toString() {
        return "OrdersFX{" +
                "id=" + id +
                ", car=" + car +
                ", faultDetails=" + faultDetails +
                ", mechanic=" + mechanic +
                ", isSolved=" + isSolved +
                '}';
    }
}
