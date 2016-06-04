package lapr.project.model;

import java.util.*;

/**
 *
 * @author Pedro Fernandes
 */
public interface Submissivel {
    
    public ListaSubmissoes getListaSubmissoes();

    public void alteraParaEmSubmissao();

    public void setListaSubmissoes(ListaSubmissoes listaSubmissoes);

    public boolean isInEmDecidida();

    public ProcessoAtribuicao getProcessoAtribuicao();
    
}
