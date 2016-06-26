package lapr.project.model;

import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lapr.project.model.lists.RegistoTipoConflitos;
import lapr.project.model.lists.RegistoMecanismosAtribuicao;
import lapr.project.model.lists.*;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CentroExposicoes implements Serializable{
    
    private static String descricao;
    private RegistoRecursos regRecursos;
    private RegistoExposicoes regExposicoes;
    private RegistoUtilizadores regUtilizadores;
    private RegistoStands regStands;
    @XmlTransient
    private RegistoMecanismosAtribuicao regMecAtribuicoes;
    private RegistoTipoConflitos regTiposConflitos;
    private static int contador=0;

    public CentroExposicoes() {
        contador++;
        descricao="CentroExposições" + contador;
        regUtilizadores = new RegistoUtilizadores();
        regExposicoes = new RegistoExposicoes();
        regRecursos = new RegistoRecursos();
        regStands=new RegistoStands();
        regMecAtribuicoes=new RegistoMecanismosAtribuicao();
        regTiposConflitos=new RegistoTipoConflitos();
    }

    public RegistoRecursos getRegistoRecursos() {
        return this.regRecursos;
    }
    
    public RegistoExposicoes getRegistoExposicoes(){
        return this.regExposicoes;
    }
    
    public RegistoStands getRegistoStands(){
        return this.regStands;
    }

    public RegistoMecanismosAtribuicao getMecanismosAtribuicao(){
        return this.regMecAtribuicoes;
    }

    /**
     * @return o registo de tipo de conflitos do centro de exposicoes;
     */
    public RegistoTipoConflitos getRegistoTipoConflitos() {
        return regTiposConflitos;
    }
    
    public RegistoUtilizadores getRegistoUtilizadores(){
        return regUtilizadores;
    }
    
    public RegistoUtilizadores getRegistoUtilizadoresRegistados() {
        RegistoUtilizadores ru=new RegistoUtilizadores();
        regUtilizadores.getListaUtilizadores().stream().filter((u) -> (u.getRegistado()==true)).forEach((u) -> {
            ru.registaUtilizador(u);
        });
        return ru;
    }
    
    public RegistoUtilizadores getRegistoUtilizadoresNaoRegistados() {
        RegistoUtilizadores ru=new RegistoUtilizadores();
        regUtilizadores.getListaUtilizadores().stream().filter((u) -> (!u.getRegistado()==true)).forEach((u) -> {
            ru.registaUtilizador(u);
        });
        return ru;
    }
    
    /**
     * Obtém a descrição do Centro de Exposições
     * @return 
     */
    public String getDescricao(){
        return descricao;
    }

    /**
     * Verifica se a empresa é igual a um objeto passado por parâmetro
     *
     * @param outroCentro
     * @return True se forem iguais, false se não forem.
     */
    @Override
    public boolean equals(Object outroCentro) {
        if (this == outroCentro) {
            return true;
        }
        if (outroCentro == null || getClass() != outroCentro.getClass()) {
            return false;
        }

        CentroExposicoes ce = (CentroExposicoes) outroCentro;
        return this.getDescricao().equalsIgnoreCase(ce.getDescricao());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.regRecursos);
        hash = 47 * hash + Objects.hashCode(this.regExposicoes);
        hash = 47 * hash + Objects.hashCode(this.regUtilizadores);
        hash = 47 * hash + Objects.hashCode(this.regStands);
        hash = 47 * hash + Objects.hashCode(this.regMecAtribuicoes);
        hash = 47 * hash + Objects.hashCode(this.regTiposConflitos);
        return hash;
    }


    public void setRegistoExposicoes (RegistoExposicoes re){
        regExposicoes=re;
    }


    @Override
    public String toString() {
        String ce= descricao;
        for(Exposicao e: getRegistoExposicoes().getExposicoes()){
            ce+=e.toString();
        }
        ce+="\nUtilizadores Registados: \n";
        for(Utilizador u: getRegistoUtilizadoresRegistados().getListaUtilizadores()){
            ce+=u.toString();
        }
        
        ce+="\nUtilizadores Não Registados: \n";
        for(Utilizador u: getRegistoUtilizadoresNaoRegistados().getListaUtilizadores()){
            ce+=u.toString();
        }
        
        for(Exposicao e: getRegistoExposicoes().getExposicoes()){
            ce+=e.toString();
        }
        
        return ce;
    }
}
