package FXfactoring;

import classes.Mechanic;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableSet;

public class CarShopFX {

    private SimpleLongProperty id = new SimpleLongProperty();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleSetProperty<Mechanic> mechanics = new SimpleSetProperty<>();

    public long getId() {
        return id.get();
    }

    public SimpleLongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public ObservableSet<Mechanic> getMechanics() {
        return mechanics.get();
    }

    public SimpleSetProperty<Mechanic> mechanicsProperty() {
        return mechanics;
    }

    public void setMechanics(ObservableSet<Mechanic> mechanics) {
        this.mechanics.set(mechanics);
    }

    @Override
    public String toString() {
        return "CarShopFX{" +
                "id=" + id +
                ", name=" + name +
                ", mechanics=" + mechanics +
                '}';
    }
}
