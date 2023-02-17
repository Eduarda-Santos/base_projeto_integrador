package ifpr.pgua.eic.projetointegrador.model.daos;

import java.util.ArrayList;
import java.util.List;


import ifpr.pgua.eic.projetointegrador.model.entities.Funcionario;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public interface FuncionarioDAO {
    Result create(Funcionario funcionario);
    Result update(int id, Funcionario funcionario);
    ArrayList<Funcionario> listAll();
    Funcionario getById(int id);
    Result delete(int id);
}
