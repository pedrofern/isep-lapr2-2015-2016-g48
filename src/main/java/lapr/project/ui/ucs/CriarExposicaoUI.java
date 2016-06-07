package lapr.project.ui.ucs;

import lapr.project.controller.*;
import lapr.project.model.*;
import lapr.project.utils.*;
import java.util.*;
import lapr.project.ui.UI;

/**
 *
 * @author Pedro Fernandes
 */
public class CriarExposicaoUI implements UI{

    private CentroExposicoes m_centroDeExposicoes;
    private CriarExposicaoController m_controller;

    public CriarExposicaoUI(CentroExposicoes centroDeExposicoes) {
        m_centroDeExposicoes = centroDeExposicoes;
        m_controller = new CriarExposicaoController(m_centroDeExposicoes);
    }

    @Override
    public void run() {
        novaExposicao();

        Exposicao exposicao = introduzDadosExposicao();

        apresentaExposicao(exposicao);
    }

    private void novaExposicao() {
        m_controller.novaExposicao();
    }

    private Exposicao introduzDadosExposicao() {
        String strTitulo = Utils.readLineFromConsole("Introduza Titulo: ");
        m_controller.setTitulo(strTitulo);

        String strDescricao = Utils.readLineFromConsole("Introduza Descricao: ");
        m_controller.setDescricao(strDescricao);

        String strLocal = Utils.readLineFromConsole("Introduza Local: ");
        m_controller.setLocal(strLocal);

        Date dtInicio = Utils.readDateFromConsole("Introduza Data Inicio: ");
        m_controller.setDataInicio(dtInicio);

        Date dtFim = Utils.readDateFromConsole("Introduza Data Fim: ");
        m_controller.setDataFim(dtFim);

        Date dtInicioSubmissao = Utils.readDateFromConsole("Introduza Data Inicio Submissao: ");
        m_controller.setDataInicioSubmissao(dtInicioSubmissao);

        Date dtFimSubmissao = Utils.readDateFromConsole("Introduza Data Fim Submissao: ");
        m_controller.setDataFimSubmissao(dtFimSubmissao);

        Date dtInicioAtribuicao = Utils.readDateFromConsole("Introduza Data Inicio Atribuicao: ");
        m_controller.setDataInicioAtribuicao(dtInicioAtribuicao);

        while (Utils.confirma("Pretende inserir orgaizador (s/n)?")) {
            String strOrg = Utils.readLineFromConsole("Introduza ID Organizador: ");
            m_controller.addOrganizador(strOrg);
        }

        apresentaExposicao(m_controller.getExposicao());

        if (Utils.confirma("Confirma?")) {
            return m_controller.registaExposicao();
        }
        return null;
    }

    private void apresentaExposicao(Exposicao exposicao) {
        if (exposicao == null) {
            System.out.println("Exposicao não registada.");
        } else {
            System.out.println(exposicao.toString());
        }
    }
}
