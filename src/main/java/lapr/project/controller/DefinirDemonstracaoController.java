package lapr.project.controller;

import java.util.*;
import lapr.project.model.*;
import lapr.project.model.lists.RegistoRecursos;

/**
 *
 * @author Pedro Fernandes
 */
public class DefinirDemonstracaoController {

    private Demonstracao m_demonstracao;
    private List<Exposicao> m_listaExposicoes;
    private CentroExposicoes m_centroDeExposicoes;
    private RegistoRecursos m_listaRecursos;
    
    public DefinirDemonstracaoController(CentroExposicoes centroDeExposicoes) {
        m_centroDeExposicoes = centroDeExposicoes;
    }

    public Demonstracao novaDemonstracao(int codigoUnico, String strDescricao, RegistoRecursos lst_recursos) {
        return m_centroDeExposicoes.getRegistoDemonstracao().novaDemonstracao(codigoUnico, strDescricao, lst_recursos, m_centroDeExposicoes);
    }

    public boolean registaDemonstracao(Demonstracao demonstracao) {
        return m_centroDeExposicoes.getRegistoDemonstracao().registaDemonstracao(demonstracao);
    }

    public void setCodigoUnico(int codigoUnico) {
        m_demonstracao.setCod(codigoUnico);
    }
    
    public void setDescricao(String novaDescricao) {
        m_demonstracao.setDesc(novaDescricao);
    }
    
//    public void setListaRecursos(RegistoRecursos novaListaRecursos) {
//        m_demonstracao.setListaRecursos(novaListaRecursos);
//    }
    
    public RegistoRecursos getListaRecursos() {
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
    
    public Demonstracao setDados(int cdgUnico, String strDescricao) {
        m_demonstracao.setCod(cdgUnico);
        m_demonstracao.setDesc(strDescricao);

        if (m_centroDeExposicoes.getRegistoDemonstracao().validaDemonstracao(m_demonstracao)) {
            return m_demonstracao;
        } else {
            return null;
        }
    }
}
