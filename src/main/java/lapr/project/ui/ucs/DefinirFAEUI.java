package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import lapr.project.controller.*;
import lapr.project.model.*;
import lapr.project.utils.*;
import java.util.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Eduangelo Ferreira Nº aluno: 1151094
 */
public class DefinirFAEUI extends JFrame {

     private JList lstCompletaUtilizadores, lstUtilizadoresFAE;
    private JButton btnEliminarFAE, btnAdicionarUtilizador, btnConfirmar, btnCancelar;
    private JComboBox comboBoxExposicao;
    private ModeloListaUtilizadores modeloListaUtilizadores;
    private ModeloListaUtilizadores modeloListaFAE;
    private ListaUtilizadores listaCompletaUtilizadores;
    private ListaUtilizadores listaUtilizadoresFAE;
    private static final Dimension LABEL_TAMANHO = new JLabel("Inserir novo utilizador").getPreferredSize();

    public DefinirFAEUI() throws FileNotFoundException {

        super("Definir FAE");

        criarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void criarComponentes() throws FileNotFoundException {

        add(criarPainelNorte(), BorderLayout.NORTH);
        add(criarPainelListas(), BorderLayout.CENTER);
        add(criarPainelSul(),BorderLayout.SOUTH);

    }

    private JPanel criarPainelNorte() {
        JPanel p = new JPanel(new FlowLayout());

        p.add(criarPainelExposicao());

        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.setBorder(new TitledBorder("Dados "));
        return p;
    }
    
     private JPanel criarPainelSul() {

        JPanel p = new JPanel(new FlowLayout());

        p.setBorder(new TitledBorder("Opção"));
        p.add(criarBotaoConfirmar());
        p.add(criarBotaoCancelar());

        return p;
    }
    
    private JPanel criarPainelExposicao() {
        JPanel p = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Exposição", SwingConstants.RIGHT);

        lbl.setPreferredSize(LABEL_TAMANHO);

        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 0, MARGEM_DIREITA = 0;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(lbl);
        p.add(getListaExposicao());

        return p;
    }
    
     private JComboBox getListaExposicao() {

        comboBoxExposicao = new JComboBox();
        comboBoxExposicao.setSelectedIndex(-1);
        comboBoxExposicao.setEditable(false);
        comboBoxExposicao.setPreferredSize(new Dimension(250, 20));
        return comboBoxExposicao;
    }
    
      private JPanel criarPainelListas() {
        final int NUMERO_LINHAS = 1, NUMERO_COLUNAS = 2;
        final int INTERVALO_HORIZONTAL = 20, INTERVALO_VERTICAL = 0;
        JPanel p = new JPanel(new GridLayout(NUMERO_LINHAS,
                NUMERO_COLUNAS,
                INTERVALO_HORIZONTAL,
                INTERVALO_VERTICAL));

        lstCompletaUtilizadores = new JList();
        listaCompletaUtilizadores = new ListaUtilizadores();
        modeloListaUtilizadores = new ModeloListaUtilizadores(listaCompletaUtilizadores);
        btnAdicionarUtilizador = criarBotaoAdicionarUtilizador();
        p.add(criarPainelLista("Lista de Utilizadores",
                lstCompletaUtilizadores,
                modeloListaUtilizadores));

        lstUtilizadoresFAE = new JList();
        listaUtilizadoresFAE = new ListaUtilizadores();
        modeloListaFAE = new ModeloListaUtilizadores(listaUtilizadoresFAE);
        btnEliminarFAE = criarBotaoEliminarJogador(lstUtilizadoresFAE);

        p.add(criarPainelListaFAE("Lista de FAE:",
                lstUtilizadoresFAE,
                modeloListaFAE,
                btnAdicionarUtilizador, btnEliminarFAE));
        return p;
    }

    private JPanel criarPainelLista(
            String tituloLista,
            JList lstLista,
            ModeloListaUtilizadores modeloLista) {
        JLabel lblTitulo = new JLabel(tituloLista, JLabel.LEFT);

        lstLista.setModel(modeloLista);
        lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(lstLista);

        JPanel p = new JPanel(new BorderLayout());

        final int MARGEM_SUPERIOR = 20, MARGEM_INFERIOR = 20;
        final int MARGEM_ESQUERDA = 20, MARGEM_DIREITA = 20;
        p.setBorder(BorderFactory.createEmptyBorder(MARGEM_SUPERIOR,
                MARGEM_ESQUERDA,
                MARGEM_INFERIOR,
                MARGEM_DIREITA));

        p.add(lblTitulo, BorderLayout.NORTH);
        p.add(scrPane, BorderLayout.CENTER);

        return p;
    }

    private JPanel criarPainelListaFAE(
            String tituloLista,
            JList lstLista,
            ModeloListaUtilizadores modeloLista,
            JButton btnSuperior,
            JButton btnInferior) {
        JLabel lblTitulo = new JLabel(tituloLista, JLabel.LEFT);

        lstLista.setModel(modeloLista);
        lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(lstLista);

        JPanel p = new JPanel(new BorderLayout());

        final int MARGEM_SUPERIOR = 20, MARGEM_INFERIOR = 20;
        final int MARGEM_ESQUERDA = 20, MARGEM_DIREITA = 20;
        p.setBorder(BorderFactory.createEmptyBorder(MARGEM_SUPERIOR,
                MARGEM_ESQUERDA,
                MARGEM_INFERIOR,
                MARGEM_DIREITA));

        p.add(lblTitulo, BorderLayout.NORTH);
        p.add(scrPane, BorderLayout.CENTER);

        JPanel pBotoes = criarPainelBotoes(btnSuperior, btnInferior);
        p.add(pBotoes, BorderLayout.SOUTH);
        return p;
    }

    private JPanel criarPainelBotoes(JButton btn1, JButton btn2) {

        final int NUMERO_LINHAS = 2, NUMERO_COLUNAS = 1;
        final int INTERVALO_HORIZONTAL = 0, INTERVALO_VERTICAL = 10;
        JPanel p = new JPanel(new GridLayout(NUMERO_LINHAS,
                NUMERO_COLUNAS,
                INTERVALO_HORIZONTAL,
                INTERVALO_VERTICAL));

        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 0, MARGEM_DIREITA = 0;
        p.setBorder(BorderFactory.createEmptyBorder(MARGEM_SUPERIOR,
                MARGEM_ESQUERDA,
                MARGEM_INFERIOR,
                MARGEM_DIREITA));

        p.add(btn1);
        p.add(btn2);

        return p;
    }

    private JButton criarBotaoEliminarJogador(JList lstLista) {
        JButton btn = new JButton("Eliminar FAE");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModeloListaUtilizadores modelo = (ModeloListaUtilizadores) lstLista.getModel();
                modelo.removeElement((Utilizador) lstLista.getSelectedValue());

            }
        });
        return btn;
    }

    private JButton criarBotaoAdicionarUtilizador() {
        btnAdicionarUtilizador = new JButton("Adicionar Utilizador");
        btnAdicionarUtilizador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeloListaFAE.addElement((Utilizador) lstCompletaUtilizadores.getSelectedValue());
                lstCompletaUtilizadores.clearSelection();

            }
        });
        return btnAdicionarUtilizador;
    }

    private JButton criarBotaoConfirmar() {
        btnConfirmar = new JButton("Confirmar");

        return btnConfirmar;
    }

    private JButton criarBotaoCancelar() {
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        return btnCancelar;
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
