package ifpr.pgua.eic.projetointegrador.model.repositories;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import ifpr.pgua.eic.projetointegrador.model.daos.AreaDAO;
import ifpr.pgua.eic.projetointegrador.model.entities.Area;
import ifpr.pgua.eic.projetointegrador.model.results.Result;


public class AreaRepository {
    private List<Area> areas;
    private AreaDAO dao;

    public AreaRepository(AreaDAO dao){
        this.dao = dao;
    }

    public Result adicionarArea(String nome){
        Optional<Area> busca = areas.stream().filter((fun)->fun.getNome().equals(nome)).findFirst();
    
        if(busca.isPresent()){
            return Result.fail("Área já está cadastrado");
        }

        Area area = new Area(nome);
        return dao.create(area);
    }

    public Result editarArea(String nome){
        Optional<Area> busca = areas.stream().filter((fun)->fun.getNome().equals(nome)).findFirst();
    
        if(busca.isPresent()){
            Area area = busca.get();
            
            return Result.success("Área atualizado");
        }
        //return Result.fail("Funcionário não encontrado");
        return Result.fail("Área não encontrado");
    }

    public Result deletarArea(String nome){
        Optional<Area> busca = areas.stream().filter((fun)->fun.getNome().equals(nome)).findFirst();
    
        if(busca.isPresent()){
            Area area = busca.get();
            area.setNome("");
            
            return Result.success("Funcionário deletado");
        }
        //return Result.fail("Funcionário não encontrado");
        return Result.fail("Funcionário não encontrado");
    }

    public List<Area> getAreas(){
        areas = dao.listAll();
        return Collections.unmodifiableList(areas);
    }
}
