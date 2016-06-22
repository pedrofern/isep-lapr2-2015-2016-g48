package lapr.project.model;

import java.io.Serializable;

/**
 *
 * @author Pedro Fernandes
 */
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
