package lapr.project.model.mechanisms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diana Silva
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlTransient
//@XmlSeeAlso({MecanismoCarga.class,
//            MecanismoRanking.class,
//            MecanismoTempoServico.class})
public class MecanismoDetecaoConflito implements Serializable{

    private List<Conflito> listaConflitos;
    
    public MecanismoDetecaoConflito(){
        listaConflitos=new ArrayList<>();
    }
    public boolean detetarConflito(){
       return true;
     
    }
}
