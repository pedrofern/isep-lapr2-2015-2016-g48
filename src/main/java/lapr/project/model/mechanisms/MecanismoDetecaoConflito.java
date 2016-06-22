package lapr.project.model.mechanisms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diana Silva
 */
public class MecanismoDetecaoConflito implements Serializable{

    private List<Conflito> listaConflitos;
    
    public MecanismoDetecaoConflito(){
        listaConflitos=new ArrayList<>();
    }
    public boolean detetarConflito(){
       return true;
     
    }
}
