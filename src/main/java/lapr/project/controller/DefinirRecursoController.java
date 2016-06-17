package lapr.project.controller;

import java.util.List;
import lapr.project.model.*;
import lapr.project.model.lists.RegistoRecursos;

/**
 *
 * @author Pedro Fernandes
 */
public class DefinirRecursoController {

    private static CentroExposicoes ce;
    private static Recurso recurso;
   
    

    public DefinirRecursoController(CentroExposicoes centroDeExposicoes) {
        ce = centroDeExposicoes;
        
    }

//    public Recurso novoRecurso(String strDescricao) {
//        return m_centroDeExposicoes.getRegistoRecurso().novoRecurso(strDescricao);
//    }
//
//    public boolean registaRecurso(Recurso recurso) {
//        return m_centroDeExposicoes.getRegistoRecurso().registaRecurso(recurso);
//    }
    
    public void setDescricao(String novaDescricao) {
        recurso.setDescricao(novaDescricao);
    }
    
//    public Recurso registaRecurso() {
//        if (m_centroDeExposicoes.getRegistoRecurso().registaRecurso(m_recurso)) {
//            return m_recurso;
//        }
//        return null;
//    }
    
    public static void novoRecurso(){
  
       recurso=ce.getRegistoRecursos().novoRecurso();

    }
    

    public Recurso getRecurso() {
        return recurso;
    }

}
