package lapr.project.model;

import lapr.project.model.lists.RegistoMecanismosAtribuicao;
import lapr.project.model.mechanisms.*;
import lapr.project.model.lists.*;
import java.util.*;

/**
 *
 * @author Pedro Fernandes
 */
public class CentroExposicoes {

    private static RegistoTipoConflitos registoTipoConflitos;
//   FAES é na exposição
//    private ListaFAE m_listaFAE;
    
    private  RegistoRecursos regRecursos;
    private  RegistoExposicoes regExposicoes;
    private RegistoUtilizadores regUtilizadores;
    private  RegistoStands regStands;
    private RegistoMecanismosAtribuicao regMecAtribuicoes;
    private RegistoTiposConflito regTiposConflitos;

    public CentroExposicoes() {
        regUtilizadores = new RegistoUtilizadores();
        regExposicoes = new RegistoExposicoes();
        regRecursos = new RegistoRecursos();
        regStands=new RegistoStands();
        regMecAtribuicoes=new RegistoMecanismosAtribuicao();
        regTiposConflitos=new RegistoTiposConflito();
    }

    public RegistoUtilizadores getRegistoUtilizadores() {
        return this.regUtilizadores;
    }
//
//    public ListaCandidaturas getListaCandidaturas() {
//        return this.m_regCandidaturas;
//    }
    
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
        return this.registoTipoConflitos;
    }

    /**
     * Verifica se a empresa é igual a um objeto passado por parâmetro
     *
     * @param o O objeto que vai ser comparado com a empresa.
     * @return True se forem iguais, false se não forem.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        CentroExposicoes outroCentro = (CentroExposicoes) o;
        return this.getRegistoUtilizadores().equals(outroCentro.getRegistoUtilizadores())
                && this.getRegistoExposicoes().equals(outroCentro.getRegistoExposicoes());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.regExposicoes);
        hash = 53 * hash + Objects.hashCode(this.regUtilizadores);
        return hash;
    }



    @Override
    public String toString() {
        return "Empresa:" + "regUtilizadores=" + regUtilizadores
                + ", regExposicoes=" + regExposicoes /**+ "m_regCandidaturas=" + m_regCandidaturas**/;
    }
}
