package lapr.project.model;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Recurso implements Comparable<Recurso>, Serializable {

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
        if (descricao == null || descricao.trim().isEmpty()) {
            return false;
        }
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
