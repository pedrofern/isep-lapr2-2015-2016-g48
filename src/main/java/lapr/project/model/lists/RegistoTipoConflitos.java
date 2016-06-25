package lapr.project.model.lists;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.mechanisms.MecanismoDetecaoConflito;
import lapr.project.model.mechanisms.TipoConflito;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RegistoTipoConflitos implements Serializable{
    private ArrayList<TipoConflito> listaTipoConflitos;

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

}
