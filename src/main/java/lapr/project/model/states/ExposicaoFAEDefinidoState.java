package lapr.project.model.states;

import lapr.project.model.Exposicao;


/**
 *
 * @author Pedro Fernandes
 */
public class ExposicaoFAEDefinidoState {

    private Exposicao exposicao;
    private ExposicaoRegistadaEstado estRegExpo;
    
    public ExposicaoFAEDefinidoState(Exposicao e) {
        this.exposicao = e;
    }

    public boolean setCriada() {
        return false;
    }
    
    public boolean setDemoSemFAE() {
        return false;
    }

    public boolean setFAESemDemo() {
        return true;
    }
    
    public boolean setCompleta() {
        if (estRegExpo.valida()){
//            exposicao.setEstado(new ExposicaoCriadaEstado(exposicao));
            return true;
        } else
            return false;
        
    }

}
