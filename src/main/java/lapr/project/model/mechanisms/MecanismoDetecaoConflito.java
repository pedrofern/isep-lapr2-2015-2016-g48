package lapr.project.model.mechanisms;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diana Silva
 */
public class MecanismoDetecaoConflito {

    private List<Conflito> listaConflitos;
    
    public MecanismoDetecaoConflito(){
        listaConflitos=new ArrayList<>();
    }
    public boolean detetarConflito(){
       return true;
     
    }
}
