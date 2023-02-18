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

            PreparedStatement pstm = con.prepareStatement("INSERT INTO funcionarios(nome,telefone,endereco,sexo,datadeNascimento,telefoneEmergencia) VALUES (?,?,?,?,?,?)");


        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public Result update(int id, Funcionario funcionario) {
        try {
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement pstm = con.prepareStatement("UPDATE INTO funcionarios(nome,telefone,endereco,sexo,datadeNascimento,telefoneEmergencia) VALUES (?,?,?,?,?,?)");


        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    @Override
    public ArrayList<Funcionario> listAll() {
        try{
            //criando uma conexão
            Connection con = fabricaConexoes.getConnection(); 
            
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM funcionarios");

            ResultSet rs = pstm.executeQuery();

            ArrayList<Funcionario> funcionarios = new ArrayList<>();

            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int telefone = rs.getInt("telefone");
                String endereco = rs.getString("endereco");
                String sexo = rs.getString("sexo");
                Date sdatadeNascimento = rs.getDate("datadeNascimento");
                int telefoneEmergencia = rs.getInt("telefoneEmergencia");

                LocalDate datadeNascimento = sdatadeNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                /*SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    dataNascimento = sdf.parse(sdataNascimento);
                } catch (ParseException pe){
                    pe.printStackTrace();
                }*/
                //LocalDate dataNascimento = new Date(sdataNascimento);

                //SimpleLocalDateFormat fmt = new SimpleLocalDateFormat("dd/MM/yyyy");
                //LocalDateTimeFormatter dataNascimento = fmt.parse(sdataNascimento);
                
                Funcionario funcionario = new Funcionario(nome, telefone, endereco, sexo, datadeNascimento, telefoneEmergencia);
                funcionarios.add(funcionario);
            }
            return funcionarios;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
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
