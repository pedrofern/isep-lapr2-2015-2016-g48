package lapr.project.model;

import java.util.*;

/**
 *
 * @author Pedro Fernandes
 */
public class Demonstracao {

    private String descricao;
    private String codigoUnico;
    private List<Recurso> lst_recursos;

    public Demonstracao(String codigoUnico, String descricao, List<Recurso> lst_recursos) {
        this.codigoUnico = codigoUnico;
        this.descricao = descricao;
        this.lst_recursos = new ArrayList<>(lst_recursos);
    }

    public Demonstracao() {

    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public List<Recurso> getListaRecursos() {
        return lst_recursos;
    }
    
    public boolean addRecurso(Recurso r) {
        if (r == null) {
            return false;
        }
        System.out.println("ListaRecursos: addRecurso: " + r.toString());
        Recurso rec = new Recurso(r.toString());

        if (rec.valida() && validaRecurso(r)) {
            return addRecurso(r);
        } else {
            return false;
        }
    }
    
    private boolean validaRecurso(Recurso r) {
        System.out.println("ListaRecursos: validaRecurso:" + r.toString());
        return true;
    }

    public void setListaRecursos(List<Recurso> novaListaRecursos) {
        this.lst_recursos = novaListaRecursos;
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
        return "Descricao = " + this.getDescricao() + "\nCodigo Unico = " + this.getCodigoUnico() + "Lista Recursos = " + this.getListaRecursos();
    }

}
