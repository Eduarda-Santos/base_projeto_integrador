package ifpr.pgua.eic.projetointegrador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import ifpr.pgua.eic.projetointegrador.controllers.TelaFuncionarios;
import ifpr.pgua.eic.projetointegrador.controllers.TelaPrincipal;
import ifpr.pgua.eic.projetointegrador.controllers.viewmodels.TelaFuncionarioViewModel;
import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.daos.FuncionarioDAO;
import ifpr.pgua.eic.projetointegrador.model.daos.JDBCFuncionario;
import ifpr.pgua.eic.projetointegrador.model.entities.Funcionario;
import ifpr.pgua.eic.projetointegrador.model.repositories.FuncionarioRepository;
import ifpr.pgua.eic.projetointegrador.utils.Navigator.BaseAppNavigator;
import ifpr.pgua.eic.projetointegrador.utils.Navigator.ScreenRegistryFXML;


/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {


    private FabricaConexoes fabricaConexoes = FabricaConexoes.getInstance();
    private FuncionarioDAO funcionarioDAO;
    private FuncionarioRepository funcionarioRepository;
    private Funcionario funcionarios;

    @Override
    public void init() throws Exception{
        super.init();

        funcionarioDAO = new JDBCFuncionario(fabricaConexoes);
        funcionarioRepository = new FuncionarioRepository(funcionarioDAO);

        funcionarios = new Funcionario("teste", 0, "teste", "teste", null, 0);
    }

    @Override
    public void stop() throws Exception {
        super.stop();

    }

    @Override
    public String getHome() {
        return "PRINCIPAL";
    }

    @Override
    public String getAppTitle() {
        return "Funcionários";
    }

    @Override
    public void registrarTelas(){
        registraTela("PRINCIPAL",  new ScreenRegistryFXML(getClass(), "fxml/principal.fxml", (o)->new TelaPrincipal()));
        registraTela("FUNCIONARIOS",  new ScreenRegistryFXML(getClass(), "fxml/funcionarios.fxml", (o)->new TelaFuncionarios(new TelaFuncionarioViewModel(funcionarioRepository))));
        //registraTela("FUNCIONARIOS", new ScreenRegistryFXML(getClass(), "fxml/funcionarios.fxml", (o)->new TelaFuncionarios(new TelaFuncionarioViewModel(funcionarioRepository))));  
    }

}