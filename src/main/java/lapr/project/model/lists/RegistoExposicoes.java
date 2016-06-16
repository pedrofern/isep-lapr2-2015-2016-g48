package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import lapr.project.model.Exposicao;
import lapr.project.model.Organizador;
import lapr.project.model.Utilizador;

/**
 *
 * @author Pedro Fernandes
 */
public class RegistoExposicoes {

    private List<Exposicao> listaExposicoes;
    private List<Utilizador> listaUtilizadores;

    public RegistoExposicoes() {
        listaExposicoes = new ArrayList<Exposicao>();
        listaUtilizadores = new ArrayList<Utilizador>();
    }

    public Exposicao novaExposicao() {

        return new Exposicao();
    }

    /**
     * Metodo que regista uma exposicao
     *
     * @param e exposicao public boolean adicionarExposicao(Exposicao expo) {
     * @return true se resgistar false em caso contrario
     */
    public boolean adicionarExposicao(Exposicao expo) {

        if (hasExposicao(expo)) {
            return false;
        } else {
            return listaExposicoes.add(expo);
        }
    }

    public boolean registaExposicao(Exposicao e) {
        if (e.valida() && valida(e)) {
            return adicionarExposicao(e);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "RegistoExposicoes:" + "listaExposicoes=" + listaExposicoes;
    }

    public List<Exposicao> getExposicoes() {
        return listaExposicoes;
    }

    public List<Exposicao> getExposicaoOrganizador(String strId) {
        List<Exposicao> leOrganizador = new ArrayList<Exposicao>();

        Utilizador user = null;

        for (Utilizador u : this.listaUtilizadores) {
            if (u.hasID(strId)) {
                user = u;
            }
        }

        if (user != null) {
            for (Iterator<Exposicao> it = this.listaExposicoes.listIterator(); it.hasNext();) {
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

        for (Utilizador u : this.listaUtilizadores) {
            if (u.hasID(strId)) {
                user = u;
            }
        }

        if (user != null) {
            for (Iterator<Exposicao> it = this.listaExposicoes.listIterator(); it.hasNext();) {
                Exposicao e = it.next();

                if (e.hasFAE(user)) {
                    leFAE.add(e);
                }
            }
        }
        return leFAE;
    }

    public Exposicao[] getArray() {
        return listaExposicoes.toArray(new Exposicao[listaExposicoes.size()]);
    }

    public void ordenarPorPosicao() {
        Collections.sort(listaExposicoes);
    }

    public int countExposicoes() {
        return listaExposicoes.size();
    }

    /**
     * Metodo que retorna uma exposicao atraves do titulo passado por parametro
     *
     * @param titulo titulo
     * @return uma exposicao atraves do titulo passado por parametro
     */
    public Exposicao getExposicao(String titulo) {
        for (Exposicao e : listaExposicoes) {
            if (e.getTitulo().equalsIgnoreCase(titulo)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Metodo que retorna a exposicao passada por parametro
     *
     * @param e2 exposicao
     * @return a exposicao passada por parametro
     */
    public Exposicao getExposicao(Exposicao e2) {
        for (Exposicao e1 : listaExposicoes) {
            if (e1.getTitulo().equalsIgnoreCase(e2.getTitulo())) {
                return e2;
            }
        }
        return null;
    }
//    /**
//     * Metodo que retorna a lista de exposicoes do FAE com o id passado por parametro
//     * @param id id 
//     * @return lista de exposicoes do FAE com o id passado por parametro
//     */
//    public RegistoExposicoes getExposicoesDoFAE(Utilizador u) {
//        RegistoExposicoes l_ExpDoFAE = new RegistoExposicoes();
//
//        for (Exposicao e : this.listaExposicoes) {
//            if (e.getListaFAEs().getFAE(u.getID()) != null) {
//                l_ExpDoFAE.adicionarExposicao(e);
//            }
//
//        }
//        return l_ExpDoFAE;
//    }

    /**
     * Retorna lista de exposicoes do organizador com o id passado por parametro
     *
     * @param strId id
     * @return lista de exposicoes do organizador com o id passado por parametro
     */
    public RegistoExposicoes getExposicoesOrganizador(Utilizador u) {
        RegistoExposicoes leOrganizador = new RegistoExposicoes();

        if (u != null) {
            for (Iterator<Exposicao> it = listaExposicoes.listIterator(); it.hasNext();) {
                Exposicao e = it.next();

                if (e.getListaOrganizadores().hasUtilizador(u)) {
                    leOrganizador.adicionarExposicao(e);
                }
            }
        }
        return leOrganizador;
    }

    public boolean hasExposicao(Exposicao e) {
        for (Exposicao exposicao : listaExposicoes) {
            if (exposicao.equals(e)) {
                return true;
            }
        }
        return false;
    }


    public boolean valida(Exposicao e) {
        if (e.validaMinOrganizadores() && e.validaDataFimSuperiorInicio() && e.validaSeguimentoDatas() && !hasExposicao(e)) {
            return true;
        } else {
            return false;
        }
    }

}
