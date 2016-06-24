
package lapr.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.mechanisms.MecanismoDetecaoConflito;

/**
 *
 * @author Diana
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TipoConflito implements Serializable{
    private List<MecanismoDetecaoConflito> listaMecConflito;
     
    public TipoConflito(){
         listaMecConflito=new ArrayList<>();
     
    }
}
