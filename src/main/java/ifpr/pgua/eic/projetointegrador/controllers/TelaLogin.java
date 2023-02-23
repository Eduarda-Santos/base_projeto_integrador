package ifpr.pgua.eic.projetointegrador.controllers;

import javax.swing.JButton;
import javax.swing.JDialog;

import ifpr.pgua.eic.projetointegrador.model.repositories.UsuarioRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class TelaLogin extends JDialog {

    private TelaLogin viewModel;

    public TelaLogin(TelaLogin viewModel){
        this.viewModel = viewModel;
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
