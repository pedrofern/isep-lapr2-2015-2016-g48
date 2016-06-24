/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.mechanisms.MecanismoAtribuicao;
import lapr.project.model.mechanisms.MecanismoCarga;
import lapr.project.model.mechanisms.MecanismoRanking;
import lapr.project.model.mechanisms.MecanismoTempoServico;

/**
 *
 * @author Diana
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RegistoMecanismosAtribuicao implements Serializable{
     
     private ArrayList<MecanismoAtribuicao> registoMecanismosAtribuicao;
     
//     private ArrayList<Object> registoMecanismosAtribuicao;
     
     public RegistoMecanismosAtribuicao(){
         registoMecanismosAtribuicao=new ArrayList<MecanismoAtribuicao>(); 
         
        MecanismoCarga m1=new MecanismoCarga();
        MecanismoTempoServico m2= new MecanismoTempoServico();
        MecanismoRanking m3=new MecanismoRanking();
        registoMecanismosAtribuicao.add(m1);
        registoMecanismosAtribuicao.add(m2);
        registoMecanismosAtribuicao.add(m3);
        
     }
     
    public void addMecanismo1(MecanismoCarga t){
        this.registoMecanismosAtribuicao.add(t);
    }
    
    public void addMecanismo2(MecanismoTempoServico t){
        this.registoMecanismosAtribuicao.add(t);
    }
    
    public void addMecanismo3(MecanismoRanking t){
        this.registoMecanismosAtribuicao.add(t);
    }

    
    public ArrayList<MecanismoAtribuicao> getRegistoMecanismos(){
        return registoMecanismosAtribuicao;
    }

    public String listaMecanismostoString(){
        String mecs="Mecanismos: ";
        for (Object m: registoMecanismosAtribuicao){
            mecs+=m.toString();
        }
        return mecs;
    }

    public MecanismoAtribuicao[] getArray(){
        return registoMecanismosAtribuicao.toArray(new MecanismoAtribuicao[registoMecanismosAtribuicao.size()]);
    }
    
     
}
