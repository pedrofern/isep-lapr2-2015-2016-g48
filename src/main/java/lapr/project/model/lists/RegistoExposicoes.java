package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import lapr.project.model.Exposicao;
import lapr.project.model.Utilizador;

/**
 *
 * @author Pedro Fernandes
 */
public class RegistoExposicoes {

    private List<Exposicao> m_listaExposicoes;
    private List<Utilizador> m_listaUtilizadores;

    public RegistoExposicoes() {
        m_listaExposicoes = new ArrayList<Exposicao>();
        m_listaUtilizadores = new ArrayList<Utilizador>();
    }

    public Exposicao novaExposicao() {
        return new Exposicao();
    }

      /**
     * Metodo que regista uma exposicao
     * @param e exposicao
    public boolean adicionarExposicao(Exposicao expo) {
     * @return true se resgistar false em caso contrario
     */
    
    public boolean adicionarExposicao(Exposicao expo) {
        if (!m_listaExposicoes.contains(expo)) {
            return m_listaExposicoes.add(expo);
        }
        return false;
    }
    
       public boolean registaExposicao(Exposicao e) {
        if (e.valida() && validaExposicao(e)) {
            return adicionarExposicao(e);
        } else {
            return false;
        }
    }

    /**
     * Metodo que valida uma exposicao
     * @param e exposicao
     * @return true se validar false caso contrario
     */
    public boolean validaExposicao(Exposicao e) {
        if (e.valida()) {
            // Introduzir as validações aqui
            return true;
        }
        return false;
    }
 

    @Override
    public String toString() {
        return "RegistoExposicoes:" + "m_listaExposicoes=" + m_listaExposicoes;
    }
    
    public List<Exposicao> getExposicao(){
        return m_listaExposicoes;
    }

    public List<Exposicao> getExposicaoOrganizador(String strId) {
        List<Exposicao> leOrganizador = new ArrayList<Exposicao>();

        Utilizador user = null;
        
        for (Utilizador u : this.m_listaUtilizadores) {
            if (u.hasID(strId)) {
                user = u;
            }
        }

        if (user != null) {
            for (Iterator<Exposicao> it = this.m_listaExposicoes.listIterator(); it.hasNext();) {
                Exposicao e = it.next();

                if (e.hasOrganizador(user)) {
                    leOrganizador.add(e);
                }
            }
        }
        return leOrganizador;
    }
    
    public List<Exposicao> getExposicaoFAE(String strId) {
        List<Exposicao> leFAE = new ArrayList<Exposicao>();

        Utilizador user = null;
        
        for (Utilizador u : this.m_listaUtilizadores) {
            if (u.hasID(strId)) {
                user = u;
            }
        }

        if (user != null) {
            for (Iterator<Exposicao> it = this.m_listaExposicoes.listIterator(); it.hasNext();) {
                Exposicao e = it.next();

                if (e.hasFAE(user)) {
                    leFAE.add(e);
                }
            }
        }
        return leFAE;
    }
    
    public Exposicao[] getArray() {
        return m_listaExposicoes.toArray( new Exposicao[m_listaExposicoes.size()] );
     }
     
    public void ordenarPorPosicao(){
        Collections.sort(m_listaExposicoes);
    }
    
     public int countExposicoes(){
        return m_listaExposicoes.size();
    }
    
     /**
     * Metodo que retorna uma exposicao atraves do titulo passado por parametro
     * @param titulo titulo
     * @return uma exposicao atraves do titulo passado por parametro
     */
    public Exposicao getExposicao(String titulo){
        for(Exposicao e : m_listaExposicoes){
            if(e.getTitulo().equalsIgnoreCase(titulo)){
                return e;
            }
        }
        return null;
    }

    
    /**
     * Metodo que retorna a exposicao passada por parametro
     * @param e2 exposicao
     * @return a exposicao passada por parametro
     */
    public Exposicao getExposicao(Exposicao e2) {
        for (Exposicao e1 : m_listaExposicoes) {
            if (e1.getTitulo().equalsIgnoreCase(e2.getTitulo())) {
                return e2;
            }
        }
        return null;
    }
    /**
     * Metodo que retorna a lista de exposicoes do FAE com o id passado por parametro
     * @param id id 
     * @return lista de exposicoes do FAE com o id passado por parametro
     */
    public RegistoExposicoes getExposicoesDoFAE(Utilizador u) {
        RegistoExposicoes l_ExpDoFAE = new RegistoExposicoes();

        for (Exposicao e : this.m_listaExposicoes) {
            if (e.getListaFAEs().getFAE(u.getID()) != null) {
                l_ExpDoFAE.adicionarExposicao(e);
            }

        }
        return l_ExpDoFAE;
    }
    
    
    
    /**
     * Retorna lista de exposicoes do organizador com o id passado por parametro
     * @param strId id 
     * @return lista de exposicoes do organizador com o id passado por parametro
     */
    public RegistoExposicoes getExposicoesOrganizador(Utilizador u) {
        RegistoExposicoes leOrganizador=new RegistoExposicoes();
        
        if (u != null) {
            for (Iterator<Exposicao> it = m_listaExposicoes.listIterator(); it.hasNext();) {
                Exposicao e = it.next();

                if (e.getListaOrganizadores().hasUtilizador(u)) {
                    leOrganizador.adicionarExposicao(e);
                }
            }
        }
        return leOrganizador;
    } 

}
