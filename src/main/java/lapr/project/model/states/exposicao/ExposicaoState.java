/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states.exposicao;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.Exposicao;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
public interface ExposicaoState extends Serializable{
    
    /**
     * metodo que valida o estado
     *
     * @param e Exposicao
     * @return true se o estado for valido
     */
    public boolean valida(Exposicao e);

    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    public boolean setExposicaoEstadoInicial(Exposicao e);
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    public boolean setExposicaoCriada(Exposicao e);
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    public boolean setExposicaoFAESemDemonstracao(Exposicao e);
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    public boolean setExposicaoDemonstracaoSemFAE(Exposicao e);
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    public boolean setExposicaoCompleta(Exposicao e);
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    public boolean setExposicaoCandidaturasAberta(Exposicao e);
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    public boolean setExposicaoCandidaturasFechadas(Exposicao e);
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    public boolean setExposicaoConflitosDetetados(Exposicao e);
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    public boolean setExposicaoConflitosAlterados(Exposicao e);
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    public boolean setExposicaoCandidaturasEmAtribuicao(Exposicao e);
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    public boolean setExposicaoCandidaturasAtribuidas(Exposicao e);
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    public boolean setExposicaoCandidaturasAvaliadas(Exposicao e);
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    public boolean setExposicaoCandidaturasDecididas(Exposicao e);
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    public boolean setExposicaoStandsAtribuidos(Exposicao e);
    
    /**
     * metodo que modifica Exposicao criada
     *
     * @param e Exposicao
     * @return
     */
    public boolean setExposicaoTerminada(Exposicao e);
    
}
