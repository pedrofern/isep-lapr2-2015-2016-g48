package lapr.project.model;

import java.util.*;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.ListaKeywords;

/**
 *
 * @author Pedro Fernandes
 */
public class FAE implements Comparable<FAE> {

    private final String nome;
    private Utilizador o_utilizador;
    private List<FAE> e_listaFAE;
    private List<Avaliacao> m_listaAvaliacoes;
    private List<Candidatura> m_listaCandidaturas;
    private final String NOME_POR_OMISSAO = "sem nome";
    private static int numeroFAEs = 1;
    private FAE m_fae;
    private ListaFAE listaFAE;

    public FAE(Utilizador u) {
        this.o_utilizador = u;
        nome = u.getNome();
    }

    public FAE(String strId, Utilizador u) {
        m_listaAvaliacoes = new ArrayList<Avaliacao>();
        nome = u.getNome();
        this.setUtilizador(u);
        numeroFAEs++;
    }

    public FAE() {
        nome = NOME_POR_OMISSAO;
        numeroFAEs++;
    }

    public void setUtilizador(Utilizador u) {
        o_utilizador = u;
    }

    public boolean validaMenbroFAE() {
        if (m_fae.getNome() == null && m_fae.getUsername() == null && m_fae.getEmail() == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean valida() {
        return true;
    }

    public String getNome() {
        return nome;
    }

    public Utilizador getUtilizador() {
        return o_utilizador;
    }

    public static int getNumeroFAEs() {
        return numeroFAEs;
    }

    @Override
    public String toString() {
        return ("Utilizador: " + this.o_utilizador);
    }

//    public String toStringCompleto() {
//        String str=" ";
//        str += "\tOrganizadores:\n";
//        for (FAE fae : listaFAE.getListaFAE()) {
//            str += "\t\t" + fae.getUtilizador().toString() + "\n";
//        }
//
//        return str;
//    }

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
        return o_utilizador.getUsername();
    }

    public String getEmail() {
        return o_utilizador.getEmail();
    }

    public boolean validaFAEDuplicado(List<FAE> listaFAE) {
        StringBuilder s = new StringBuilder();

        String[] listFae = new String[listaFAE.size()];

        int i = 0;
        for (FAE fae : listaFAE) {
            s.append(fae.toString());
            s.append("\n");
            listFae[i] = s.toString();
            i++;
        }

        for (int p = 0; p < listaFAE.size(); p++) {
            for (int j = 1; j < listaFAE.size(); j++) {
                if (listaFAE.get(p).equals(listaFAE.get(j))) {
                    return true;
                }
            }
        }
        return false;
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

    public List<FAE> getListaFAE() {
        List<FAE> lf = new ArrayList<FAE>();

        for (FAE f : e_listaFAE) {
            lf.add(f);
        }
        return lf;
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
