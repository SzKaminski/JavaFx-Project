package Controllers.TableViewControllers;

import Controllers.Controller;
import FXfactoring.MechanicFX;
import FXfactoring.observablelistclasses.ObservableListMechanicClass;
import classes.Car;
import classes.CarShop;
import classes.Orders;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Set;

public class TableViewMechanicController {

    private Controller controller;

    @FXML
    private TableView<MechanicFX> tableViewMechanic;
    @FXML
    private TableColumn<MechanicFX, Number> mechanicIdColumn;
    @FXML
    private TableColumn<MechanicFX, String> nameMechanicColumn;
    @FXML
    private TableColumn<MechanicFX, String> surnameMechanicColumn;
    @FXML
    private TableColumn<MechanicFX, CarShop> carshopMechanicColumn;
    @FXML
    private TableColumn<MechanicFX, Set<Car>> carsMechanicColumn;
    @FXML
    private TableColumn<MechanicFX, Orders> orderMechanicColumn;

    @FXML
    void initialize(){
        ObservableListMechanicClass observableListClass = new ObservableListMechanicClass();

        observableListClass.addAllObservableList();

        tableViewMechanic.setItems(observableListClass.getObservableList());
        this.mechanicIdColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        this.nameMechanicColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        this.surnameMechanicColumn.setCellValueFactory(cellData -> cellData.getValue().surnameProperty());
        this.carshopMechanicColumn.setCellValueFactory(cellData -> cellData.getValue().carShopProperty());
       // this.carsMechanicColumn.setCellValueFactory(cellData -> cellData.getValue().carsProperty()));
        this.orderMechanicColumn.setCellValueFactory(cellData -> cellData.getValue().ordersProperty());
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public TableView<MechanicFX> getTableViewMechanic() {
        return tableViewMechanic;
    }
}
