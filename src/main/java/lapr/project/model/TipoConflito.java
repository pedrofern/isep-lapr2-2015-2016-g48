
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.mechanisms.MecanismoDetecaoConflito;

/**
 *
 * @author Diana
 */
public class TipoConflito {
    private List<MecanismoDetecaoConflito> listaMecConflito;
     
    public TipoConflito(){
         listaMecConflito=new ArrayList<>();
     
    }
}
