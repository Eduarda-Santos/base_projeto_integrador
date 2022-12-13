package ifpr.pgua.eic.projetointegrador.model.daos;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import ifpr.pgua.eic.projetointegrador.model.entities.Funcionario;

public interface FuncionarioDAO {
    Result create(Funcionario funcionario);
    Result update(int id, Funcionario funcionario);
    List<Funcionario> listAll();
    Funcionario getById(int id);
    Result delete(int id);
}
