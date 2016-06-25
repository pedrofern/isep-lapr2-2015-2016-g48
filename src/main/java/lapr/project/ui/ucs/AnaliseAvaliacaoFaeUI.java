/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Utilizador;
import lapr.project.utils.Utils;

/**
 *
 * @author Edu
 */
public class AnaliseAvaliacaoFaeUI extends JFrame {

    private JButton btnEliminarFAE, btnAdicionarUtilizador, btnConfirmar, btnCancelar;
    private Exposicao exposicao;
    private CentroExposicoes centro;
    private Utilizador utilizador;
    private static JComboBox comboBoxExposicao;
    private static final Dimension LABEL_TAMANHO = new JLabel("Valor observado da estatistica de teste").getPreferredSize();

    public AnaliseAvaliacaoFaeUI(CentroExposicoes centro, Utilizador utilizador) throws FileNotFoundException {

        this.centro = centro;
        this.utilizador = utilizador;

        criarComponentes();
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void criarComponentes() throws FileNotFoundException {

        add(criarPainelNorte(), BorderLayout.NORTH);
        add(criarPainelTabela(), BorderLayout.CENTER);
    }

    private JPanel criarPainelNorte() {
        JPanel p = new JPanel(new FlowLayout());

        p.add(criarPainelExposicao());

        p.setBorder(new EmptyBorder(0, 10,
                0, 10));

        p.setBorder(new TitledBorder("Dados "));
        return p;
    }

    private JPanel criarPainelExposicao() {
        JPanel p = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Exposição", SwingConstants.RIGHT);

        lbl.setPreferredSize(LABEL_TAMANHO);

        p.setBorder(new EmptyBorder(0, 0,
                0, 0));

        p.add(lbl);
        p.add(getListaExposicao());

        return p;
    }

    private JComboBox getListaExposicao() {

//        comboBoxExposicao = Utils.criarComboExpo(); para utilizar com controller
        comboBoxExposicao = new JComboBox(); //teste
        comboBoxExposicao.setSelectedIndex(-1);
        comboBoxExposicao.setEditable(false);
        comboBoxExposicao.setPreferredSize(new Dimension(200, 20));
        comboBoxExposicao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                comboBoxExposicao.setEnabled(false);
            }
        });
        return comboBoxExposicao;
    }

    public JPanel criarPainelTabela() {
        JPanel painel = new JPanel(new FlowLayout());
        painel.setBorder(new TitledBorder("Estatisticas:"));

        String[] columnNames = {"FAE",
            "Média das classificações do FAE",
            "Média dos desvios",
            "Valor observado da estatistica de teste",
            "Decisão Alerta:Sim/Não",};

        Object[][] data = {
            {new Integer(1), new String(" "), new String(" "), new String(" "), new String(" ")},
            {new Integer(2), new String(" "), new String(" "), new String(" "), new String(" ")},
            {new Integer(3), new String(" "), new String(" "), new String(" "), new String(" ")},};

        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 80));
        table.setFillsViewportHeight(true);

        //table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                imprimirDadosTabela(table);

            }
        });

        JScrollPane scrollPane = new JScrollPane(table);

        painel.add(scrollPane);

        return painel;
    }

    private void imprimirDadosTabela(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Dados: ");
        for (int i = 0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j = 0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    private JButton criarBotaoCancelar() {
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener((ActionEvent e) -> {
            dispose();
        });
        return btnCancelar;
    }

    class AlinharCentro extends DefaultTableCellRenderer {

        public AlinharCentro() {
            setHorizontalAlignment(CENTER); // ou LEFT, RIGHT, etc
        }
    }

}
