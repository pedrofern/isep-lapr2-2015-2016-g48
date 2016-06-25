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
 * @author anasilva
 */
public class CriarStandController {
    
    /**
     * O centro de exposicoes
     */
    private CentroExposicoes mce;
    /**
     * O stand
     */
    private Stand mStand;
    
    /**
     * O registo de Stands
     */
    private RegistoStands regStands;
   
    
/**
 * Constroi uma instancia de CriarStandcontroller, recebendo como parametro o centro de exposicoes
 * @param centroDeExposicoes 
 */
    public CriarStandController(CentroExposicoes centroDeExposicoes) {
        mce = centroDeExposicoes;
        
    }
    /**
     * Devolve um objecto RegistoStands, que contem uma lista de stands
     * @return a lista de stands
     */
    public RegistoStands getRegistoStands(){
        return regStands=mce.getRegistoStands();
    }

    /**
     * Devolve a descricao e a area do stand
     * @return 
     */
    public String getStand() {
        return mStand.getDescricao()+mStand.getArea();
    }
    
    
    /**
     * Altera a descricao do stand
     * @param novoStand 
     */
    public void setStand(String novoStand) {
       mStand.setDescricao(novoStand);
    }
   
    /**
     * Cria um objecto Stand no registo de stands
     * @return novo stand
     */
    public Stand novoStand(){
       regStands=mce.getRegistoStands();
       return mStand= regStands.novoStand();
        
        
    }
    /**
     * Adiciona o objecto Stand a lista de Stands
     */
    public void adicionarStand(){
        regStands.adicionarStand(mStand);
    }
    
}
