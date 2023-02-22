package ifpr.pgua.eic.projetointegrador.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.fxml.Initializable;
import ifpr.pgua.eic.projetointegrador.model.results.Result;
import ifpr.pgua.eic.projetointegrador.model.results.SuccessResult;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.event.ChangeListener;

import ifpr.pgua.eic.projetointegrador.controllers.viewmodels.FuncionarioRow;
import ifpr.pgua.eic.projetointegrador.controllers.viewmodels.TelaFuncionarioViewModel;

public class TelaFuncionarios extends BaseController {

    @FXML
    public TextField tfNome;

    @FXML
    public TableColumn<FuncionarioRow, String> tbcNome;

    @FXML
    public TableColumn<FuncionarioRow, Integer> tbcTelefone;

    @FXML
    public TableColumn<FuncionarioRow, String> tbcEndereco;

    @FXML
    public TableColumn<FuncionarioRow, String> tbcSexo;

    @FXML
    public TableColumn<FuncionarioRow, Integer> tbcTelefoneEmergencia;

    @FXML
    public TableView<FuncionarioRow> tbFuncionarios;

    @FXML
    public TextField tfTelefone;

    @FXML
    public TextField tfEndereco;

    @FXML
    public TextField tfSexo;

    @FXML
    private DatePicker dpDataNascimento;

    @FXML
    public TextField tfTelefoneEmergencia;

    @FXML
    public Button btCadastrar;
    
    @FXML
    private Button btLimpar;

    public TelaFuncionarioViewModel viewModel;

    public TelaFuncionarios(TelaFuncionarioViewModel viewModel){
        this.viewModel = viewModel;
    }

    public void initialize(URL arg0, ResourceBundle arg1) {
        
    
        //define quais serão as propriedades que servirão para preencher
        //o valor da coluna. Note que o nome da propriedade deve possuir
        //um get equivalente no modelo que representa a linha da tabela.
        
        tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbcTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tbcEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        tbcSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        tbcTelefoneEmergencia.setCellValueFactory(new PropertyValueFactory<>("telefoneEmergencia"));
    
        //liga o conjunto de itens da tabela com a lista de clientes do viewmodel
        tbFuncionarios.setItems(viewModel.getFuncionarios());
    
        //liga a propriedade selecionado do viewmodel com a tabela
        viewModel.selecionadoProperty().bind(tbFuncionarios.getSelectionModel().selectedItemProperty());
    
        /*viewModel.alertProperty().addListener((ChangeListener<Result>) (observable, oldVal, newVal) -> {
            // TODO Auto-generated method stub
            BaseController.showMessage(newVal);
        });*/
    
        //liga a propriedade texto do textfield nome com a propriedade do viewmodel
        tfNome.textProperty().bindBidirectional(viewModel.nomeProperty());
        //liga a propriedade editavel do textfield com a propriedade do viewmodel
        tfNome.editableProperty().bind(viewModel.podeEditarProperty());
        
        
        tfTelefone.textProperty().bindBidirectional(viewModel.telefoneProperty());
        tfTelefone.editableProperty().bind(viewModel.podeEditarProperty());
    
        tfEndereco.textProperty().bindBidirectional(viewModel.enderecoProperty());
        tfEndereco.editableProperty().bind(viewModel.podeEditarProperty());
    
        tfSexo.textProperty().bindBidirectional(viewModel.sexoProperty());
        tfSexo.editableProperty().bind(viewModel.podeEditarProperty());
    
        tfTelefoneEmergencia.textProperty().bindBidirectional(viewModel.telefoneEmergenciaProperty());
        tfTelefoneEmergencia.editableProperty().bind(viewModel.podeEditarProperty());
    
        btCadastrar.textProperty().bind(viewModel.operacaoProperty());
    }

    @FXML
    private void cadastrar(){
        viewModel.cadastrar();
        //showMessage(Result msg);
    }

    @FXML
    private void limpar(){
        viewModel.limpar();
    }
    
    @FXML
    private void editar(MouseEvent event){
        if(event.getClickCount() == 2){
            viewModel.editar();
        }
        
    }

}
