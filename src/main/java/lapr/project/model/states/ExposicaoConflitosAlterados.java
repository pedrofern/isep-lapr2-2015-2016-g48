/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.util.TimerTask;
import lapr.project.model.Exposicao;

/**
 *
 * @author Diana Silva
 */
public class ExposicaoConflitosAlterados extends TimerTask implements ExposicaoEstado{
    
    private final Exposicao exposicao;
    
    public ExposicaoConflitosAlterados(Exposicao exposicao){
        this.exposicao=exposicao;
    }
    
    @Override
    public void run() {
        setConflitosAlterados();
    }
    
    public boolean setConflitosAlterados(){
        ExposicaoEstado estadoAtual=exposicao.getEstadoAtualExposicao();
        
        if(estadoAtual.estaValidaParaEstadoConflitosAlterados()==true)
            exposicao.alterarEstado((ExposicaoEstado) new ExposicaoConflitosAlterados(exposicao));
        
        return false;
    }
    
    
    public boolean setCandidaturasEmAtribuicao(){
        ExposicaoEstado estadoAtual=exposicao.getEstadoAtualExposicao();
        
        if(estadoAtual.estaValidaParaEstadoCandidaturasAtribuidas()==true)
            exposicao.alterarEstado((ExposicaoEstado) new ExposicaoCandidaturasEmAtribuicao(exposicao));
        
        return false;
    }
    
  
     @Override
    public boolean estaValidaParaCriada() {
        return false;
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
        return false;}

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
        return true;
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
        return "Estado: conflitos alterados";
    }

}
