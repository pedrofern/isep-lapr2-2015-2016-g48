package lapr.project.model.mechanisms;

import lapr.project.model.mechanisms.TipoConflito;

/**
 *
 * @author Pedro Fernandes
 */
public interface MecanismoDetecaoConflito {

    public boolean detetarConflito(TipoConflito tc);
}
