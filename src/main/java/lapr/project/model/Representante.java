package lapr.project.model;

import java.util.*;
import lapr.project.model.lists.*;

/**
 *
 * @author Pedro Fernandes
 */
public class Representante {

    private ListaProduto m_listaProdutos;
    private ListaCandidaturas m_listaCandidaturas;

    public Representante() {
        m_listaProdutos = new ListaProduto();
        m_listaCandidaturas = new ListaCandidaturas();
    }

    public boolean registaProduto(Produto p) {
        if (p.valida() && validaProduto(p)) {
            return addProduto(p);
        } else {
            return false;
        }
    }

    private boolean validaProduto(Produto p) {
        System.out.println("Produto: validaProduto: " + p.toString());
        return true;
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
        return m_listaCandidaturas.addCandidatura(c);
    }

    public Produto getProduto(String nomeProduto) {
        for (Produto p : this.m_listaProdutos.getListaProduto()) {
            String s1 = p.getNomeProduto();
            if (s1.equalsIgnoreCase(nomeProduto)) {
                return p;
            }
        }

        return null;
    }

    private boolean addProduto(Produto p) {
        return m_listaProdutos.adicionarProduto(p);
    }

    public Produto novoProduto() {
        return new Produto();
    }

    public ListaProduto getListaProdutos() {
        ListaProduto lProduto = new ListaProduto();

        for (ListIterator<Produto> it = m_listaProdutos.getListaProduto().listIterator(); it.hasNext();) {
            lProduto.adicionarProduto(it.next());
        }

        return lProduto;
    }

    public ListaProduto getProdutos() {
        return m_listaProdutos;
    }
}
