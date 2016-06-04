package lapr.project.controller;

import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
public class DefinirTipoConflitoController {
    private CentroExposicoes m_centroDeExposicoes;

    public DefinirTipoConflitoController(CentroExposicoes centroDeExposicoes) {
        m_centroDeExposicoes = centroDeExposicoes;
    }

    public TipoConflito novoTipoConflito(String strDescricao, MecanismoDetecaoConflito mecanismo) {
        return m_centroDeExposicoes.getRegistoTipoConflitos().novoTipoConflito(strDescricao, mecanismo);
    }

    public boolean registaTipoConflito(TipoConflito tpConflito) {
        return m_centroDeExposicoes.getRegistoTipoConflitos().registaTipoConflito(tpConflito);
    }
}
