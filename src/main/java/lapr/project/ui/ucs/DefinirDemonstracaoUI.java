package lapr.project.ui.ucs;

import java.awt.Dimension;
import lapr.project.controller.*;
import java.util.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import lapr.project.utils.*;
import lapr.project.model.*;
import lapr.project.ui.UI;

/**
 *
 * @author Pedro Fernandes
 */
public class DefinirDemonstracaoUI extends JFrame {

    private JComboBox comboBoxExposicao;
    private JTextField txtCodigo;
    private JTextArea txtDescricao;
    private JList listaRecurso = new JList();
    private JScrollPane scrollPaneLisaRecurso = new JScrollPane(listaRecurso);
    private static final Dimension LABEL_TAMANHO = new JLabel("Descrição").getPreferredSize();

    public DefinirDemonstracaoUI() {
      
        super("Criar Demonstração");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setVisible(true);
    }

//    private CentroExposicoes m_centroDeExposicoes;
//    private DefinirDemonstracaoController m_controller;
//
//    public DefinirDemonstracaoUI(CentroExposicoes centroDeExposicoes) {
//        m_centroDeExposicoes = centroDeExposicoes;
//        m_controller = new DefinirDemonstracaoController(m_centroDeExposicoes);
//    }
//
//    @Override
//    public void run() {
//
//        String strCodigoUnico = Utils.readLineFromConsole("Introduza o código único da demonstração: ");
//        m_controller.setCodigoUnico(strCodigoUnico);
//
//        String strDescricao = Utils.readLineFromConsole("Introduza a descrição da demonstração: ");
//        m_controller.setDescricao(strDescricao);
//
//        apresentaDemonstracao(m_controller.getDemonstracao());
//
//        if (Utils.confirma("Confirma?")) {
//            m_controller.registaDemonstracao();
//        }
//    }
//
//    private void apresentaDemonstracao(Demonstracao demonstracao) {
//        if (demonstracao == null) {
//            System.out.println("Demonstração não registada.");
//        } else {
//            System.out.println(demonstracao.toString());
//        }
//    }
}
