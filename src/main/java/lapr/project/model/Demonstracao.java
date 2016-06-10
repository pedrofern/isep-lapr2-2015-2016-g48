package lapr.project.model;

import lapr.project.model.lists.RegistoRecursos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List.*;
import lapr.project.utils.Data;

/**
 *
 * @author Pedro Fernandes
 */
public class Demonstracao implements Serializable {

    private CentroExposicoes m_centroExposicoes;
    private RegistoRecursos m_listaRecursos;
    private String desc;
    private String temaexposicao;
    private Data inicio, fim;
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
        this.desc = desc;
        this.m_listaRecursos = new RegistoRecursos();

    }

    public void setDados(String desc, String temaexposicao, Data inicio, Data fim) {
       this.desc=desc;
       this.temaexposicao=temaexposicao;
       this.inicio=inicio;
       this.fim=fim;
    }

    /**
     * Metodo que constroi objetos demonstração por omissão
     *
     * @param m_centroExposicoes centro de exposições
     */
    public Demonstracao(CentroExposicoes m_centroExposicoes) {
        m_listaRecursos = new RegistoRecursos();
        this.m_centroExposicoes = m_centroExposicoes;
    }

    /**
     * Metodo que retorna a lista de recursos
     *
     * @return lista de recursos
     */
    public RegistoRecursos getListaRecursos() {
        return m_listaRecursos;
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
    public void setDesc(String desc) {
        this.desc = desc;
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
        return m_listaRecursos.adicionarRecurso(r);
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
        return String.format("%s", desc);
    }
}
