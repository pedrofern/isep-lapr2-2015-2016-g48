package lapr.project.model;

import java.util.*;

/**
 *
 * @author Pedro Fernandes
 */
public class Organizador {

    private Utilizador m_oUtilizador;
    private List<Atribuicao> ac_listaAtribuicao;
    private final String m_strNome;
    private Utilizador m_utilizador;

    public Organizador(Utilizador u) {
        m_strNome = u.getNome();
        this.setUtilizador(u);
    }

    private void setUtilizador(Utilizador u) {
        m_utilizador = u;
    }

    public Utilizador getUtilizador() {
        return this.m_utilizador;
    }

    public boolean valida() {
        if (m_oUtilizador.valida()) {
            System.out.println("Organizador:valida: " + this.toString());
            return true;
        }
        return false;
    }

    public Atribuicao novaAtribuicaoCandidatura() {
        return new Atribuicao();
    }

    public boolean registaAtribuicaoCandidatura(Atribuicao ac) {
        if (validaAtribuicaoCandidatura(ac)) {
            return addAtribuicaoCandidatura(ac);
        } else {
            return false;
        }
    }

    private boolean addAtribuicaoCandidatura(Atribuicao ac) {
        return ac_listaAtribuicao.add(ac);
    }

    public boolean validaAtribuicaoCandidatura(Atribuicao ac) {
        return ac.valida();
    }

    public boolean validaAvaliacao(Candidatura c) {
        return c.valida();
    }

    public boolean validaAvaliacao(FAE f) {
        return f.valida();
    }

    @Override
    public String toString() {
        return this.m_oUtilizador.toString();
    }

    public boolean isUtilizador(Utilizador u) {
        if (this.m_oUtilizador != null) {
            return this.m_oUtilizador.equals(u);
        }
        return false;
    }

}
