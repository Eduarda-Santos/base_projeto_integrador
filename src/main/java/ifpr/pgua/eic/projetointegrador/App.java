package ifpr.pgua.eic.projetointegrador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import ifpr.pgua.eic.projetointegrador.controllers.TelaAreas;
import ifpr.pgua.eic.projetointegrador.controllers.TelaFuncionarios;
import ifpr.pgua.eic.projetointegrador.controllers.TelaLogin;
import ifpr.pgua.eic.projetointegrador.controllers.TelaPrincipal;
import ifpr.pgua.eic.projetointegrador.controllers.viewmodels.TelaAreaViewModel;
import ifpr.pgua.eic.projetointegrador.controllers.viewmodels.TelaFuncionarioViewModel;
import ifpr.pgua.eic.projetointegrador.controllers.viewmodels.TelaUserViewModel;
import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.daos.AreaDAO;
import ifpr.pgua.eic.projetointegrador.model.daos.FuncionarioDAO;
import ifpr.pgua.eic.projetointegrador.model.daos.JDBCArea;
import ifpr.pgua.eic.projetointegrador.model.daos.JDBCFuncionario;
import ifpr.pgua.eic.projetointegrador.model.daos.JDBCUsuario;
import ifpr.pgua.eic.projetointegrador.model.daos.UsuarioDAO;
import ifpr.pgua.eic.projetointegrador.model.entities.Funcionario;
import ifpr.pgua.eic.projetointegrador.model.repositories.AreaRepository;
import ifpr.pgua.eic.projetointegrador.model.repositories.FuncionarioRepository;
import ifpr.pgua.eic.projetointegrador.model.repositories.UsuarioRepository;
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

    private UsuarioDAO usuarioDAO;
    private UsuarioRepository usuarioRepository;

    private AreaDAO areaDAO;
    private AreaRepository areaRepository;

    @Override
    public void init() throws Exception{
        super.init();

        funcionarioDAO = new JDBCFuncionario(fabricaConexoes);
        funcionarioRepository = new FuncionarioRepository(funcionarioDAO);

        funcionarios = new Funcionario("teste", 0, "teste", "teste", 0);
    
        usuarioDAO = new JDBCUsuario(fabricaConexoes);
        usuarioRepository = new UsuarioRepository(usuarioDAO);

        areaDAO = new JDBCArea(fabricaConexoes);
        areaRepository = new AreaRepository(areaDAO);
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
        registraTela("LOGIN", new ScreenRegistryFXML(getClass(), "fxml/login.fxml", (o)->new TelaLogin(new TelaUserViewModel(usuarioRepository))));  
        registraTela("PRINCIPAL",  new ScreenRegistryFXML(getClass(), "fxml/principal.fxml", (o)->new TelaPrincipal()));
        registraTela("FUNCIONARIOS",  new ScreenRegistryFXML(getClass(), "fxml/funcionarios.fxml", (o)->new TelaFuncionarios(new TelaFuncionarioViewModel(funcionarioRepository))));
        registraTela("AREAS",  new ScreenRegistryFXML(getClass(), "fxml/areas.fxml", (o)->new TelaAreas(new TelaAreaViewModel(areaRepository))));
    
    }

}