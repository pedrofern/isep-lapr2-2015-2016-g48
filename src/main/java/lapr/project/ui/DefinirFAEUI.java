package lapr.project.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import lapr.project.controller.*;
import lapr.project.model.*;
import lapr.project.utils.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Pedro Fernandes
 */
public class DefinirFAEUI extends JFrame {

    private JFrame framePai;
    private static final Dimension LABEL_TAMANHO = new JLabel("Inserir novo utilizador").getPreferredSize();
    private static final int JANELA_LARGURA = 820;
    private static final int JANELA_ALTURA = 320;

    public DefinirFAEUI() {

        super("Definir FAE");

        setSize(JANELA_LARGURA, JANELA_LARGURA);
        setLocationRelativeTo(framePai);
        setVisible(true);
    }

    private JPanel criarPainelNorte() {
        JPanel painel = new JPanel(new FlowLayout());

        painel.add(criarPainelExposicao());
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        painel.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA, MARGEM_INFERIOR, MARGEM_DIREITA));

        painel.setBorder(new TitledBorder("Dados"));

        return painel;

    }

    private JPanel criarPainelExposicao() {

        JPanel painel = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Exposição", SwingConstants.RIGHT);
        label.setPreferredSize(LABEL_TAMANHO);

        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        painel.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA, MARGEM_INFERIOR, MARGEM_DIREITA));
        
        painel.add(label);
        
        return painel;

    }

//    private final CentroExposicoes m_centro_exposicoes;
//    private final DefinirFAEController m_controllerFAE;
//
//    public DefinirFAEUI(CentroExposicoes centroDeExposicoes) {
//        m_centro_exposicoes = centroDeExposicoes;
//        m_controllerFAE = new DefinirFAEController(m_centro_exposicoes);
//
//    }
//
//    @Override
//    public void run() {
//        String strIdOrganizador = introduzIdOrganizador();
//
//        List<Exposicao> le = m_controllerFAE.getListaExposicoes(strIdOrganizador);
//
//        apresentaExposicoesOrganizador(strIdOrganizador, le);
//
//        Exposicao e = selecionaExposicao(le);
//
//        if (e != null) {
//            m_controllerFAE.selectExposicao(e);
//
//            List<Utilizador> lu = m_controllerFAE.getListaUtilizadores();
//
//            Utilizador u;
//            do {
//                apresentaUtilizadores(lu);
//
//                u = selecionaUtilizador(lu);
//
//                if (u != null) {
//                    FAE fae = m_controllerFAE.addMembroFAE(u.getID());
//
//                    boolean conf = Utils.confirma("Confirma o FAE:" + fae.toString() + "(S/N)?");
//                    if (conf) {
//                        
//                        //TEM DE SER NA EXPOSIÇAO
//                        
////                        m_controllerFAE.registaMembroFAE(fae);
//
//                        // Não apresenta o utilizador que já foi convertido em FAE
//                        lu.remove(u);
//                    }
//
//                }
//            } while (u != null);
//        } else {
//            System.out.println("Criação dos Membros do FAE cancelada.");
//        }
//    }
//
//    private String introduzIdOrganizador() {
//        return Utils.readLineFromConsole("Introduza Id Organizador: ");
//    }
//
//    private void apresentaExposicoesOrganizador(String strIdOrganizador, List<Exposicao> le) {
//        System.out.println("Exposicoes do organizador " + strIdOrganizador + ":");
//
//        int index = 0;
//        for (Exposicao e : le) {
//            index++;
//
//            System.out.println(index + ". " + e.toString());
//        }
//        System.out.println("");
//        System.out.println("0 - Cancelar");
//    }
//
//    private void apresentaUtilizadores(List<Utilizador> lu) {
//        System.out.println("Utilizadores" + ":");
//
//        int index = 0;
//        for (Utilizador u : lu) {
//            index++;
//
//            System.out.println(index + ". " + u.toString());
//        }
//        System.out.println("");
//        System.out.println("0 - Cancelar");
//    }
//
//    private Exposicao selecionaExposicao(List<Exposicao> le) {
//        String opcao;
//        int nOpcao;
//        do {
//            opcao = Utils.readLineFromConsole("Introduza opção: ");
//            nOpcao = new Integer(opcao);
//        } while (nOpcao < 0 || nOpcao > le.size());
//
//        if (nOpcao == 0) {
//            return null;
//        } else {
//            return le.get(nOpcao - 1);
//        }
//    }
//
//    private Utilizador selecionaUtilizador(List<Utilizador> lu) {
//        String opcao1;
//        int nOpcao1;
//        do {
//            opcao1 = Utils.readLineFromConsole("Introduza opção: ");
//            nOpcao1 = new Integer(opcao1);
//        } while (nOpcao1 < 0 || nOpcao1 > lu.size());
//
//        if (nOpcao1 == 0) {
//            return null;
//        } else {
//            return lu.get(nOpcao1 - 1);
//
//        }
//    }
}
