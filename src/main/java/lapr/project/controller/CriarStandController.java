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
    
    
    private CentroExposicoes mce;
    private Stand mStand;
    private RegistoStands regStands;
   
    

    public CriarStandController(CentroExposicoes centroDeExposicoes) {
        mce = centroDeExposicoes;
        
    }
    
    public RegistoStands getRegistoStands(){
        return regStands=mce.getRegistoStands();
    }

    
    public String getStand() {
        return mStand.getDescricao()+mStand.getArea();
    }
    
    
    
    public void setStand(String novoStand) {
       mStand.setDescricao(novoStand);
    }
   
    
    public Stand novoStand(){
       regStands=mce.getRegistoStands();
       return mStand= regStands.novoStand();
        
        
    }
    
    public void adicionarStand(){
        regStands.adicionarStand(mStand);
    }
    
}
