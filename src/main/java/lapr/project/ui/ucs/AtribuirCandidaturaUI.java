package lapr.project.ui.ucs;

import lapr.project.controller.*;
import java.util.*;
import lapr.project.model.*;
import lapr.project.ui.*;
import lapr.project.utils.*;

/**
 *
 * @author Pedro Fernandes
 */
public class AtribuirCandidaturaUI {

    private CentroExposicoes m_centroDeExposicoes;
    private AtribuirCandidaturaController m_controllerAC;

    public AtribuirCandidaturaUI(CentroExposicoes centroDeExposicoes) {
        m_centroDeExposicoes = centroDeExposicoes;
        m_controllerAC = new AtribuirCandidaturaController(m_centroDeExposicoes);
    }

    public AtribuirCandidaturaUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void run() {

        novaAtribuicaoCandidatura();

        List<Exposicao> le = m_controllerAC.iniciarAtribuicaoCandidatura();

        apresentaExposicoes(le);

        Exposicao e = selecionaExposicao(le);

        if (e != null) {

            List<Candidatura> lc = m_controllerAC.getListaCandidaturas();

            apresentaCandidaturas(lc);

            Candidatura c = selecionaCandidatura(lc);

            if (c != null) {

                List<FAE> lf = m_controllerAC.getListaFAE();

                apresentaFAE(lf);

                FAE f = selecionaFAE(lf);

                m_controllerAC.setAtribuicao();

                String strQuestao = "Confirma a decisao da atribuição de candidatura com a seguinte informação: \n" + m_controllerAC.getInfoResumo() + "\n Opção (S/N):";
                boolean bConfirma = confirma(strQuestao);

                if (bConfirma) {
                    if (m_controllerAC.registarDecisao()) {
                        System.out.println("Decisao concluida com sucesso.");
                    } else {
                        System.out.println("Decisao cancelada devido a erros.");
                    }

                } else {
                    System.out.println("Decisao de atribuição de candidatura cancelada.");
                }

                System.out.println("Terminado.");

            } else {
                System.out.println("Decisao de candidatura cancelada.");
            }

        } else {
            System.out.println("Decisao de candidatura cancelada.");
        }
    }

    private void novaAtribuicaoCandidatura() {
        m_controllerAC.novaAtribuicaoCandidatura();
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

    private void apresentaCandidaturas(List<Candidatura> lc) {
        System.out.println("Candidaturas: ");

        int index = 0;
        for (Candidatura c : lc) {
            index++;

            System.out.println(index + ". " + c.toString());
        }
        System.out.println("");
        System.out.println("0 - Cancelar");
    }

    private Candidatura selecionaCandidatura(List<Candidatura> lc) {
        String opcao;
        int nOpcao;
        do {
            opcao = Utils.readLineFromConsole("Introduza opção: ");
            nOpcao = new Integer(opcao);
        } while (nOpcao < 0 || nOpcao > lc.size());

        if (nOpcao == 0) {
            return null;
        } else {
            return lc.get(nOpcao - 1);
        }
    }

    private void apresentaFAE(List<FAE> lf) {
        System.out.println("FAE's: ");

        int index = 0;
        for (FAE f : lf) {
            index++;

            System.out.println(index + ". " + f.toString());
        }
        System.out.println("");
        System.out.println("0 - Cancelar");
    }

    private FAE selecionaFAE(List<FAE> lf) {
        String opcao;
        int nOpcao;
        do {
            opcao = Utils.readLineFromConsole("Introduza opção: ");
            nOpcao = new Integer(opcao);
        } while (nOpcao < 0 || nOpcao > lf.size());

        if (nOpcao == 0) {
            return null;
        } else {
            return lf.get(nOpcao - 1);
        }
    }

    private boolean confirma(String questao) {
        String strConfirma;
        do {
            strConfirma = Utils.readLineFromConsole(questao);
        } while (!strConfirma.equalsIgnoreCase("s") && !strConfirma.equalsIgnoreCase("n"));

        return strConfirma.equalsIgnoreCase("s");
    }

}
