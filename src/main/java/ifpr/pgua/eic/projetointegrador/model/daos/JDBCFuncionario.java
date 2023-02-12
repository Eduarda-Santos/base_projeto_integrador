package ifpr.pgua.eic.projetointegrador.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;


import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.entities.Funcionario;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public class JDBCFuncionario implements FuncionarioDAO{

    private FabricaConexoes fabricaConexoes;

    public JDBCFuncionario(FabricaConexoes fabricaConexoes){
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Result create(Funcionario funcionario) {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement pstm = con.prepareStatement("INSERT INTO funcionarios(nome,telefone,endereco,sexo,dataNascimento,telefoneEmergencia) VALUES (?,?,?,?,?,?)");


        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public Result update(int id, Funcionario funcionario) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Funcionario> listAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Funcionario getById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Result delete(int id) {
        // TODO Auto-generated method stub
        return null;
    }
   
}
