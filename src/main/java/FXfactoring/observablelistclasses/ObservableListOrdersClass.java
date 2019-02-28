package FXfactoring.observablelistclasses;

import FXfactoring.CarShopFX;
import FXfactoring.Converter;
import FXfactoring.OrdersFX;
import classes.CarShop;
import classes.Orders;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CarDao;

import java.util.List;


public class ObservableListOrdersClass {

    private ObservableList<OrdersFX> observableList = FXCollections.observableArrayList();

    public void addAllObservableList(){
        List<Orders> ordersList = CarDao.getAll(Orders.class);
        ordersList.forEach(orders -> {
            this.observableList.add(Converter.converttoOrdersFx(orders));
        });
    }

    public ObservableList<OrdersFX> getObservableList() {
        return observableList;
    }

    public void setObservableList(ObservableList<OrdersFX> observableList) {
        this.observableList = observableList;
    }
}
