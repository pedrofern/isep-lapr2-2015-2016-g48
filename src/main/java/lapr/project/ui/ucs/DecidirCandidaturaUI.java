/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;

/**
 *
 * @author DianaSilva
 */
public class DecidirCandidaturaUI {
    
    private static CentroExposicoes ce;
    private static Utilizador user;
    
    public DecidirCandidaturaUI(CentroExposicoes centroExposicoes, Utilizador utilizador){
        ce=centroExposicoes;
        user=utilizador;
    }
}
