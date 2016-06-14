package lapr.project.model;

import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.lists.RegistoStands;

/**
 *
 * @author Dians
 */
public class Stand {
    
    private String id;
    private String descricao;
    private float area;
    
    
    public Stand(String id, String descricao, float area){
        this.id=id;
        this.descricao=descricao;
        this.area=area;
    }
    public Stand(){
    }
    
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the area
     */
    public float getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(float area) {
        this.area = area;
    }
    
    public boolean valida() {
        return true;
    }
    
    @Override
    public String toString() {
        String str;
       str= this.getDescricao();
        return str;
        
    }
}
