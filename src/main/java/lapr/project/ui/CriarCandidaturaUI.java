package lapr.project.ui;

import lapr.project.model.*;
import lapr.project.controller.*;
import lapr.project.utils.*;

/**
 *
 * @author Pedro Fernandes
 */
public class CriarCandidaturaUI implements UI{

    private Representante e_representante;
    private CriarCandidaturaController m_controllerCCC;

    public CriarCandidaturaUI(Representante representante) {
        e_representante = representante;
        m_controllerCCC = new CriarCandidaturaController(e_representante);
    }

    @Override
    public void run() {
        novaCandidatura();

        introduzNomeEmpresa();
        introduzMorada();
        introduzTelemovel();
        introduzAreaExposicao();
        introduzQuantidadeConvites();
        adicionaProduto();

        apresentaCandidatura();

        if (confirmaCriacaoCandidatura()) {
            if (m_controllerCCC.registaCandidatura()) {
                System.out.println("Candidatura registada.");
            } else {
                System.out.println("Candidatura não registada.");
            }
        }
    }

    private void novaCandidatura() {
        m_controllerCCC.novaCandidatura();
    }

    private void introduzNomeEmpresa() {
        String nomeEmpresa = Utils.readLineFromConsole("Introduza Nome da Empresa: ");

        m_controllerCCC.setNomeEmpresa(nomeEmpresa);
    }

    private void introduzMorada() {
        String morada = Utils.readLineFromConsole("Introduza Morada: ");

        m_controllerCCC.setMorada(morada);
    }

    private void introduzTelemovel() {
        String telemovel = Utils.readLineFromConsole("Introduza Telemovel: ");

        int nrTelemovel = Integer.parseInt(telemovel);

        m_controllerCCC.setTelemovel(nrTelemovel);
    }

    private void introduzAreaExposicao() {
        String areaExposicao = Utils.readLineFromConsole("Introduza Area de Exposicao: ");

        double areaExposicaoo = Double.parseDouble(areaExposicao);

        m_controllerCCC.setAreaExposicao(areaExposicaoo);
    }

    private void introduzQuantidadeConvites() {
        String quantidadeConvites = Utils.readLineFromConsole("Introduza Quantidade de Convites: ");

        int quantidadeConvitess = Integer.parseInt(quantidadeConvites);

        m_controllerCCC.setQuantidadeConvites(quantidadeConvitess);
    }

    private void adicionaProduto() {
        String strResposta;
        do {
            String nomeProduto = Utils.readLineFromConsole("Introduza o nome do Produto: ");

            boolean bAdicionado = m_controllerCCC.addProduto(nomeProduto);

            if (bAdicionado) {
                System.out.println("Produto adicionado.");
            } else {
                System.out.println("Produto não adicionado.");
            }

            strResposta = Utils.readLineFromConsole("Introduzir outro Produto (S/N)? ");
        } while (strResposta.equalsIgnoreCase("S"));
    }

    private void apresentaCandidatura() {
        System.out.println("Candidatura: ");

        System.out.println(m_controllerCCC.getCandidaturaString());
    }

    private boolean confirmaCriacaoCandidatura() {
        String strConfirma;
        do {
            strConfirma = Utils.readLineFromConsole("Confirma criação de Candidatura (S/N): ");
        } while (!strConfirma.equalsIgnoreCase("s") && !strConfirma.equalsIgnoreCase("n"));

        if (strConfirma.equalsIgnoreCase("s")) {
            return true;
        } else {
            return false;
        }
    }

}
