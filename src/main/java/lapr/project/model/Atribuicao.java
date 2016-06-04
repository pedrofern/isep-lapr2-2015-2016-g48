package lapr.project.model;

import java.util.*;

/**
 *
 * @author Pedro Fernandes
 */
public class Atribuicao {

    private Candidatura m_candidatura;
    private List<FAE> e_listaFAE;

    public Atribuicao() {
        e_listaFAE = new ArrayList<FAE>();
    }

    public boolean valida() {
        System.out.println("Atribuição Candidatura: valida: " + this.toString());
        return true;
    }

    private boolean validaFAE(FAE f) {
        System.out.println("Atribuição Candidatura: validaFAE: " + f.toString());
        return true;
    }

    public void addFAE(Utilizador ut) {
        FAE f = new FAE();
        f.setUtilizador(ut);
        if (validaFAE(f)) {
            addFAE(f);
        }
    }

    private void addFAE(FAE f) {
        e_listaFAE.add(f);
    }

    public List<FAE> getListaFAE() {
        List<FAE> lf = new ArrayList<FAE>();

        for (FAE f : e_listaFAE) {
            lf.add(f);
        }
        return lf;
    }

    public String getInfo() {
        return this.toString() + "\n";
    }

    @Override
    public String toString() {
        return this.m_candidatura.toString() + "\nATRIBUIDA A: " + getListaFAE() + "\n";
    }

}
