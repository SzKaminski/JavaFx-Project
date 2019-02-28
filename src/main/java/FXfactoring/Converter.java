package FXfactoring;

import classes.Car;
import classes.CarShop;
import classes.Mechanic;
import classes.Orders;
import javafx.collections.ObservableSet;

import java.util.List;

public class Converter {

    public static Car converttoCar(CarFX carFX){
        Car car = new Car();
        car.setId(carFX.getId());
        car.setBrand(carFX.getBrand());
        car.setCarBodyType(carFX.getCarBodyType());
        car.setColor(carFX.getColor());
        car.setKm(carFX.getKm());
        car.setModel(carFX.getModel());
        car.setProductionDate(carFX.getProductionDate());

        return car;
    }

    public static CarFX converttoCarFx(Car car){
        CarFX carFX = new CarFX();
        carFX.setId(car.getId());
        carFX.setBrand(car.getBrand());
        carFX.setCarBodyType(car.getCarBodyType());
        carFX.setColor(car.getColor());
        carFX.setKm(car.getKm());
        carFX.setModel(car.getModel());
        carFX.setLocalDate(car.getProductionDate());

        return carFX;
    }

    public static MechanicFX converttoMechanicFx(Mechanic mechanic){
        MechanicFX mechanicFX = new MechanicFX();
        mechanicFX.setId(mechanic.getId());
        mechanicFX.setName(mechanic.getName());
        mechanicFX.setSurname(mechanic.getSurname());
        mechanicFX.setCarShop(mechanic.getCarShop());
     //   mechanicFX.setCars((ObservableSet<Car>) mechanic.getCars());
        mechanicFX.setOrders(mechanic.getOrders());

        return mechanicFX;
    }

    public static CarShopFX converttoCarShopFx(CarShop carShop) {
        CarShopFX carShopFX = new CarShopFX();
        carShopFX.setId(carShop.getId());
        carShopFX.setName(carShop.getName());
       // carShopFX.setMechanics(carShop.getMechanics());
        return carShopFX;
    }

    public static OrdersFX converttoOrdersFx(Orders orders) {
        OrdersFX ordersFX = new OrdersFX();
        ordersFX.setId(orders.getId());
        ordersFX.setCar(orders.getCar());
        ordersFX.setFaultDetails(orders.getFaultDetails());
        ordersFX.setMechanic(orders.getMechanic());
        ordersFX.setIsSolved(orders.isSolved());

        return ordersFX;
    }
}
