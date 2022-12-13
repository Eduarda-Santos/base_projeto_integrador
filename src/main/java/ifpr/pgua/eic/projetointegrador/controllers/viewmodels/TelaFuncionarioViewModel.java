package ifpr.pgua.eic.projetointegrador.controllers.viewmodels;

import java.sql.Date;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class TelaFuncionarioViewModel {
    private StringProperty nomeProperty = new SimpleStringProperty();
    private ObjectProperty<Date> dataProperty = new SimpleObjectProperty<>();
    

    public StringProperty nomeProperty(){
        return nomeProperty;
    }
    public void cadastrar(){
        String nome = nomeProperty.getValue();

        limpar();
    }
    
    public void limpar(){
        nomeProperty.setValue("");
    }
}
