package lapr.project.model;

import java.util.Objects;

/**
 *
 * @author Pedro Fernandes
 */
public class Submissao {
    private Candidatura candidatura;
//    private SubmissaoState state;

    public Submissao() {
        this.candidatura = new Candidatura();
//        this.state = new SubmissaoStateEmSubmissao(this);
    }

    public Candidatura novaCandidatura() {
        return new Candidatura();
    }

    public String getInfo() {
        String str = candidatura.getInfo() + "\n\n";
        return str;
    }

    public void setCandidatura(Candidatura candidatura) {
        this.candidatura = candidatura;
    }

    public boolean valida() {
        if (this.candidatura == null) {
            return false;
        }
        return true;
    }

//    Representante getRepresentanteCorrespondente() {
//        return getCandidatura().getRepresentanteCorrespondente();
//    }

//    public boolean setState(SubmissaoState state) {
//        this.state = state;
//        return true;
//    }

    /**
     * Verifica se a submissão encontra-se no estado "Aceite".
     *
     * @return boolean true se a submissão está no estado "Aceite".
     */
//    public boolean isInAceite() {
//        return this.getState().isInAceite();
//    }

    /**
     * Verifica se a submissão encontra-se no estado "Rejeitada".
     *
     * @return boolean true se a submissão está no estado "Rejeitada".
     */
//    public boolean isInRejeitada() {
//        return this.getState().isInRejeitada();
//    }

    /**
     * Altera o estado da submissão para aceite.
     *
     * @return boolean.
     */
//    public boolean setAceite() {
//        return this.getState().setStateAceite();
//    }

    /**
     * Altera o estado da submissão para rejeitada.
     *
     * @return boolean.
     */
//    public boolean setRejeitada() {
//        return this.getState().setStateRejeitada();
//    }

    /**
     * Obtem a Candidatura da submissao.
     *
     * @return the artigo
     */
    public Candidatura getCandidatura() {
        return candidatura;
    }

    /**
     * Verifica se o estado nao esta em camera ready.
     *
     * @return boolean se nao esta ou esta
     */
//    public boolean isNotInCameraReady() {
//        return !this.state.isInCameraReady();
//    }

    /**
     * Verifica se o estado esta em revisao.
     *
     * @return boolean se nao esta ou esta
     */
//    public boolean isInEmRevisao() {
//        return this.state.isInEmRevisao();
//    }

    /**
     * Altera o estado da submissão para retirada se as condições se
     * satisfazerem.
     *
     * @return boolean retirada ou não
     */
//    public boolean setRetirada() {
//        return this.getState().setStateRetirada();
//    }

    /**
     * Verifica se a submissao é igual a um objeto passado por parâmetro
     *
     * @param o O objeto que vai ser comparado
     * @return True se forem iguais, false se não forem.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Submissao sub = (Submissao) o;
        return this.candidatura.equals(sub.getCandidatura());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.candidatura);
        return hash;
    }

    /**
     * Altera o estado para o estado recebido por parametro.
     *
     * @param state
     * @return boolean se alterou ou não
     */
    public boolean setState(String state) {
//        if (state.equals("SubmissaoStateAceite")) {
//            return setState(new SubmissaoStateAceite(this));
//        }
//        if (state.equals("SubmissaoStateEmRevisao")) {
//            return setState(new SubmissaoStateEmRevisao(this));
//        }
//        if (state.equals("SubmissaoStateEmSubmissao")) {
//            return setState(new SubmissaoStateEmSubmissao(this));
//        }
//        if (state.equals("SubmissaoStateNaoRevista")) {
//            return setState(new SubmissaoStateNaoRevista(this));
//        }
//        if (state.equals("SubmissaoStateRejeitada")) {
//            return setState(new SubmissaoStateRejeitada(this));
//        }
//        if (state.equals("SubmissaoStateRetirada")) {
//            return setState(new SubmissaoStateRetirada(this));
//        }
//        if (state.equals("SubmissaoStateRevista")) {
//            return setState(new SubmissaoStateRevista(this));
//        }
        return false;
    }

    /**
     * Obtem o estado da submissão.
     *
     * @return the state
     */
//    public SubmissaoState getState() {
//        return state;
//    }

    /**
     * Retorna clone desta submissão.
     *
     * @return Clone.
     */
    public Submissao criaClone() {
        Submissao aux = new Submissao();
        aux.setCandidatura(this.candidatura);
//        aux.setState(this.state);
        return aux;
    }

    /**
     * Altera o estado da submissão para nao revista.
     */
//    public void alteraParaNaoRevista() {
//        if (isInEmRevisao()) {
//            this.state.setStateNaoRevista();
//        }
//    }

    /**
     * Altera o estado da submissão para revista.
     */
//    public void alteraParaRevista() {
//        this.state.setStateRevista();
//    }
}
