package Controllers;

import Controllers.TableViewControllers.TableViewController;
import Controllers.TableViewControllers.TableViewMechanicController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;


public class Controller {

    @FXML
    private SplitPane mainSplitPane;
    @FXML
    private MenuButtonsController menuButtonsController;

    @FXML
    private TableViewController tableViewController;

    @FXML
    private TableViewMechanicController tableViewMechanicController;

    @FXML
    private BorderPane borderPane;

    @FXML
    private BorderPane upAnchorPane;



    @FXML
    private void initialize(){
        menuButtonsController.setController(this);
    }

    public void setTable(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        Parent parent = loader.load();
        upAnchorPane.setCenter(parent);

    }


    public void setCenter(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        Parent parent = loader.load();
        borderPane.setCenter(parent);
    }
}
