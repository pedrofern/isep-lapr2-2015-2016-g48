package lapr.project.model;

/**
 *
 * @author Pedro Fernandes
 */
public class Recurso {

    private String descricao;

    public Recurso(String descricao) {
        this.descricao = descricao;
    }

    public Recurso() {

    }

    public void setDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean valida() {
        return true;
    }

    @Override
    public String toString() {
        return this.getDescricao();
    }

}
