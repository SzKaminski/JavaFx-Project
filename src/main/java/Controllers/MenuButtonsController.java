package Controllers;

import classes.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import model.CarDao;

import java.io.IOException;

import static java.lang.Long.valueOf;


public class MenuButtonsController{



    private Controller controller;

    @FXML
    public void openAddCarMenu() throws IOException {
        controller.setCenter("/addStufffxmls/addCar.fxml");
        controller.setTable("/tableviews/tableView.fxml");
    }
    @FXML
    public void openAddMechanicMenu() throws IOException {
        controller.setCenter("/addStufffxmls/addMechanic.fxml");
        controller.setTable("/tableviews/tableViewMechanic.fxml");
    }
    @FXML
    public void openAddCarShopMenu() throws IOException {
        controller.setCenter("/addStufffxmls/addCarShop.fxml");
        controller.setTable("/tableviews/tableViewCarShop.fxml");
    }
    @FXML
    public void openOrderMenu() throws IOException {
        controller.setCenter("/addStufffxmls/addOrder.fxml");
        controller.setTable("/tableviews/tableViewOrders.fxml");
    }
    @FXML
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @FXML
    private TextField brandTextField;
    @FXML
    private TextField modelTextField;
    @FXML
    private TextField colorTextField;
    @FXML
    private ChoiceBox<CarBodyType> carBodyType;
    @FXML
    private TextField kmTextField;
    @FXML
    private DatePicker productionDater;

    public void addNewCar() {
        Car car = new Car(brandTextField.getText(),
                        modelTextField.getText(),
                        carBodyType.getValue(),
                        productionDater.getValue(),
                        colorTextField.getText(),
                        valueOf(kmTextField.getText()));
        boolean result = CarDao.createEntity(car);
        brandTextField.clear();
        modelTextField.clear();
        carBodyType.setValue(null);
        productionDater.getEditor().clear();
        colorTextField.clear();
        kmTextField.clear();

        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Add: " + result, ButtonType.CLOSE);
        alert.showAndWait();

    }

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;

    public void addNewMechanic() throws IOException {

        Mechanic mechanic = new Mechanic(nameTextField.getText(),surnameTextField.getText());
        boolean result = CarDao.createEntity(mechanic);
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Add: " + result, ButtonType.CLOSE);
        alert.showAndWait();

    }

    @FXML
    private TextField signTextField;

    public void addNewCarShop(){
        CarShop carShop = new CarShop(signTextField.getText());
        boolean result = CarDao.createEntity(carShop);
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Add: " + result, ButtonType.CLOSE);
        alert.showAndWait();

    }

    @FXML
    private TextArea faultDescribe;

    public void addNewOrder(){
        Orders orders = new Orders(faultDescribe.getText());
        boolean result = CarDao.createEntity(orders);
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Add: " + result, ButtonType.CLOSE);
        alert.showAndWait();

    }

}