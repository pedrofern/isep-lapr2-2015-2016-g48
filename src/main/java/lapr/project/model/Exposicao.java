package lapr.project.model;

import lapr.project.model.mechanisms.ProcessoAtribuicaoExposicao;
import lapr.project.model.mechanisms.Atribuivel;
import lapr.project.model.states.ExposicaoCriadaEstado;
import lapr.project.model.states.ExposicaoStateEmRevisao;
import lapr.project.model.states.ExposicaoEstado;
import lapr.project.model.mechanisms.ProcessoAtribuicao;
import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.model.lists.ListaSubmissoes;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.ListaCandidaturas;
import java.util.*;
import lapr.project.controller.DetetarConflitosController;
import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.states.AlterarCandAbertas;
import lapr.project.model.states.AlterarCandFechadas;
import lapr.project.utils.Data;

/**
 *
 * @author Pedro Fernandes e Diana 
 */
public class Exposicao implements Submissivel, Atribuivel ,Comparable<Exposicao> {

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
    
    private static ListaCandidaturas listaCandidaturas;
    private static ListaFAE listaFaes;
    private static ListaOrganizadores listaOrganizadores;
    private static ListaDemonstracoes listaDemonstracoes;
    
    private static ExposicaoEstado state;
    private static Timer timer;

    public Exposicao() {
        state = new ExposicaoCriadaEstado(this);
        listaOrganizadores = new ListaOrganizadores();
        listaCandidaturas = new ListaCandidaturas();
        listaDemonstracoes=new ListaDemonstracoes();
        listaFaes= new ListaFAE();
        timer = new Timer();
        
    }
    
    public ListaDemonstracoes getListaDemonstracoes(){
        return listaDemonstracoes;
    }
    
    public ListaFAE getListaFAEs() {
          return listaFaes;
    }
    
    public ListaOrganizadores getListaOrganizadores() {
          return listaOrganizadores;
    }
         
    public ListaCandidaturas getRegistoCandidaturas() {
        return listaCandidaturas;
    }
   
