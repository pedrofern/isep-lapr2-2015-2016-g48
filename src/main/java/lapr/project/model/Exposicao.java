package lapr.project.model;

import java.util.*;

/**
 *
 * @author Pedro Fernandes
 */
public class Exposicao implements Submissivel, Atribuivel {

    private String titulo;
    private String textoDescritivo;
    private Date dataInicio;
    private Date dataFim;
    private String local;
    private Date dataInicioSubmissao;
    private Date dataFimSubmissao;
    private Date dataInicioAtribuicao;
    private Date dataFimAtribuicao;
    private RegistoCandidaturas m_regCandidaturas;
    private RegistoFAEs m_regFAEs;
    private final List<Organizador> e_listaOrganizadores;
    private ListaSubmissoes listaSubmissoes;
    private ProcessoAtribuicao processoAtribuicao;
    private List<FAE> e_listaFAE;
    private ListaOrganizadores m_lstOrganizadores;
    private ListaFAE m_lstFaes;
    private ExposicaoEstado state;

    public Exposicao() {
        state = new ExposicaoCriadaEstado(this);
        e_listaOrganizadores = new ArrayList<Organizador>();
        listaSubmissoes = new ListaSubmissoes(this);
    }

    public boolean setState(ExposicaoEstado state) {
        this.state = state;
        return true;
    }

    public boolean isInRegistada() {
        return this.getState().isInRegistada();
    }

    public boolean isInFAEDefinida() {
        return this.getState().isInFAEDefinida();
    }

    public boolean isInEmSubmissao() {
        return this.getState().isInEmSubmissao();
    }

    public boolean isInEmDetecaoConflitos() {
        return this.getState().isInEmDetecaoConflitos();
    }

    public boolean isInEmAtribuicao() {
        return this.getState().isInEmAtribuicao();
    }

    public boolean isInEmRevisao() {
        return this.getState().isInEmRevisao();
    }

    public boolean isInEmDecisao() {
        return this.getState().isInEmDecisao();
    }

    public boolean isInEmDecidida() {
        return this.getState().isInEmDecidida();
    }

    public boolean setStateRegistada() {
        return this.getState().setStateRegistada();
    }

    public boolean setStateEmSubmissao() {
        return this.getState().setStateEmSubmissao();
    }

    public boolean setStateEmDetecaoConflitos() {
        return this.getState().setStateEmDetecaoConflitos();
    }

    public boolean setStateEmAtribuicao() {
        return this.getState().setStateEmAtribuicao();
    }

    public boolean setStateEmRevisao() {
        return this.getState().setStateEmRevisao();
    }

    public boolean setStateEmDecisao() {
        return this.getState().setStateEmDecisao();
    }

    public boolean setStateEmDecidida() {
        return this.getState().setStateEmDecidida();
    }

    public Avaliacao novaAvaliacao() {
        return new Avaliacao();
    }

    @Override
    public String toString() {
        String str = "Exposição:\n";
        str += "\tTitulo: " + this.titulo + "\n";
        str += "\tTexto descritivo: " + this.textoDescritivo + "\n";
        str += "\tData inicial: " + this.dataInicio + "\n";
        str += "\tData final: " + this.dataFim + "\n";
        str += "\tData inicial de submissão: " + this.dataInicioSubmissao + "\n";
        str += "\tData final de submissão: " + this.dataFimSubmissao + "\n";
        str += "\tData inicial de atribuição: " + this.dataInicioAtribuicao + "\n";
        str += "\tData final de atribuição: " + this.dataFimAtribuicao + "\n";
        str += "\tLocal: " + this.local + "\n";
        str += "\tOrganizadores:\n";
        for (Organizador o : e_listaOrganizadores) {
            str += "\t\t" + o.getUtilizador().getUsername() + "\n";
        }

        return str;
    }

