package lapr.project.controller;

import lapr.project.model.lists.RegistoUtilizadores;
import java.util.*;
import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
public class ConfirmarRegistoUtilizadorController {

    /**
     * O centro de exposicoes
     */
    private final CentroExposicoes ce;
    /**
     * O utilizador a confirmar
     */
    private Utilizador utilizadorAConfirmar;
    /**
     * O registo de utilizadores
     */
    private RegistoUtilizadores registoUtilizadores;

    /**
     * Cria uma instancia de ConfirmarRegistoUtilizadorController e passa como parametro o centro de ezposicoes
     * @param centroExposicoes 
     */
    public ConfirmarRegistoUtilizadorController(CentroExposicoes centroExposicoes) {
        this.ce = centroExposicoes;
    }

    /**
     * Devolve a informacao do utilizador, passando como parametro o id do utilizador
     * @param uId
     * @return o utilizador a confirmar
     */
    public Utilizador getUtilizadorInfo(String uId) {
        utilizadorAConfirmar = registoUtilizadores.getUtilizadorInfo(uId);
        return utilizadorAConfirmar;
    }

    /**
     * Confirma o registo do utilizador, passando como parametro o utlizador a confirmar
     */
    public void confirmaRegistoUtilizador() {
        registoUtilizadores.confirmaRegistoUtilizador(utilizadorAConfirmar);
    }
    
    /**
     * Devolve um objecto RegistoUtilizadores, que contem a lista de utilizadores pendentes
     * @return a lista de utilizadores ainda por confirmar
     */
    public RegistoUtilizadores getRegistoUtilizadoresNaoRegistados(){
        return registoUtilizadores=ce.getRegistoUtilizadoresNaoRegistados();
    }
    
}
