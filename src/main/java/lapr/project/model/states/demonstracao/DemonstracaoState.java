/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states.demonstracao;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.Demonstracao;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
public interface DemonstracaoState extends Serializable{
    
    /**
     * metodo que valida o estado
     *
     * @param d Demonstracao
     * @return true se o estado for valido
     */
    public boolean valida(Demonstracao d);

    /**
     * metodo que modifica Demonstracao criada
     *
     * @param d Demonstracao
     * @return
     */
    public boolean setDemonstracaoCriada(Demonstracao d);
    
    /**
     * metodo que modifica Demonstracao registada
     *
     * @param d Demonstracao
     * @return
     */
    public boolean setDemonstracaoRegistada(Demonstracao d);
    
    /**
     * metodo que modifica Demonstracao em interesse
     *
     * @param d Demonstracao
     * @return
     */
    public boolean setDemonstracaoEmInteresse(Demonstracao d);
    
    /**
     * metodo que modifica Demonstracao criada
     *
     * @param d Demonstracao
     * @return
     */
    public boolean setDemonstracaoDecididas(Demonstracao d);
    
    /**
     * metodo que modifica Demonstracao criada
     *
     * @param d Demonstracao
     * @return
     */
    public boolean setDemonstracaoEmAberto(Demonstracao d);
    
    /**
     * metodo que modifica CandidaturaDemonstracao criada
     *
     * @param d Demonstracao
     * @return
     */
    public boolean setDemonstracaoFechadas(Demonstracao d);
 
}