    public void setTitulo(String strTitulo) {
        titulo = strTitulo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTextoDescritivo(String strDescritivo) {
        textoDescritivo = strDescritivo;
    }

    public String getTextoDescritivo() {
        return textoDescritivo;
    }

    public void setLocal(String strLocal) {
        local = strLocal;
    }

    public String getLocal() {
        return local;
    }

    public void setDataInicioSubmissao(Date strDataInicioSubmissao) {
        this.dataInicioSubmissao = strDataInicioSubmissao;
    }

    public RegistoCandidaturas getRegistoCandidaturas() {
        return this.m_regCandidaturas;
    }

    public RegistoFAEs getRegistoFAEs() {
        return this.m_regFAEs;
    }

    public Date getDataInicioSubmissao() {
        return this.dataInicioSubmissao;
    }

    /**
     * Obtem o estado da exposicao
     *
     * @return the state
     */
    public ExposicaoEstado getState() {
        return state;
    }

    public void setDataFimSubmissao(Date strDataFimSubmissao) {
        this.dataFimSubmissao = strDataFimSubmissao;
    }

    public Date getDataFimSubmissao() {
        return this.dataFimSubmissao;
    }

    public void setDataInicioAtribuicao(Date strDataInicioAtribuicao) {
        this.dataInicioAtribuicao = strDataInicioAtribuicao;
    }

    public Date getDataInicioAtribuicao() {
        return this.dataInicioAtribuicao;
    }

    public void setDataInicio(Date strDataInicio) {
        this.dataInicio = strDataInicio;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataFim(Date strDataFim) {
        this.dataFim = strDataFim;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public ListaOrganizadores getListaOrganizadores() {
        return this.m_lstOrganizadores;
    }

    /**
     * Retorna uma nova instância de processo de atribuição.
     *
     * @return uma nova instância de processo de atribuição.
     */
    @Override
    public ProcessoAtribuicao novaAtribuicao() {
        return new ProcessoAtribuicaoExposicao();
    }

    /**
     * Define o processo de atribuição e altera o estado para Exposicao em
 Revisão.
     *
     * @param pa O processo de atribuição que vai ser definido para a exposicao.
     */
    @Override
    public void setProcessoAtribuicao(ProcessoAtribuicao pa) {
        save(pa);
        if (this.getState().setStateEmRevisao()) {
            setState(new ExposicaoStateEmRevisao(this));
        }

    }

    @Override
    public ProcessoAtribuicao getProcessoAtribuicao() {
        return processoAtribuicao;
    }

    /**
     * Define o processo de atribuição.
     *
     * @param pa O processo de atribuição que vai ser definido para a exposicao.
     */
    public void save(ProcessoAtribuicao pa) {
        this.processoAtribuicao = pa;
    }

    /**
     * Verifica se a exposicao é igual a um objeto passado por parâmetro
     *
     * @param o O objeto que vai ser comparado com a exposicao.
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
        Exposicao outraEX = (Exposicao) o;
        return this.getTextoDescritivo().equals(outraEX.getTextoDescritivo()) && this.getTitulo().equals(outraEX.getTitulo());
    }

    /**
     * Modifica a lista de submissoes.
     *
     * @param listaSubmissoes the listaSubmissoes to set
     */
    public void setListaSubmissoes(ListaSubmissoes listaSubmissoes) {
        this.listaSubmissoes = listaSubmissoes;
    }

    public void setListaOrganizadores(ListaOrganizadores lstOrganizadores) {
        this.m_lstOrganizadores = lstOrganizadores;
    }

    public ListaFAE getListaFaes() {
        return this.m_lstFaes;
    }

    /**
     * Altera o estado para o estado recebido por parametro.
     *
     * @param state
     * @return boolean se alterou ou não
     */
    public boolean setState(String state) {
//        if (state.equals("ExposicaoFAEDefinidoState")) {
//            return setState(new ExposicaoFAEDefinidoState(this));
//        }
//        if (state.equals("ExposicaoStateCriada")) {
//            return setState(new ExposicaoCriadaEstado(this));
//        }
//        if (state.equals("ExposicaoStateEmDecidida")) {
//            return setState(new ExposicaoStateEmDecidida(this));
//        }
//        if (state.equals("ExposicaoStateEmDecisao")) {
//            return setState(new ExposicaoStateEmDecisao(this));
//        }
//        if (state.equals("ExposicaoStateEmDetecaoConflitos")) {
//            return setState(new ExposicaoStateEmDetecaoConflitos(this));
//        }
//        if (state.equals("ExposicaoStateEmAtribuicao")) {
//            return setState(new ExposicaoStateEmAtribuicao(this));
//        }
//        if (state.equals("ExposicaoStateEmRevisao")) {
//            return setState(new ExposicaoStateEmRevisao(this));
//        }
//        if (state.equals("ExposicaoStateEmSubmissao")) {
//            return setState(new ExposicaoEmSubmissaoEstado(this));
//        }
//        if (state.equals("ExposicaoStateRegistada")) {
//            return setState(new ExposicaoRegistadaEstado(this));
//        }
        return false;
    }

    public void setListaFaes(ListaFAE lstFaes) {
        this.m_lstFaes = lstFaes;
    }

    public boolean valida() {
        System.out.println("Exposição: valida: " + this.toString());
        return true;
    }

    public boolean validaGeral() {
        System.out.println("valida: " + this.toString());
        if (validaTitulo() == true && validaTextoDescritivo() == true && validaLocal() == true) {
            return true;
        }
        return false;
    }

    public boolean validaTitulo() {
        if (titulo == null || titulo.matches(".*\\d+.*")) {
            return false;
        }
        return true;
    }

    public boolean validaTextoDescritivo() {
        if (textoDescritivo == null) {
            return false;
        }
        return true;
    }

    public boolean validaLocal() {
        if (local == null) {
            return false;
        }
        return true;
    }

    public List<Organizador> getLstOrganizadores() {
        List<Organizador> lOrg = new ArrayList<Organizador>();

        for (ListIterator<Organizador> it = e_listaOrganizadores.listIterator(); it.hasNext();) {
            lOrg.add(it.next());
        }

        return lOrg;
    }

    public boolean validaLstOrganizadores(List<Organizador> listaOrg) {
        if (listaOrg.size() >= 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasOrganizador(Utilizador u) {
        for (Iterator<Organizador> it = this.e_listaOrganizadores.listIterator(); it.hasNext();) {
            Organizador org = it.next();

            if (org.isUtilizador(u)) {
                return true;
            }
        }
        return false;
    }

    private boolean validaDemonstracao(Demonstracao d) {
        System.out.println("Exposição: validaDemonstracao: " + d.toString());
        return true;
    }

    public void addDemonstracao(Demonstracao d) {
        if (validaDemonstracao(d)) {
            addDemonstracao(d);
        }
    }

    public boolean hasFAE(Utilizador u) {
        for (Iterator<FAE> it = this.e_listaFAE.listIterator(); it.hasNext();) {
            FAE fae = it.next();

            if (fae.isUtilizador(u)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ListaSubmissoes getListaSubmissoes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alteraParaEmSubmissao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alteraParaEmAtribuicao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
