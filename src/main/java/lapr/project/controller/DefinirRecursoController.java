package lapr.project.controller;

import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
public class DefinirRecursoController {

    private CentroExposicoes m_centroDeExposicoes;
    private Recurso m_recurso;

    public DefinirRecursoController(CentroExposicoes centroDeExposicoes) {
        m_centroDeExposicoes = centroDeExposicoes;
    }

//    public Recurso novoRecurso(String strDescricao) {
//        return m_centroDeExposicoes.getRegistoRecurso().novoRecurso(strDescricao);
//    }
//
//    public boolean registaRecurso(Recurso recurso) {
//        return m_centroDeExposicoes.getRegistoRecurso().registaRecurso(recurso);
//    }
    
    public void setDescricao(String novaDescricao) {
        m_recurso.setDescricao(novaDescricao);
    }
    
//    public Recurso registaRecurso() {
//        if (m_centroDeExposicoes.getRegistoRecurso().registaRecurso(m_recurso)) {
//            return m_recurso;
//        }
//        return null;
//    }
    
    public Recurso getRecurso() {
        return m_recurso;
    }

}
