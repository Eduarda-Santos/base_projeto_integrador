package ifpr.pgua.eic.projetointegrador.controllers.viewmodels;

import ifpr.pgua.eic.projetointegrador.model.entities.Funcionario;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FuncionarioRow {
    
    private Funcionario funcionario;

    public FuncionarioRow(Funcionario funcionario){
        this.funcionario = funcionario;
    }

    public StringProperty idProperty(){
        return new SimpleStringProperty(String.valueOf(funcionario.getId()));
    }
}
