package FXfactoring.observablelistclasses;

import FXfactoring.CarShopFX;
import FXfactoring.Converter;
import classes.CarShop;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CarDao;

import java.util.List;

public class ObservableListCarShopClass {

    private ObservableList<CarShopFX> observableList = FXCollections.observableArrayList();

    public void addAllObservableList(){
        List<CarShop> carShops = CarDao.getAll(CarShop.class);
        carShops.forEach(carShop -> {
            this.observableList.add(Converter.converttoCarShopFx(carShop));
        });
    }

    public ObservableList<CarShopFX> getObservableList() {
        return observableList;
    }

    public void setObservableList(ObservableList<CarShopFX> observableList) {
        this.observableList = observableList;
    }
}
