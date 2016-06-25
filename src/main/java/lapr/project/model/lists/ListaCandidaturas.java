package lapr.project.model.lists;

import java.io.Serializable;
import java.util.*;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.Candidatura;
import lapr.project.model.states.candidaturasExpo.CandidaturaEmAtribuicao;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaCandidaturas implements Serializable{
    
    private ArrayList<Candidatura> listaCandidaturas;

    public ListaCandidaturas() {
        listaCandidaturas = new ArrayList<>();
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
        return !listaCandidaturas.contains(c);
    }

    public boolean addCandidatura(Candidatura c) {
        return listaCandidaturas.add(c);
    }

    public List<Candidatura> getListaCandidaturas() {
        return listaCandidaturas;
    }
    
    public ListaCandidaturas getListaCandidaturasEmAtribuicao(){
        
        ListaCandidaturas listCandidaturas=new ListaCandidaturas();
        for(Candidatura c: listaCandidaturas){
   
            if (c.getEstadoAtualCandidatura() instanceof CandidaturaEmAtribuicao) {
                listCandidaturas.addCandidatura(c);
            }
        }

        return listCandidaturas;
    }

    public Candidatura getCandidaturaByNomeEmpresa(String strNomeEmpresa) {
        for (Candidatura c : this.listaCandidaturas) {
            if (c.getNomeEmpresa().equals(strNomeEmpresa)) {
                return c;
            }
        }
        return null;
    }

    public boolean alteraCandidatura(Candidatura cOriginal, Candidatura cClone) {
        if (cClone.valida()) {
            List<Candidatura> lstCandidaturas = new ArrayList<>(listaCandidaturas);
            lstCandidaturas.remove(cOriginal);
            lstCandidaturas.add(cClone);
            if (validaLista(lstCandidaturas)) {
                cOriginal.setNomeEmpresa(cClone.getNomeEmpresa());
                cOriginal.setMorada(cClone.getMorada());
                cOriginal.setTelemovel(cClone.getTelemovel());
                cOriginal.setAreaExposicao(cClone.getAreaExposicao());
                cOriginal.setQuantidadeConvites(cClone.getQuantidadeConvites());
                cOriginal.setListaKeywords(cClone.getListaKeywords());
                cOriginal.setListaProdutos(cClone.getListaProdutos());
                return true;
            }
        }
        return false;
    }
    
    private boolean validaLista(List<Candidatura> lista) {
        //validar
        return true;
    }

    public Candidatura getCandidaturaInfo(String cNomeEmpresa) {
        for (Candidatura c : listaCandidaturas) {
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
        return "RegistoCandidaturas:" + "m_listaCandidaturas=" + listaCandidaturas;
    }
    
    public Candidatura[] getArray() {
        return listaCandidaturas.toArray(new Candidatura[listaCandidaturas.size()] );
     }
    /**
     * metodo que obtem a candidatura na posicao passada por parametro
     *
     * @param indice Numero passado por parametro
     * @return candidatura na posicao passada por parametro
     */
    public Candidatura obterCandidatura(int indice) {
        return listaCandidaturas.get(indice);
    }
    /**
     * Metodo para remover candidaturas da lista
     * @param candidatura Candidatura
     * @return true se remover com sucesso false em caso contrario
     */
    public boolean removerCandidatura(Candidatura candidatura) {
        return listaCandidaturas.remove(candidatura);
    }
    /**
     * Metodo que retorna o tamanho da lista
     * @return o tamanho da lista
     */
    public int tamanho() {
        return this.listaCandidaturas.size();
    }
    /**
     * Metodo que retorna a posição da candidatura passada por parametro
     * @param candidatura Candidatura 
     * @return posição da candidatura passada por parametro
     */
    public int indiceDeCandidatura(Candidatura candidatura) {
        return listaCandidaturas.indexOf(candidatura);
    }
    /**
     * Metodo que verifica se uma candidatura existe na lista
     * @param candidatura Candidatura
     * @return true se a candidatura existir false em caso contrário
     */
    public boolean contem(Candidatura candidatura) {
        return listaCandidaturas.contains(candidatura);
    }
    
}
