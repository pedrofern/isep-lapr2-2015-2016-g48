package lapr.project.model;

import lapr.project.model.lists.RegistoRecursos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List.*;
import lapr.project.model.lists.*;
import lapr.project.utils.Data;

/**
 *
 * @author Pedro Fernandes
 */
public class Demonstracao implements Serializable {

    private CentroExposicoes m_centroExposicoes;
    private RegistoRecursos m_listaRecursos;
    private ListaCandidaturasDemonstracoes listaCandidaturasDemonstracoes;
    private String desc;
    private String temaexposicao;
    private Data inicio, fim;
    private RegistoRecursos registorecurso;
    private ListaRecursoDemonstracao listarecursodemonstracao;
    private Demonstracao demonstracao;
    /**
     * Metodo que constroi objetos demonstração
     *
     * @param cod codigo
     * @param desc descrição
     * @param listaRecursos lista de recursos
     * @param m_centroExposicoes centro de exposições
     */

    private static String codigoUnico = "Demo-";
    private static int totalDemonstracao = 0;

    public Demonstracao() {
        codigoUnico = codigoUnico + totalDemonstracao++;
        this.m_listaRecursos = new RegistoRecursos();
        listaCandidaturasDemonstracoes = new ListaCandidaturasDemonstracoes();
        listarecursodemonstracao = new ListaRecursoDemonstracao();
    }

    public void setDados(String desc, String temaexposicao, Data inicio, Data fim) {
        setDesc(desc);
        this.temaexposicao = temaexposicao;
        this.inicio = inicio;
        this.fim = fim;
    }

    public void setDados(String desc, String temaexposicao) {
        setDesc(desc);
        this.temaexposicao = temaexposicao;
        this.inicio = new Data();
        this.fim = new Data();
    }

    /**
     * Metodo que retorna a lista de recursos
     *
     * @return lista de recursos
     */
    public RegistoRecursos getListaRecursos() {
        return m_listaRecursos;
    }

    public ListaRecursoDemonstracao getListaRecursosDemonstracao() {
        return listarecursodemonstracao;
    }

    /**
     * Metodo que retorna a lista de recursos
     *
     * @return lista de recursos
     */
    public ListaCandidaturasDemonstracoes getListaCandidaturasDemonstracao() {
        return listaCandidaturasDemonstracoes;
    }

    public void addRecursoDemonstracao(Recurso recurso) {
        listarecursodemonstracao.addRecursoDemonstracao(recurso);
    }
//    /**
//     * Metodo que modifica o codigo
//     *
//     * @param cod codigo
//     */
//    public void setCod(int cod) {
//        this.cod = cod;
//    }

    /**
     * Metodo que modifica a descricao
     *
     * @param desc descricao
     */
    public final void setDesc(String desc) {

        if (validaDescricao(desc)) {
            this.desc = desc;
        }

    }

    public static String getCondigoUnico() {

        return codigoUnico;
    }

    public boolean validaDescricao(String descricao) {

        if (descricao == null || descricao.trim().isEmpty()) {
            return false;
        } else {

            return true;
        }
    }

    /**
     * Metodo que modifica o recurso
     *
     * @param r recurso
     * @return recurso
     */
    public Recurso setRecurso(Recurso r) {
        if (getListaRecursos().contem(r)) {
            return r;
        } else {
            return null;
        }
    }

    public CandidaturaDemonstracao setCandidaturaDemonstracao(CandidaturaDemonstracao cd) {
        if (getListaCandidaturasDemonstracao().getListaCandidaturasDemonstracao().contains(cd)) {
            return cd;
        } else {
            return null;
        }
    }

    /**
     * Metodo que modifica e adiciona o recurso a lista
     *
     * @param recurso recurso
     * @return true se adicionou a lista false em caso contrario
     */
//    public boolean setRecurso(String recurso) {
//        
//        Recurso r = this.m_centroExposicoes.getRegistoRecursos().indiceDeRecurso(recurso);
//        
//        if (r != null && validaRecurso(r)) {
//            m_listaRecursos.adicionarRecurso(r);
//            
//            return true;
//        } else {
//            return false;
//        }
//
//    }
    /**
     * metodo que valida o recurso r
     *
     * @param r recurso
     * @return true se valida false caso contrario
     */
    public boolean validaRecurso(Recurso r) {
        if (!m_listaRecursos.contem(r)) {
            //validar
            return true;
        } else {
            return false;
        }
    }

//    /**
//     * Metodo que retorna o codigo
//     *
//     * @return o codigo
//     */
//    public int getCod() {
//        return cod;
//    }
    /**
     * Metodo que retorna a descrição
     *
     * @return descrição
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Metodo que adiciona o recurso a lista
     *
     * @param r recurso
     * @return true caso adicone false em caso contrario
     */
    public boolean addRecurso(Recurso r) {
        return m_listaRecursos.addRecurso(r);
    }

    /**
     * Metodo que regista o recurso
     *
     * @param r recurso
     * @return true caso adicione false em caso contrario
     */
    public boolean registaRecurso(Recurso r) {
        if (!validaRecurso(r)) {
            return false;
        }
        return addRecurso(r);
    }

    /**
     * Metodo que faz representação grafica do objeto demonstração
     *
     * @return representação grafica do objeto demonstração
     */
    @Override
    public String toString() {
        return String.format("%s\n %s", desc, codigoUnico);
    }

    public String toStringCompleto() {
        String str = "\n";
        str += "\tDescrição: " + this.desc + "\n";
        str += "\tCodigo Unico: " + codigoUnico + "\n";
        str += "\tTema da exposição: " + temaexposicao + "\n";
        str += "\tRecursos:\n";
        for (Recurso recurso : listarecursodemonstracao.getListaRecursoDemonstracao()) {
            str += "\t\t" + recurso.toString() + "\n";
        }

        return str;
    }

    public void setRecurso(RegistoRecursos registorecurso) {
        this.registorecurso = registorecurso;
    }

    public boolean valida() {

        if (validaDescricao(desc)) {
            return true;
        }

        return false;

    }
}
