/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
public interface CandidaturaDemoEstado {    
    
    public  boolean validaEstadoCandidaturaDemo();
    
   @Override
    public String toString();

}
