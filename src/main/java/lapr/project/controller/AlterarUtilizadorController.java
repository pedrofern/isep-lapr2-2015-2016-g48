package lapr.project.controller;

import lapr.project.model.*;

/**
 *
 * @author Diana Silva
 */
public class AlterarUtilizadorController {
    
    private CentroExposicoes m_centroDeExposicoes;
    private Utilizador m_user;

    public AlterarUtilizadorController(CentroExposicoes centroDeExposicoes) {
        m_centroDeExposicoes = centroDeExposicoes;
    }
    
    public void setUtilizador(Utilizador u){
        m_user=u;
        
    }

    public Utilizador getUtilizador(String strID) {
        m_user = m_centroDeExposicoes.getRegistoUtilizadores().getUtilizadorByID(strID);
        return m_user;
    }

    public boolean alteraDados(String strNome, String strUsername, String strPwd, String strEmail) {
        Utilizador uClone = m_user.clone();
        uClone.setNome(strNome);
        uClone.setEmail(strEmail);
        uClone.setUsername(strUsername);
        uClone.setPassword(strPwd);
        return m_centroDeExposicoes.getRegistoUtilizadores().alteraUtilizador(m_user, uClone);
    }
    
}
