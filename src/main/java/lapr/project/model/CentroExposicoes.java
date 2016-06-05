package lapr.project.model;

import java.util.*;

/**
 *
 * @author Pedro Fernandes
 */
public class CentroExposicoes {

    private RegistoTipoConflitos registoTipoConflitos;
    private List<Utilizador> m_listaUtilizadores;
    private List<Exposicao> m_listaExposicoes;
    private List<FAE> m_listaFAE;
    private List<Recurso> m_listaRecursos;
    private RegistoRecursos m_regRecursos;
    private List<Demonstracao> m_listaDemonstracoes;
    private RegistoDemonstracoes m_regDemonstracoes;
    private RegistoExposicoes m_regExposicoes;
    private RegistoUtilizadores m_regUtilizadores;
    private RegistoCandidaturas m_regCandidaturas;
    private Timer timer;
    private List<MecanismoAtribuicao> listaMecanismoAtribuicao;
    private List<MecanismoAvaliacao> listaMecanismoAvaliacao;
    private List<MecanismoDetecaoConflito> listaMecanismoDetecao;

    public CentroExposicoes() {
        m_listaUtilizadores = new ArrayList<Utilizador>();
        m_listaExposicoes = new ArrayList<Exposicao>();
//        m_listaFAE = new ArrayList<FAE>();
        m_listaRecursos = new ArrayList<Recurso>();
//        m_listaDemonstracoes = new ArrayList<Demonstracao>();
        m_regUtilizadores = new RegistoUtilizadores();
        m_regExposicoes = new RegistoExposicoes();
        this.timer = new Timer();
        this.listaMecanismoAvaliacao = new ArrayList<>();
        this.listaMecanismoDetecao = new ArrayList<>();
        this.listaMecanismoAtribuicao = new ArrayList<>();
        m_regCandidaturas = new RegistoCandidaturas();
        fillInData();
    }

    public void fillInData() {

        Utilizador u = new Utilizador();
        u.setNome("João");
        u.setEmail("joao@esoft.pt");
        u.setUsername("joao");
        u.setPassword("abc");
        m_listaUtilizadores.add(u);

        Utilizador u2 = new Utilizador();
        u2.setNome("ricardo");
        u2.setEmail("ricardo@esoft.pt");
        u2.setUsername("ricardo");
        u2.setPassword("def");
        m_listaUtilizadores.add(u2);

        Utilizador u3 = new Utilizador();
        u3.setNome("pedro");
        u3.setEmail("pedro@esoft.pt");
        u3.setUsername("pedro");
        u3.setPassword("ghi");
        m_listaUtilizadores.add(u3);

        Utilizador u4 = new Utilizador();
        u4.setNome("joaquim");
        u4.setEmail("joaquim@esoft.pt");
        u4.setUsername("joaquim");
        u4.setPassword("jkl");
        m_listaUtilizadores.add(u4);

        Utilizador u5 = new Utilizador();
        u5.setNome("Bruno");
        u5.setEmail("bruno@esoft.pt");
        u5.setUsername("bruno");
        u5.setPassword("mno");
        m_listaUtilizadores.add(u5);
    }

    public RegistoUtilizadores getRegistoUtilizadores() {
        return this.m_regUtilizadores;
    }

    public RegistoCandidaturas getRegistoCandidaturas() {
        return this.m_regCandidaturas;
    }

    public RegistoExposicoes getRegistoExposicoes() {
        return this.m_regExposicoes;
    }
    
    public RegistoRecursos getRegistoRecursos() {
        return this.m_regRecursos;
    }
//
//    public FAE novoDefinirFAE() {
//        return new FAE();
//    }
//
//    public void schedule(TimerTask task, Date date) {
//        timer.schedule(task, date);
//    }
//
//    public boolean registaDefinirFAE(FAE f) {
//        if (validaDefinirFAE(f)) {
//            return addDefinirFAE(f);
//        } else {
//            return false;
//        }
//    }
//
//    private boolean addDefinirFAE(FAE f) {
//        return m_listaFAE.add(f);
//    }
//
//    public List<FAE> getListaFAE() {
//        List<FAE> lF = new ArrayList<FAE>();
//
//        for (ListIterator<FAE> it = m_listaFAE.listIterator(); it.hasNext();) {
//            lF.add(it.next());
//        }
//
//        return lF;
//    }
//
//    public boolean validaDefinirFAE(FAE f) {
//        return f.valida();
//    }

    public List<Utilizador> getUtilizadores() {
        return m_listaUtilizadores;
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

    public List<Exposicao> getListaExposicoes() {
        List<Exposicao> le = new ArrayList<Exposicao>();

        for (Exposicao e : m_listaExposicoes) {
            le.add(e);
        }
        return le;
    }

    public Atribuicao novaAtribuicaoCandidatura() {
        return new Atribuicao();
    }

    public RegistoRecursos getRegistoRecurso() {
        return this.m_regRecursos;
    }

    public RegistoDemonstracoes getRegistoDemonstracao() {
        return this.m_regDemonstracoes;
    }

    public boolean hasUtilizador(String username, String password) {
        return this.m_regUtilizadores.hasUtilizador(username, password);
    }

    public Utilizador getUtilizador(String strId) {
        for (Utilizador u : this.m_listaUtilizadores) {
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
}
