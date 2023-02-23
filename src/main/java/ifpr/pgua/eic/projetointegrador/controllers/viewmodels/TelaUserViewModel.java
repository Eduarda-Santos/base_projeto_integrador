package ifpr.pgua.eic.projetointegrador.controllers.viewmodels;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import ifpr.pgua.eic.projetointegrador.controllers.TelaLogin;
import ifpr.pgua.eic.projetointegrador.controllers.TelaPrincipal;
import ifpr.pgua.eic.projetointegrador.model.daos.UsuarioDAO;
import ifpr.pgua.eic.projetointegrador.model.entities.Usuario;
import ifpr.pgua.eic.projetointegrador.model.repositories.UsuarioRepository;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;

public class TelaUserViewModel {

    private StringProperty nomeProperty = new SimpleStringProperty();
    private StringProperty senhaProperty = new SimpleStringProperty();


    private UsuarioRepository repository;

    public TelaUserViewModel(UsuarioRepository repository){
        this.repository = repository;
    }

    public StringProperty nomeProperty(){
        return nomeProperty;
    }

    public StringProperty senhaProperty(){
        return senhaProperty;
    }

    private UsuarioDAO dao;

    public void UsuarioRepository(UsuarioDAO dao){
        this.dao = dao;
    }

    //UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void login(){
        try {
            
            String nome = nomeProperty.getValue();
            String senha = senhaProperty.getValue();

            //usuarioRepository.setNome_usuario(nome);
            //usuarioRepository.setSenha_usuario(senha);

            //UsuarioDAO usuarioDAO = new UsuarioDAO();

            Usuario usuario = new Usuario(nome, senha);

            ResultSet rsUsuario = dao.autenticacaoUsuario(usuario);
            //resultset sempre é utilizado quando se trabalha com consulta no banco

            if(rsUsuario.next()){
                TelaPrincipal objPrincipal = new TelaPrincipal();
                objPrincipal.setVisible(true);

                TelaUserViewModel.dispose(true);
            }
            else{
                JOptionPane.showMessageDialog(null,"Usuário ou senha inválidas");
            }
            repository.login(nome, senha);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Tela Login View");
            
        }
    }

    public static void dispose(boolean b) {
        dispose(b);
    }

    
}
