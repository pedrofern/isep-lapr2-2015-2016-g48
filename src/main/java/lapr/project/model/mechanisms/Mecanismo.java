/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.mechanisms;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pedro Fernandes
 */
@XmlTransient
@XmlSeeAlso({MecanismoCarga.class, MecanismoDetecaoConflito.class,
    MecanismoRanking.class, MecanismoTempoServico.class})
public abstract class Mecanismo implements MecanismoAtribuicao{
    
    @Override
    public boolean atribui() {
        return false;
    }
    
}
