package lapr.project.model;

/**
 *
 * @author Pedro Fernandes
 */
public class Produto {

    private String nomeProduto;

    public Produto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Produto() {

    }

    public void setTitulo(String novoNomeProduto) {
        this.nomeProduto = novoNomeProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public boolean valida() {
        return true;
    }

    @Override
    public String toString() {
        return this.getNomeProduto();
    }
}
