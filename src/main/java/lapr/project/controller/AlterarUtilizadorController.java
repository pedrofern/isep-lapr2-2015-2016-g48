package lapr.project.controller;

import lapr.project.model.*;

/**
 *
 * @author Diana Silva
 */
public class AlterarUtilizadorController {
    
    private static CentroExposicoes ce;
    private static Utilizador user;

    public AlterarUtilizadorController(CentroExposicoes centroExposicoes) {
        ce = centroExposicoes;
    }
    
    public void setUtilizador(Utilizador u){
        user=u;
        
    }

    public Utilizador getUtilizador(String strID) {
        user = ce.getRegistoUtilizadores().getUtilizadorByID(strID);
        return user;
    }

    public boolean alteraDados(String strNome, String strUsername, String strPwd, String strEmail) throws CloneNotSupportedException {
        Utilizador uClone = user.clone();
        uClone.setNome(strNome);
        uClone.setEmail(strEmail);
        uClone.setUsername(strUsername);
        uClone.setPassword(strPwd);
        return ce.getRegistoUtilizadores().alteraUtilizador(user, uClone);
    }
    
}
