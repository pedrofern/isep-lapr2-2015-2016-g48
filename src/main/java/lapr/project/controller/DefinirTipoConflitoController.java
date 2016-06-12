package lapr.project.controller;

import lapr.project.model.mechanisms.MecanismoDetecaoConflito;
import lapr.project.model.mechanisms.TipoConflito;
import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
public class DefinirTipoConflitoController {
    private static CentroExposicoes ce;

    public DefinirTipoConflitoController(CentroExposicoes centroDeExposicoes) {
        ce = centroDeExposicoes;
    }

    public TipoConflito novoTipoConflito(String strDescricao, MecanismoDetecaoConflito mecanismo) {
        return ce.getRegistoTipoConflitos().novoTipoConflito(strDescricao, mecanismo);
    }

    public boolean registaTipoConflito(TipoConflito tpConflito) {
        return ce.getRegistoTipoConflitos().registaTipoConflito(tpConflito);
    }
}
