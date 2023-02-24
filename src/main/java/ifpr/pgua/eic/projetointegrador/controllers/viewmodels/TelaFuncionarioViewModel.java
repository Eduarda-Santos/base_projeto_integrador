package ifpr.pgua.eic.projetointegrador.controllers.viewmodels;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Objects;
import java.util.ResourceBundle;

import ifpr.pgua.eic.projetointegrador.controllers.BaseController;
import ifpr.pgua.eic.projetointegrador.controllers.TelaFuncionarios;
import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.daos.FuncionarioDAO;
import ifpr.pgua.eic.projetointegrador.model.daos.JDBCFuncionario;
import ifpr.pgua.eic.projetointegrador.model.entities.Funcionario;
import ifpr.pgua.eic.projetointegrador.model.repositories.FuncionarioRepository;
import ifpr.pgua.eic.projetointegrador.model.results.Result;
import ifpr.pgua.eic.projetointegrador.model.results.SuccessResult;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import static java.lang.Integer.parseInt;;

public class TelaFuncionarioViewModel {
    private StringProperty idProperty = new SimpleStringProperty(); 
    private StringProperty nomeProperty = new SimpleStringProperty();
    private StringProperty telefoneProperty = new SimpleStringProperty();
    private StringProperty enderecoProperty = new SimpleStringProperty();
    private StringProperty sexoProperty = new SimpleStringProperty();
    private ObjectProperty<LocalDate> datadeNascimentoProperty = new SimpleObjectProperty<>();
    private StringProperty telefoneEmergenciaProperty = new SimpleStringProperty();
    private ObjectProperty<Result> alertProperty = new SimpleObjectProperty<>();
    private ObjectProperty<FuncionarioRow> selecionado = new SimpleObjectProperty<>();

    private StringProperty operacao = new SimpleStringProperty("Cadastrar");
    private BooleanProperty podeEditar = new SimpleBooleanProperty(true);
    private boolean editar = false;

    private ObservableList<FuncionarioRow> funcionarios = FXCollections.observableArrayList();
    
    private FuncionarioRepository repository;

    public TelaFuncionarioViewModel(FuncionarioRepository repository){
        this.repository = repository;

        updateList();
    }

    public void updateList(){
        funcionarios.clear();
        for(Funcionario f : repository.getFuncionarios()){
            funcionarios.add(new FuncionarioRow(f));
        }
    }

    public ObservableList<FuncionarioRow> getFuncionarios(){
        return funcionarios;
    }
    
    public ObjectProperty<Result> alertProperty() {
        return alertProperty;
    }

    public StringProperty operacaoProperty() {
        return operacao;
    }

    public BooleanProperty podeEditarProperty() {
        return podeEditar;
    }

    public StringProperty nomeProperty(){
        return this.nomeProperty;
    }

    public StringProperty telefoneProperty(){
        return this.telefoneProperty;
    }

    public StringProperty enderecoProperty(){
        return this.enderecoProperty;
    }

    public StringProperty sexoProperty(){
        return this.sexoProperty;
    }

    
    public ObjectProperty<LocalDate> datadeNascimentoProperty() {
        return datadeNascimentoProperty;
    }

    public StringProperty telefoneEmergenciaProperty(){
        return this.telefoneEmergenciaProperty;
    }

    public ObjectProperty<FuncionarioRow> selecionadoProperty() {
        return selecionado;
    }
    
    public Result cadastrar(){
        String nome = nomeProperty.getValue();
        int telefone = parseInt(telefoneProperty.getValue());
        String endereco = enderecoProperty.getValue();
        String sexo = sexoProperty.getValue();
        //Date sdatadeNascimento = datadeNascimentoProperty.getValue();
        LocalDate datadeNascimento = datadeNascimentoProperty.getValue();
        int telefoneEmergencia = parseInt(telefoneEmergenciaProperty.getValue());

        
        //LocalDate datadeNascimento = null;
        //repository.adicionarFuncionario(nome, telefone, endereco, sexo, datadeNascimento, telefoneEmergencia);
        //repository.adicionarFuncionario(nome, telefone, endereco, sexo, telefoneEmergencia);
         
        Result resultado = null;
        
        if(editar){
            repository.editarFuncionario(nome, telefone, endereco, sexo, telefoneEmergencia);
            //Result msg = Result.success("Funcionário Editado com sucesso!");
        }
        else{
            resultado = repository.adicionarFuncionario(nome, telefone, endereco, sexo, telefoneEmergencia);
            //msg = Result.success("Funcionário Cadastrado com sucesso!");
        }
        //return msg;
        updateList();
        limpar();

        if(resultado instanceof SuccessResult){
            updateList();
            limpar();
        }
        return resultado;
    }

    public void editar(){
        operacao.setValue("Editar");
        podeEditar.setValue(false);
        editar = true;
        Funcionario funcionario = selecionado.get().getFuncionario();
        nomeProperty.setValue(funcionario.getNome());
        //telefoneProperty.setValue(funcionario.getTelefone());
        enderecoProperty.setValue(funcionario.getEndereco());
        sexoProperty.setValue(funcionario.getSexo());
        //telefoneEmergenciaProperty.setValue(funcionario.getTelefoneEmergencia());
        
       // datadeNascimentoProperty.set(funcionario.getDatadeNascimento());
        //LocalDate datadeNascimento = sdatadeNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        alertProperty.setValue(Result.fail("Teste"));
    }

    public void limpar(){
        idProperty.setValue("");
        nomeProperty.setValue("");
        telefoneProperty.setValue(null);
        enderecoProperty.setValue("");
        sexoProperty.setValue("");
        //datadeNascimentoProperty.setValue(null);
        telefoneEmergenciaProperty.setValue(null);
        podeEditar.setValue(true);
        editar = false;
        operacao.setValue("Cadastrar");
    }
}
