package lapr.project.model;

import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.lists.RegistoStands;

/**
 *
 * @author Dians
 */
public class Stand {
    
     private String descricao;
    private String area;
    private RegistoStands mListaStands;
    private Exposicao expo;
    private GestorDeExposicoes gestor;
    
    private String ID = "Stand-";
    private static int totalDemonstracao = 0;
    
    public Stand(){
        ID = ID + totalDemonstracao++;
        this.descricao=descricao;
        this.mListaStands=new RegistoStands();
    }
    
 public void setDados(String descricao, String area) {
       this.descricao=descricao;
       this.area=area;
    }
 
 public boolean addStand(Stand s) {
        return mListaStands.adicionarStand(s);
    }
    
    public String getDescricao() {
        return descricao;
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
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }
    
    public boolean valida() {
        return true;
    }
    
    @Override
    public String toString() {
        return ("Descricao: "+this.descricao+"\nArea: "+this.area);
        
    }
    
    public void setExpo(Exposicao e){
        expo =e;
    }
}
