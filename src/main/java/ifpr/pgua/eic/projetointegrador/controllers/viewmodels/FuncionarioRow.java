package ifpr.pgua.eic.projetointegrador.controllers.viewmodels;

import java.time.format.DateTimeFormatter;

import ifpr.pgua.eic.projetointegrador.model.entities.Funcionario;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FuncionarioRow {
    
    private Funcionario funcionario;

    public FuncionarioRow(Funcionario funcionario){
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario(){
        return funcionario;
    }

    public IntegerProperty idProperty(){
        return new SimpleIntegerProperty(funcionario.getId());
    }

    public StringProperty nomeProperty(){
        return new SimpleStringProperty(funcionario.getNome());
    }

    public StringProperty enderecoProperty(){
        return new SimpleStringProperty(funcionario.getEndereco());
    }

    public IntegerProperty telefoneProperty(){
        return new SimpleIntegerProperty(funcionario.getTelefone());
    }

    public StringProperty sexoProperty(){
        return new SimpleStringProperty(funcionario.getSexo());
    }
    
    public StringProperty datadeNascimentoProperty(){
        return new SimpleStringProperty(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(funcionario.getDatadeNascimento()));
    }

    public IntegerProperty telefoneEmergenciaProperty(){
        return new SimpleIntegerProperty(funcionario.getTelefoneEmergencia());
    }

    
}
