package ifpr.pgua.eic.projetointegrador.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import ifpr.pgua.eic.projetointegrador.controllers.viewmodels.TelaFuncionarioViewModel;

public class TelaFuncionarios extends BaseController {

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

    public TelaFuncionarios(TelaFuncionarioViewModel viewModel){
        this.viewModel = viewModel;
    }

    @FXML
    private void cadastrar(){
        viewModel.cadastrar();
    }

    @FXML
    private void limpar(){
        viewModel.limpar();
    }

}
