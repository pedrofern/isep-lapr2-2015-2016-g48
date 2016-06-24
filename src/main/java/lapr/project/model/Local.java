package lapr.project.model;

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
public class Local implements Serializable{

    private String local;

    public Local() {

    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String newLocal) {
        local = newLocal;
    }

    public boolean validaLocal() {
        return true;
    }

    @Override
    public String toString() {
        return "Local: " + local;
    }
}
