package ifpr.pgua.eic.projetointegrador.controllers;

import ifpr.pgua.eic.projetointegrador.controllers.viewmodels.TelaFuncionarioViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class TelaEditar {
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

    private TelaFuncionarioViewModel viewModel;

    public TelaEditar(TelaFuncionarioViewModel viewModel){
        this.viewModel = viewModel;
    }

    @FXML
    private void editar(){
        viewModel.editar();
    }

    @FXML
    private void limpar(){
        viewModel.limpar();
    }
}
