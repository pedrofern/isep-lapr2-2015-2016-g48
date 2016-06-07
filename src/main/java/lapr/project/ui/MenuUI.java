package lapr.project.ui;

import lapr.project.ui.ucs.DecidirCandidaturaUI;
import lapr.project.ui.ucs.CriarExposicaoUI;
import lapr.project.ui.ucs.CriarCandidaturaUI;
import lapr.project.ui.ucs.DefinirRecursoUI;
import lapr.project.ui.ucs.AtribuirCandidaturaUI;
import lapr.project.ui.ucs.ConfirmarRegistoUtilizadorUI;
import lapr.project.ui.ucs.DefinirDemonstracaoUI;
import lapr.project.model.*;
import lapr.project.utils.*;
import java.io.*;
import java.util.*;
import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
public class MenuUI {

    private Representante m_representante;
    private CentroExposicoes m_centroDeExposicoes;
    private String opcao;
    private Utilizador m_utilizador;

    public MenuUI(CentroExposicoes centroDeExposicoes) {
        m_centroDeExposicoes = centroDeExposicoes;
    }

    public void run() throws IOException {

        //Uma espécie de Login
        List<Utilizador> lUsers = this.m_centroDeExposicoes.getUtilizadores();
        Utilizador utilizador;
        do {
            utilizador = (Utilizador) Utils.apresentaESeleciona(lUsers, "Selecione Utilizador");

        } while (utilizador == null);

        do {
            System.out.println("1. Criar Exposição");
            System.out.println("2. Definir FAE");
            System.out.println("3. Atribuir Candidatura");
            System.out.println("4. Decidir Candidatura");
            System.out.println("5. Criar Candidatura");
            System.out.println("6. Criar Perfil de Utilizador");
            System.out.println("7. Confirmar Registo de Utilizador");
            System.out.println("8. Definir Demonstração");
            System.out.println("9. Definir Recurso");
            System.out.println("0. Sair");

            opcao = Utils.readLineFromConsole("Introduza opção: ");

            if (opcao.equals("1")) {
                CriarExposicaoUI uiRU = new CriarExposicaoUI(m_centroDeExposicoes);
                uiRU.run();
            }

//            if (opcao.equals("2")) {
//                DefinirFAEUI uiRU = new DefinirFAEUI(m_centroDeExposicoes);
//                uiRU.run();
//            }

            if (opcao.equals("3")) {
                AtribuirCandidaturaUI uiRU = new AtribuirCandidaturaUI(m_centroDeExposicoes);
                uiRU.run();
            }

            if (opcao.equals("4")) {
                DecidirCandidaturaUI uiRU = new DecidirCandidaturaUI(m_centroDeExposicoes);
                uiRU.run();
            }

            if (opcao.equals("5")) {
                CriarCandidaturaUI uiRU = new CriarCandidaturaUI(m_representante);
                uiRU.run();
            }

            if (opcao.equals("6")) {
                RegistarUtilizadorUI uiRU = new RegistarUtilizadorUI(m_centroDeExposicoes);
                uiRU.run();
            }

            if (opcao.equals("7")) {
                ConfirmarRegistoUtilizadorUI uiRU = new ConfirmarRegistoUtilizadorUI(m_centroDeExposicoes, m_utilizador);
                uiRU.run();
            }

            if (opcao.equals("8")) {
                DefinirDemonstracaoUI uiRU = new DefinirDemonstracaoUI(m_centroDeExposicoes);
                uiRU.run();
            }

            if (opcao.equals("9")) {
                DefinirRecursoUI uiRU = new DefinirRecursoUI(m_centroDeExposicoes);
                uiRU.run();
            }

        } while (!opcao.equals("0"));
    }

}
