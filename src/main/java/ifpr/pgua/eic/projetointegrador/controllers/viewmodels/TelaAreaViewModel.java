package ifpr.pgua.eic.projetointegrador.controllers.viewmodels;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Objects;
import java.util.ResourceBundle;

import ifpr.pgua.eic.projetointegrador.controllers.BaseController;
import ifpr.pgua.eic.projetointegrador.controllers.TelaAreas;
import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.daos.AreaDAO;
import ifpr.pgua.eic.projetointegrador.model.daos.JDBCArea;
import ifpr.pgua.eic.projetointegrador.model.entities.Area;
import ifpr.pgua.eic.projetointegrador.model.repositories.AreaRepository;
import ifpr.pgua.eic.projetointegrador.model.results.Result;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class TelaAreaViewModel {
    private StringProperty nomeProperty = new SimpleStringProperty();
    private ObjectProperty<Result> alertProperty = new SimpleObjectProperty<>();
    private ObjectProperty<AreaRow> selecionado = new SimpleObjectProperty<>();

    private StringProperty operacao = new SimpleStringProperty("Cadastrar");
    private BooleanProperty podeEditar = new SimpleBooleanProperty(true);
    private boolean editar = false;

    private ObservableList<AreaRow> areas = FXCollections.observableArrayList();
    
    private AreaRepository repository;

    public TelaAreaViewModel(AreaRepository repository){
        this.repository = repository;

        updateList();
    }

    public void updateList(){
        areas.clear();
        for(Area f : repository.getAreas()){
            areas.add(new AreaRow(f));
        }
    }

    public ObservableList<AreaRow> getAreas(){
        return this.areas;
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

    public ObjectProperty<AreaRow> selecionadoProperty() {
        return selecionado;
    }
    
    public void cadastrar(){
        String nome = nomeProperty.getValue();
        
        repository.adicionarArea(nome);
            
        //Result msg = (null);
        
        if(editar){
            repository.editarArea(nome);
            Result msg = Result.success("Área editada com sucesso!");
        }
        else{
            repository.adicionarArea(nome);
            //msg = Result.success("Área Cadastrado com sucesso!");
        }
        //return msg;
        updateList();
        limpar();
    }

    public void editar(){
        operacao.setValue("Editar");
        podeEditar.setValue(false);
        editar = true;
        Area area = selecionado.get().getArea();
        nomeProperty.setValue(area.getNome());
        alertProperty.setValue(Result.fail("Teste"));
    }
    
    public void limpar(){
        nomeProperty.setValue("");
    }
}
