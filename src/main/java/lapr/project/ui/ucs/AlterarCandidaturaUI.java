package lapr.project.ui.ucs;

import lapr.project.controller.*;
import lapr.project.model.*;


/**
 *
 * @author Pedro Fernandes
 */
public class AlterarCandidaturaUI {
    
    private static CentroExposicoes ce;
    private static Utilizador user;
    private static AlterarCandidaturaController controller;

    public AlterarCandidaturaUI(CentroExposicoes centroExposicoes, Utilizador utilizador) {
        ce = centroExposicoes;
        user=utilizador;
        controller = new AlterarCandidaturaController(ce);
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
