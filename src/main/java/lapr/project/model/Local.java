package lapr.project.model;

/**
 *
 * @author Pedro Fernandes
 */
public class Local {

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
