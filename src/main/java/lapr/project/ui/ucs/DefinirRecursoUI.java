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
public class DefinirRecursoUI implements UI{

    private CentroExposicoes m_centroDeExposicoes;
    private DefinirRecursoController m_controller;

    public DefinirRecursoUI(CentroExposicoes centroDeExposicoes) {
        m_centroDeExposicoes = centroDeExposicoes;
        m_controller = new DefinirRecursoController(m_centroDeExposicoes);
    }

    @Override
    public void run() {

        String strDescricao = Utils.readLineFromConsole("Introduza a descrição do recurso: ");
        m_controller.setDescricao(strDescricao);

        apresentaRecurso(m_controller.getRecurso());

        if (Utils.confirma("Confirma?")) {
            m_controller.registaRecurso();
        }

    }
    
    private void apresentaRecurso(Recurso recurso) {
        if (recurso == null) {
            System.out.println("Recurso não registado.");
        } else {
            System.out.println(recurso.toString());
        }
    }

}
