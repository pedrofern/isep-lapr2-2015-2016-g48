package lapr.project.model;

import lapr.project.model.mechanisms.*;
import lapr.project.model.lists.*;
import java.util.*;

/**
 *
 * @author Pedro Fernandes
 */
public class CentroExposicoes {

    private RegistoTipoConflitos registoTipoConflitos;
    private ListaFAE m_listaFAE;
    private RegistoRecursos m_regRecursos;
    private RegistoExposicoes m_regExposicoes;
    private RegistoUtilizadores m_regUtilizadores;
    private ListaCandidaturas m_regCandidaturas;
    private RegistoDemonstracoes m_listaDemonstracoes;
    private Timer timer;
    private List<MecanismoAtribuicao> listaMecanismoAtribuicao;
    private List<MecanismoAvaliacao> listaMecanismoAvaliacao;
    private List<MecanismoDetecaoConflito> listaMecanismoDetecao;

    public CentroExposicoes() {
        m_regUtilizadores = new RegistoUtilizadores();
        m_regExposicoes = new RegistoExposicoes();
//        m_listaFAE = new ArrayList<FAE>();
        m_regRecursos = new RegistoRecursos();
        m_listaDemonstracoes = new RegistoDemonstracoes();
        this.timer = new Timer();
        this.listaMecanismoAvaliacao = new ArrayList<>();
        this.listaMecanismoDetecao = new ArrayList<>();
        this.listaMecanismoAtribuicao = new ArrayList<>();
        m_regCandidaturas = new ListaCandidaturas();
//        fillInData();
    }

//    public void fillInData() {
//
//        Utilizador u = new Utilizador();
//        u.setNome("João");
//        u.setEmail("joao@esoft.pt");
//        u.setUsername("joao");
//        u.setPassword("abc");
//        m_listaUtilizadores.add(u);
//
//        Utilizador u2 = new Utilizador();
//        u2.setNome("ricardo");
//        u2.setEmail("ricardo@esoft.pt");
//        u2.setUsername("ricardo");
//        u2.setPassword("def");
//        m_listaUtilizadores.add(u2);
//
//        Utilizador u3 = new Utilizador();
//        u3.setNome("pedro");
//        u3.setEmail("pedro@esoft.pt");
//        u3.setUsername("pedro");
//        u3.setPassword("ghi");
//        m_listaUtilizadores.add(u3);
//
//        Utilizador u4 = new Utilizador();
//        u4.setNome("joaquim");
//        u4.setEmail("joaquim@esoft.pt");
//        u4.setUsername("joaquim");
//        u4.setPassword("jkl");
//        m_listaUtilizadores.add(u4);
//
//        Utilizador u5 = new Utilizador();
//        u5.setNome("Bruno");
//        u5.setEmail("bruno@esoft.pt");
//        u5.setUsername("bruno");
//        u5.setPassword("mno");
//        m_listaUtilizadores.add(u5);
//    }

    public RegistoUtilizadores getRegistoUtilizadores() {
        return this.m_regUtilizadores;
    }

    public ListaCandidaturas getRegistoCandidaturas() {
        return this.m_regCandidaturas;
    }

    public RegistoExposicoes getRegistoExposicoes() {
        return this.m_regExposicoes;
    }
    
    public RegistoRecursos getRegistoRecursos() {
        return this.m_regRecursos;
    }
    
    public RegistoDemonstracoes getRegistoDemonstracoes() {
        return this.m_listaDemonstracoes;
    }
    
    public FAE novoDefinirFAE() {
        return new FAE();
    }

    public void schedule(TimerTask task, Date date) {
        timer.schedule(task, date);
    }

    public boolean registaDefinirFAE(FAE f) {
        if (validaDefinirFAE(f)) {
            return addDefinirFAE(f);
        } else {
            return false;
        }
    }

    private boolean addDefinirFAE(FAE f) {
        return m_listaFAE.adicionarFAE(f);
    }

