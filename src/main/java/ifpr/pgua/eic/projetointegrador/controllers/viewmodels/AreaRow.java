package ifpr.pgua.eic.projetointegrador.controllers.viewmodels;

import java.time.format.DateTimeFormatter;

import ifpr.pgua.eic.projetointegrador.model.entities.Area;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AreaRow {
    
    private Area area;

    public AreaRow(Area area){
        this.area = area;
    }

    public Area getArea(){
        return area;
    }

    public IntegerProperty idProperty(){
        return new SimpleIntegerProperty(area.getId());
    }

    public StringProperty nomeProperty(){
        return new SimpleStringProperty(area.getNome());
    }

    
}
