package lapr.project.controller;

import lapr.project.model.*;

/**
 *
 * @author Diana Silva
 */
public class AlterarUtilizadorController {
    
    /**
     * O centro de exposicoes
     */
    private CentroExposicoes ce;
    /**
     * O utilizador
     */
    private Utilizador user;

    /**
     * Cria uma nova instancia de AlterarUtilizadorController
     * @param centroExposicoes 
     */
    public AlterarUtilizadorController(CentroExposicoes centroExposicoes) {
        ce = centroExposicoes;
    }
    /**
     * Altera o utilizador
     * @param u 
     */
    public void setUtilizador(Utilizador u){
        user=u;  
    }
    /**
     * Altera dados do utilizador
     * @param strNome
     * @param strUsername
     * @param strPwd
     * @param strEmail
     * @return dados actualizados
     * @throws CloneNotSupportedException 
     */
    public boolean alteraDados(String strNome, String strUsername, String strPwd, String strEmail) throws CloneNotSupportedException {
        Utilizador uClone = user.cloneUtilizador();
        uClone.setNome(strNome);
        uClone.setEmail(strEmail);
        uClone.setUsername(strUsername);
        uClone.setPassword(strPwd);
        return ce.getRegistoUtilizadores().alteraUtilizador(user, uClone);
    }
    
}