    public ListaFAE getListaFAE() {
        ListaFAE lF = new ListaFAE();

        for (ListIterator<FAE> it = m_listaFAE.getListaFAE().listIterator(); it.hasNext();) {
            lF.adicionarFAE(it.next());
        }

        return lF;
    }

    public boolean validaDefinirFAE(FAE f) {
        return f.valida();
    }

    public RegistoUtilizadores getUtilizadores() {
        return m_regUtilizadores;
    }

    public List<MecanismoAvaliacao> getMecanismosAvaliacao() {
        List<MecanismoAvaliacao> lMecanismos = new ArrayList<>();

        for (ListIterator<MecanismoAvaliacao> it = listaMecanismoAvaliacao.listIterator(); it.hasNext();) {
            lMecanismos.add(it.next());
        }

        return lMecanismos;
    }

    public List<MecanismoAtribuicao> getMecanismosAtribuicao() {
        List<MecanismoAtribuicao> lMecanismos = new ArrayList<>();

        for (ListIterator<MecanismoAtribuicao> it = listaMecanismoAtribuicao.listIterator(); it.hasNext();) {
            lMecanismos.add(it.next());
        }

        return lMecanismos;
    }

    /**
     * @return o registo de tipo de conflitos do centro de exposicoes;
     */
    public RegistoTipoConflitos getRegistoTipoConflitos() {
        return this.registoTipoConflitos;
    }

