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
   
    

    public DefinirRecursoController(CentroExposicoes centroDeExposicoes) {
        mce = centroDeExposicoes;
        
    }
    
    public RegistoRecursos getRegistoRecursos(){
        return regRecursos=mce.getRegistoRecursos();
    }

    
    public String getRecurso() {
        return mRecurso.getDescricao();
    }
    
    
    public void setRecurso(String novaDescricao) {
       mRecurso.setDescricao(novaDescricao);
    }
   
    
    public Recurso novoRecurso(){
       regRecursos=mce.getRegistoRecursos();
       return mRecurso= regRecursos.novoRecurso();
        
        
    }
    
    public void adicionarRecurso(){
        regRecursos.addRecurso(mRecurso);
    }
    
    

}
