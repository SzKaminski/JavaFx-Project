package Controllers.TableViewControllers;

import Controllers.Controller;
import FXfactoring.CarShopFX;
import FXfactoring.observablelistclasses.ObservableListCarShopClass;
import FXfactoring.observablelistclasses.ObservableListMechanicClass;
import classes.Car;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Set;

public class TableViewCarShopController {

    private Controller controller;

    @FXML
    private TableView<CarShopFX> tableViewMechanic;
    @FXML
    private TableColumn<CarShopFX, Number> carShopIdColumn;
    @FXML
    private TableColumn<CarShopFX, String> nameCarShopColumn;
    @FXML
    private TableColumn<CarShopFX, Set<Car>> mechanicsCarShopColumn;

    @FXML
    void initialize(){
        ObservableListCarShopClass observableListClass = new ObservableListCarShopClass();

        observableListClass.addAllObservableList();

        tableViewMechanic.setItems(observableListClass.getObservableList());
        this.carShopIdColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        this.nameCarShopColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
     //   this.mechanicsCarShopColumn.setCellValueFactory(cellData -> cellData.getValue().setMechanics());

    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
