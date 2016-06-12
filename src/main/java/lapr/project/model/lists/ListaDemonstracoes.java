package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
import lapr.project.model.Recurso;
import lapr.project.utils.Data;

/**
 *
 * @author Pedro Fernandes
 */
public class ListaDemonstracoes {

    private ArrayList<Demonstracao> m_lstDemonstracao;
    private Demonstracao m_demonstraco;

    public ListaDemonstracoes() {
        m_lstDemonstracao = new ArrayList<>();
    }

    public void novaDemonstracao(String strDescricao, String temaExposicao, Data inicio, Data fim ) {
        m_demonstraco.setDados(strDescricao, temaExposicao, inicio, fim);
    }

    public boolean registaDemonstracao(Demonstracao demonstracao) {
        if (validaDemonstracao(demonstracao)) {
            return m_lstDemonstracao.add(demonstracao);
        }
        return false;
    }

    public boolean validaDemonstracao(Demonstracao demonstracao) {
//        System.out.println("ListaDemonstracoes: validaDemonstracao: " + demonstracao.valida());
        return true;
    }

    public ArrayList<Demonstracao> getListaDemonstracoes() {
        return m_lstDemonstracao;
    }

    @Override
    public String toString() {
        return "RegistoDemonstracoes{" + "m_lstDemonstracoes=" + m_lstDemonstracao + '}';
    }

    
    public Demonstracao[] getArray() {
        return m_lstDemonstracao.toArray( new Demonstracao[m_lstDemonstracao.size()] );
     }
}
