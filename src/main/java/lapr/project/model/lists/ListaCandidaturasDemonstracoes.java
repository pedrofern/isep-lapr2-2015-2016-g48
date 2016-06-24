package lapr.project.model.lists;

import java.io.Serializable;
import java.util.*;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaCandidaturasDemonstracoes implements Serializable{
    
    private final ArrayList<CandidaturaDemonstracao> listaCandidaturasDemonstracoes;

    public ListaCandidaturasDemonstracoes() {
        listaCandidaturasDemonstracoes = new ArrayList<>();
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

    private boolean validaCandidaturaDemonstracao(CandidaturaDemonstracao cd) {
        return cd.valida();
    }

    public boolean addCandidaturaDemonstracao(CandidaturaDemonstracao c) {
        return listaCandidaturasDemonstracoes.add(c);
    }

    public List<CandidaturaDemonstracao> getListaCandidaturasDemonstracao() {
        return listaCandidaturasDemonstracoes;
    }

    public CandidaturaDemonstracao getCandidaturaDemonstracaoByNomeEmpresa(String strNomeEmpresa) {
        for (CandidaturaDemonstracao c : this.listaCandidaturasDemonstracoes) {
            if (c.getNomeEmpresaCD().equals(strNomeEmpresa)) {
                return c;
            }
        }
        return null;
    }

    public boolean alteraCandidaturaDemonstracao(CandidaturaDemonstracao cOriginal, CandidaturaDemonstracao cClone) {
        if (cClone.valida()) {
            List<CandidaturaDemonstracao> lstCandidaturas = new ArrayList<>(listaCandidaturasDemonstracoes);
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
        //validar
        return true;
    }

    public CandidaturaDemonstracao getCandidaturaDemonstracaoInfo(String cNomeEmpresa) {
        for (CandidaturaDemonstracao c : listaCandidaturasDemonstracoes) {
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
        return "RegistoCandidaturas:" + listaCandidaturasDemonstracoes;
    }
    
    public CandidaturaDemonstracao[] getArray() {
        return listaCandidaturasDemonstracoes.toArray(new CandidaturaDemonstracao[listaCandidaturasDemonstracoes.size()] );
     }
    
}
