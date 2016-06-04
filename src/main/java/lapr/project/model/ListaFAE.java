package lapr.project.model;

import java.util.*;

/**
 *
 * @author Pedro Fernandes
 */
public class ListaFAE {

    /**
     * A lista de Faes.
     */
    private List<FAE> m_listaFaes;

    /**
     * Constroi um ArrayList de Faes.
     */
    public ListaFAE() {
        m_listaFaes = new ArrayList<FAE>();
    }

    /**
     * Valida o FAE e se for válido adiciona a uma Lista de Faes.
     *
     * @param u o utilizador a adicionar.
     * @return boolean
     */
    public boolean addFAE(Utilizador u) {
        if (u == null) {
            return false;
        }
        System.out.println("ListaFaes: addFAE: " + u.toString());
        FAE f = new FAE();

        if (f.valida() && validaFAE(f)) {
            return addFAE(f);
        } else {
            return false;
        }
    }
    
    public boolean registaFAE(FAE fae) {
        if (fae.valida() && validaFAE(fae)) {
            return addFAE(fae);
        } else {
            return false;
        }
    }
    
    public List<FAE> getListaFAEs(){
        return this.m_listaFaes;
    }

    public FAE addMembroFAE(Utilizador u) {
        FAE fae = new FAE(u);
        validaFAE(fae);
        return fae;
    }

    /**
     * Adiciona o FAE a uma Lista.
     *
     * @param f o FAE a adicionar
     * @return m_listaOrganizadores
     */
    private boolean addFAE(FAE f) {
        return m_listaFaes.add(f);
    }
    
    public boolean validaLista(List<FAE> listaFAE) {
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

    /**
     * Validação do FAE.
     *
     * @param f o FAE
     * @return boolean
     */
    private boolean validaFAE(FAE f) {
        System.out.println("ListaFaes: validaFAE:" + f.toString());
        return true;
    }

    /**
     * Verifica se existe o FAE com a mesma ID recebida por parametro.
     *
     * @param strID a identificação do FAE
     * @return bollean
     */
    public boolean hasFAE(String strID) {
        for (FAE f : this.m_listaFaes) {
            if (f.getUtilizador().getUsername().equals(strID)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Devolve a descrição textual da Lista de Faes.
     *
     * @return características da Lista de Faes.
     */
    @Override
    public String toString() {
        return "ListaFaes:" + "m_listaFaes=" + m_listaFaes;
    }
}
