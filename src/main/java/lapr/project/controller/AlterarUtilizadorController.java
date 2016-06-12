package lapr.project.controller;

import lapr.project.model.*;

/**
 *
 * @author Diana Silva
 */
public class AlterarUtilizadorController {
    
    private static CentroExposicoes m_ce;
    private static Utilizador m_user;

    public AlterarUtilizadorController(CentroExposicoes ce) {
        m_ce = ce;
    }
    
    public void setUtilizador(Utilizador u){
        m_user=u;
        
    }

    public Utilizador getUtilizador(String strID) {
        m_user = m_ce.getRegistoUtilizadores().getUtilizadorByID(strID);
        return m_user;
    }

    public boolean alteraDados(String strNome, String strUsername, String strPwd, String strEmail) throws CloneNotSupportedException {
        Utilizador uClone = m_user.clone();
        uClone.setNome(strNome);
        uClone.setEmail(strEmail);
        uClone.setUsername(strUsername);
        uClone.setPassword(strPwd);
        return m_ce.getRegistoUtilizadores().alteraUtilizador(m_user, uClone);
    }
    
}
