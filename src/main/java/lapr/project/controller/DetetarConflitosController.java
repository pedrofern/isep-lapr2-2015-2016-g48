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

    public DetetarConflitosController(Exposicao exposicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
