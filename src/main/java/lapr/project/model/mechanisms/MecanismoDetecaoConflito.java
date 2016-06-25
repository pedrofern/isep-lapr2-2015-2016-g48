package lapr.project.model.mechanisms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diana Silva
 */
@XmlRootElement
public class MecanismoDetecaoConflito extends Mecanismo implements Serializable{

    
    public MecanismoDetecaoConflito(){
        listaConflitos=new ArrayList<>();
    }
    public boolean detetarConflito(){
       return true;
     
    }
}
