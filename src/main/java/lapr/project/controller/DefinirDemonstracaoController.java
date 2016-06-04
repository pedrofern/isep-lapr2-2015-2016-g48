package lapr.project.controller;

import java.util.*;
import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
public class DefinirDemonstracaoController {

    private Demonstracao m_demonstracao;
    private List<Exposicao> m_listaExposicoes;
    private CentroExposicoes m_centroDeExposicoes;
    private List<Recurso> m_listaRecursos;
    
    public DefinirDemonstracaoController(CentroExposicoes centroDeExposicoes) {
        m_centroDeExposicoes = centroDeExposicoes;
    }

    public Demonstracao novaDemonstracao(String codigoUnico, String strDescricao, List<Recurso> lst_recursos) {
        return m_centroDeExposicoes.getRegistoDemonstracao().novaDemonstracao(codigoUnico, strDescricao, lst_recursos);
    }

    public boolean registaDemonstracao(Demonstracao demonstracao) {
        return m_centroDeExposicoes.getRegistoDemonstracao().registaDemonstracao(demonstracao);
    }

    public void setCodigoUnico(String codigoUnico) {
        m_demonstracao.setCodigoUnico(codigoUnico);
    }
    
    public void setDescricao(String novaDescricao) {
        m_demonstracao.setDescricao(novaDescricao);
    }
    
    public void setListaRecursos(List<Recurso> novaListaRecursos) {
        m_demonstracao.setListaRecursos(novaListaRecursos);
    }
    
    public List<Recurso> getListaRecursos() {
        return m_listaRecursos;
    }
        
    public void addRecursoDemonstracao(Recurso r){
        m_demonstracao.addRecurso(r);
    }
    
    public List<Exposicao> getListaExposicoes() {
        List<Exposicao> le = new ArrayList<Exposicao>();

        for (Exposicao e : m_listaExposicoes) {
            le.add(e);
        }
        return le;
    }

    public Demonstracao registaDemonstracao() {
        if (m_centroDeExposicoes.getRegistoDemonstracao().registaDemonstracao(m_demonstracao)) {
            return m_demonstracao;
        }
        return null;
    }
    
    public Demonstracao getDemonstracao() {
        return m_demonstracao;
    }
    
    public Demonstracao setDados(String cdgUnico, String strDescricao) {
        m_demonstracao.setCodigoUnico(cdgUnico);
        m_demonstracao.setDescricao(strDescricao);

        if (m_centroDeExposicoes.getRegistoDemonstracao().validaDemonstracao(m_demonstracao)) {
            return m_demonstracao;
        } else {
            return null;
        }
    }
}