    public void setDados(String titulo, String descricao, Data dataInicio, Data dataFim, String local, Data dataSubInicio, Data dataSubFim, Data dataAvInicio, Data dataAvFim, Data dConflitos, Data dataInicioStands, Data dataFimStand, Data dAConflitos){
        this.titulo=titulo;
        textoDescritivo=descricao;
        this.dataInicio=dataInicio;
        this.dataFim=dataFim;
        this.local=local;
        dataInicioSubmissao=dataSubInicio;
        dataFimSubmissao=dataSubFim;
        dataInicioAvaliacao=dataAvInicio;
        dataFimAvaliacao=dataAvFim;
        dataDeteccaoConflitos=dConflitos;
        this.dataInicioStands=dataInicioStands;
        this.dataFimStands=dataFimStand;
        dataAlteracaoConflitos=dAConflitos;
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

    public String getLocal() {
        return local;
    }
    
    public Date getDataInicioSubmissao() throws Exception {
        return Data.converterParaDate(dataInicioSubmissao);
    }
    
    public Date getDataFimSubmissao() throws Exception {
        return Data.converterParaDate(dataFimSubmissao);
    }

    public Date getDataInicioAtribuicao() throws Exception {
        return Data.converterParaDate(dataInicioAvaliacao); 
    }
    
     public Date getDataFimAtribuicao() throws Exception {
        return Data.converterParaDate(dataFimAvaliacao); 
    }
    
    public Date getDataInicio() throws Exception {
        return Data.converterParaDate(dataInicio);
    }
    
    public Date getDataFim() throws Exception {
        return Data.converterParaDate(dataFim);
    }
    
    public Date getDataAlteracaConflitos() throws Exception {
        return Data.converterParaDate(dataAlteracaoConflitos);
    }
    
    public Date getDataInicioStands() throws Exception{
        return Data.converterParaDate(dataInicioStands);
    }
    
    public Date getDataFimStands() throws Exception {
        return Data.converterParaDate(dataFimStands);
    }
    
    public Date getDataAlteracaoConflitos() throws Exception{   
        return Data.converterParaDate(dataDeteccaoConflitos);
    }
 
        
    public void createTimers() throws Exception {
//        AlterarCandAbertas task1 = new AlterarCandAbertas(this);
//        
//        schedule(task1, getDataInicioSubmissao());
//        
//        
//        AlterarCandFechadas task2=new AlterarCandFechadas(this);
//        
//        
//
//        AlterarStateParaEmAtribuicao task2 = new AlterarStateParaEmAtribuicao(this);
//        schedule(task2, this.getDataInicioAtribuicao());
//
//        DetetarConflitosController task3 = new DetetarConflitosController(ce, this);
//        schedule(task3, this.getDataFimSubmissao());
    }

    

    /**
     * Obtem o estado da exposicao
     *
     * @return the state
     */
    public ExposicaoEstado getState() {
        return state;
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

    public void setDataFim(Data strDataFim) {
        this.dataFim = strDataFim;
    }
    public void setDataInicio(Data strDataInicio) {
        this.dataInicio = strDataInicio;
    }

//   
//
//    /**
//     * Retorna uma nova instância de processo de atribuição.
//     *
//     * @return uma nova instância de processo de atribuição.
//     */
//    @Override
//    public ProcessoAtribuicao novaAtribuicao() {
//        return new ProcessoAtribuicaoExposicao();
//    }
//
//    /**
//     * Define o processo de atribuição e altera o estado para Exposicao em
// Revisão.
//     *
//     * @param pa O processo de atribuição que vai ser definido para a exposicao.
//     */
//    @Override
//    public void setProcessoAtribuicao(ProcessoAtribuicao pa) {
//        save(pa);
//        if (this.getState().setStateEmRevisao()) {
//            setState(new ExposicaoStateEmRevisao(this));
//        }
//
//    }
//    
//    public void setDataLimiteAlterarConflitos(Exposicao d_conflitos){
//        this.d_conflitos=d_conflitos;
//    }
//
//    @Override
//    public ProcessoAtribuicao getProcessoAtribuicao() {
//        return processoAtribuicao;
//    }
//
//    /**
//     * Define o processo de atribuição.
//     *
//     * @param pa O processo de atribuição que vai ser definido para a exposicao.
//     */
//    public void save(ProcessoAtribuicao pa) {
//        this.processoAtribuicao = pa;
//    }

    /**
     * Verifica se a exposicao é igual a um objeto passado por parâmetro
     *
     * @param o O objeto que vai ser comparado com a exposicao.
     * @return True se forem iguais, false se não forem.
     */
 
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
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
        this.listaOrganizadores = lstOrganizadores;
    }

    /**
     * Altera o estado para o estado recebido por parametro.
     *
     * @param state
     * @return boolean se alterou ou não
     */
    public boolean setState(String state) {
//        if (state.equals("ExposicaoFAEDefinidoState")) {
//            return setState(new ExposicaoFAEDefinidoState(this));
//        }
//        if (state.equals("ExposicaoStateCriada")) {
//            return setState(new ExposicaoCriadaEstado(this));
//        }
//        if (state.equals("ExposicaoStateEmDecidida")) {
//            return setState(new ExposicaoStateEmDecidida(this));
//        }
//        if (state.equals("ExposicaoStateEmDecisao")) {
//            return setState(new ExposicaoStateEmDecisao(this));
//        }
//        if (state.equals("ExposicaoStateEmDetecaoConflitos")) {
//            return setState(new ExposicaoStateEmDetecaoConflitos(this));
//        }
//        if (state.equals("ExposicaoStateEmAtribuicao")) {
//            return setState(new ExposicaoStateEmAtribuicao(this));
//        }
//        if (state.equals("ExposicaoStateEmRevisao")) {
//            return setState(new ExposicaoStateEmRevisao(this));
//        }
//        if (state.equals("ExposicaoStateEmSubmissao")) {
//            return setState(new ExposicaoEmSubmissaoEstado(this));
//        }
//        if (state.equals("ExposicaoStateRegistada")) {
//            return setState(new ExposicaoRegistadaEstado(this));
//        }
        return false;
    }

    public void setListaFaes(ListaFAE lstFaes) {
        this.listaFaes = lstFaes;
    }

    public boolean valida() {
         if (validaTitulo() == true && validaTextoDescritivo() == true && validaLocal() == true) {
            return true;
        }
        return false;
    }

    public boolean validaTitulo() {
        if (titulo == null || titulo.matches(".*\\d+.*")) {
            return false;
        }
        return true;
    }

    public boolean validaTextoDescritivo() {
        if (textoDescritivo == null) {
            return false;
        }
        return true;
    }

    public boolean validaLocal() {
        if (local == null) {
            return false;
        }
        return true;
    }


    public boolean validaMinOrganizadores(List<Organizador> listaOrg) {
        if (listaOrg.size() >= 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasOrganizador(Utilizador u) {
        for (Organizador o : listaOrganizadores.getListaOrganizadores()) {

            if (o.equals(u)) {
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
        for (Iterator<FAE> it = this.listaFaes.getListaFAE().listIterator(); it.hasNext();) {
            FAE fae = it.next();

            if (fae.isUtilizador(u)) {
                return true;
            }
        }
        return false;
    }

     

    @Override
    public int compareTo(Exposicao outraExposicao) {
        return titulo.compareTo(outraExposicao.titulo);
    }
    

    @Override
    public void alteraParaEmSubmissao() {
        
    }

    @Override
    public void alteraParaEmAtribuicao() {
        
    }

    public boolean validaDefinirFAE(FAE f) {
        return f.valida();
    }

     public void schedule(TimerTask task, Date date) {
        timer.schedule(task, date);
    }

    public boolean setState(ExposicaoEstado state) {
        this.state = state;
        return true;
    }

    public boolean isInRegistada() {
        return this.getState().isInRegistada();
    }

    public boolean isInFAEDefinida() {
        return this.getState().isInFAEDefinida();
    }

    public boolean isInEmSubmissao() {
        return this.getState().isInEmSubmissao();
    }

    public boolean isInEmDetecaoConflitos() {
        return this.getState().isInEmDetecaoConflitos();
    }

    public boolean isInEmAtribuicao() {
        return this.getState().isInEmAtribuicao();
    }

    public boolean isInEmRevisao() {
        return this.getState().isInEmRevisao();
    }

    public boolean isInEmDecisao() {
        return this.getState().isInEmDecisao();
    }

    @Override
    public boolean isInEmDecidida() {
        return this.getState().isInEmDecidida();
    }

    public boolean setStateRegistada() {
        return this.getState().setStateRegistada();
    }

    public boolean setStateEmSubmissao() {
        return this.getState().setStateEmSubmissao();
    }

    public boolean setStateEmDetecaoConflitos() {
        return this.getState().setStateEmDetecaoConflitos();
    }

    public boolean setStateEmAtribuicao() {
        return this.getState().setStateEmAtribuicao();
    }

    public boolean setStateEmRevisao() {
        return this.getState().setStateEmRevisao();
    }

    public boolean setStateEmDecisao() {
        return this.getState().setStateEmDecisao();
    }

    public boolean setStateEmDecidida() {
        return this.getState().setStateEmDecidida();
    }

    @Override
     public String toString() {
        return titulo;
    }
     
     public String toStringCompleto(){
         String str = "Exposição:\n";
        str += "\tTitulo: " + this.titulo + "\n";
        str += "\tTexto descritivo: " + this.textoDescritivo + "\n";
        str += "\tData inicial: " + this.dataInicio + "\n";
        str += "\tData final: " + this.dataFim + "\n";
        str += "\tData inicial de submissão: " + this.dataInicioSubmissao + "\n";
        str += "\tData final de submissão: " + this.dataFimSubmissao + "\n";
        str += "\tData inicial de atribuição: " + this.dataInicioAvaliacao + "\n";
        str += "\tData final de atribuição: " + this.dataFimAvaliacao + "\n";
        str += "\tLocal: " + this.local + "\n";
        str += "\tOrganizadores:\n";
        for (Organizador o : listaOrganizadores.getListaOrganizadores()) {
            str += "\t\t" + o.getUtilizador().getUsername() + "\n";
        }

        return str;
     }

    @Override
    public ListaSubmissoes getListaSubmissoes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setListaSubmissoes(ListaSubmissoes listaSubmissoes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProcessoAtribuicao getProcessoAtribuicao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProcessoAtribuicao novaAtribuicao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setProcessoAtribuicao(ProcessoAtribuicao pa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
