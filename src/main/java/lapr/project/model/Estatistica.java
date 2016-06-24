/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.lists.ListaFAE;

/**
 *
 * @author DianaSilva
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Estatistica {
    
    private Exposicao exposicao;
    private ListaFAE listaFaes;
    private FAE fae;
    
    private double mediaGeral;
    private double desvioFae;
    private double desvioGeral;
    private double varianciaFaes;
    private double desvioPadrao;
    
    private static final int MEDIA_POPULACIONAL=1;
    private double nivelSignificancia;
    private double intervaloConfianca;
    private double zonaCritica;
    private double z0;
    
    
    public Estatistica(Exposicao e, FAE fae, double intervaloConfianca){
        this.fae=fae;
        this.exposicao=e;
        listaFaes=e.getListaFAE();
        mediaGeral=0;
        desvioGeral=0;
        varianciaFaes=0;
        desvioPadrao=0;
        nivelSignificancia=0;
        zonaCritica=0;
        z0=0;
        this.intervaloConfianca=intervaloConfianca;
    }
    public Estatistica(){
        
    }

}
