package lapr.project.model.lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.Exposicao;
import lapr.project.model.Utilizador;
import lapr.project.model.states.exposicao.*;

/**
 *
 * @author Pedro Fernandes, Diana Silva
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RegistoExposicoes implements Serializable{

    private ArrayList<Exposicao> listaExposicoes;

    public RegistoExposicoes() {
        listaExposicoes = new ArrayList<>();
    }

    public Exposicao novaExposicao() throws Exception {

        return new Exposicao();
    }

    /**
     * Metodo que regista uma exposicao
     *
     * @param expo exposicao public boolean adicionarExposicao(Exposicao expo) {
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

    public Exposicao[] getArray() {
        return listaExposicoes.toArray(new Exposicao[listaExposicoes.size()]);
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

    /**
     * Metodo que retorna a lista de exposicoes do FAE com o utilizador passado
     * por parametro
     *
     * @param u utilizador que contém papel de FAE
     * @return lista de exposicoes do FAE com o id passado por parametro
     */
    public RegistoExposicoes getExposicoesDoFAE(Utilizador u) {
        RegistoExposicoes listaExpDoFAE = new RegistoExposicoes();

        for (Exposicao e : this.listaExposicoes) {
            if (e.hasFAE(u)) {
                listaExpDoFAE.adicionarExposicao(e);
            }

        }
        return listaExpDoFAE;
    }

    /**
     * Retorna lista de exposicoes do organizador com o utilizador passado por
     * parametro
     *
     * @param u que contém papel de organizador
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
            if (exposicao.getTitulo().equals(e.getTitulo())) {
                return true;
            }
        }
        return false;
    }

    public boolean temFuncaoOrganizador(Utilizador utilizador) {
        for (Exposicao e : listaExposicoes) {
            if (e.hasOrganizador(utilizador)) {
                return false;
            }

        }
        return false;
    }

    public boolean temFuncaoFAE(Utilizador utilizador) {
        for (Exposicao e : listaExposicoes) {
            if (e.hasFAE(utilizador)) {
                return false;
            }
        }
        return false;
    }

    public RegistoExposicoes getExposicoesEstadoCriada() {
        RegistoExposicoes regExposicoes = new RegistoExposicoes();
        for (Exposicao e : listaExposicoes) {
            if (e.getEstadoAtualExposicao() instanceof ExposicaoCriada) {
                regExposicoes.adicionarExposicao(e);
            }
        }

        return regExposicoes;
    }

    public RegistoExposicoes getExposicoesFAESemDemonstracao() {
        RegistoExposicoes regExposicoes = new RegistoExposicoes();
        for (Exposicao e : listaExposicoes) {
            if (e.getEstadoAtualExposicao() instanceof ExposicaoFAESemDemonstracao) {
                regExposicoes.adicionarExposicao(e);
            }
        }

        return regExposicoes;
    }

    public RegistoExposicoes getExposicoesDemonstracaoSemFae() {
        RegistoExposicoes regExposicoes = new RegistoExposicoes();
        for (Exposicao e : listaExposicoes) {
            if (e.getEstadoAtualExposicao() instanceof ExposicaoDemonstracaoSemFAE) {
                regExposicoes.adicionarExposicao(e);
            }
        }

        return regExposicoes;
    }

    public RegistoExposicoes getExposicoesCandidaturasAbertas() {

        RegistoExposicoes expoCandAbertas = new RegistoExposicoes();
        for (Exposicao e : listaExposicoes) {
            if (e.getEstadoAtualExposicao() instanceof ExposicaoCandidaturasAberta) {
                expoCandAbertas.adicionarExposicao(e);
            }
        }

        return expoCandAbertas;
    }

    public RegistoExposicoes getExposicoesConflitosDetetados() {

        RegistoExposicoes regExpo = new RegistoExposicoes();
        for (Exposicao e : listaExposicoes) {
            if (e.getEstadoAtualExposicao() instanceof ExposicaoConflitosDetetados) {
                regExpo.adicionarExposicao(e);
            }
        }
        return regExpo;
    }

    public RegistoExposicoes getExposicoesConflitosAlterados() {

        RegistoExposicoes regExpo = new RegistoExposicoes();
        for (Exposicao e : listaExposicoes) {
            if (e.getEstadoAtualExposicao() instanceof ExposicaoConflitosAlterados) {
                regExpo.adicionarExposicao(e);
            }
        }
        return regExpo;
    }
    
    public RegistoExposicoes getExposicoesCandidaturasEmAtribuicao() {

        RegistoExposicoes regExpo = new RegistoExposicoes();
        for (Exposicao e : listaExposicoes) {
            if (e.getEstadoAtualExposicao() instanceof ExposicaoCandidaturasEmAtribuicao) {
                regExpo.adicionarExposicao(e);
            }
        }
        return regExpo;
    }

    public RegistoExposicoes getExposicoesCandidaturasAtribuidas() {

        RegistoExposicoes regExpo = new RegistoExposicoes();
        for (Exposicao e : listaExposicoes) {
            if (e.getEstadoAtualExposicao() instanceof ExposicaoCandidaturasAtribuidas) {
                regExpo.adicionarExposicao(e);
            }
        }
        return regExpo;
    }

    public RegistoExposicoes getExposicoesCandidaturasDecididas() {

        RegistoExposicoes regExpo = new RegistoExposicoes();
        for (Exposicao e : listaExposicoes) {
            if (e.getEstadoAtualExposicao() instanceof ExposicaoCandidaturasDecididas) {
                regExpo.adicionarExposicao(e);
            }
        }
        return regExpo;
    }

    public RegistoExposicoes getExposicoesStandsAtribuidos() {

        RegistoExposicoes regExpo = new RegistoExposicoes();
        for (Exposicao e : listaExposicoes) {
            if (e.getEstadoAtualExposicao() instanceof ExposicaoStandsAtribuidos) {
                regExpo.adicionarExposicao(e);
            }
        }
        return regExpo;
    }

    public boolean valida(Exposicao e) {
        if (e.validaMinOrganizadores() && e.validaDataFimSuperiorInicio() && e.validaSeguimentoDatas() && !hasExposicao(e)) {
            return true;
        } else {
            return false;
        }
    }

}
