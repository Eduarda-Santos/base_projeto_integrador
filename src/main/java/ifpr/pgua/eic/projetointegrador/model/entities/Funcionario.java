package ifpr.pgua.eic.projetointegrador.model.entities;

import java.sql.Date;
import java.time.format.DateTimeFormatter;

public class Funcionario {

    private int id;
    private String nome;
    private int telefone;
    private String endereco;
    private String sexo;
    private DateTimeFormatter datadeNascimento;
    private int telefoneEmergencia;
    
    public Funcionario(String nome, int telefone, String endereco, String sexo, DateTimeFormatter datadeNascimento,
            int telefoneEmergencia) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.sexo = sexo;
        this.datadeNascimento = datadeNascimento;
        this.telefoneEmergencia = telefoneEmergencia;
    }

    public Funcionario(int id, String nome, int telefone, String endereco, String sexo, DateTimeFormatter datadeNascimento,
            int telefoneEmergencia) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.sexo = sexo;
        this.datadeNascimento = datadeNascimento;
        this.telefoneEmergencia = telefoneEmergencia;
    }
    
    public Funcionario(int id, String nome, int telefone, String endereco, String sexo, int telefoneEmergencia) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.sexo = sexo;
        this.telefoneEmergencia = telefoneEmergencia;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public DateTimeFormatter getDatadeNascimento() {
        return datadeNascimento;
    }
    public void setDatadeNascimento(DateTimeFormatter datadeNascimento) {
        this.datadeNascimento = datadeNascimento;
    }

    public int getTelefoneEmergencia() {
        return telefoneEmergencia;
    }
    public void setTelefoneEmergencia(int telefoneEmergencia) {
        this.telefoneEmergencia = telefoneEmergencia;
    }
}
