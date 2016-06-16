/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import lapr.project.model.Exposicao;
import lapr.project.utils.Data;
import lapr.project.utils.Utils;

/**
 *
 * @author Diana Silva
 */
public class ExposicaoEstadoRegistada implements ExposicaoEstado {
    
    private final Exposicao exposicao;
    
    public ExposicaoEstadoRegistada(Exposicao exposicao){
        this.exposicao=exposicao;
    }
    
    public boolean setFAESemDemonstracao(){
        if(estaValidaParaEstadoFAESemDemonstracao()){
            return exposicao.alterarEstado((ExposicaoEstado) new ExposicaoFAESemDemonstracao(exposicao));
        }
        return false;
    }
    

    @Override
    public boolean estaValidaParaCriada() {
        return false;
    }

    @Override
    public boolean estaValidaParaEstadoFAESemDemonstracao() {
        return true;
    }

    @Override
    public boolean estaValidaParaEstadoDemonstracaoSemFae() {
        return false;
    }

    @Override
    public boolean estaValidaParaEstadoRegistada() {
        return false;
    }

    @Override
    public boolean estaValidaParaEstadoCandidaturasAbertas() {
        Data dataAtual=Utils.getdataAtual();
        
        return Data.dataAtual().isMaior(exposicao.getDataInicioSubmissao()) && exposicao.getDataFimSubmissao().isMaior(dataAtual); 
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
        return "Estado: Exposição Registada (com FAE e demonstração)";
    }
}
