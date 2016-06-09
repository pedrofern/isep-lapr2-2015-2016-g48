package lapr.project.model.lists;

import java.util.ArrayList;
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

//    public Exposicao novaExposicao() {
//        return new Exposicao();
//    }

    public boolean registaExposicao(Exposicao e) {
        if (e.valida() && validaExposicao(e)) {
            return addExposicao(e);
        } else {
            return false;
        }
    }

    private boolean addExposicao(Exposicao e) {
        return m_listaExposicoes.add(e);
    }

    public boolean validaExposicao(Exposicao e) {
        System.out.println("RegistoExposicoes: validaExposicao:" + e.toString());
        return true;
    }

    @Override
    public String toString() {
        return "RegistoExposicoes:" + "m_listaExposicoes=" + m_listaExposicoes;
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
     
    
    
}
