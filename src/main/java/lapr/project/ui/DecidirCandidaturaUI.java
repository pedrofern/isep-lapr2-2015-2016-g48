package lapr.project.ui;

import lapr.project.controller.*;
import java.util.*;
import lapr.project.model.*;
import lapr.project.utils.*;

/**
 *
 * @author Pedro Fernandes
 */
public class DecidirCandidaturaUI implements UI{

    private CentroExposicoes m_centroDeExposicoes;
    private AvaliarCandidaturaController m_controllerDC;

    public DecidirCandidaturaUI(CentroExposicoes centroDeExposicoes) {
        m_centroDeExposicoes = centroDeExposicoes;
        m_controllerDC = new AvaliarCandidaturaController(m_centroDeExposicoes);
    }

    @Override
    public void run() {

        List<Exposicao> le = m_controllerDC.iniciarAvaliacao();

        apresentaExposicoes(le);

        Exposicao e = selecionaExposicao(le);

        if (e != null) {
            m_controllerDC.selectExposicao(e);

            String strResposta = Utils.readLineFromConsole("Introduza a Resposta à Candidatura: ");
            String strJustificacao = Utils.readLineFromConsole("Introduza a Justificação dessa Resposta: ");

            m_controllerDC.setAvaliacao(strResposta, strJustificacao);

            String strQuestao = "Confirma a decisao da candidatura com a seguinte informação: \n" + m_controllerDC.getInfoResumo() + "\n Opção (S/N):";
            boolean bConfirma = confirma(strQuestao);

            if (bConfirma) {
                if (m_controllerDC.registarDecisao()) {
                    System.out.println("Decisao concluida com sucesso.");
                } else {
                    System.out.println("Decisao cancelada devido a erros.");
                }

            } else {
                System.out.println("Decisao de candidatura cancelada.");
            }

            System.out.println("Terminado.");
        } else {
            System.out.println("Decisao de candidatura cancelada.");
        }

    }

    private Exposicao selecionaExposicao(List<Exposicao> le) {
        String opcao;
        int nOpcao;
        do {
            opcao = Utils.readLineFromConsole("Introduza opção: ");
            nOpcao = new Integer(opcao);
        } while (nOpcao < 0 || nOpcao > le.size());

        if (nOpcao == 0) {
            return null;
        } else {
            return le.get(nOpcao - 1);
        }
    }

    private void apresentaExposicoes(List<Exposicao> le) {
        System.out.println("Exposicoes: ");

        int index = 0;
        for (Exposicao e : le) {
            index++;

            System.out.println(index + ". " + e.toString());
        }
        System.out.println("");
        System.out.println("0 - Cancelar");
    }

    private boolean confirma(String questao) {
        String strConfirma;
        do {
            strConfirma = Utils.readLineFromConsole(questao);
        } while (!strConfirma.equalsIgnoreCase("s") && !strConfirma.equalsIgnoreCase("n"));

        return strConfirma.equalsIgnoreCase("s");
    }
}
