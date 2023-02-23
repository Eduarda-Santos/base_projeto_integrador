package ifpr.pgua.eic.projetointegrador.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.projetointegrador.controllers.viewmodels.AreaRow;
import ifpr.pgua.eic.projetointegrador.controllers.viewmodels.FuncionarioRow;
import ifpr.pgua.eic.projetointegrador.controllers.viewmodels.TelaAreaViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class TelaAreas extends BaseController{
    @FXML
    private TextField tfNome;

    @FXML
    public TableColumn<AreaRow, String> tbcNome;

    @FXML
    public TableView<AreaRow> tbAreas;

    @FXML
    private Button btCadastrar;
    
    @FXML
    private Button btLimpar;

    private TelaAreaViewModel viewModel;

    public TelaAreas(TelaAreaViewModel telaAreaViewModel){
        this.viewModel = telaAreaViewModel;
    }

    public void initialize(URL arg0, ResourceBundle arg1) {
        
    
        //define quais serão as propriedades que servirão para preencher
        //o valor da coluna. Note que o nome da propriedade deve possuir
        //um get equivalente no modelo que representa a linha da tabela.
        
        tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    
        //liga o conjunto de itens da tabela com a lista de clientes do viewmodel
        tbAreas.setItems(viewModel.getAreas());
    
        //liga a propriedade selecionado do viewmodel com a tabela
        viewModel.selecionadoProperty().bind(tbAreas.getSelectionModel().selectedItemProperty());
    
        /*viewModel.alertProperty().addListener((ChangeListener<Result>) (observable, oldVal, newVal) -> {
            // TODO Auto-generated method stub
            BaseController.showMessage(newVal);
        });*/
    
        //liga a propriedade texto do textfield nome com a propriedade do viewmodel
        tfNome.textProperty().bindBidirectional(viewModel.nomeProperty());
        //liga a propriedade editavel do textfield com a propriedade do viewmodel
        tfNome.editableProperty().bind(viewModel.podeEditarProperty());
    
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
