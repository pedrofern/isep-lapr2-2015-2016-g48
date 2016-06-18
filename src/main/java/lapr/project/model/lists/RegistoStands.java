package lapr.project.model.lists;

import java.util.ArrayList;
import lapr.project.model.Stand;

/**
 *
 * @author Tomas
 */
public class RegistoStands {
    
    private ArrayList<Stand> listaStands;
    private Stand m_s;
    /**
     * Construtor relativo a lista de stands
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
     * Metodo que retorna a lista de stands
     * @return lista stands
     */
    public ArrayList<Stand> getListaStands(){
        return listaStands;
    }
    /**
     * Metodo para adicionar o stand passado por parametro a lista de stands
     * @param stand stand
     * @return true se o conflito for adicionado false em caso contrario
     */
    
    public boolean adicionarStand(Stand stand){
        
        if(!listaStands.contains(stand)){
            return listaStands.add(stand);
        }return false;
    }
    
    public Stand novoStand() {
        
    
        m_s= new Stand();
        
       listaStands.add(m_s);
        
       return m_s;
       
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
     * Metodo para retornar o tamanho da lista de cstands
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
