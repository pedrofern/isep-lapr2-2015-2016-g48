package lapr.project.ui.ucs;

import lapr.project.utils.*;
import lapr.project.controller.*;
import lapr.project.model.*;
import lapr.project.ui.UI;

/**
 *
 * @author Pedro Fernandes
 */
public class AlterarUtilizadorUI implements UI {
    private CentroExposicoes m_centroDeExposicoes;
    private AlterarUtilizadorController m_controller;

    public AlterarUtilizadorUI(CentroExposicoes centroDeExposicoes) {
        m_centroDeExposicoes = centroDeExposicoes;
        m_controller = new AlterarUtilizadorController(m_centroDeExposicoes);
    }

    @Override
    public void run() {
        String strUser = Utils.readLineFromConsole("Introduza ID Utilizador: ");
        Utilizador u = m_controller.getUtilizador(strUser);

        u.toString();

        String strNome = Utils.readLineFromConsole("Novo Nome:").trim();
        if (strNome.isEmpty()) {
            strNome = u.getNome();
        }
        String strUsername = Utils.readLineFromConsole("Novo Username:").trim();
        if (strUsername.isEmpty()) {
            strUsername = u.getUsername();
        }
        String strPwd = Utils.readLineFromConsole("Nova Pwd:").trim();
        if (strPwd.isEmpty()) {
            strPwd = u.getPassword();
        }
        String strEmail = Utils.readLineFromConsole("Novo Email:").trim();
        if (strEmail.isEmpty()) {
            strPwd = u.getEmail();
        }

        if (m_controller.alteraDados(strNome, strUsername, strPwd, strEmail)) {
            System.out.println("Utilizador alterado com sucesso");
        }
    }
}
