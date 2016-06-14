package lapr.project.model.lists;

import java.util.*;
import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
public class ListaFAE {

    /**
     * A lista de Faes.
     */
    private List<FAE> m_listaFaes;
    private List<Exposicao> m_listaExposicaoFAE;

    /**
     * Constroi um ArrayList de Faes.
     */
    public ListaFAE() {
        m_listaFaes = new ArrayList<>();
    }

    public boolean registaMenbroFAE(FAE fae) {
        if (fae.validaMenbroFAE() && validaListaFAE(m_listaFaes)) {
            return adicionarFAE(fae);
        } else {
            return false;
        }
    }

    public boolean adicionarFAE(FAE fae) {
        if (!m_listaFaes.contains(fae)) {
            return m_listaFaes.add(fae);
        }
        return false;
    }

    public boolean validaListaFAE(List<FAE> listaFAE) {
        StringBuilder s = new StringBuilder();

        String[] listFae = new String[listaFAE.size()];

        int i = 0;
        for (FAE fae : listaFAE) {
            s.append(fae.toString());
            s.append("\n");
            listFae[i] = s.toString();
            i++;
        }

        for (int p = 0; p < listaFAE.size(); p++) {
            for (int j = 1; j < listaFAE.size(); j++) {
                if (listaFAE.get(p).equals(listaFAE.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<FAE> getListaFAE() {
        return m_listaFaes;
    }

    public boolean addFAE(FAE fae, Exposicao exposicao) {

        if (!m_listaFaes.contains(fae) && !m_listaExposicaoFAE.contains(exposicao)) {
            adicionarFAE(fae);
            m_listaExposicaoFAE.add(exposicao);
            return true;
        }

        return false;
    }

    /**
     * Metodo que retorna o FAE que tenha o ID passado por parametro
     *
     * @param strId ID
     * @return FAE que tenha o ID passado por parametro
     */
    public FAE getFAE(String strId) {
        for (FAE f : m_listaFaes) {
            if (f.getUtilizador().hasID(strId)) {
                return f;
            }
        }
        return null;

    }

    public List<Exposicao> getListaExposicaoFAE() {
        
        return m_listaExposicaoFAE;
    }
}
//    /**
//     * metodo que obtem o FAE na posicao passada por indice
//     *
//     * @param indice indice
//     * @return o FAE na posicao passada por indice
//     */
//    public FAE obterFAE(int indice) {
//        return m_listaFaes.get(indice);
//    }
//
//    public List<FAE> getListaOrganizadores() {
//        return m_listaFaes;
//    }
//
//    /**
//     * metodo que retorna o array FAE
//     *
//     * @return o array FAE
//     */
//    public FAE[] getArray() {
//        return m_listaFaes.toArray(new FAE[m_listaFaes.size()]);
//    }
//
//    /**
//     * metodo que retorna a lista de FAEs
//     *
//     * @return a lista de FAEs
//     */

//
//    /**
//     * metodo para adicionar o FAEs passado por parametro a lista
//     *
//     * @param fae FAE
//     * @return true se adicionar false caso contrario
//     */
//
//    /**
//     * metodo para remover o FAEs passado por parametro a lista
//     *
//     * @param fae FAE
//     * @return true se remover false caso contrario
//     */
//    public boolean removerFAE(FAE fae) {
//        return m_listaFaes.remove(fae);
//    }
//
//    /**
//     * metodo para retornar o tamanho da lista de FAEs
//     *
//     * @return o tamanho da lista de FAEs
//     */
//    public int tamanho() {
//        return this.m_listaFaes.size();
//    }
//
//    /**
//     * metodo para retornar o indice do FAE passado por parametro
//     *
//     * @param fae FAE
//     * @return o indice do FAE passado por parametro
//     */
//    public int indiceDeFAE(FAE fae) {
//        return m_listaFaes.indexOf(fae);
//    }
//
//    /**
//     * Metodo que verifica se o FAE passado por parametro existe na lista
//     *
//     * @param fae FAE
//     * @return true caso exista false caso contrario
//     */
//    public boolean contem(FAE fae) {
//        return m_listaFaes.contains(fae);
//    }
//
//    /**
//     * Metodo que verifica se o FAE com o id passado por parametro existe na
//     * lista
//     *
//     * @param strID ID
//     * @return true caso existe false caso contrario
//     */
//    public boolean hasFAE(Utilizador u) {
//        for (FAE fae : this.m_listaFaes) {
//            if (fae.getUtilizador().toString().equals(u)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//    /**
//     * Adiciona um novo FAE a lista
//     *
//     * @param u Utilizador
//     * @return A instancia de FAE criada
//     */
//    public FAE addMembroFAE(Utilizador u) {
//        FAE fae = new FAE(u);
//        validaMembroFAE(fae);
//        return fae;
//    }
//
//     public FAE criaFAE(Utilizador u) {
//        FAE fae=new FAE(u);
//        return fae;
//    }
//    public boolean addMembroFAEAll(Utilizador u) {
//
//        //if (u.valida()) {
//            FAE fae = new FAE(u);
//            validaMembroFAE(fae);
//            return true;
//       // }
//       
//    }
//
//    /**
//     * Metodo que vai validar um FAE
//     *
//     * @param fae FAE
//     * @return true caso o FAE seja valida false caso contrario
//     */
//    public boolean validaMembroFAE(FAE fae) {
//        if (fae.valida()) {
//            m_listaFaes.add(fae);
//            return true;
//        }
//        return false;
//    }
//
//    //isto é no registofaes
//    public FAE novoDefinirFAE() {
//        return new FAE();
//    }

