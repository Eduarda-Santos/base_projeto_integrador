package ifpr.pgua.eic.projetointegrador.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.entities.Usuario;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public class JDBCUsuario implements UsuarioDAO{

    @Override
    public Result create(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Result update(int id, Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ArrayList<Usuario> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public Usuario getById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public Result delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    private FabricaConexoes fabricaConexoes;

    public JDBCUsuario(FabricaConexoes fabricaConexoes){
        this.fabricaConexoes = fabricaConexoes;
    }

    public ResultSet autenticacaoUsuario(Usuario usuario){
        try {
        
            Connection con = fabricaConexoes.getConnection();

            try{
                String sql = ("SELECT * from usuario where nome_usuario = ? and senha_usuario = ? ");
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, usuario.getNome_usuario());
                pstm.setString(2, usuario.getSenha_usuario());
                
                ResultSet rs = pstm.executeQuery();
                return rs;
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, erro, null, 0);
                return null;
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;


    }
    
}
