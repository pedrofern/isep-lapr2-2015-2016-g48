package lapr.project.model;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.ListaKeywords;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FAE implements Comparable<FAE>,Serializable {

    private final String nome, email, username;
    private Utilizador o_utilizador;
    private final String NOME_POR_OMISSAO = "sem nome";
    private static final String EMAIL_POR_OMISSAO = "Email do utilizador não registado";
    private static final String USER_POR_OMISSAO = "Username do utilizador não registado";
    private FAE m_fae;
    private int nCand;
    private Classificacao classificacao;

    public FAE(Utilizador u) {
        this.o_utilizador = u;
        nome = u.getNome();
        username = u.getUsername();
        email = u.getEmail();
        nCand=0;
        classificacao=new Classificacao();
    }

    public FAE(String strId, Utilizador u) {
        nome = u.getNome();
        username = u.getUsername();
        email = u.getEmail();
        this.setUtilizador(u);
        nCand=0;
        classificacao=new Classificacao();
    }

    public FAE() {
        nome = NOME_POR_OMISSAO;
        username =USER_POR_OMISSAO;
        email = EMAIL_POR_OMISSAO;
        nCand=0;
        classificacao=new Classificacao();
    }

    public void setUtilizador(Utilizador u) {
        o_utilizador = u;
    }

    public boolean validaMenbroFAE() {
        if (nome == null || username == null || email == null) {
            return false;
        } else {
            return true;
        }
    }
   

    public String getNome() {
        return nome;
    }

    public Utilizador getUtilizador() {
        return o_utilizador;
    }

  
    public int getNAtribuidas(){
        return nCand;
    }
    
    public void incrementaNAtribuidas(){
        nCand++;
    }
    
    public Classificacao getClassificacao(){
        return classificacao;
    }

    @Override
    public String toString() {
        return ("Utilizador: " + this.o_utilizador.toString());
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object outroObjeto) {

        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        FAE outroFAE = (FAE) outroObjeto;
        return this.getEmail().equals(outroFAE.getEmail());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.m_fae);
        return hash;
    }


    public boolean isUtilizador(Utilizador u) {
        if (this.o_utilizador != null) {
            return this.o_utilizador.equals(u);
        }
        return false;
    }

    public int getTempoServico() {
        return o_utilizador.getTempoServico();
    }

    @Override
    public int compareTo(FAE o) {
        return this.getTempoServico() - o.getTempoServico();
    }

}
