package lapr.project.model.mechanisms;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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
