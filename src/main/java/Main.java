import Controllers.Controller;
import classes.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.CarDao;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main extends Application {

    static Stage window;
    public static void main(String[] args) {

        Set<Mechanic> mechanicsSet = new HashSet<>();
        Set<Car> carsSet = new HashSet<>();

        Car car0 = new Car(null, "Renault", "Megane", CarBodyType.CABRIO, LocalDate.of(1999,06,30),"Red", 184000, null);
        Car car1 = new Car(null,"BMW", "E60",CarBodyType.SEDAN,LocalDate.of(2006,02,11),"Blue",89000, null);
        Car car2 = new Car(null,"BMW","E28",CarBodyType.SEDAN,LocalDate.of(1984,07,23),"Red",516000,null);
        Car car3 = new Car(null,"Toyota", "Avensis", CarBodyType.COMBI,LocalDate.of(2014,03,02),"Yellow",216000,null);
        Car car4 = new Car(null,"Toyota","Rav4",CarBodyType.CABRIO,LocalDate.of(2009,03,24),"Black", 77000,null);
        Car car5 = new Car(null,"Tesla","Model X", CarBodyType.COMBI,LocalDate.of(2018,01,01),"White",200,null);
        Car car6 = new Car(null,"Renault","Laguna",CarBodyType.COMBI,LocalDate.of(1994,02,02),"Pink",84000,null);


        CarShop carShop0 = new CarShop(null,"GorillaGaraz",mechanicsSet);
        Mechanic mechanic0 = new Mechanic(null,"Kamil", "Slimak", carsSet, null, carShop0);
        Orders orders = new Orders(null, mechanic0, car1, "Uszkodzony silnik",false);


        CarDao.createEntity(car0);
        CarDao.createEntity(car1);
        CarDao.createEntity(car2);
        CarDao.createEntity(car3);
        CarDao.createEntity(car4);
        CarDao.createEntity(car5);
        CarDao.createEntity(car6);

        CarDao.createEntity(carShop0);
        CarDao.createEntity(mechanic0);
        CarDao.createEntity(orders);



        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        BorderPane layout = new BorderPane();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/sample.fxml"));
        Controller controller = new Controller();
        loader.setController(controller);
        ChoiceBox chooseMechanic = new ChoiceBox();
        chooseMechanic.getItems();

        SplitPane splitPane = loader.load();
        window.setResizable(false);

        layout.setCenter(splitPane);
        Scene scene = new Scene(layout, 600, 410);
        window.setScene(scene);
        window.setTitle("JAVAFX PROGRAM");
        window.show();
    }
}
