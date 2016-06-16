/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

/**
 *
 * @author DianaSilva
 */
public interface ExposicaoEstado {
    
   public  boolean estaValidaParaCriada();
    
    public boolean estaValidaParaEstadoFAESemDemonstracao();
    
    public boolean estaValidaParaEstadoDemonstracaoSemFae();
    
    public boolean estaValidaParaEstadoRegistada();
    
    public boolean estaValidaParaEstadoCandidaturasAbertas();
    
    public boolean estaValidaParaEstadoCandidaturasFechadas();
    
    public boolean estaValidaParaEstadoConflitosDetetados();
    
    public boolean estaValidaParaEstadoConflitosAlterados();
    
    public boolean estaValidaParaEstadoCandidaturasAtribuidas();
    
    public boolean estaValidaParaEstadoCandidaturasEmAvaliacao();
    
    public boolean estaValidaParaEstadoCandidaturasAvaliadas();
    
    public boolean estaValidaParaEstadoCandidaturasNaoAvaliadas();
    
    public boolean estaValidaParaEstadoCandidaturasEmDecisao();
    
    public boolean estaValidaParaEstadoCandidaturasDecididas();
    
    public boolean estaValidaParaEstadoStandsAtribuiveis();
    
    public boolean estaValidaParaEstadoStandsAtribuidos();
    
    public String toString();

}
