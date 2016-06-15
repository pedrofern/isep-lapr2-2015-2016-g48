package lapr.project.model;

import java.util.*;
import lapr.project.model.lists.*;

/**
 *
 * @author Pedro Fernandes
 */
public class Representante {

    private ListaProduto listaProdutos;
    private ListaCandidaturas listaCandidaturas;

    public Representante() {
        listaProdutos = new ListaProduto();
        listaCandidaturas = new ListaCandidaturas();
    }

    public boolean registaProduto(Produto p) {
        if (p.valida() && validaProduto(p)) {
            return addProduto(p);
        } else {
            return false;
        }
    }

    private boolean validaProduto(Produto p) {
        return p.valida();
    }

    public Candidatura novaCandidatura() {
        return new Candidatura();
    }

    public boolean registaCandidatura(Candidatura c) {
        if (c.valida() && validaCandidatura(c)) {
            return addCandidatura(c);
        } else {
            return false;
        }
    }

    private boolean validaCandidatura(Candidatura c) {
        return c.valida();
    }

    private boolean addCandidatura(Candidatura c) {
        return listaCandidaturas.addCandidatura(c);
    }

    public Produto getProduto(String nomeProduto) {
        for (Produto p : this.listaProdutos.getListaProduto()) {
            String s1 = p.getNomeProduto();
            if (s1.equalsIgnoreCase(nomeProduto)) {
                return p;
            }
        }

        return null;
    }

    private boolean addProduto(Produto p) {
        return listaProdutos.adicionarProduto(p);
    }

    public Produto novoProduto() {
        return new Produto();
    }

    public ListaProduto getListaProdutos() {
        ListaProduto lProduto = new ListaProduto();

        for (ListIterator<Produto> it = listaProdutos.getListaProduto().listIterator(); it.hasNext();) {
            lProduto.adicionarProduto(it.next());
        }

        return lProduto;
    }

    public ListaProduto getProdutos() {
        return listaProdutos;
    }
}
