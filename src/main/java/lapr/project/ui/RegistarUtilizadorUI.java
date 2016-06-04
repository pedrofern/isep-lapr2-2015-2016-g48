package lapr.project.ui;

import lapr.project.controller.*;
import lapr.project.model.*;
import lapr.project.utils.*;

/**
 *
 * @author Pedro Fernandes
 */
public class RegistarUtilizadorUI implements UI{

    private CentroExposicoes centroDeExposicoes;
    private RegistarUtilizadorController m_controllerRU;

    public RegistarUtilizadorUI(CentroExposicoes empresa) {
        centroDeExposicoes = empresa;
        m_controllerRU = new RegistarUtilizadorController(centroDeExposicoes);
    }

    @Override
    public void run() {
        novoUtilizador();

        Utilizador utilizador = introduzDadosUtilizador();

        apresentaUtilizador(utilizador);
    }

    private void novoUtilizador() {
        m_controllerRU.novoUtilizador();
    }

    private Utilizador introduzDadosUtilizador() {
        String strUsername = Utils.readLineFromConsole("Introduza Username: ");

        String strPassword = Utils.readLineFromConsole("Introduza Password: ");

        String strNome = Utils.readLineFromConsole("Introduza Nome: ");

        String strEmail = Utils.readLineFromConsole("Introduza Email: ");

        return m_controllerRU.setDados(strUsername, strPassword, strNome, strEmail);
    }

    private void apresentaUtilizador(Utilizador utilizador) {
        if (utilizador == null) {
            System.out.println("Utilizador não registado.");
        } else {
            System.out.println(utilizador.toString());
        }
    }

}
