package lapr.project.controller;

import lapr.project.model.*;

/**
 *
 * @author Diana Silva
 */
public class AlterarUtilizadorController {
    
    private CentroExposicoes ce;
    private Utilizador user;

    public AlterarUtilizadorController(CentroExposicoes centroExposicoes) {
        ce = centroExposicoes;
    }
    
    public void setUtilizador(Utilizador u){
        user=u;  
    }
    
    public boolean alteraDados(String strNome, String strUsername, String strPwd, String strEmail) throws CloneNotSupportedException {
        Utilizador uClone = user.cloneUtilizador();
        uClone.setNome(strNome);
        uClone.setEmail(strEmail);
        uClone.setUsername(strUsername);
        uClone.setPassword(strPwd);
        boolean b= ce.getRegistoUtilizadores().alteraUtilizador(user, uClone);
        return b;
    }
    
}
