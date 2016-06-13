package lapr.project.controller;

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

    private static CentroExposicoes ce;
    private Exposicao exposicao;
    private Utilizador user;
    private Organizador organizador;


    public CriarExposicaoController(CentroExposicoes centroExposicoes) {
        ce = centroExposicoes;
    }
    
    public RegistoExposicoes getRegistoExposicoes(){
        return ce.getRegistoExposicoes();
    }
            
    public void criarExposicao() {
        exposicao = ce.getRegistoExposicoes().novaExposicao();
    }
    
    public void setExposicao(Exposicao e){
        exposicao=e;
    }
    
    public void setDados(String titulo, String desc, Data i, Data f, String l, Data is, Data fs, Data diatrib, Data dfatrib, Data dConflitos, Data dIstand, Data dFstand, Data dAConflitos){
        exposicao.setDados(titulo, desc,i,f,l,is,fs,diatrib,dfatrib,dConflitos, dIstand, dFstand, dAConflitos);
    }
    
    public void validaDadosExposicao(){
        exposicao.validaLocal();
    }

    public RegistoUtilizadores getListaUtilizadores() {
        return ce.getRegistoUtilizadores();
    }
    
    public void setUtilizador(Utilizador u){
        user=u;
    }
   
    
    public ListaOrganizadores getListaOrganizadores(){
        return exposicao.getListaOrganizadores();
    }
    
    public void setListaOrganizadores(ListaOrganizadores lo){
        exposicao.setListaOrganizadores(lo);
    }


    public void criaOrganizador(Utilizador u) {
        
        organizador= exposicao.getListaOrganizadores().criaOrganizador(u);
  
    }
    
    public Organizador getOrganizador(){
        return organizador;
    }
    
    public boolean validaMinOrganizadores(){
        return exposicao.validaMinOrganizadores();
    }
    
     public boolean validaDataFimSuperiorInicio(){
        return exposicao.validaDataFimSuperiorInicio();
    }
    
     
    public boolean validaSeguimentoDatas(){
        return exposicao.validaSeguimentoDatas();
    }

    public boolean registaExposicao() {
        if (ce.getRegistoExposicoes().registaExposicao(exposicao)) {
            return true;
        }
        return false;
    }
    


    public boolean validaExposicao() {
        return ce.getRegistoExposicoes().validaExposicao(exposicao);
    }

    public String getExposicaoString() {
        return this.exposicao.toStringCompleto();
    }
    
    public void addTimer() throws Exception{
        exposicao.createTimers();
    }
    
    public Exposicao getExposicao(){
        return exposicao;
    }

    public boolean validaDatas(String datai, String dataf, String datasub, String datafsub, String dataconflitos, String dataaltconflitos, 
        String dataavcand, String datafavcand, String dataistand, String datafstand) {
        return exposicao.validaDatas(datai, dataf, datasub, datafsub, dataconflitos, dataaltconflitos, 
        dataavcand, datafavcand, dataistand, datafstand); 
    }

}
