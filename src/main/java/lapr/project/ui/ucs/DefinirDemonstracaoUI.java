/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.border.TitledBorder;
import lapr.project.model.lists.RegistoRecursos;

/**
 *
 * @author Edu
 */
public class DefinirDemonstracaoUI extends JFrame {

    private JButton btnConfirmar, btnCancelar, btnAdicionarRecurso;
    private JComboBox comboBoxExposicao, comboBoxDemonstracao;
    private JFrame framepai;
    private ModeloListaRecursos modeloListaRecurso;
    private JList listaCompletaRecurso;
    private JTable tableListaRecurso;
    private static final Dimension LABEL_TAMANHO = new JLabel("Descrição").getPreferredSize();
    private static final int JANELA_LARGURA = 900;
    private static final int JANELA_ALTURA = 400;

    public DefinirDemonstracaoUI() throws FileNotFoundException {

        super("Definir Demonstração");
        criarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void criarComponentes() throws FileNotFoundException {

        add(criarPainelNorte(), BorderLayout.NORTH);
    }

    private JPanel criarPainelNorte() throws FileNotFoundException {
        JPanel p = new JPanel(new FlowLayout());
        p.setBorder(new TitledBorder("Dados"));
        JLabel lbl = new JLabel("Exposição", SwingConstants.RIGHT);
        JLabel lbldemonstração = new JLabel("Demonstração", SwingConstants.RIGHT);
        p.add(lbl);
        p.add(getListaExposicao());
        p.add(lbldemonstração);
        p.add(getListaDemonstracao());
        
        return p;
    }

    private JComboBox getListaExposicao() {

        comboBoxExposicao = new JComboBox();
        comboBoxExposicao.setSelectedIndex(-1);
        comboBoxExposicao.setEditable(false);
        comboBoxExposicao.setPreferredSize(new Dimension(200, 20));

        return comboBoxExposicao;
    }

    private JComboBox getListaDemonstracao() {

        comboBoxExposicao = new JComboBox();
        comboBoxExposicao.setSelectedIndex(-1);
        comboBoxExposicao.setEditable(false);
        comboBoxExposicao.setPreferredSize(new Dimension(200, 20));

        return comboBoxExposicao;
    }

}
