package lapr.project.model;

import lapr.project.model.mechanisms.ProcessoAtribuicao;
import lapr.project.model.lists.ListaSubmissoes;
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
