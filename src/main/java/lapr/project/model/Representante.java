package lapr.project.model;

import java.util.*;

/**
 *
 * @author Pedro Fernandes
 */
public class Representante {

    private List<Produto> m_listaProdutos;
    private List<Candidatura> m_listaCandidaturas;

    public Representante() {
        m_listaProdutos = new ArrayList<Produto>();
        m_listaCandidaturas = new ArrayList<Candidatura>();
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
        return m_listaCandidaturas.add(c);
    }

    public Produto getProduto(String nomeProduto) {
        for (Produto p : this.m_listaProdutos) {
            String s1 = p.getNomeProduto();
            if (s1.equalsIgnoreCase(nomeProduto)) {
                return p;
            }
        }

        return null;
    }

    private boolean addProduto(Produto p) {
        return m_listaProdutos.add(p);
    }

    public Produto novoProduto() {
        return new Produto();
    }

    public List<Produto> getListaProdutos() {
        List<Produto> lProduto = new ArrayList<Produto>();

        for (ListIterator<Produto> it = m_listaProdutos.listIterator(); it.hasNext();) {
            lProduto.add(it.next());
        }

        return lProduto;
    }

    public List<Produto> getProdutos() {
        return m_listaProdutos;
    }
}
