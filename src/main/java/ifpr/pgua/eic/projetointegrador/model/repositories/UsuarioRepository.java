package ifpr.pgua.eic.projetointegrador.model.repositories;

import java.sql.ResultSet;

import ifpr.pgua.eic.projetointegrador.model.daos.UsuarioDAO;
import ifpr.pgua.eic.projetointegrador.model.entities.Usuario;
import ifpr.pgua.eic.projetointegrador.model.results.Result;
import javafx.event.ActionEvent;

public class UsuarioRepository {

    private UsuarioDAO dao;

    public UsuarioRepository(UsuarioDAO dao){
        this.dao = dao;
    }

    public ResultSet login(String nome, String senha){

        Usuario usuario = new Usuario(nome, senha);
        return dao.autenticacaoUsuario(usuario);
        
    }
}
