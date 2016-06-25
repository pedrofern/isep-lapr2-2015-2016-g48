package lapr.project.controller;


import lapr.project.model.*;
import lapr.project.model.lists.RegistoRecursos;

/**
 *
 * @author Pedro Fernandes
 */
public class DefinirRecursoController {

    private CentroExposicoes mce;
    private Recurso mRecurso;
    private RegistoRecursos regRecursos;
   
    
/**
 * Cria nova instancia de definirrecursoController
 * @param centroDeExposicoes 
 */
    public DefinirRecursoController(CentroExposicoes centroDeExposicoes) {
        mce = centroDeExposicoes;
        
    }
    /**
     * Devolve lista de recursos
     * @return lista de recursos
     */
    public RegistoRecursos getRegistoRecursos(){
        return regRecursos=mce.getRegistoRecursos();
    }

    /**
     * Devolve recurso
     * @return recurso
     */
    public String getRecurso() {
        return mRecurso.getDescricao();
    }
    
    /**
     * Altera recurso
     * @param novaDescricao 
     */
    public void setRecurso(String novaDescricao) {
       mRecurso.setDescricao(novaDescricao);
    }
   
    /**
     * Cria um novo recurso
     * @return recurso criado
     */
    public Recurso novoRecurso(){
       regRecursos=mce.getRegistoRecursos();
       return mRecurso= regRecursos.novoRecurso();
        
        
    }
    /**
     * Adiciona recurso a lista de recursos
     */
    public void adicionarRecurso(){
        regRecursos.addRecurso(mRecurso);
    }
    
    

}
