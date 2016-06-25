/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states.exposicao;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlSeeAlso;
import lapr.project.model.Exposicao;

/**
 *
 * @author Pedro Fernandes
 */
@XmlTransient
@XmlSeeAlso({ExposicaoEstadoInicial.class, ExposicaoCriada.class,
    ExposicaoFAESemDemonstracao.class, ExposicaoDemonstracaoSemFAE.class,
    ExposicaoCompleta.class, ExposicaoCandidaturasAberta.class,
ExposicaoCandidaturasFechadas.class,ExposicaoConflitosDetetados.class,
ExposicaoConflitosAlterados.class,ExposicaoCandidaturasEmAtribuicao.class,
ExposicaoCandidaturasAtribuidas.class,ExposicaoCandidaturasAvaliadas.class,
ExposicaoCandidaturasDecididas.class,ExposicaoStandsAtribuidos.class,
ExposicaoTerminada.class})
public class ExposicaoEstado implements ExposicaoState{
    /**
     * metodo que valida o estado
     *
     * @param e Exposicao
     * @return true se o estado for valido
     */
    @Override
    public boolean valida(Exposicao e){
        return false;
    }

    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    @Override
    public boolean setExposicaoEstadoInicial(Exposicao e){
        return false;
    }
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    @Override
    public boolean setExposicaoCriada(Exposicao e){
        return false;
    }
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    @Override
    public boolean setExposicaoFAESemDemonstracao(Exposicao e){
        return false;
    }
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    @Override
    public boolean setExposicaoDemonstracaoSemFAE(Exposicao e){
        return false;
    }
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    @Override
    public boolean setExposicaoCompleta(Exposicao e){
        return false;
    }
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    @Override
    public boolean setExposicaoCandidaturasAberta(Exposicao e){
        return false;
    }
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    @Override
    public boolean setExposicaoCandidaturasFechadas(Exposicao e){
        return false;
    }
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    @Override
    public boolean setExposicaoConflitosDetetados(Exposicao e){
        return false;
    }
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    @Override
    public boolean setExposicaoConflitosAlterados(Exposicao e){
        return false;
    }
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    @Override
    public boolean setExposicaoCandidaturasEmAtribuicao(Exposicao e){
        return false;
    }
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    @Override
    public boolean setExposicaoCandidaturasAtribuidas(Exposicao e){
        return false;
    }
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    @Override
    public boolean setExposicaoCandidaturasAvaliadas(Exposicao e){
        return false;
    }
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    @Override
    public boolean setExposicaoCandidaturasDecididas(Exposicao e){
        return false;
    }
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    @Override
    public boolean setExposicaoStandsAtribuidos(Exposicao e){
        return false;
    }
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    @Override
    public boolean setExposicaoTerminada(Exposicao e){
        return false;
    }
 
}
