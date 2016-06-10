package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
import lapr.project.model.Recurso;

/**
 *
 * @author Pedro Fernandes
 */
public class RegistoDemonstracoes {

    private ArrayList<Demonstracao> m_lstDemonstracao;

    public RegistoDemonstracoes() {
        m_lstDemonstracao = new ArrayList<>();
    }

//    public Demonstracao novaDemonstracao(int codigoUnico, String strDescricao, RegistoRecursos listaRecursos, CentroExposicoes m_centroExposicoes) {
//        return new Demonstracao(codigoUnico, strDescricao, listaRecursos, m_centroExposicoes);
//    }

    public boolean registaDemonstracao(Demonstracao demonstracao) {
        if (validaDemonstracao(demonstracao)) {
            return m_lstDemonstracao.add(demonstracao);
        }
        return false;
    }

    public boolean validaDemonstracao(Demonstracao demonstracao) {
//        System.out.println("RegistoDemonstracoes: validaDemonstracao: " + demonstracao.valida());
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
