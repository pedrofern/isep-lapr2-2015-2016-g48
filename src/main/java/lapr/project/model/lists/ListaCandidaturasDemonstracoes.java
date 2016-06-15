package lapr.project.model.lists;

import java.util.*;
import java.util.ArrayList;
import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
public class ListaCandidaturasDemonstracoes {
    
    private final List<CandidaturaDemonstracao> m_listaCandidaturasDemonstracoes;

    public ListaCandidaturasDemonstracoes() {
        m_listaCandidaturasDemonstracoes = new ArrayList<>();
    }

    /**
     * Cria uma nova Candidaturas.
     *
     * @return Candidaturas.
     */
    public CandidaturaDemonstracao novaCandidaturaDemonstracao(Candidatura c) {
        return new CandidaturaDemonstracao(c);
    }

    public boolean registaCandidaturaDemonstracao(CandidaturaDemonstracao c) {
        if (c.valida() && validaCandidaturaDemonstracao(c)) {
            return addCandidaturaDemonstracao(c);
        } else {
            return false;
        }
    }

    private boolean validaCandidaturaDemonstracao(CandidaturaDemonstracao c) {
        System.out.println("RegistoCandidaturas: validaCandidatura: " + c.toString());
        return true;
    }

    public boolean addCandidaturaDemonstracao(CandidaturaDemonstracao c) {
        return m_listaCandidaturasDemonstracoes.add(c);
    }

    public List<CandidaturaDemonstracao> getListaCandidaturasDemonstracao() {
        return m_listaCandidaturasDemonstracoes;
    }

    public CandidaturaDemonstracao getCandidaturaDemonstracaoByNomeEmpresa(String strNomeEmpresa) {
        for (CandidaturaDemonstracao c : this.m_listaCandidaturasDemonstracoes) {
            if (c.getNomeEmpresaCD().equals(strNomeEmpresa)) {
                return c;
            }
        }
        return null;
    }

    public boolean alteraCandidaturaDemonstracao(CandidaturaDemonstracao cOriginal, CandidaturaDemonstracao cClone) {
        if (cClone.valida()) {
            List<CandidaturaDemonstracao> lstCandidaturas = new ArrayList<CandidaturaDemonstracao>(m_listaCandidaturasDemonstracoes);
            lstCandidaturas.remove(cOriginal);
            lstCandidaturas.add(cClone);
            if (validaListaDemonstracao(lstCandidaturas)) {
                cOriginal.setNomeEmpresaCD(cClone.getNomeEmpresaCD());
                cOriginal.setMoradaCD(cClone.getMoradaCD());
                cOriginal.setTelemovelCD(cClone.getTelemovelCD());
                cOriginal.setAreaExposicaoCD(cClone.getAreaExposicaoCD());
                cOriginal.setQuantidadeConvitesCD(cClone.getQuantidadeConvitesCD());
                return true;
            }
        }
        return false;
    }
    
    private boolean validaListaDemonstracao(List<CandidaturaDemonstracao> lista) {
        System.out.println("RegistoCandidaturasDemonstracao: validaLista: " + lista.toString());
        return true;
    }

    public CandidaturaDemonstracao getCandidaturaDemonstracaoInfo(String cNomeEmpresa) {
        for (CandidaturaDemonstracao c : m_listaCandidaturasDemonstracoes) {
            if (cNomeEmpresa.equalsIgnoreCase(c.getNomeEmpresaCD())) {
                return c;
            }
        }
        return null;
    }

    /**
     * Devolve a descrição textual do Registo de Candidaturas.
     *
     * @return características do Registo de Candidaturas.
     */
    @Override
    public String toString() {
        return "RegistoCandidaturas:" + "m_listaCandidaturas=" + m_listaCandidaturasDemonstracoes;
    }
    
    public CandidaturaDemonstracao[] getArray() {
        return m_listaCandidaturasDemonstracoes.toArray( new CandidaturaDemonstracao[m_listaCandidaturasDemonstracoes.size()] );
     }
    
}
