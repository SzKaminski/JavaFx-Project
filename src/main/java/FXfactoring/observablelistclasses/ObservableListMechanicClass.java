package FXfactoring.observablelistclasses;

import FXfactoring.Converter;
import FXfactoring.MechanicFX;
import classes.Mechanic;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CarDao;
import model.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.List;

public class ObservableListMechanicClass {

    private ObservableList<MechanicFX> observableList = FXCollections.observableArrayList();


    public void addAllObservableList(){
        List<Mechanic> mechanics = CarDao.getAll(Mechanic.class);
        mechanics.forEach(mechanic -> {
            this.observableList.add(Converter.converttoMechanicFx(mechanic));
        });
    }

    public ObservableList<MechanicFX> getObservableList() {
        return observableList;
    }

    public void setObservableList(ObservableList<MechanicFX> observableList) {
        this.observableList = observableList;
    }

}
