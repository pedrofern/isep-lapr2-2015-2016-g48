package lapr.project.model;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.lists.RegistoStands;

/**
 *
 * @author Dians
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Stand implements Serializable{
    
    private String descricao;
    private String area;
    
    private String ID = "Stand-";
    private static int totalDemonstracao = 0;

    public Stand(String descricao,String area) {
        ID = ID + totalDemonstracao++;
        this.descricao = descricao;
        this.area=area;
        
    }

    public Stand() {

    }

    public void setDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public void setArea(String novaArea) {
        this.area = novaArea;
    }
    
    public String getArea(){
        return area;
    }
    

    public boolean valida() {
        if (descricao == null || descricao.trim().isEmpty() || area==null || area.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Descricao: "+this.getDescricao()+"\n"
                + "Area: "  +this.area;
    }

    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Stand stand = (Stand) outroObjeto;

        return descricao.equalsIgnoreCase(stand.descricao);
        
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.descricao);
        
        return hash;
    }


    public int compareTo(Stand stand) {
        return descricao.compareTo(stand.descricao)+area.compareTo(stand.area);
    }

}
