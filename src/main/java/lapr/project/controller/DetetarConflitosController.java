package lapr.project.controller;

import java.util.TimerTask;
import lapr.project.model.*;

/**
 *
 * @author Diana Silva
 */
public class DetetarConflitosController extends TimerTask {
    
    private static CentroExposicoes ce;
    
    public DetetarConflitosController(CentroExposicoes centroExposicoes){
        ce=centroExposicoes;    
    }

    @Override
    public void run() {
        
    }

    
}
