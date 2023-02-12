package ifpr.pgua.eic.projetointegrador.controllers.viewmodels;

import java.time.format.DateTimeFormatter;

import ifpr.pgua.eic.projetointegrador.model.entities.Funcionario;
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

    public StringProperty idProperty(){
        return new SimpleStringProperty(String.valueOf(funcionario.getId()));
    }

    public StringProperty nomeProperty(){
        return new SimpleStringProperty(String.valueOf(funcionario.getNome()));
    }

    public StringProperty enderecoProperty(){
        return new SimpleStringProperty(String.valueOf(funcionario.getEndereco()));
    }

    public StringProperty telefoneProperty(){
        return new SimpleStringProperty(String.valueOf(funcionario.getTelefone()));
    }

    public StringProperty sexoProperty(){
        return new SimpleStringProperty(String.valueOf(funcionario.getSexo()));
    }
    /*
    public StringProperty datadeNascimentoProperty(){
        return new SimpleStringProperty(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(funcionario.getDatadeNascimento()));
    }*/

    public StringProperty telefoneEmergenciaProperty(){
        return new SimpleStringProperty(String.valueOf(funcionario.getTelefoneEmergencia()));
    }

    
}
