package lapr.project.model.lists;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.Atribuicao;
import lapr.project.model.Candidatura;
import lapr.project.model.FAE;
import lapr.project.model.Stand;
import lapr.project.model.Utilizador;

/**
 *
 * @author DianaSilva
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaAtribuicoes implements Serializable{
    private ArrayList<Atribuicao> listaAtribuicoes;

    public ListaAtribuicoes() {
        this.listaAtribuicoes = new ArrayList<>();
    }

    public boolean createAtribuicaoFAECand(FAE f, Candidatura c){
        Atribuicao atrib=new Atribuicao(f,c);
        this.listaAtribuicoes.add(atrib);
        return true;
    }
    
    public boolean createAtribuicaoStandCand(FAE f, Candidatura c){
        Atribuicao atrib=new Atribuicao(f,c);
        this.listaAtribuicoes.add(atrib);
        return true;
    }
    
    public List<Atribuicao> getListaAtribuicoes(){
        return new ArrayList(listaAtribuicoes);
    }
    
    public int tamanho(){
        return this.listaAtribuicoes.size();
    }
    
    public Atribuicao obterAtribuicao(int indice){
        return listaAtribuicoes.get(indice);
    }
    
    public boolean adicionarAtribuicao(Atribuicao atribuicao){
        if (!listaAtribuicoes.contains(atribuicao)){
            return listaAtribuicoes.add(atribuicao);
        }
        return false;
    }
    
    public Atribuicao removerAtribuicao(int indice){
        return this.listaAtribuicoes.remove(indice);
    }
    
    public boolean removerAtribuicao(Atribuicao atribuicao){
        return listaAtribuicoes.remove(atribuicao);
    }
    
    public boolean removerTodasAtribuicoes(ListaAtribuicoes listaAtribuicoes){
        return this.listaAtribuicoes.removeAll(listaAtribuicoes.getListaAtribuicoes());
    }
    
     public int obterIndiceAtribuicao(Atribuicao atrib){
        return this.listaAtribuicoes.indexOf(atrib);
    }

    public boolean adicionharListaAtribuicoes(ListaAtribuicoes listaAtribuicoesNovas) {
        return this.listaAtribuicoes.addAll(listaAtribuicoesNovas.getListaAtribuicoes());
    }
    
    public ListaCandidaturas getCandidaturasAtribuidasFAE(Utilizador u){
        ListaCandidaturas lc=new ListaCandidaturas();
        for(Atribuicao a: listaAtribuicoes){
            if(a.getFae().getEmail().equalsIgnoreCase(u.getEmail())){
                lc.addCandidatura(a.getCandidatura());
            }
        }
        return lc;
    }
}
