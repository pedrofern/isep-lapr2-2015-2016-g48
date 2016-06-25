package lapr.project.controller;

import java.util.regex.Pattern;
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
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^.+@.+\\..+$");

    public RegistarUtilizadorController(CentroExposicoes centroExposicoes) {
        ce= centroExposicoes;
        registoUtilizadores = ce.getRegistoUtilizadoresRegistados();

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
    
    public boolean isEmailValido(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
    
    public Utilizador getUtilizador(){
        return this.utilizador;
    }

    public void setUtilizador(Utilizador user) {
        this.utilizador = user;
    }

}
