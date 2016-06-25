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
/**
 * Cria uma instancia de registarUtilizadorController e recebe o centro de exposicoes como parametro
 * @param centroExposicoes 
 */
    public RegistarUtilizadorController(CentroExposicoes centroExposicoes) {
        ce= centroExposicoes;
        registoUtilizadores = ce.getRegistoUtilizadoresRegistados();

    }
/**
 * Cria um novo utilizador
 */
    public void novoUtilizador() {
        utilizador = new Utilizador();
    }
/**
 * Cria dados do utilizador
 * @param nome
 * @param email
 * @param user
 * @param pass
 * @return utilizador registado
 */
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
    /**
     * Verifica se o email e valido
     * @param email
     * @return true se for, false se nao for
     */
    public boolean isEmailValido(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
    /**
     * Devolve o utilizador
     * @return o utilizador
     */
    public Utilizador getUtilizador(){
        return this.utilizador;
    }
/**
 * Altera o utilizador
 * @param user 
 */
    public void setUtilizador(Utilizador user) {
        this.utilizador = user;
    }

}
