
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
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import lapr.project.controller.AnaliseAvaliacaoFaeController;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.FAE;
import lapr.project.model.Utilizador;
import lapr.project.utils.Utils;

/**
 *
 * @author Edu e Diana
 */
public class AnaliseAvaliacaoFaeUI extends JFrame {

    private JButton btnEliminarFAE, btnAdicionarUtilizador, btnConfirmar, btnCancelar;
    private final CentroExposicoes centro;
    private final Utilizador utilizador;
    private JComboBox comboBoxExposicao;
    private static final Dimension LABEL_TAMANHO = new JLabel("Valor observado da estatistica de teste").getPreferredSize();
    private transient AnaliseAvaliacaoFaeController controller;
    private JTable table;
    private DefaultTableModel modeloEstatistica;
    private JComboBox<Double> comboIC;
    
    
    public AnaliseAvaliacaoFaeUI(CentroExposicoes centro, Utilizador utilizador) throws FileNotFoundException {

        this.centro = centro;
        this.utilizador = utilizador;
        
        controller=new AnaliseAvaliacaoFaeController(centro, utilizador);

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
        p.add(getComboIC());
        p.add(getListaExposicao());
        
        
        

        return p;
    }
    
    private JComboBox getComboIC(){
        comboIC= new JComboBox<>();
        comboIC.addItem(90.00);
        comboIC.addItem(95.00);
        comboIC.addItem(99.00);
        comboIC.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setIntervaloConfianca((double)comboIC.getSelectedItem());
                comboIC.setEnabled(false);
            }
            
        });
        return comboIC;
    }

    private JComboBox getListaExposicao() {
 
        comboBoxExposicao = Utils.criarComboExpo(controller.getExposicoes()); 
        comboBoxExposicao.setSelectedIndex(-1);
        comboBoxExposicao.setEditable(false);
        comboBoxExposicao.setPreferredSize(new Dimension(200, 20));
        comboBoxExposicao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                comboBoxExposicao.setEnabled(false);
                controller.setExposicao((Exposicao)comboBoxExposicao.getSelectedItem());
                try{
                controller.setIntervaloConfianca((double)comboIC.getSelectedItem());
                
               String[] columnNames = {"FAE",
                                        "Média das classificações do FAE",
                                        "Média dos desvios",
                                        "Valor observado da estatistica de teste",
                                        "Decisão Alerta:Sim/Não",};
                for (String columnName : columnNames) {
                    modeloEstatistica.addColumn(columnName);
                }
                
               
               for(FAE f: controller.getListaFAE().getListaFAE()){
                        modeloEstatistica.addRow(controller.toStringEstatistica(f));
  
                }   

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Não existem FAE com candidaturas avaliadas",
                        "Análise FAE",
                        JOptionPane.ERROR_MESSAGE);
            }
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

        Object[][] data ={{"sem FAE","seleccione a exposição",""}}; 

        table = new JTable(data, columnNames);
        modeloEstatistica=new DefaultTableModel();
        
        table.setModel(modeloEstatistica);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 80));
        table.setFillsViewportHeight(true);


        JScrollPane scrollPane = new JScrollPane(table);

        painel.add(scrollPane);

        return painel;
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




