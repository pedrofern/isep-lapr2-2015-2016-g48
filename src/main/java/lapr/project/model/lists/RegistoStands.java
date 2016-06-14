package lapr.project.model.lists;

import java.util.ArrayList;
import lapr.project.model.Stand;

/**
 *
 * @author Tomas
 */
public class RegistoStands {
    
    /**
     * 
     */
    private ArrayList<Stand> listaStands;
    private Stand stand;
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
    public Stand obterStands(int indice) {
        return listaStands.get(indice);
    }
    /**
     * Metodo que retorna o array de stand
     * @return o array de stand
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
     * @return true se o stand for adicionado false em caso contrario
     */
    
    
        
    /**
     * Metodo que adiciona o stand passado por parametro a lista
     * @param s stand
     * @return true se adicionar false caso contrario
     */
    public boolean addStand(Stand s) {
       if(!listaStands.contains(s)){
            return listaStands.add(s);
        }
       
       return false;
    }
    
    public Stand novoStand() {
        
    
        stand= new Stand();
        
       listaStands.add(stand);
        
       return stand;
       
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
    
    
    /**
     * Metodo que retorna um stand
     * @param stand stand
     * @return stand
     */
    public Stand getStand(String stand) {
        for (Stand s : listaStands) {
            if (s.getDescricao().equalsIgnoreCase(stand)) {
                return s;
            }
        }

        return null;

    }
    
    
    /**
     * Metodo que regista um stand
     * @param s stand
     * @return true se registar ou false caso contrario
     */
    public boolean registaStand(Stand s) {
        if (validaStand(s)) {
            addStand(s);
            return true;
        }
        return false;
    }
    /**
     * Metodo que valida stand
     * @param s stand
     * @return true se validar false caso contrario
     */
    public boolean validaStand(Stand s) {
        return !listaStands.contains(s);
    }
}
