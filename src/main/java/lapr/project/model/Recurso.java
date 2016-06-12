package lapr.project.model;

import java.util.Objects;

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

    @Override
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public int compareTo(Recurso outroRecurso) {
        return descricao.compareTo(outroRecurso.descricao);
    }

}
