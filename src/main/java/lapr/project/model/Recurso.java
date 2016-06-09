package lapr.project.model;

/**
 *
 * @author Pedro Fernandes
 */
public class Recurso implements Comparable<Recurso> {

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

    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Recurso recurso = (Recurso) outroObjeto;

        return descricao.equalsIgnoreCase(recurso.descricao);
    }

    public int compareTo(Recurso outroRecurso) {
        return descricao.compareTo(outroRecurso.descricao);
    }

}
