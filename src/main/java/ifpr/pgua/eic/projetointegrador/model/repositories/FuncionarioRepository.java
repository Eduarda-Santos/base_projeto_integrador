package ifpr.pgua.eic.projetointegrador.model.repositories;


import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import ifpr.pgua.eic.projetointegrador.model.daos.FuncionarioDAO;
import ifpr.pgua.eic.projetointegrador.model.entities.Funcionario;
import ifpr.pgua.eic.projetointegrador.model.results.Result;


public class FuncionarioRepository {
    private List<Funcionario> funcionarios;
    private FuncionarioDAO dao;

    public FuncionarioRepository(FuncionarioDAO dao){
        this.dao = dao;
    }

    public Result adicionarFuncionario(String nome, int telefone, String endereco, String sexo, 
    int telefoneEmergencia){
        Optional<Funcionario> busca = funcionarios.stream().filter((fun)->fun.getNome().equals(nome)).findFirst();
    
        if(busca.isPresent()){
            return Result.fail("Funcinonário já está cadastrado");
        }

        Funcionario funcionario = new Funcionario(nome, telefone, endereco, sexo, telefoneEmergencia);
        return dao.create(funcionario);
    }

    public Result editarFuncionario(String nome, int telefone, String endereco, String sexo, 
    int telefoneEmergencia){
        Optional<Funcionario> busca = funcionarios.stream().filter((fun)->fun.getNome().equals(nome)).findFirst();
    
        if(busca.isPresent()){
            Funcionario funcionario = busca.get();
            funcionario.setNome(nome);
            funcionario.setTelefone(telefone);
            funcionario.setEndereco(endereco);
            //funcionario.setDatadeNascimento(datadeNascimento);
            funcionario.setSexo(sexo);
            funcionario.setTelefoneEmergencia(telefoneEmergencia);
            
            return Result.success("Funcionário atualizado");
        }
        //return Result.fail("Funcionário não encontrado");
        return Result.fail("Funcionário não encontrado");
    }

    public Result deletarFuncionario(String nome, int telefone, String endereco, String sexo, 
    int telefoneEmergencia){
        Optional<Funcionario> busca = funcionarios.stream().filter((fun)->fun.getNome().equals(nome)).findFirst();
    
        if(busca.isPresent()){
            Funcionario funcionario = busca.get();
            funcionario.setNome("");
            funcionario.setTelefone(0);
            funcionario.setEndereco("");
            //funcionario.setDatadeNascimento(null);
            funcionario.setSexo("");
            funcionario.setTelefoneEmergencia(0);
            
            return Result.success("Funcionário deletado");
        }
        //return Result.fail("Funcionário não encontrado");
        return Result.fail("Funcionário não encontrado");
    }

    public List<Funcionario> getFuncionarios(){
        funcionarios = dao.listAll();
        return Collections.unmodifiableList(funcionarios);
    }

}
