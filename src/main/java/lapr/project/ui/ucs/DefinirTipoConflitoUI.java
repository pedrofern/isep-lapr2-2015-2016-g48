package lapr.project.ui.ucs;

import lapr.project.controller.*;
import lapr.project.model.*;
import java.util.*;
import lapr.project.ui.UI;
import lapr.project.utils.*;

/**
 *
 * @author Pedro Fernandes
 */
public class DefinirTipoConflitoUI implements UI{
    
    private CentroExposicoes m_centroDeExposicoes;
    private DefinirTipoConflitoController m_controller;

    public DefinirTipoConflitoUI(CentroExposicoes centroDeExposicoes) {
        m_centroDeExposicoes = centroDeExposicoes;
        m_controller = new DefinirTipoConflitoController(m_centroDeExposicoes);
    }

    @Override
    public void run() {
//        String strDesc = Utils.readLineFromConsole("Introduza Descrição Tipo Conflito: ");
//        List<MecanismoDetecaoConflito> lsObjs = m_centroDeExposicoes.getMecanismosDetecaoConflito();
//        Utils.apresentaLista(lsObjs, "Selecione Mecanismo de Detecao:");
//        MecanismoDetecaoConflito mec = (MecanismoDetecaoConflito) Utils.selecionaObject(lsObjs);
//
//        TipoConflito tc = m_controller.novoTipoConflito(strDesc, mec);
//
//        if (Utils.confirma("Confirma (s/n)?")) {
//            m_controller.registaTipoConflito(tc);
//        }
    }
}
