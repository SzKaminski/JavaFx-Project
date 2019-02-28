package Controllers.TableViewControllers;

import Controllers.Controller;
import FXfactoring.CarFX;
import FXfactoring.observablelistclasses.ObservableListClass;
import classes.*;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TableViewController {

    private Controller controller;

    @FXML
    private TableView<CarFX> tableView;
    @FXML
    private TableColumn<CarFX, Number> idColumn;
    @FXML
    private TableColumn<CarFX, String> brandColumn;
    @FXML
    private TableColumn<CarFX, CarBodyType> bodytypeColumn;
    @FXML
    private TableColumn<CarFX,String> colorColumn;
    @FXML
    private TableColumn<CarFX,Long> kmColumn;
    @FXML
    private TableColumn<CarFX,String> modelColumn;
    @FXML
    private TableColumn<CarFX, LocalDateTime> modifiedColumn;
    @FXML
    private TableColumn<CarFX, LocalDate> productionColumn;
    @FXML
    private TableColumn<CarFX, Mechanic> mechanicColumn;


    public TableViewController() {
    }


    @FXML
    void initialize(){
        ObservableListClass observableListClass = new ObservableListClass();

        observableListClass.addAllObservableList();

        tableView.setItems(observableListClass.getObservableList());
        this.idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        this.brandColumn.setCellValueFactory(cellData -> cellData.getValue().brandProperty());
        this.bodytypeColumn.setCellValueFactory(cellData -> cellData.getValue().carBodyTypeProperty());
        this.colorColumn.setCellValueFactory(cellData -> cellData.getValue().colorProperty());
        this.colorColumn.setCellValueFactory(cellData -> cellData.getValue().colorProperty());
        this.kmColumn.setCellValueFactory(cellData -> cellData.getValue().kmProperty().asObject());
        this.modelColumn.setCellValueFactory(cellData -> cellData.getValue().modelProperty());
        this.modifiedColumn.setCellValueFactory(cellData -> cellData.getValue().modifiedDateProperty());
        this.productionColumn.setCellValueFactory(cellData -> cellData.getValue().localDateProperty());
        this.mechanicColumn.setCellValueFactory(cellData -> cellData.getValue().mechanicProperty());

    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void refreshList(){
        tableView.refresh();
    }


}
