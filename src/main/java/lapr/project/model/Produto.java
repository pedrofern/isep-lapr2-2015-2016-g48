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
    
    /**
     * Metodo que vai comprar objetos produto entre si
     * @param outroObjeto outro produto
     * @return se os objetos forem iguais retorna true caso contrario false
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Produto outroProduto = (Produto) outroObjeto;
        
        return nomeProduto.equalsIgnoreCase(outroProduto.nomeProduto);
    }   
}
