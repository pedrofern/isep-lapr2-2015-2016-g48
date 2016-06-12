package lapr.project.ui.ucs;

import lapr.project.controller.*;
import lapr.project.model.*;
import java.util.*;
import lapr.project.ui.*;
import lapr.project.utils.*;

/**
 *
 * @author Pedro Fernandes
 */
public class DefinirTipoConflitoUI {
    
    private static CentroExposicoes ce;
    
    private DefinirTipoConflitoController controller;

    public DefinirTipoConflitoUI(CentroExposicoes centroExposicoes) {
        ce = centroExposicoes;
        controller = new DefinirTipoConflitoController(ce);
    }

    
//    public void run() {
//        String strDesc = Utils.readLineFromConsole("Introduza Descrição Tipo Conflito: ");
//        List<MecanismoDetecaoConflito> lsObjs = m_centroDeExposicoes.getMecanismosDetecaoConflito();
//        Utils.apresentaLista(lsObjs, "Selecione Mecanismo de Detecao:");
//        MecanismoDetecaoConflito mec = (MecanismoDetecaoConflito) Utils.selecionaObject(lsObjs);
//
//        TipoConflito tc = m_controller.novoTipoConflito(strDesc, mec);
//
//        if (Utils.confirma("Confirma (s/n)?")) {
//            m_controller.registaTipoConflito(tc);
////        }
//    }
}
