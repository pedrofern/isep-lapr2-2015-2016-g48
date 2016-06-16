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
 * @author Worten
 */
public class ExposicaoCandidaturasEmAvaliacao extends TimerTask implements ExposicaoEstado{
    
    private final Exposicao exposicao;
    
    public ExposicaoCandidaturasEmAvaliacao(Exposicao exposicao){
        this.exposicao=exposicao;
    }

    @Override
    public void run() {
        setCandidaturasEmAvaliacao();
    }
    
    public boolean setCandidaturasEmAvaliacao(){
        ExposicaoEstado estadoAtual=exposicao.getEstadoAtualExposicao();
        
        if(estadoAtual.estaValidaParaEstadoCandidaturasEmAvaliacao()==true)
            exposicao.alterarEstado((ExposicaoEstado) new ExposicaoCandidaturasEmAvaliacao(exposicao));
        
        return false;
    }
    
    public boolean setCandidaturasAvaliadas(){
        ExposicaoEstado estadoAtual=exposicao.getEstadoAtualExposicao();
        
        if(estadoAtual.estaValidaParaEstadoCandidaturasAvaliadas()==true)
            exposicao.alterarEstado((ExposicaoEstado) new ExposicaoCandidaturasAvaliadas(exposicao));
        
        return false;
    }
    
    public boolean setCandidaturasNaoAvaliadas(){
        ExposicaoEstado estadoAtual=exposicao.getEstadoAtualExposicao();
        
        if(estadoAtual.estaValidaParaEstadoCandidaturasNaoAvaliadas()==true)
            exposicao.alterarEstado((ExposicaoEstado) new ExposicaoEstadoTerminada(exposicao));
        
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
        return false;
    }

    @Override
    public boolean estaValidaParaEstadoCandidaturasEmAvaliacao() {
        return false;
    }

    @Override
    public boolean estaValidaParaEstadoCandidaturasAvaliadas() {
        return true;
    }

    @Override
    public boolean estaValidaParaEstadoCandidaturasNaoAvaliadas() {
        return true;
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
        return "Estado: candidaturas em avaliação";
    }

}
