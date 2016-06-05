package lapr.project.controller;

import lapr.project.model.lists.RegistoUtilizadores;
import java.util.*;
import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
public class ConfirmarRegistoUtilizadorController {

    private final CentroExposicoes m_ce;
    private Utilizador m_utilizadorAConfirmar;
    private RegistoUtilizadores m_registoUtilizadores;

    public ConfirmarRegistoUtilizadorController(CentroExposicoes ce) {
        this.m_ce = ce;
    }

    public List<Utilizador> iniciaConfirmacaoUtilizador() {
        return m_registoUtilizadores.getUtilizadoresNaoRegistados();
    }

    public Utilizador getUtilizadorInfo(String uId) {
        m_utilizadorAConfirmar = m_registoUtilizadores.getUtilizadorInfo(uId);
        return m_utilizadorAConfirmar;
    }

    public void confirmaRegistoUtilizador() {
        m_registoUtilizadores.confirmaRegistoUtilizador(m_utilizadorAConfirmar);
    }
}
