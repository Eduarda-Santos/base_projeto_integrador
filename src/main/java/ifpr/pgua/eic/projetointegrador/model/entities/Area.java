package ifpr.pgua.eic.projetointegrador.model.entities;

public class Area {

    private int id;
    private String nome;
    
    public Area(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Area(String nome) {
        this.nome = nome;
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
}
