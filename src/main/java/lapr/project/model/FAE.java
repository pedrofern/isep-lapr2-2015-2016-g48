package lapr.project.model;

import java.util.*;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.ListaKeywords;

/**
 *
 * @author Pedro Fernandes
 */
public class FAE implements Comparable<FAE> {

    private final String nome, email, username;
    private Utilizador o_utilizador;
    private List<FAE> e_listaFAE;
    private List<Avaliacao> m_listaAvaliacoes;
    private List<Candidatura> m_listaCandidaturas;
    private final String NOME_POR_OMISSAO = "sem nome";
    private static final String EMAIL_POR_OMISSAO = "Email do utilizador não registado";
    private static final String USER_POR_OMISSAO = "Username do utilizador não registado";
    private static int numeroFAEs = 0;
    private FAE m_fae;
    private ListaFAE listaFAE;

    public FAE(Utilizador u) {
        this.o_utilizador = u;
        nome = u.getNome();
        username = u.getUsername();
        email = u.getEmail();
        numeroFAEs++;
    }

    public FAE(String strId, Utilizador u) {
        m_listaAvaliacoes = new ArrayList<Avaliacao>();
        nome = u.getNome();
        username = u.getUsername();
        email = u.getEmail();
        this.setUtilizador(u);
        numeroFAEs++;
    }

    public FAE() {
        nome = NOME_POR_OMISSAO;
        username =USER_POR_OMISSAO;
        email = EMAIL_POR_OMISSAO;
        numeroFAEs++;
    }

    public void setUtilizador(Utilizador u) {
        o_utilizador = u;
    }

    public boolean validaMenbroFAE() {
        if (nome == null || username == null || email == null) {
            return false;
        } else {
            return true;
        }
    }

    public String getNome() {
        return nome;
    }

    public Utilizador getUtilizador() {
        return o_utilizador;
    }

 

    @Override
    public String toString() {
        return ("Utilizador: " + this.o_utilizador.toString());
    }

    public boolean validaAvaliacao(Avaliacao ava) {
        return ava.valida();
    }

    public Avaliacao novaAvaliacao() {
        return new Avaliacao();
    }

    public boolean registaAvaliacao(Avaliacao ava) {
        if (ava.valida() && validaAvaliacao(ava)) {
            return addAvaliacao(ava);
     
        } else {
            return false;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object outroObjeto) {

        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        FAE outroFAE = (FAE) outroObjeto;
        return this.getEmail().equals(outroFAE.getEmail());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.m_fae);
        return hash;
    }

    private boolean addAvaliacao(Avaliacao ava) {
        
        return m_listaAvaliacoes.add(ava);
    }

    public boolean isUtilizador(Utilizador u) {
        if (this.o_utilizador != null) {
            return this.o_utilizador.equals(u);
        }
        return false;
    }

    public int getTempoServico() {
        return o_utilizador.getTempoServico();
    }

    @Override
    public int compareTo(FAE o) {
        return this.getTempoServico() - o.getTempoServico();
    }

}
