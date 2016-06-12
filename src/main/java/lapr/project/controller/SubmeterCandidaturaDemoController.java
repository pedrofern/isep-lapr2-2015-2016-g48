package lapr.project.controller;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.RegistoUtilizadores;

/**
 *
 * @author Diana
 */
public class SubmeterCandidaturaDemoController {
    
    private static CentroExposicoes ce;
    
    private static Utilizador user;
    

    public SubmeterCandidaturaDemoController(CentroExposicoes centroExposicoes, Utilizador utilizador){
        ce=centroExposicoes;
        user=utilizador;
    }
    
}
