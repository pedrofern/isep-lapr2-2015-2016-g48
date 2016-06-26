/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.*;

/**
 *
 * @author anasilva
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RegistoStands {
    
    private ArrayList<Stand> listaStands;
    private Stand mStand;
    /**
     * Construtor relativo a lista de Stands
     */
    public RegistoStands() {
        listaStands = new ArrayList<>();
    }
    /**
     * Metodo que retorna o stand no indice passado por parametro
     * @param indice indice
     * @return o stand no indice passado por parametro
     */
    public Stand obterStand(int indice) {
        return listaStands.get(indice);
    }
    /**
     * Metodo que retorna o array de Stand
     * @return o array de Stand
     */
    public Stand[] getArray() {
        return listaStands.toArray( new Stand[listaStands.size()] );
    }
    /**
     * Metodo que retorna a lista de Stands
     * @return lista stands
     */
    public ArrayList<Stand> getListaStands(){
        return listaStands;
    }
    /**
     * Metodo para adicionar o stand passado por parametro a lista de stands
     * @param stand stand
     * @return true se o stand for adicionado false em caso contrario
     */
    public boolean adicionarStand(Stand s){
        
       if(!listaStands.contains(s)){
            return listaStands.add(s);
        }
       
       return false;
    }
    
    /**
     * Metodo que cria um novo stand
     * @return novo stand
     */
    public Stand novoStand() {
        
    
       return  new Stand();
        
       
    }
    
     /**
     * Metodo para remover o stand passado por parametro a lista de stands
     * @param stand stand
     * @return true se o stand for removido false em caso contrario
     */
    public boolean removerStand(Stand stand) {
        return listaStands.remove(stand);
    }
    /**
     * Metodo para retornar o tamanho da lista de stands
     * @return o tamanho da lista de stands
     */
    public int tamanho() {
        return this.listaStands.size();
    }
    /**
     * Metodo que retorna o indice do stand passado por parametro
     * @param stand stand
     * @return o indice do stand passado por parametro
     */
    public int indiceDeStand(Stand stand) {
        return listaStands.indexOf(stand);
    }
    /**
     * Metodo que verifica se o stand passado por  parametro existe na lista 
     * @param stand stand
     * @return true se existir false em caso contrario
     */
    public boolean contem(Stand stand){
        return listaStands.contains(stand);
    }
}
