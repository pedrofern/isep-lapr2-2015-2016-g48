package lapr.project.model.mechanisms;

import java.io.Serializable;
import lapr.project.model.mechanisms.MecanismoDetecaoConflito;

/**
 *
 * @author Pedro Fernandes
 */
public class Conflito implements Serializable{
    
    MecanismoDetecaoConflito m_mecanismoDetecaoConflito;

    public MecanismoDetecaoConflito getMecanismo() {
       return m_mecanismoDetecaoConflito;
    }

    @Override
    public String toString() {
        return "Conflito{" + "m_mecanismoDetecaoConflito=" + m_mecanismoDetecaoConflito + '}';
    }
    
}
