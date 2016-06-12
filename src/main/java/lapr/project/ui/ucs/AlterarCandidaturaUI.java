package lapr.project.ui.ucs;

import lapr.project.controller.*;
import lapr.project.model.*;
import lapr.project.ui.*;
import lapr.project.utils.*;

/**
 *
 * @author Pedro Fernandes
 */
public class AlterarCandidaturaUI {
    
    private static CentroExposicoes m_ce;
    private static Utilizador m_user;
    private static AlterarCandidaturaController m_controller;

    public AlterarCandidaturaUI(CentroExposicoes ce, Utilizador user) {
        m_ce = ce;
        m_user=user;
        m_controller = new AlterarCandidaturaController(m_ce);
    }

    
//    public void run() {
//        String strNomeEmpresa = Utils.readLineFromConsole("Introduza o nome da empresa: ");
//        Candidatura c = m_controller.getCandidatura(strNomeEmpresa);
//
//        c.toString();
//
//        String strNomeEmpres = Utils.readLineFromConsole("Novo nome empresa: ").trim();
//        if (strNomeEmpres.isEmpty()) {
//            strNomeEmpres = c.getNomeEmpresa();
//        }
//        String strMorada = Utils.readLineFromConsole("Nova morada: ").trim();
//        if (strMorada.isEmpty()) {
//            strMorada = c.getMorada();
//        }
//        String strTelemovel = Utils.readLineFromConsole("Novo telem�vel: ").trim();
//        int tlm = Integer.parseInt(strTelemovel);
//        if (strTelemovel.isEmpty()) {
//            tlm = c.getTelemovel();
//        }
//        String strArea = Utils.readLineFromConsole("Nova �rea: ").trim();
//        int area = Integer.parseInt(strArea);
//        if (strArea.isEmpty()) {
//            area = c.getAreaExposicao();
//        }
//        String strQuantidadeConvites = Utils.readLineFromConsole("Nova Quantidade de Convites:").trim();
//        int convites = Integer.parseInt(strQuantidadeConvites);
//        if (strQuantidadeConvites.isEmpty()) {
//            convites = c.getQuantidadeConvites();
//        }
//        
//        if (m_controller.alteraDados(strNomeEmpres, strMorada, tlm, area, convites)) {
//            System.out.println("Utilizador alterado com sucesso");
//        }
//    }
}
