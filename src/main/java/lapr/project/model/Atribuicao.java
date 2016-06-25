package lapr.project.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DianaSilva
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Atribuicao implements Serializable{

   
    private Avaliacao avaliacao;
    private FAE fae;
    private Candidatura candidatura;
    private boolean atribuida=false;
    
    public Atribuicao(){
        
    }
    
    public Atribuicao(FAE fae, Candidatura c){
        this.avaliacao=new Avaliacao();
        this.fae=fae;
        candidatura=c;            
    }
    
    public void setAtribuida(){
        this.atribuida=true;
    }
    
    public FAE getFae(){
        return fae;
    }
    
    public Candidatura getCandidatura(){
        return candidatura;
    }
    
    public boolean getEstadoAtribuicao(){
        return atribuida;
    }
    
    public void setFae(FAE fae){
        this.fae=fae;
    }
    
    public void setCandidatura(Candidatura candidatura){
        this.candidatura=candidatura;
    }

    @Override
    public String toString() {
        return this.candidatura.toString() + " - atribuída ao - " + fae.toString() + "\n";
    }

}
