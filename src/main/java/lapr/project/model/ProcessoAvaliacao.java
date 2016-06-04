package lapr.project.model;

import java.util.*;

/**
 *
 * @author Pedro Fernandes
 */
public interface ProcessoAvaliacao {
    void setMecanismoAvaliacao(MecanismoAvaliacao mecanismo);

    void avalia();

    void setListAvaliacoes(List<Avaliacao> listaAvaliacoes);

    Avaliacao novaAvaliacao();

    boolean notifica();

    List<Avaliacao> getAvaliacoes();

    Avaliacao getAvaliacaoSubmissao(Submissao s);
}
