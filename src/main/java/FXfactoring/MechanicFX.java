package FXfactoring;

import classes.Car;
import classes.CarShop;
import classes.Orders;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableObjectValue;
import javafx.collections.ObservableSet;

import java.util.Set;

public class MechanicFX {

    private SimpleLongProperty id = new SimpleLongProperty();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty surname = new SimpleStringProperty();
    private SimpleObjectProperty<CarShop> carShop = new SimpleObjectProperty<>();
    private SimpleSetProperty<Car> cars = new SimpleSetProperty<>();
    private SimpleObjectProperty<Orders> orders = new SimpleObjectProperty<>();


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

    public String getSurname() {
        return surname.get();
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public CarShop getCarShop() {
        return carShop.get();
    }

    public SimpleObjectProperty<CarShop> carShopProperty() {
        return carShop;
    }

    public void setCarShop(CarShop carShop) {
        this.carShop.set(carShop);
    }

    public ObservableSet<Car> getCars() {
        return cars.get();
    }

    public SimpleSetProperty<Car> carsProperty() {
        return cars;
    }

    public void setCars(ObservableSet<Car> cars) {
        this.cars.set(cars);
    }

    public Orders getOrders() {
        return orders.get();
    }

    public SimpleObjectProperty<Orders> ordersProperty() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders.set(orders);
    }

    @Override
    public String toString() {
        return "MechanicFX{" +
                "id=" + id +
                ", name=" + name +
                ", surname=" + surname +
                ", carShop=" + carShop +
                ", cars=" + cars +
                ", orders=" + orders +
                '}';
    }

}
