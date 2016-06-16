/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import lapr.project.model.Exposicao;

/**
 *
 * @author Diana Silva
 */
public class ExposicaoFAESemDemonstracao implements ExposicaoEstado{
    
    private final Exposicao exposicao;
    
    public ExposicaoFAESemDemonstracao(Exposicao exposicao){
        this.exposicao=exposicao;
    }
    
    public boolean setRegistada(){
        if(estaValidaParaCriada()){
            return exposicao.alterarEstado((ExposicaoEstado) new ExposicaoDemonstracaoSemFAE(exposicao));
        }
        return false;
    }
    
    public boolean setEstadoCriada(){
        if(estaValidaParaCriada()){
            return exposicao.alterarEstado((ExposicaoEstado) new ExposicaoEstadoRegistada(exposicao));
        }
        return false;
    }
    
    @Override
    public boolean estaValidaParaCriada() {
        return true;
    }

    @Override
    public boolean estaValidaParaEstadoFAESemDemonstracao() {
       return false;
    }

    @Override
    public boolean estaValidaParaEstadoDemonstracaoSemFae() {
        return false;
    }

    @Override
    public boolean estaValidaParaEstadoRegistada() {
        return true;
    }

    @Override
    public boolean estaValidaParaEstadoCandidaturasAbertas() {
        return false;
    }

    @Override
    public boolean estaValidaParaEstadoCandidaturasFechadas() {
        return false;
    }

    @Override
    public boolean estaValidaParaEstadoConflitosDetetados() {
        return false;
    }

    @Override
    public boolean estaValidaParaEstadoConflitosAlterados() {
        return false;
    }

    @Override
    public boolean estaValidaParaEstadoCandidaturasAtribuidas() {
        return false;
    }

    @Override
    public boolean estaValidaParaEstadoCandidaturasEmAvaliacao() {
        return false;
    }

    @Override
    public boolean estaValidaParaEstadoCandidaturasAvaliadas() {
        return false;
    }

    @Override
    public boolean estaValidaParaEstadoCandidaturasNaoAvaliadas() {
        return false;
    }

    @Override
    public boolean estaValidaParaEstadoCandidaturasEmDecisao() {
        return false;
    }

    @Override
    public boolean estaValidaParaEstadoCandidaturasDecididas() {
        return false;
    }

    @Override
    public boolean estaValidaParaEstadoStandsAtribuiveis() {
        return false;
    }

    @Override
    public boolean estaValidaParaEstadoStandsAtribuidos() {
        return false;
    }
    
   @Override
    public String toString(){
        return "Estado; exposição com FAE definido, sem demonstração";
    }
}
