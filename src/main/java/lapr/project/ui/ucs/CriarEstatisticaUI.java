/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Utilizador;

/**
 *
 * @author Edu
 */
public class CriarEstatisticaUI extends JFrame {

    private DefaultTableModel modeloTabela;
    private JTable tabela;
    private Exposicao exposicao;
    private CentroExposicoes centro;
    private Utilizador utilizador;
    private String[] titulo = {"FAE", "Nº de submissões", "Média das classificações do FAE", "Média dos desvios", "Valor observado da estatistica de teste", "Decisão Alerta:Sim/Não"};
    private Object[][] linha = new Object[10][10];

    public CriarEstatisticaUI(CentroExposicoes centro, Utilizador utilizador) throws FileNotFoundException {

        super("Estatistica");
        this.centro = centro;
        this.utilizador = utilizador;

        criarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void criarComponentes() throws FileNotFoundException {

        add(criarPainelCentro(), BorderLayout.CENTER);
    }

    private JPanel criarPainelCentro() {

        JPanel p = new JPanel(new FlowLayout());

        tabela = new JTable();

        TableModel dataModel = new AbstractTableModel() {
            public int getColumnCount() {
                return titulo.length;
            }

            public int getRowCount() {
                return linha.length;
            }

            public Object getValueAt(int row, int col) {
                return linha[row][col];
            }

            public String getColumnName(int column) {
                return titulo[column];
            }

            public Class getColumnClass(int col) {
                return getValueAt(0, col).getClass();
            }
        };

        tabela.setModel(dataModel);
        p.add(criarPainelTabela(tabela));
        return p;
    }

    public JPanel criarPainelTabela(JTable tabela) {

        JPanel painel = new JPanel(new BorderLayout());
        ListSelectionModel listMod = tabela.getSelectionModel();
        listMod.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listMod.addListSelectionListener(new Selecao(tabela));
        tabela.setPreferredScrollableViewportSize(new Dimension(350, 50));
        JScrollPane scrPane = new JScrollPane(tabela);
        

        painel.add(scrPane, BorderLayout.CENTER);
        return painel;
    }

    class Selecao implements ListSelectionListener {

        private JTable tabela;

        public Selecao(JTable tb) {
            this.tabela = tb;
        }

        public void valueChanged(ListSelectionEvent e) {
            int maxRows;
            int[] selRows;
            Object value;

            if (!e.getValueIsAdjusting()) {
                selRows = tabela.getSelectedRows();

                if (selRows.length > 0) {
                    for (int i = 0; i < 3; i++) {
                        TableModel tm = tabela.getModel();
                        value = tm.getValueAt(selRows[0], i);
                        System.out.println("Selecao : " + value);
                    }
                    System.out.println();
                }
            }
        }
    }
}