    /**
     * Verifica se a empresa é igual a um objeto passado por parâmetro
     *
     * @param o O objeto que vai ser comparado com a empresa.
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
        CentroExposicoes outroCentro = (CentroExposicoes) o;
        return this.getRegistoUtilizadores().equals(outroCentro.getRegistoUtilizadores())
                && this.getRegistoExposicoes().equals(outroCentro.getRegistoExposicoes());
    }

    public RegistoExposicoes getListaExposicoes() {
        RegistoExposicoes le = new RegistoExposicoes();

        for (Exposicao e : m_regExposicoes.getExposicao()) {
            le.adicionarExposicao(e);
        }
        return le;
    }

    public Atribuicao novaAtribuicaoCandidatura() {
        return new Atribuicao();
    }

    public Utilizador getUtilizador(String strId) {
        for (Utilizador u : this.m_regUtilizadores.getListaUtilizadores()) {
            if (u.hasID(strId)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Empresa:" + "m_regUtilizadores=" + m_regUtilizadores
                + ", m_regExposicoes=" + m_regExposicoes + "m_regCandidaturas=" + m_regCandidaturas;
    }
    
    /**
     * Metodo responsavel por criar um novo utilizador
     * @return um novo utilizador
     */
    public Utilizador novoUtilizador() {
        return new Utilizador();
    }
    /**
     * Metodo responsavel por registar utilizador
     * @param u utilizador
     * @return true se for registado false caso contrario
     */
    public boolean registaUtilizador(Utilizador u) {
        if (validaUtilizador(u)) {
            addUtilizador(u);
            return true;
        }
        return false;
    }
    /**
     * Metodo que retorna um recurso
     * @param recurso recurso
     * @return recurso
     */
    public Recurso getRecurso(String recurso) {
        for (Recurso r : m_regRecursos.getListaRecursos()) {
            if (r.getDescricao().equalsIgnoreCase(recurso)) {
                return r;
            }
        }

        return null;

    }
    /**
     * Metodo que retorna uma exposicao atraves do titulo passado por parametro
     * @param titulo titulo
     * @return uma exposicao atraves do titulo passado por parametro
     */
    public Exposicao getExposicao(String titulo){
        for(Exposicao e : m_regExposicoes.getExposicao()){
            if(e.getTitulo().equalsIgnoreCase(titulo)){
                return e;
            }
        }
        return null;
    }
    /**
     * Metodo que regista um recurso
     * @param r recurso
     * @return true se registar ou false caso contrario
     */
    public boolean registaRecurso(Recurso r) {
        if (validaRecurso(r)) {
            addRecurso(r);
            return true;
        }
        return false;
    }
    /**
     * Metodo que valida recurso
     * @param r recurso
     * @return true se validar false caso contrario
     */
    public boolean validaRecurso(Recurso r) {
        return !m_regRecursos.contem(r);
    }
    /**
     * Metodo que adiciona o recurso passado por parametro a lista
     * @param r reucrso
     * @return true se adicionar false caso contrario
     */
    public boolean addRecurso(Recurso r) {
        return m_regRecursos.adicionarRecurso(r);
    }
    /**
     * Metodo responsavel por validar utilizador
     * @param u utilizador 
     * @return true se validar false caso contrario
     */
    private boolean validaUtilizador(Utilizador u) {
        return !m_regUtilizadores.getListaUtilizadores().contains(u);
    }
    /**
     * Metodo responsavel por adicionar o utilizador passado por parametro a lista
     * @param u utilizador
     */
    private void addUtilizador(Utilizador u) {
        this.m_regUtilizadores.getListaUtilizadores().add(u);
    }
    /**
     * Metodo que cria uma nova exposicao
     * @return nova exposicao
     */
    public Exposicao novaExposicao() {
        return new Exposicao();
    }
    /**
     * Metodo que valida uma exposicao
     * @param e exposicao
     * @return true se validar false caso contrario
     */
    public boolean validaExposicao(Exposicao e) {
        if (e.valida()) {
            // Introduzir as validações aqui
            return true;
        }
        return false;
    }
    /**
     * Metodo que regista uma exposicao
     * @param e exposicao
     * @return true se resgistar false em caso contrario
     */
    public boolean registaExposicao(Exposicao e) {
        return this.addExposicao(e);
    }
    /**
     * Metodo que adiciona uma exposicao a lista
     * @param e exposicao
     * @return true se adicionar false em caso contrario
     */
    private boolean addExposicao(Exposicao e) {
        return this.m_regExposicoes.adicionarExposicao(e);
    }
    /**
     * Metodo responsavel por retornar lista de recursos
     * @return lista de recursos
     */
    public RegistoRecursos getRecursos() {
        return this.m_regRecursos;
    }
    /**
     * Metodo que retorna a exposicao passada por parametro
     * @param e2 exposicao
     * @return a exposicao passada por parametro
     */
    public Exposicao getExposicao(Exposicao e2) {
        for (Exposicao e1 : m_regExposicoes.getExposicao()) {
            if (e1.getTitulo().equalsIgnoreCase(e2.getTitulo())) {
                return e2;
            }
        }
        return null;
    }
    /**
     * Metodo que retorna a lista de exposicoes do FAE com o id passado por parametro
     * @param id id 
     * @return lista de exposicoes do FAE com o id passado por parametro
     */
    public RegistoExposicoes getListaExposicoesDoFAE(String id) {
        RegistoExposicoes l_ExpDoFAE = new RegistoExposicoes();

        for (Exposicao e : this.m_regExposicoes.getExposicao()) {
            if (e.getListaFaes().getFAE(id) != null) {
                l_ExpDoFAE.adicionarExposicao(e);
            }

        }
        return l_ExpDoFAE;
    }
    /**
     * Retorna lista de exposicoes do organizador com o id passado por parametro
     * @param strId id 
     * @return lista de exposicoes do organizador com o id passado por parametro
     */
    public RegistoExposicoes getExposicaoOrganizador(String strId) {
        RegistoExposicoes leOrganizador = new RegistoExposicoes();

        Utilizador u = getUtilizadores().getUtilizadorByID(strId);

        if (u != null) {
            for (Iterator<Exposicao> it = this.m_regExposicoes.getExposicao().listIterator(); it.hasNext();) {
                Exposicao e = it.next();

                if (e.getListaOrganizadores().hasOrganizador(strId)) {
                    leOrganizador.adicionarExposicao(e);
                }
            }
        }
        return leOrganizador;
    }

}
