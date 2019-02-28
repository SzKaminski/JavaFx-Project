package FXfactoring.observablelistclasses;

import FXfactoring.CarFX;
import FXfactoring.Converter;
import classes.Car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CarDao;

import java.util.List;

public class ObservableListClass {

    private ObservableList<CarFX> observableList = FXCollections.observableArrayList();

    public void addAllObservableList(){
        List<Car> cars = CarDao.getAll(Car.class);
        cars.forEach(car -> {
            this.observableList.add(Converter.converttoCarFx(car));
        });
    }

    public ObservableList<CarFX> getObservableList() {
        return observableList;
    }

    public void setObservableList(ObservableList<CarFX> observableList) {
        this.observableList = observableList;
    }


}
