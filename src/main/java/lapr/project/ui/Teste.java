/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.FileNotFoundException;
import lapr.project.model.*;
import lapr.project.ui.ucs.*;

/**
 *
 * @author Edu
 */
public class Teste {

    /**
     * @param ar        CentroExposicoes centro=new CentroExposicoes();
        Utilizador utilizador=new Utilizador();
        
       new AvaliarCandidaturaUI(centro,utilizador);gs the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        CentroExposicoes ce=new CentroExposicoes();
        Utilizador user=new Utilizador();
        
       //new AvaliarCandidaturaUI(centro,utilizador);
        //new DefinirFAEUI();
        RegistarCandidaturaUI teste=new RegistarCandidaturaUI(ce, user);
    }
    
}
