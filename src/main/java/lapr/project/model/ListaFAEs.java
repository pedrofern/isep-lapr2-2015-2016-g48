package lapr.project.model;

import java.util.*;

/**
 *
 * @author Pedro Fernandes
 */
public class ListaFAEs {
    private List<FAE> listaFaes;

    public ListaFAEs() {
        listaFaes = new ArrayList<>();
    }

    /**
     * Adiciona FAE á lista.
     *
     * @param nome
     * @param email
     * @param username
     * @param password
     * @return boolean se adicionou ou não.
     */
    public boolean addFAE(String nome, String email, String username, String password) {
        if (email == null || nome == null || username == null || password == null) {
            return false;
        }
        Utilizador u = new Utilizador (nome, email, username, password);
        FAE fae = new FAE(u);

        if (validaFAE(fae)) {
            return addFAE(fae);
        } else {
            return false;
        }
    }

    private boolean addFAE(FAE fae) {
        return getListaFAEs().add(fae);
    }

    /**
     * Verifica se FAE é valido verificando se o mesmo já existe na
     * lista.
     *
     * @param fae FAE a validar
     * @return boolean se é valido ou não
     */
    private boolean validaFAE(FAE f) {
        for (FAE fae : getListaFAEs()) {
            if (fae.getEmail().equals(f.getEmail())) {
                return false;
            }
        }
        return true;
    }

    public boolean hasFAE(String email) {
        for (FAE fae : this.getListaFAEs()) {
            if (fae.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Obtem a lista de FAEs.
     *
     * @return the listaFAEs
     */
    public List<FAE> getListaFAEs() {
        return listaFaes;
    }

    /**
     * Verifica se o lista de organizadores é igual a um objeto passado por
     * parâmetro
     *
     * @param f O objeto que vai ser comparado com o processo de distribuição.
     * @return True se forem iguais, false se não forem.
     */
    @Override
    public boolean equals(Object f) {
        if (this == f) {
            return true;
        }
        if (f == null || this.getClass() != f.getClass()) {
            return false;
        }
        ListaFAE lFae = (ListaFAE) f;
        return listaFaes.equals(lFae.getListaFAEs());
    }
}
