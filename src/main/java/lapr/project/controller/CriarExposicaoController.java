package lapr.project.controller;

import java.text.ParseException;
import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.lists.RegistoExposicoes;
import lapr.project.model.*;
import lapr.project.utils.Data;

/**
 *
 * @author Diana Silva
 */
public class CriarExposicaoController {

    /**
     * O centro de exposicoes
     */
    private static CentroExposicoes ce;
    /**
     * A exposicao
     */
    private Exposicao exposicao;
    /**
     * O organizador
     */
    private Organizador organizador;
    /**
     * O fae
     */
    private FAE fae;

    /**
     * Cria uma nova instancia da classe
     * @param centroExposicoes 
     */
    public CriarExposicaoController(CentroExposicoes centroExposicoes) {
        ce = centroExposicoes;
    }
    /**
     * Devolve a lista de exposicoes
     * @return a lista de exposicoes
     */
    public RegistoExposicoes getRegistoExposicoes(){
        return ce.getRegistoExposicoes();
    }
           /**
            * Cria uma nova exposicao e lança uma excepcao se nao for criada
            * @throws Exception 
            */ 
    public void criarExposicao() throws Exception {
        exposicao = ce.getRegistoExposicoes().novaExposicao();
    }
    /**
     * Altera a exposicao
     * @param e 
     */
    public void setExposicao(Exposicao e){
        exposicao=e;
    }
    /**
     * Altera dados principais
     * @param titulo
     * @param desc
     * @param i
     * @param f
     * @param l
     * @param is
     * @param fs 
     */
    public void setDadosPrincipais(String titulo, String desc, Data i, Data f, String l,Data is, Data fs){
        exposicao.setDadosPrincipais(titulo, desc,i,f,l,is,fs);
    }
    /**
     * Altera dados relativos ao stand, conflitos
     * @param diatrib
     * @param dfatrib
     * @param dConflitos
     * @param dIstand
     * @param dFstand
     * @param dAConflitos 
     */
    public void setDadosData(Data diatrib, Data dfatrib, Data dConflitos, Data dIstand, Data dFstand, Data dAConflitos){
        exposicao.setDadosData(diatrib,dfatrib, dConflitos, dIstand, dFstand,dAConflitos);
    }
    /**
     * Valida os dados
     */
    public void validaDadosExposicao(){
        exposicao.validaLocal();
    }
/**
 * Devolve a lista de utilizadores registados
 * @return a lista de utilizadores registados
 */
    public RegistoUtilizadores getListaUtilizadores() {
        return ce.getRegistoUtilizadoresRegistados();
    }
    /**
     * Devolve a lista de organizadores
     * @return a lista de organizadores
     */
    public ListaOrganizadores getListaOrganizadores(){
        return exposicao.getListaOrganizadores();
    }
    /**
     * Altera a lista de organizadores
     * @param lo 
     */
    public void setListaOrganizadores(ListaOrganizadores lo){
        exposicao.setListaOrganizadores(lo);
    }

/**
 * Cria organizador
 * @param u 
 */
    public void criaOrganizador(Utilizador u) {
        
        organizador= exposicao.getListaOrganizadores().criaOrganizador(u);
  
    }
    
/**
 * Devolve organizador
 * @return organizador
 */
    public Organizador getOrganizador(){
        return organizador;
    }
    /**
     * Devolve fae
     * @return fae
     */
     public FAE getFAE(){
        return fae;
    }
    /**
     * Valida o numero de organizadores minimos
     * @return true se validos, false se nao
     */
    public boolean validaMinOrganizadores(){
        return exposicao.validaMinOrganizadores();
    }
    /**
     * valida data de fim superior ao inicio
     * @return true se valida, false se nao
     */
     public boolean validaDataFimSuperiorInicio(){
        return exposicao.validaDataFimSuperiorInicio();
    }
    
     /**
      * Valida seguimento das datas
      * @return true se valido, false se nao
      */
    public boolean validaSeguimentoDatas(){
        return exposicao.validaSeguimentoDatas();
    }
    /**
     * Valida titulo e descricao
     * @return true se valido, false se nao
     */
    public boolean validaTituloEDescricao(){
        return exposicao.valida();
    }
/**
 * Verifica se a exposicao foi guardada
 * @return true se sim, false se nao
 */
    public boolean registaExposicao() {
        return getRegistoExposicoes().registaExposicao(exposicao);  
    }
  /**
   * Devolve a exposicao como string
   * @return dados da exposicao como string
   */
    public String getExposicaoString() {
        return this.exposicao.toStringCompleto();
    }
    
//    public void addTimer() throws Exception{
//        exposicao.createTimers();
//    }
    /**
     * Devolve exposicao
     * @return exposicao
     */
    public Exposicao getExposicao(){
        return exposicao;
    }
/**
 * Valida datas
 * @param datai
 * @param dataf
 * @param datasub
 * @param datafsub
 * @param dataconflitos
 * @param dataaltconflitos
 * @return true se valida, false se nao
 */
    public boolean validaDatas1(String datai, String dataf, String datasub, String datafsub, String dataconflitos, String dataaltconflitos ) {
        return exposicao.validaDatas1(datai, dataf, datasub, datafsub, dataconflitos, dataaltconflitos);
    }
    /**
     * Valida datas
     * @param dataavcand
     * @param datafavcand
     * @param dataistand
     * @param datafstand
     * @return true se valida, false se nao
     */
    public boolean validaDatas2(String dataavcand, String datafavcand, String dataistand, String datafstand){
        return exposicao.validaDatas2(dataavcand, datafavcand, dataistand, datafstand);
    }
    /**
     * 
     * @throws ParseException 
     */
    public void setCriada() throws ParseException {
        exposicao.setCriada();
    }
}
