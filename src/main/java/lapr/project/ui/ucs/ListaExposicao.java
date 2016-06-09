package lapr.project.ui.ucs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lapr.project.model.*;
import sun.security.util.PropertyExpander;

public class ListaExposicao {

    private List<Exposicao> listaExposicao;

    public ListaExposicao() {
        listaExposicao = new ArrayList<>();
    }
    
    public Exposicao obterExposicao(int indice) {
        return listaExposicao.get(indice);
    }

    public boolean adicionarExposicao(Exposicao exposicao) {
        if (!listaExposicao.contains(exposicao)) {
            return listaExposicao.add(exposicao);
        }
        return false;
    }

    public boolean removerExposicao(Exposicao exposicao) {
        return listaExposicao.remove(exposicao);
    }

    public int tamanho() {
        return this.listaExposicao.size();
    }

    public int indiceDe(Exposicao exposicao) {
        return listaExposicao.indexOf(exposicao);
    }
    
    public boolean contem(Exposicao exposicao){
        return listaExposicao.contains(exposicao);
    }
    
    public void ordenarPorPosicao(){
        Collections.sort(listaExposicao);
    }
    
}
