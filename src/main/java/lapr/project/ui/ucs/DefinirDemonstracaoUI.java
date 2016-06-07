package lapr.project.ui.ucs;

import lapr.project.controller.*;
import java.util.*;
import lapr.project.utils.*;
import lapr.project.model.*;
import lapr.project.ui.UI;

/**
 *
 * @author Pedro Fernandes
 */
public class DefinirDemonstracaoUI implements UI{

    private CentroExposicoes m_centroDeExposicoes;
    private DefinirDemonstracaoController m_controller;

    public DefinirDemonstracaoUI(CentroExposicoes centroDeExposicoes) {
        m_centroDeExposicoes = centroDeExposicoes;
        m_controller = new DefinirDemonstracaoController(m_centroDeExposicoes);
    }

    @Override
    public void run() {

        String strCodigoUnico = Utils.readLineFromConsole("Introduza o código único da demonstração: ");
        m_controller.setCodigoUnico(strCodigoUnico);

        String strDescricao = Utils.readLineFromConsole("Introduza a descrição da demonstração: ");
        m_controller.setDescricao(strDescricao);

        apresentaDemonstracao(m_controller.getDemonstracao());

        if (Utils.confirma("Confirma?")) {
            m_controller.registaDemonstracao();
        }
    }

    private void apresentaDemonstracao(Demonstracao demonstracao) {
        if (demonstracao == null) {
            System.out.println("Demonstração não registada.");
        } else {
            System.out.println(demonstracao.toString());
        }
    }

}
