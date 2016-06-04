package lapr.project.model;

/**
 *
 * @author Pedro Fernandes
 */
public class Conflito {
    
    MecanismoDetecaoConflito m_mecanismoDetecaoConflito;

    public MecanismoDetecaoConflito getMecanismo() {
       return m_mecanismoDetecaoConflito;
    }

    @Override
    public String toString() {
        return "Conflito{" + "m_mecanismoDetecaoConflito=" + m_mecanismoDetecaoConflito + '}';
    }
    
}
