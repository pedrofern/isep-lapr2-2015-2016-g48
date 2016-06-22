package lapr.project.controller;

import java.util.TimerTask;
import lapr.project.model.*;

/**
 *
 * @author Diana Silva
 */
public class DetetarConflitosController extends TimerTask {
    
    private static CentroExposicoes ce;
    private Exposicao exposicao;
    
    public DetetarConflitosController(CentroExposicoes centroExposicoes){
        ce=centroExposicoes;    
    }
    
    public DetetarConflitosController(Exposicao exposicao){
        this.exposicao=exposicao;
    }

    @Override
    public void run() {
        System.out.println("cucu");
    }

    
}
