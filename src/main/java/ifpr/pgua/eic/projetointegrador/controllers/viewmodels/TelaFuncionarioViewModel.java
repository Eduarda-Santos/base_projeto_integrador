package ifpr.pgua.eic.projetointegrador.controllers.viewmodels;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;

import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.daos.FuncionarioDAO;
import ifpr.pgua.eic.projetointegrador.model.daos.JDBCFuncionario;
import ifpr.pgua.eic.projetointegrador.model.entities.Funcionario;
import ifpr.pgua.eic.projetointegrador.model.repositories.FuncionarioRepository;
import ifpr.pgua.eic.projetointegrador.model.results.Result;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class TelaFuncionarioViewModel {
    private StringProperty nomeProperty = new SimpleStringProperty();
    private StringProperty telefoneProperty = new SimpleStringProperty();
    private StringProperty enderecoProperty = new SimpleStringProperty();
    private StringProperty sexoProperty = new SimpleStringProperty();
    private ObjectProperty<DateTimeFormatter> datadeNascimentoProperty = new SimpleObjectProperty<>();
    private StringProperty telefoneEmergenciaProperty = new SimpleStringProperty();
    private ObjectProperty<Result> alertProperty = new SimpleObjectProperty<>();
    private ObjectProperty<FuncionarioRow> selecionado = new SimpleObjectProperty<>();

    private StringProperty operacao = new SimpleStringProperty("Cadastrar");
    private BooleanProperty podeEditar = new SimpleBooleanProperty(true);
    private boolean atualizar = false;

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
        return this.funcionarios;
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
        return nomeProperty;
    }

    public StringProperty telefoneProperty(){
        return telefoneProperty;
    }

    public StringProperty enderecoProperty(){
        return enderecoProperty;
    }

    public StringProperty sexoProperty(){
        return sexoProperty;
    }

    public ObjectProperty<DateTimeFormatter> datadeNascimentoProperty() {
        return datadeNascimentoProperty;
    }

    public StringProperty telefoneEmergenciaProperty(){
        return telefoneEmergenciaProperty;
    }

    public ObjectProperty<FuncionarioRow> selecionadoProperty() {
        return selecionado;
    }
    
    public void cadastrar(){
        String nome = nomeProperty.getValue();
        String sTelefone = telefoneProperty.getValue();
        String endereco = enderecoProperty.getValue();
        String sexo = sexoProperty.getValue();
        DateTimeFormatter datadeNascimento = datadeNascimentoProperty.getValue();
        String sTelefoneEmergencia = telefoneEmergenciaProperty.getValue();
        
        Integer telefone = Integer.valueOf(sTelefone);
        Integer telefoneEmergencia = Integer.valueOf(sTelefoneEmergencia);

        repository.adicionarFuncionario(nome, 0, endereco, sexo, datadeNascimento, 0);
        
        limpar();
    }

    public void editar(){
        String nome = nomeProperty.getValue();
        String sTelefone = telefoneProperty.getValue();
        String endereco = enderecoProperty.getValue();
        String sexo = sexoProperty.getValue();
        DateTimeFormatter datadeNascimento = datadeNascimentoProperty.getValue();
        String sTelefoneEmergencia = telefoneEmergenciaProperty.getValue();
        Funcionario funcionario = selecionado.get().getFuncionario();
        
        Integer telefone = Integer.valueOf(sTelefone);
        Integer telefoneEmergencia = Integer.valueOf(sTelefoneEmergencia);

        repository.editarFuncionario(nome, 0, endereco, sexo, datadeNascimento, 0);
        
        limpar();
    }
    
    public void limpar(){
        nomeProperty.setValue("");
        telefoneProperty.setValue("");
        enderecoProperty.setValue("");
        sexoProperty.setValue("");
        datadeNascimentoProperty.setValue(null);
        telefoneEmergenciaProperty.setValue("");
    }
}
