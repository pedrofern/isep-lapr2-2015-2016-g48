/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;
import lapr.project.model.*;
import lapr.project.model.lists.*;

/**
 *
 * @author Tomas
 */
public class CriarStandController {
    
    private GestorDeExposicoes gestor;
    private Stand m_stand;
    private RegistoStands m_listaStands;
    private CentroExposicoes mce;
    
    
   
    public CriarStandController(CentroExposicoes ce) {

        this.mce=ce;
    }

    public void novoStand() {
        m_stand=mce.getRegistoStands().novoStand();
    }

    public Stand registaStand(String descricao, String area) {
       
        m_stand.setDados(descricao, area);
        
        return m_stand;
    }

//    public void setCodigoUnico(int codigoUnico) {
//        m_demonstracao.setCod(codigoUnico);
//    }
//    
    public void setDescricao(String novaDescricao) {
        m_stand.setDescricao(novaDescricao);
    }
    
//    public void setListaRecursos(RegistoRecursos novaListaRecursos) {
//        m_demonstracao.setListaRecursos(novaListaRecursos);
//    }
    
    public RegistoStands getListaStands() {
        return m_listaStands;
    }
        
    public void addStand(Stand s){
        m_stand.addStand(s);
    }
    
   
    public Stand getStand() {
        return m_stand;
    }
    
    
}
