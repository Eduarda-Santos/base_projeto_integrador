package ifpr.pgua.eic.projetointegrador.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.spi.DirStateFactory.Result;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaFuncionarios {
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfTndereco;

    @FXML
    private TextField tfSexo;

    @FXML
    private DatePicker dpDataNascimento;

    @FXML
    private TextField tfTelefoneEmergencia;

    @FXML
    private Button btCadastrar;
    
    @FXML
    private Button btLimpar;


    @FXML
    private void cadastrar(){
        viewModel.cadastrar();
    }

    @FXML
    private void limpar(){
        viewModel.limpar();
    }

}
