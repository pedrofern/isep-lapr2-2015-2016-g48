package lapr.project.model;

import java.util.*;

/**
 *
 * @author Pedro Fernandes
 */
public class RegistoRecursos {

    private List<Recurso> m_lstRecurso;

    public RegistoRecursos() {
        m_lstRecurso = new ArrayList<Recurso>();
    }

    public Recurso novoRecurso(String strDescricao) {
        return new Recurso(strDescricao);
    }

    public boolean registaRecurso(Recurso recurso) {
        if (recurso.valida() && validaRecurso(recurso)) {
            return m_lstRecurso.add(recurso);
        }
        return false;
    }

    private boolean validaRecurso(Recurso recurso) {
        System.out.println("RegistoRecursos: validaRecurso: " + recurso.valida());
        if(recurso.getDescricao()!=null){
            return true;
        } else
            return false;
    }

    public void addRecurso(Recurso r){
        m_lstRecurso.add(r);
    }
    
    public List<Recurso> getListaRecursos() {
        return m_lstRecurso;
    }

    @Override
    public String toString() {
        return "RegistoRecursos{" + "m_lstRecursos=" + m_lstRecurso + '}';
    }
}
