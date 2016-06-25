package lapr.project.model.mechanisms;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
public interface MecanismoAtribuicao extends Serializable{

    public boolean atribui();

}
