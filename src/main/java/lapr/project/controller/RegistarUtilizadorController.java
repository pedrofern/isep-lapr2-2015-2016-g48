package lapr.project.controller;

import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.*;

/**
 *
 * @author Pedro Fernandes
 */
public class RegistarUtilizadorController {

    private CentroExposicoes ce;
    private Utilizador utilizador;
    private RegistoUtilizadores registoUtilizadores;

    public RegistarUtilizadorController(CentroExposicoes centroExposicoes) {
        ce= centroExposicoes;
        registoUtilizadores = ce.getRegistoUtilizadores();

    }

    public void novoUtilizador() {
        utilizador = new Utilizador();
    }

    public Utilizador criaUtilizador(String nome, String email, String user, String pass) {        
        utilizador.setUsername(user);
        utilizador.setPassword(pass);
        utilizador.setNome(nome);
        utilizador.setEmail(email);
        
        utilizador.setRegistado(Boolean.TRUE);

        if (registoUtilizadores.registaUtilizador(utilizador)) {
            return utilizador;
        
        } else {
            return null;
        }
        

    }
    

    public void setUtilizador(Utilizador user) {
        this.utilizador = user;
    }

}
