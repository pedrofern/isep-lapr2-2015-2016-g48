/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states.demonstracao;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlSeeAlso;
import lapr.project.model.Demonstracao;

/**
 *
 * @author Pedro Fernandes
 */
@XmlTransient
@XmlSeeAlso({DemonstracaoCriada.class, DemonstracaoRegistada.class,
    DemonstracaoEmInteresse.class, DemonstracaoDecididas.class,
    DemonstracaoEmAberto.class, DemonstracaoFechadas.class})
public abstract class DemonstracaoEstado implements DemonstracaoState{
    /**
     * metodo que valida o estado
     *
     * @param d Demonstracao
     * @return true se o estado for valido
     */
    @Override
    public boolean valida(Demonstracao d){
        return false;
    }

    /**
     * metodo que modifica Demonstracao criada
     *
     * @param d Demonstracao
     * @return
     */
    @Override
    public boolean setDemonstracaoCriada(Demonstracao d){
        return false;
    }
    
    /**
     * metodo que modifica Demonstracao registada
     *
     * @param d Demonstracao
     * @return
     */
    @Override
    public boolean setDemonstracaoRegistada(Demonstracao d){
        return false;
    }
    
    /**
     * metodo que modifica Demonstracao em interesse
     *
     * @param d Demonstracao
     * @return
     */
    @Override
    public boolean setDemonstracaoEmInteresse(Demonstracao d){
        return false;
    }
    
    /**
     * metodo que modifica Demonstracao criada
     *
     * @param d Demonstracao
     * @return
     */
    @Override
    public boolean setDemonstracaoDecididas(Demonstracao d){
        return false;
    }
    
    /**
     * metodo que modifica Demonstracao criada
     *
     * @param d Demonstracao
     * @return
     */
    @Override
    public boolean setDemonstracaoEmAberto(Demonstracao d){
        return false;
    }
    
    /**
     * metodo que modifica CandidaturaDemonstracao criada
     *
     * @param d Demonstracao
     * @return
     */
    @Override
    public boolean setDemonstracaoFechadas(Demonstracao d){
        return false;
    }

    
}
