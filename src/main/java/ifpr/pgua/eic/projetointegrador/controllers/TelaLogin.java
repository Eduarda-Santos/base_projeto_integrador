package ifpr.pgua.eic.projetointegrador.controllers;

import javax.swing.JButton;
import javax.swing.JDialog;

import ifpr.pgua.eic.projetointegrador.App;
import ifpr.pgua.eic.projetointegrador.controllers.viewmodels.TelaUserViewModel;
import ifpr.pgua.eic.projetointegrador.model.repositories.UsuarioRepository;
import ifpr.pgua.eic.projetointegrador.utils.Navigator.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class TelaLogin extends BaseController {

    @FXML
    private void carregarTelaLogin(){
        App.changeScreenRegion("LOGIN", BorderPaneRegion.CENTER);
    }

    private TelaUserViewModel viewModel;

    public TelaLogin(TelaUserViewModel telaUserViewModel){
        this.viewModel = telaUserViewModel;
    }
    
    @FXML
    public TextField tfNomeUsuario;

    @FXML
    public TextField tfSenhaUsuario;
    
    @FXML
    public Button btLogin;

    @FXML
    private void login(){
        viewModel.login();
    }
    
    
}
