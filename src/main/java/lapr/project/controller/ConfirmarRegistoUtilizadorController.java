package lapr.project.controller;

import lapr.project.model.lists.RegistoUtilizadores;
import java.util.*;
import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
public class ConfirmarRegistoUtilizadorController {

    private final CentroExposicoes ce;
    private Utilizador utilizadorAConfirmar;
    private RegistoUtilizadores registoUtilizadores;

    public ConfirmarRegistoUtilizadorController(CentroExposicoes centroExposicoes) {
        this.ce = centroExposicoes;
    }

    public List<Utilizador> iniciaConfirmacaoUtilizador() {
        return registoUtilizadores.getUtilizadoresNaoRegistados();
    }

    public Utilizador getUtilizadorInfo(String uId) {
        utilizadorAConfirmar = registoUtilizadores.getUtilizadorInfo(uId);
        return utilizadorAConfirmar;
    }

    public void confirmaRegistoUtilizador() {
        registoUtilizadores.confirmaRegistoUtilizador(utilizadorAConfirmar);
    }
    
    public RegistoUtilizadores getRegistoUtilizadores(){
        return registoUtilizadores=ce.getRegistoUtilizadoresNaoRegistados().getUtilizadoresPend();
    }
    
}
