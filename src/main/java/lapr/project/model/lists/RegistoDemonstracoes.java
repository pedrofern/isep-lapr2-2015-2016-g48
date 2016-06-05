package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Demonstracao;
import lapr.project.model.Recurso;

/**
 *
 * @author Pedro Fernandes
 */
public class RegistoDemonstracoes {

    private List<Demonstracao> m_lstDemonstracao;

    public RegistoDemonstracoes() {
        m_lstDemonstracao = new ArrayList<Demonstracao>();
    }

    public Demonstracao novaDemonstracao(String codigoUnico, String strDescricao, List<Recurso> lst_recursos) {
        return new Demonstracao(codigoUnico, strDescricao, lst_recursos);
    }

    public boolean registaDemonstracao(Demonstracao demonstracao) {
        if (demonstracao.valida() && validaDemonstracao(demonstracao)) {
            return m_lstDemonstracao.add(demonstracao);
        }
        return false;
    }

    public boolean validaDemonstracao(Demonstracao demonstracao) {
        System.out.println("RegistoDemonstracoes: validaDemonstracao: " + demonstracao.valida());
        return true;
    }

    public List<Demonstracao> getListaDemonstracoes() {
        return m_lstDemonstracao;
    }

    @Override
    public String toString() {
        return "RegistoDemonstracoes{" + "m_lstDemonstracoes=" + m_lstDemonstracao + '}';
    }

}
