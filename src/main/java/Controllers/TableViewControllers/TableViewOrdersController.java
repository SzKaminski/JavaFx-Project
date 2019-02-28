package Controllers.TableViewControllers;

import Controllers.Controller;
import FXfactoring.MechanicFX;
import FXfactoring.OrdersFX;
import FXfactoring.observablelistclasses.ObservableListMechanicClass;
import FXfactoring.observablelistclasses.ObservableListOrdersClass;
import classes.Car;
import classes.CarShop;
import classes.Mechanic;
import classes.Orders;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class TableViewOrdersController {

    private Controller controller;

    @FXML
    private TableView<OrdersFX> tableViewOrders;
    @FXML
    private TableColumn<OrdersFX, Number> ordersIdColumn;
    @FXML
    private TableColumn<OrdersFX, Car> carOrdersColumn;
    @FXML
    private TableColumn<OrdersFX, String> detailsOrdersColumn;
    @FXML
    private TableColumn<OrdersFX, Mechanic> mechanicOrdersColumn;
    @FXML
    private TableColumn<OrdersFX, Boolean> isSolvedOrdersColumn;

    @FXML
    void initialize(){
        ObservableListOrdersClass observableListClass = new ObservableListOrdersClass();

        observableListClass.addAllObservableList();

        tableViewOrders.setItems(observableListClass.getObservableList());
        this.ordersIdColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        this.carOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().carProperty());
        this.detailsOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().faultDetailsProperty());
        this.mechanicOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().mechanicProperty());
        this.isSolvedOrdersColumn.setCellValueFactory(cellData -> cellData.getValue().isSolvedProperty());

    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
