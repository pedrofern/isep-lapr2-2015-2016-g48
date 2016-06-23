package lapr.project.controller;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;

/**
 *
 * @author Pedro Fernandes
 */
public class SubmeterCandidaturaDemoController {
    
    
    
    private CentroExposicoes ce;
    
    private Utilizador user;
    

    public SubmeterCandidaturaDemoController(CentroExposicoes centroExposicoes, Utilizador utilizador){
        ce=centroExposicoes;
        user=utilizador;
    }
    
    
    
}
