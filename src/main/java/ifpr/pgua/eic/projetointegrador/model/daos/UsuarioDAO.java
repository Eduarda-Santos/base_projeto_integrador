package ifpr.pgua.eic.projetointegrador.model.daos;

import java.sql.ResultSet;
import java.util.ArrayList;

import ifpr.pgua.eic.projetointegrador.model.entities.Usuario;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public interface UsuarioDAO {
    Result create(Usuario usuario);
    Result update(int id, Usuario usuario);
    ArrayList<Usuario> listAll();
    Usuario getById(int id);
    Result delete(int id); 
    ResultSet autenticacaoUsuario(Usuario usuario);
}
