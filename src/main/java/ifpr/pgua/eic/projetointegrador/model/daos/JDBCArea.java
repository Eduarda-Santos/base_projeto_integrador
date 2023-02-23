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
import java.util.Date;
import java.util.List;


import ifpr.pgua.eic.projetointegrador.model.FabricaConexoes;
import ifpr.pgua.eic.projetointegrador.model.entities.Area;
import ifpr.pgua.eic.projetointegrador.model.results.Result;

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


        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public Result update(int id, Area area) {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement pstm = con.prepareStatement("UPDATE INTO areas(nome) VALUES (?)");


        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public ArrayList<Area> listAll() {
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
            return areas;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
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
