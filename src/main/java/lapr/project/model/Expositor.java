package lapr.project.model;

/**
 *
 * @author Pedro Fernandes
 */
public class Expositor {

    private String nome;
    private String morada;

    public Expositor(String nome, String morada) {
        this.nome = nome;
        this.morada = morada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    @Override
    public String toString() {
        return "Nome = " + this.getNome() + "\nMorada = " + this.getMorada();
    }

}
