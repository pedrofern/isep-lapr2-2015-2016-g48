package lapr.project.model;

import java.util.*;

/**
 *
 * @author Pedro Fernandes
 */
public class RegistoTipoConflitos {
    private List<TipoConflito> listaTipoConflitos;

    public RegistoTipoConflitos() {
        listaTipoConflitos = new ArrayList<>();
    }

    public TipoConflito novoTipoConflito(String descricao, MecanismoDetecaoConflito mecanismo) {
        return new TipoConflito(descricao, mecanismo);
    }

    public boolean registaTipoConflito(TipoConflito tipoConflito) {
        if (tipoConflito.valida() && validaTipoConflito(tipoConflito)) {
            return listaTipoConflitos.add(tipoConflito);
        }
        return false;
    }

    /**
     * Verifica se tipo de conflito é válido.
     *
     * @param tipoConflito
     * @return boolean valido ou não
     */
    private boolean validaTipoConflito(TipoConflito tipoConflito) {
        for (TipoConflito tc : listaTipoConflitos) {
            if (tc.equals(tipoConflito)) {
                return false;
            }
        }
        return true;
    }

    public List<TipoConflito> getListaConflitos() {
        return listaTipoConflitos;
    }

    /**
     * Verifica se o registo de tipos de conflito é igual a um objeto passado
     * por parâmetro.
     *
     * @param o O objeto que vai ser comparado
     * @return True se forem iguais, false se não forem.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        RegistoTipoConflitos reg = (RegistoTipoConflitos) o;
        return listaTipoConflitos.equals(reg.getListaConflitos());
    }
}
