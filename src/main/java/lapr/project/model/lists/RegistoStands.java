package lapr.project.model.lists;

import java.util.ArrayList;
import lapr.project.model.Stand;

/**
 *
 * @author Diana
 */
public class RegistoStands {
    
    
    private ArrayList<Stand> m_listaStands;
    
    public RegistoStands(){
        m_listaStands=new ArrayList<>();
    }
    
    public Stand[] getArray() {
        return m_listaStands.toArray( new Stand[m_listaStands.size()] );
     }
    
}
