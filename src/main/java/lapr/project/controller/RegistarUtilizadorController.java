package lapr.project.controller;

import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
public class RegistarUtilizadorController {

    private CentroExposicoes centroDeExposicoes;
    private Utilizador m_utilizador;
    private RegistoUtilizadores m_registoUtilizadores;

    public RegistarUtilizadorController(CentroExposicoes aCentroDeExposicoes) {
        centroDeExposicoes = aCentroDeExposicoes;
    }

    public void novoUtilizador() {
        m_utilizador = m_registoUtilizadores.novoUtilizador();
    }

    public Utilizador criaUtilizador(String nome, String email, String user, String pass) {
        novoUtilizador();
        m_utilizador.setUsername(user);
        m_utilizador.setPassword(pass);
        m_utilizador.setNome(nome);
        m_utilizador.setEmail(email);

        if (m_registoUtilizadores.registaUtilizador(m_utilizador)) {
            return m_utilizador;
        } else {
            return null;
        }
    }

    public void setUtilizador(Utilizador m_utilizador) {
        this.m_utilizador = m_utilizador;
    }

}
