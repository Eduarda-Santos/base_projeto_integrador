package ifpr.pgua.eic.projetointegrador.controllers.viewmodels;

import java.time.format.DateTimeFormatter;

import ifpr.pgua.eic.projetointegrador.model.entities.Area;
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

    public StringProperty idProperty(){
        return new SimpleStringProperty(String.valueOf(area.getId()));
    }

    public StringProperty nomeProperty(){
        return new SimpleStringProperty(String.valueOf(area.getNome()));
    }

    
}
