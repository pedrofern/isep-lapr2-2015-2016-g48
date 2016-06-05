package lapr.project.model.lists;

import java.util.*;
import lapr.project.model.Submissao;
import lapr.project.model.Submissivel;

/**
 *
 * @author Pedro Fernandes
 */
public class ListaSubmissoes {
    private Submissivel submissivel;
    private List<Submissao> listaSubmissoes;

    /**
     * Construtor.
     * @param eventoSessao Submissivel.
     */
    public ListaSubmissoes(Submissivel eventoSessao) {
        this.submissivel = eventoSessao;
        this.listaSubmissoes = new ArrayList<>();
    }

    /**
     * Cria uma nova submissão.
     *
     * @return Submissão.
     */
    public Submissao novaSubmissao() {
        return new Submissao();
    }

    /**
     * Adiciona uma submissão à lista de submissões se as validações se
     * satisfazerem.
     *
     * @param submissao Submissão a adicionar.
     * @return boolean true se adicionada com sucesso, false se não for
     * adicionada.
     */
    public boolean addSubmissao(Submissao submissao) {
        if (validaSubmissao(submissao)) {
            return this.getListaSubmissoes().add(submissao);
        } else {
            return false;
        }
    }

    /**
     * Retorna lista com todas as submissões feitas no Submissivel.
     *
     * @return lista de submissões.
     */
    public List<Submissao> getListaSubmissoes() {
        return listaSubmissoes;
    }
    
    public List<Submissao> getSubmissoesAutor(String email){
        List lstAux = new ArrayList<>();
        for(Submissao s : this.listaSubmissoes){
//            if(s.hasRepresentante(email)){
//                lstAux.add(s);
//            }
        }
        return lstAux;    
    }

    /**
     * Retorna uma lista com todas as submissões aceites do utilizador passado
     * por parâmetro.
     *
     * @param id do utilizador.
     * @return lista com as submissões aceites do utilizador.
     */
    public List<Submissao> getSubmissoesAceites(String id) {
        List<Submissao> lstSubmissoesAceites = new ArrayList<>();
        for (Submissao s : this.getListaSubmissoes()) {
//            if (s.isInAceite() && s.hasRepresentante(id)) {
//                lstSubmissoesAceites.add(s);
//            }
        }
        return lstSubmissoesAceites;
    }

    /**
     * Verifica se submissão é valida, se a mesma não existir na lista é valida.
     *
     * @param submissao a validar
     * @return boolean submissão valida ou não
     */
    private boolean validaSubmissao(Submissao submissao) {
        for (Submissao sub : getListaSubmissoes()) {
            if (sub.equals(submissao)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica se o lista de submissoes é igual a um objeto passado por
     * parâmetro
     *
     * @param o O objeto que vai ser comparado com o processo de distribuição.
     * @return True se forem iguais, false se não forem.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        ListaSubmissoes lSub = (ListaSubmissoes) o;
        return listaSubmissoes.equals(lSub.getListaSubmissoes());
    }
}
