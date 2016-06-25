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
    
    /**
     * Descricao do stand
     */
    private String descricao;
    /**
     * Descricao da area
     */
    private String area;
    
    /**
     * ID do stand
     */
    private String ID = "Stand-";
    private static int totalDemonstracao = 0;

    /**
     * Constroi uma instancia de Stand, com parametro descricao e area
     * @param descricao
     * @param area 
     */
    public Stand(String descricao,String area) {
        ID = ID + totalDemonstracao++;
        this.descricao = descricao;
        this.area=area;
        
    }

    /**
     * Constroi uma instancia de Stand vazia
     */
    public Stand() {

    }
/**
 * Altera a descricao do stand
 * @param novaDescricao 
 */
    public void setDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }
/**
 * Devolve a descricao do Stand
 * @return 
 */
    public String getDescricao() {
        return descricao;
    }
    /**
     * Altera a area do stand
     * @param novaArea 
     */
    public void setArea(String novaArea) {
        this.area = novaArea;
    }
    /**
     * Devolve a area do Stand
     * @return 
     */
    public String getArea(){
        return area;
    }
    
/**
 * Valida a descricao e a area do stand
 * @return true se forem validos e false se nao forem
 */
    public boolean valida() {
        if (descricao == null || descricao.trim().isEmpty() || area==null || area.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    /**
     * Devolve a descricao textual do stand
     */
    public String toString() {
        return "Descricao: "+this.getDescricao()+"\n"
                + "Area: "  +this.area;
    }

    /**
     * Compara o Stand com outro objecto
     * @param outroObjeto
     * @return true se o objecto recebido é equivalente a descricao e false caso contrario 
     */
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
/**
 * Calcula o hashcode de descricao
 * @return hash
 */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.descricao);
        
        return hash;
    }

/**
 * Compara a descricao e a area de um Stand com outra descricao e area de outro Stand
 * @param stand
 * @return 0 se forem iguais ou maior que 0 ou menor que 0, caso contrario 
 */
    public int compareTo(Stand stand) {
        return descricao.compareTo(stand.descricao)+area.compareTo(stand.area);
    }

}
