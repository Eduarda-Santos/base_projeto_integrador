package ifpr.pgua.eic.projetointegrador.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.entities.Area;
import ifpr.pgua.eic.projetointegrador.model.results.Result;
import ifpr.pgua.eic.projetointegrador.model.results.SuccessResult;

public class JDBCArea implements AreaDAO{

    private FabricaConexoes fabricaConexoes;

    public JDBCArea(FabricaConexoes fabricaConexoes){
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Result create(Area area) {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement pstm = con.prepareStatement("INSERT INTO areas(nome) VALUES (?)");

            pstm.setString(1, area.getNome());

            pstm.executeUpdate();
            pstm.close();
            con.close();

            return Result.success("Área cadastrada");
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @Override
    public Result update(String nome) {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement pstm = con.prepareStatement("UPDATE INTO areas(id,nome) VALUES (?)");

            pstm.setString(1, nome);
            pstm.close();
            con.close();

            return Result.success("Área atualizada");
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
    }

    @Override
    public List<Area> listAll() {
        try{
            //criando uma conexão
            Connection con = fabricaConexoes.getConnection(); 
            
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM areas");

            ResultSet rs = pstm.executeQuery();

            ArrayList<Area> areas = new ArrayList<>();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
            
                Area area = new Area(nome);
                areas.add(area);
            }
            rs.close();
            con.close();
            return areas;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public Area getById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Result delete(int id) {
        // TODO Auto-generated method stub
        return null;
    }
   
}
