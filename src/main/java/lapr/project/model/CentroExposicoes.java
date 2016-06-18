package lapr.project.model;

import lapr.project.model.lists.RegistoTipoConflitos;
import lapr.project.model.lists.RegistoMecanismosAtribuicao;
//import lapr.project.model.mechanisms.*;
import lapr.project.model.lists.*;

/**
 *
 * @author Pedro Fernandes
 */
public class CentroExposicoes {

    private RegistoRecursos regRecursos;
    private RegistoExposicoes regExposicoes;
    private RegistoUtilizadores regUtilizadores;
    private RegistoStands regStands;
    private RegistoMecanismosAtribuicao regMecAtribuicoes;
    private RegistoTipoConflitos regTiposConflitos;

    public CentroExposicoes() {
        regUtilizadores = new RegistoUtilizadores();
        regExposicoes = new RegistoExposicoes();
        regRecursos = new RegistoRecursos();
        regStands=new RegistoStands();
        regMecAtribuicoes=new RegistoMecanismosAtribuicao();
        regTiposConflitos=new RegistoTipoConflitos();
    }

    public RegistoUtilizadores getRegistoUtilizadores() {
        return this.regUtilizadores;
    }
    
    public RegistoRecursos getRegistoRecursos() {
        return this.regRecursos;
    }
    
    public RegistoExposicoes getRegistoExposicoes(){
        return this.regExposicoes;
    }
    
    public RegistoStands getRegistoStands(){
        return this.regStands;
    }

    public RegistoMecanismosAtribuicao getMecanismosAtribuicao(){
        return this.regMecAtribuicoes;
    }

    /**
     * @return o registo de tipo de conflitos do centro de exposicoes;
     */
    public RegistoTipoConflitos getRegistoTipoConflitos() {
        return regTiposConflitos;
    }

//    /**
//     * Verifica se a empresa é igual a um objeto passado por parâmetro
//     *
//     * @param o O objeto que vai ser comparado com a empresa.
//     * @return True se forem iguais, false se não forem.
//     */
//    @Override
//    public boolean equals(Object o) {
//       
//        CentroExposicoes outroCentro = (CentroExposicoes) o;
//        return this.getRegistoUtilizadores().equals(outroCentro.getRegistoUtilizadores())
//                && this.getRegistoExposicoes().equals(outroCentro.getRegistoExposicoes());
//    }


    public void setRegistoExposicoes (RegistoExposicoes re){
        regExposicoes=re;
    }


    @Override
    public String toString() {
        return "Empresa:" + "regUtilizadores=" + regUtilizadores
                + ", regExposicoes=" + regExposicoes /**+ "m_regCandidaturas=" + m_regCandidaturas**/;
    }
}
