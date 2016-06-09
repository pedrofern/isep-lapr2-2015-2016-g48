package lapr.project.model.lists;

import java.util.*;
import java.util.ArrayList;
import lapr.project.model.Candidatura;

/**
 *
 * @author Pedro Fernandes
 */
public class ListaCandidaturas {
    
    private final List<Candidatura> m_listaCandidaturas;

    public ListaCandidaturas() {
        m_listaCandidaturas = new ArrayList<>();
    }

    /**
     * Cria uma nova Candidaturas.
     *
     * @return Candidaturas.
     */
    public Candidatura novaCandidatura() {
        return new Candidatura();
    }

    public boolean registaCandidaturas(Candidatura c) {
        if (c.valida() && validaCandidatura(c)) {
            return addCandidatura(c);
        } else {
            return false;
        }
    }

    private boolean validaCandidatura(Candidatura c) {
        System.out.println("RegistoCandidaturas: validaCandidatura: " + c.toString());
        return true;
    }

    public boolean addCandidatura(Candidatura c) {
        return m_listaCandidaturas.add(c);
    }

    public List<Candidatura> getListaCandidaturas() {
        return m_listaCandidaturas;
    }

    public Candidatura getCandidaturaByNomeEmpresa(String strNomeEmpresa) {
        for (Candidatura c : this.m_listaCandidaturas) {
            if (c.getNomeEmpresa().equals(strNomeEmpresa)) {
                return c;
            }
        }
        return null;
    }

    public boolean alteraCandidatura(Candidatura cOriginal, Candidatura cClone) {
        if (cClone.valida()) {
            List<Candidatura> lstCandidaturas = new ArrayList<Candidatura>(m_listaCandidaturas);
            lstCandidaturas.remove(cOriginal);
            lstCandidaturas.add(cClone);
            if (validaLista(lstCandidaturas)) {
                cOriginal.setNomeEmpresa(cClone.getNomeEmpresa());
                cOriginal.setMorada(cClone.getMorada());
                cOriginal.setTelemovel(cClone.getTelemovel());
                cOriginal.setAreaExposicao(cClone.getAreaExposicao());
                cOriginal.setQuantidadeConvites(cClone.getQuantidadeConvites());
                return true;
            }
        }
        return false;
    }
    
    private boolean validaLista(List<Candidatura> lista) {
        System.out.println("RegistoCandidaturas: validaLista: " + lista.toString());
        return true;
    }

    public Candidatura getCandidaturaInfo(String cNomeEmpresa) {
        for (Candidatura c : m_listaCandidaturas) {
            if (cNomeEmpresa.equalsIgnoreCase(c.getNomeEmpresa())) {
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
        return "RegistoCandidaturas:" + "m_listaCandidaturas=" + m_listaCandidaturas;
    }
    
    public Candidatura[] getArray() {
        return m_listaCandidaturas.toArray( new Candidatura[m_listaCandidaturas.size()] );
     }
    
}
