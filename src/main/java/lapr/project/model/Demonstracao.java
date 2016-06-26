package lapr.project.model;

import lapr.project.model.lists.RegistoRecursos;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Timer;
import java.util.TimerTask;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.lists.*;
import lapr.project.model.states.demonstracao.*;
import lapr.project.utils.Data;
import lapr.project.utils.Utils;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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
    @XmlTransient
    private DemonstracaoEstado estado;
//    private TimerTask task1, task2;
    /**
     * Metodo que constroi objetos demonstração
     *
     * @param cod codigo
     * @param desc descrição
     * @param listaRecursos lista de recursos
     * @param m_centroExposicoes centro de exposições
     */

    private static final String codigoDesc = "Demo-";
    private static int contador = 0;

    public Demonstracao() throws Exception {
        estado = new DemonstracaoCriada();
        this.m_listaRecursos = new RegistoRecursos();
        this.listaCandidaturasDemonstracoes = new ListaCandidaturasDemonstracoes();
        this.listarecursodemonstracao = new ListaRecursoDemonstracao();
        contador++;
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
        this.listarecursodemonstracao.addRecursoDemonstracao(recurso);
    }

//    public void createTimers() throws ParseException {
//
//        Timer timer = new Timer();
//
//        task1 = new DemonstracaoEmAberto(this);
//        timer.schedule(task1, inicio.converterParaDate());
//
//        task2 = new DemonstracoesFechadas(this);
//        timer.schedule(task2, fim.converterParaDate());
//
//    }

    public DemonstracaoEstado getEstadoAtualDemonstracao() {
        return estado;
    }

    public void setEstadoDemonstracao(DemonstracaoEstado estado) {
        this.estado = estado;
    }

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
        return codigoDesc;
    }

    public void setPeriodoCandidaturas(Data inicio, Data fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public boolean validaDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validaDataFimSuperiorInicio() {
        return fim.isMaior(inicio);
    }

    public boolean validaDatas(String datai, String dataf) {
        boolean b1 = Utils.validaDatasString(datai);
        boolean b2 = Utils.validaDatasString(dataf);

        return b1 == true && b2 == true;
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
        return String.format("%s%n %s%d", desc, codigoDesc, contador);
    }

    public String toStringCompleto() {
        String str = "\n";
        str += "\tDescrição: " + this.desc + "\n";
        str += "\tCodigo Unico: " + codigoDesc + contador + "\n";
        str += "\tTema da exposição: " + temaexposicao + "\n";
        str += "\tRecursos:\n";
        for (Recurso recurso : listarecursodemonstracao.getListaRecursoDemonstracao()) {
            str += "\t\t" + recurso.toString() + "\n";
        }
        return str;
    }

    public void setRecursoDemonstracao(ListaRecursoDemonstracao listarecursodemonstracao) {
        this.listarecursodemonstracao = listarecursodemonstracao;
    }

    public boolean valida() {

        if (validaDescricao(desc)) {
            return true;
        }
        return false;
    }
}
