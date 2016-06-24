package lapr.project.model;

import java.io.Serializable;
import java.text.ParseException;
import lapr.project.model.states.*;
import lapr.project.model.states.ExposicaoEstado;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.ListaCandidaturas;
import java.util.*;
import lapr.project.model.lists.ListaAtribuicoes;
import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.utils.Data;
import lapr.project.utils.Utils;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author Pedro Fernandes e Diana
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Exposicao implements Comparable<Exposicao>, Serializable {

    private String titulo;
    private String textoDescritivo;
    private Data dataInicio;
    private Data dataFim;
    private String local;
    private Data dataInicioSubmissao;
    private Data dataFimSubmissao;
    private Data dataInicioAvaliacao;
    private Data dataFimAvaliacao;
    private Data dataAlteracaoConflitos;
    private Data dataInicioStands;
    private Data dataFimStands;
    private Data dataDeteccaoConflitos;

    private ListaCandidaturas listaCandidaturas;
    private ListaFAE listaFaes;
    private ListaOrganizadores listaOrganizadores;
    private ListaDemonstracoes listaDemonstracoes;
    private ListaAtribuicoes listaAtribuicoes;
    @XmlTransient
    private ExposicaoEstado estado;
//    private TimerTask task1, task2, task3, task4, task5, task6, task7;

    public Exposicao() throws Exception {
        estado = new ExposicaoEstadoInicial(this);
        listaOrganizadores = new ListaOrganizadores();
        listaCandidaturas = new ListaCandidaturas();
        listaDemonstracoes = new ListaDemonstracoes();
        listaFaes = new ListaFAE();
        listaAtribuicoes = new ListaAtribuicoes();
    }

    public ListaDemonstracoes getListaDemonstracoes() {
        return listaDemonstracoes;
    }

    public ListaFAE getListaFAE() {
        return listaFaes;
    }

    public ListaOrganizadores getListaOrganizadores() {
        return listaOrganizadores;
    }

    public ListaCandidaturas getListaCandidaturas() {
        return listaCandidaturas;
    }

    public ListaAtribuicoes getListaAtribuicoes() {
        return listaAtribuicoes;
    }

    public void setDadosPrincipais(String titulo, String descricao, Data dataInicio, Data dataFim, String local, Data dataSubInicio, Data dataSubFim) {
        this.titulo = titulo;
        textoDescritivo = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.local = local;
        dataInicioSubmissao = dataSubInicio;
        dataFimSubmissao = dataSubFim;
        
    }
    
    public void setDadosData(Data dataAvInicio, Data dataAvFim, Data dConflitos, Data dataInicioStands, Data dataFimStand, Data dAConflitos){
        dataInicioAvaliacao = dataAvInicio;
        dataFimAvaliacao = dataAvFim;
        dataDeteccaoConflitos = dConflitos;
        this.setDataInicioStands(dataInicioStands);
        this.setDataFimStands(dataFimStand);
        dataAlteracaoConflitos = dAConflitos;
    }

    public void setTitulo(String strTitulo) {
        titulo = strTitulo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTextoDescritivo(String strDescritivo) {
        textoDescritivo = strDescritivo;
    }

    public String getTextoDescritivo() {
        return textoDescritivo;
    }

    public void setLocal(String strLocal) {
        local = strLocal;
    }
    
    public void setListaAtribuicoes(ListaAtribuicoes lista){
        listaAtribuicoes=lista;
    }

    public String getLocal() {
        return local;
    }

    public Data getDataInicio() {
        return dataInicio;
    }

    public Data getDataFim() {
        return dataFim;
    }

    public Data getDataInicioSubmissao() {
        return dataInicioSubmissao;
    }

    public Data getDataFimSubmissao() {
        return dataFimSubmissao;
    }

    public Data getDataInicioAtribuicao() {
        return dataInicioAvaliacao;
    }

    public Data getDataFimAtribuicao() {
        return dataFimAvaliacao;
    }

    public Data getDataAlteracaConflitos() {
        return dataAlteracaoConflitos;
    }

    public Data getDataInicioStands() {
        return dataInicioStands;
    }

    public Data getDataFimStands() {
        return dataFimStands;
    }

    public Data getDateAlteracaoConflitos() {
        return dataDeteccaoConflitos;
    }

    /**
     * Obtem o estado da exposicao
     *
     * @return the state
     */
    public ExposicaoEstado getState() {
        return estado;
    }

    public ExposicaoEstado getEstadoAtualExposicao() {
        return estado;
    }

    public void setDataInicioSubmissao(Data strDataInicioSubmissao) {
        this.dataInicioSubmissao = strDataInicioSubmissao;
    }

    public void setDataFimSubmissao(Data strDataFimSubmissao) {
        this.dataFimSubmissao = strDataFimSubmissao;
    }

    public void setDataInicioAtribuicao(Data strDataInicioAtribuicao) {
        this.dataInicioAvaliacao = strDataInicioAtribuicao;
    }

    public void setDataFimAtribuicao(Data strDataFimAtribuicao) {
        this.dataFimAvaliacao = strDataFimAtribuicao;
    }

    public void setDataFim(Data strDataFim) {
        this.dataFim = strDataFim;
    }

    public void setDataInicio(Data strDataInicio) {
        this.dataInicio = strDataInicio;
    }

    public void setDataAlteracaoConflito(Data strDataAlteracaoConflito) {
       
        this.dataAlteracaoConflitos=strDataAlteracaoConflito;
    }
      public void setDataInicoStands(Data strDataInicioStands) {
       
          this.setDataInicioStands(strDataInicioStands);
    }
       public void setDataFimStands(Data strDataFimStands) {
       
        this.dataFimStands=strDataFimStands;
    }

//    public void createTimers() throws ParseException {

//        Timer timer = new Timer();
//
//        task1 = new ExposicaoCandidaturasAbertas(this);
//        timer.schedule(task1, dataInicioSubmissao.converterParaDate());
//
//        task2 = new ExposicaoCandidaturasFechadas(this);
//        timer.schedule(task2, dataFimSubmissao.converterParaDate());
//
//        task3 = new DetetarConflitosController(this);
//        timer.schedule(task3, dataDeteccaoConflitos.converterParaDate());
//
//        task4 = new ExposicaoConflitosAlterados(this);
//        timer.schedule(task4, dataAlteracaoConflitos.converterParaDate());
//
//        task5 = new ExposicaoCandidaturasEmAvaliacao(this);
//        timer.schedule(task5, dataInicioAvaliacao.converterParaDate());
//
//        task6 = new ExposicaoStandsAtribuiveis(this);
//        timer.schedule(task6, dataInicioStands.converterParaDate());
//    }

    
    
    
    /**
     * Verifica se a exposicao é igual a um objeto passado por parâmetro
     *
     * @param o O objeto que vai ser comparado com a exposicao.
     * @return True se forem iguais, false se não forem.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Exposicao outraEX = (Exposicao) o;
        return this.getTextoDescritivo().equals(outraEX.getTextoDescritivo()) && this.getTitulo().equals(outraEX.getTitulo());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.titulo);
        hash = 29 * hash + Objects.hashCode(this.textoDescritivo);
        return hash;
    }
    
   

//    /**
//     * Modifica a lista de submissoes.
//     *
//     * @param listaSubmissoes the listaSubmissoes to set
//     */
//    public void setListaSubmissoes(ListaSubmissoes listaSubmissoes) {
//        this.listaSubmissoes = listaSubmissoes;
//    }
    public void setListaOrganizadores(ListaOrganizadores lstOrganizadores) {
        listaOrganizadores = lstOrganizadores;
    }

    /**
     * Altera o estado para o estado recebido por parametro.
     *
     * @param estado estado para o qual a exposição se altera
     * @return boolean se alterou ou não
     */
    public boolean alterarEstado(ExposicaoEstado estado) {
        this.estado = estado;
        return true;
    }
    
    public void setCriada() throws ParseException{
        ExposicaoEstadoInicial state=(ExposicaoEstadoInicial) estado;
        state.setCriada();
    }

    public void setListaFaes(ListaFAE lstFaes) {
        listaFaes = lstFaes;
    }

    public boolean hasOrganizador(Utilizador u) {
        for (Organizador o : listaOrganizadores.getListaOrganizadores()) {
            if (o.getUtilizador().getEmail().equals(u.getEmail())) {
                return true;
            }
        }
        return false;
    }

    private boolean validaDemonstracao(Demonstracao d) {
        System.out.println("Exposição: validaDemonstracao: " + d.toString());
        return true;
    }

    public void addDemonstracao(Demonstracao d) {
        if (validaDemonstracao(d)) {
            addDemonstracao(d);
        }
    }

    public boolean hasFAE(Utilizador u) {
        for (FAE fae : listaFaes.getListaFAE()) {
            if (fae.getEmail().equals(u.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public boolean validaDefinirFAE(FAE f) {
        return f.validaMenbroFAE();
    }

    @Override
    public int compareTo(Exposicao outraExposicao) {
        return titulo.compareTo(outraExposicao.titulo);
    }

    public boolean valida() {
        return validaTitulo() == true && validaTextoDescritivo() == true && validaLocal() == true;
    }

    public boolean validaTitulo() {
        return !(titulo == null || titulo.matches(".*\\d+.*"));
    }

    public boolean validaTextoDescritivo() {
        return textoDescritivo != null;
    }

    public boolean validaLocal() {
        return local != null;
    }

    public boolean validaDatas1(String datai, String dataf, String datasub, String datafsub, String dataconflitos, String dataaltconflitos) {
        boolean b1 = Utils.validaDatasString(datai);
        boolean b2 = Utils.validaDatasString(dataf);
        boolean b3 = Utils.validaDatasString(datasub);
        boolean b4 = Utils.validaDatasString(datafsub);
        boolean b5 = Utils.validaDatasString(dataconflitos);
        boolean b6 = Utils.validaDatasString(dataaltconflitos);

        return b1 == true && b2 == true && b3 == true && b4 == true && b5 == true && b6 == true;
    }
    
       public boolean validaDatas2(String dataavcand, String datafavcand, String dataistand, String datafstand) {
  
        boolean b7 = Utils.validaDatasString(dataavcand);
        boolean b8 = Utils.validaDatasString(datafavcand);
        boolean b9 = Utils.validaDatasString(dataistand);
        boolean b10 = Utils.validaDatasString(datafstand);

        return  b7 == true && b8 == true && b9 == true && b10 == true;
    }
    

    public boolean validaMinOrganizadores() {
        return listaOrganizadores.getListaOrganizadores().size() >= 2;
    }

    public boolean validaDataFimSuperiorInicio() {
        return dataFim.isMaior(dataInicio) && dataFimAvaliacao.isMaior(dataInicioAvaliacao) && dataFimStands.isMaior(dataInicioStands)
                && dataFimSubmissao.isMaior(dataInicioSubmissao);
    }

    public boolean validaSeguimentoDatas() {
        return dataInicio.isMaior(dataFimStands) || dataFimStands.isMaior(dataFimAvaliacao) && dataFimAvaliacao.isMaior(dataAlteracaoConflitos)
                && dataAlteracaoConflitos.isMaior(dataDeteccaoConflitos) && dataDeteccaoConflitos.isMaior(dataFimSubmissao);
    }

    @Override
    public String toString() {
        return titulo;
    }

    public String toStringCompleto() {
        String str = "Exposição:\n";
        str += "\tTitulo: " + this.titulo + "\n";
        str += "\tTexto descritivo: " + this.textoDescritivo + "\n";
        str += "\tData inicial: " + this.dataInicio + "\n";
        str += "\tData final: " + this.dataFim + "\n";
        str += "\tData inicial de submissão: " + this.dataInicioSubmissao + "\n";
        str += "\tData final de submissão: " + this.dataFimSubmissao + "\n";
        str += "\tData inicial de atribuição: " + this.dataInicioAvaliacao + "\n";
        str += "\tData final de atribuição: " + this.dataFimAvaliacao + "\n";
        str += "\tData final de avaliações: " + this.dataInicioAvaliacao + "\n";
        str += "\tData para a deteção de conflitos: " + this.dataDeteccaoConflitos + "\n";
        str += "\tData alteração de conflitos: " + this.dataAlteracaoConflitos + "\n";
        str += "\tLocal: " + this.local + "\n";
        str += "\tOrganizadores:\n";
        for (Organizador o : listaOrganizadores.getListaOrganizadores()) {
            str += "\t\t" + o.getUtilizador().toString() + "\n";
        }

        return str;
    }

    /**
     * @param dataInicioStands the dataInicioStands to set
     */
    public void setDataInicioStands(Data dataInicioStands) {
        this.dataInicioStands = dataInicioStands;
    }
}
