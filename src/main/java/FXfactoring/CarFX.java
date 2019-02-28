package FXfactoring;

import classes.Car;
import classes.CarBodyType;
import classes.Mechanic;
import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CarFX extends Car {

    private SimpleLongProperty id = new SimpleLongProperty();
    private SimpleStringProperty brand = new SimpleStringProperty();
    private SimpleStringProperty model = new SimpleStringProperty();
    private ObjectProperty<CarBodyType> carBodyType = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> localDate = new SimpleObjectProperty<>();
    private SimpleStringProperty color = new SimpleStringProperty();
    private SimpleLongProperty km = new SimpleLongProperty();
    private ObjectProperty<LocalDateTime> modifiedDate = new SimpleObjectProperty<>();
    private ObjectProperty<Mechanic> mechanic = new SimpleObjectProperty<>();

    @Override
    public Long getId() {
        return id.get();
    }

    public SimpleLongProperty idProperty() {
        return id;
    }

    public void setId(Long id) {
        this.id.set(id);
    }

    public String getBrand() {
        return brand.get();
    }

    public SimpleStringProperty brandProperty() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public String getModel() {
        return model.get();
    }

    public SimpleStringProperty modelProperty() {
        return model;
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    public CarBodyType getCarBodyType() {
        return carBodyType.get();
    }

    public ObjectProperty<CarBodyType> carBodyTypeProperty() {
        return carBodyType;
    }

    public void setCarBodyType(CarBodyType carBodyType) {
        this.carBodyType.set(carBodyType);
    }

    public LocalDate getLocalDate() {
        return localDate.get();
    }

    public ObjectProperty<LocalDate> localDateProperty() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate.set(localDate);
    }

    public String getColor() {
        return color.get();
    }

    public SimpleStringProperty colorProperty() {
        return color;
    }

    public void setColor(String color) {
        this.color.set(color);
    }

    public long getKm() {
        return km.get();
    }

    public SimpleLongProperty kmProperty() {
        return km;
    }

    public void setKm(long km) {
        this.km.set(km);
    }

    public LocalDateTime getModifiedDate() {
        return LocalDateTime.from(modifiedDate.get());
    }

    public ObjectProperty<LocalDateTime> modifiedDateProperty() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate.set(modifiedDate);
    }

    @Override
    public Mechanic getMechanic() {
        return mechanic.get();
    }

    public ObjectProperty<Mechanic> mechanicProperty() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic.set(mechanic);
    }

    @Override
    public String toString() {
        return "CarFX{" +
                "id=" + id +
                ", brand=" + brand +
                ", model=" + model +
                ", carBodyType=" + carBodyType +
                ", localDate=" + localDate +
                ", color=" + color +
                ", km=" + km +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}