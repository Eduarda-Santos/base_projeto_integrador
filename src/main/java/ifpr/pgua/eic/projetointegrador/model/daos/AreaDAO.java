package ifpr.pgua.eic.projetointegrador.model.daos;


import java.util.ArrayList;

import ifpr.pgua.eic.projetointegrador.model.entities.Area;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

public interface AreaDAO {
    Result create(Area area);
    Result update(int id, Area area);
    ArrayList<Area> listAll();
    Area getById(int id);
    Result delete(int id);
}
