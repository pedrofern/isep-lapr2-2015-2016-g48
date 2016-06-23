/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import lapr.project.model.*;
import lapr.project.controller.*;
import lapr.project.model.lists.*;
import lapr.project.utils.*;

/**
 *
 * @author anasilva
 */
public class EstatisticasCandidaturasExposicaoUI extends JFrame{
    
    private CentroExposicoes ce;
    private JComboBox combolistaCandidaturas;
    private final EstatisticasCandidaturasExposicaoController controller;
    private boolean DEBUG = false;
    private JPanel painel,pCand;
    private List<Candidatura> lst;
    
   
   public EstatisticasCandidaturasExposicaoUI(CentroExposicoes ce) {
        
        super("Estatisticas");
        this.ce=ce;
        
        controller= new EstatisticasCandidaturasExposicaoController(ce);
        
       
        criarComponentes();
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(800, 100));
        setLocationRelativeTo(null);
        setVisible(true);
        
   }
        
        public JPanel criarTabela(){
            
            painel.setBorder(new TitledBorder("Estatisticas:"));
            //painel.add(combolistaCandidaturas,BorderLayout.NORTH);
            
            String[] columnNames = {"Candidaturas",
                                    "Aceitacao",
                                    "Valor Medio Submissao (Global)",
                                    "Valor medio Submissao (Exposicoes)",
                                    "Taxa Aceitacao candidaturas (Global)",
                                    "Taxa de Aceitacao candidaturas (Exposicao)"
                                    };
 
        Object[][] data = {
        {new Integer(5), new String("Sim"),new Integer(5),new Integer(5),new Integer(5),new Integer(5)},
        {new Integer(3), new String("Nao"),new Integer(3),new Integer(3),new Integer(3),new Integer(3)},
        {new Integer(2), new String("Nao"),new Integer(2),new Integer(2),new Integer(2),new Integer(2)},
        {new Integer(2), new String("Sim"),new Integer(2),new Integer(2),new Integer(2),new Integer(2)},
        {new Integer(2), new String("Sim"),new Integer(2),new Integer(2),new Integer(2),new Integer(2)},
        {new Integer(2), new String("Nao"),new Integer(2),new Integer(2),new Integer(2),new Integer(2)}
        };
 
        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setFillsViewportHeight(true);
 
        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    imprimirDadosTabela(table);
                }
            });
        }
 
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
 
        //Add the scroll pane to this panel.
        add(scrollPane);
        
        return painel;
    }
//        
      
    public void criarComponentes(){
        
        painel=new JPanel();
        painel.setLayout(new BorderLayout());
     
        add(criarPainelWest(), BorderLayout.NORTH);
        add(criarTabela(),BorderLayout.NORTH);
        
        
    }
    
    private JPanel criarPainelWest(){
        pCand= new JPanel(new BorderLayout());

        pCand.add(criarPainelCandidaturas((ListaCandidaturas)controller.getListaCandidaturas()));        
                
        return pCand;
    }
    
    
    public JPanel criarPainelCandidaturas(ListaCandidaturas lst ){
        JPanel p= new JPanel(new BorderLayout());
        
        painel.setBorder(new TitledBorder("Candidaturas:"));
        combolistaCandidaturas = Utils.criarComboCand(lst);
        painel.add(combolistaCandidaturas,BorderLayout.NORTH);
        
        return painel;
    }

    private void imprimirDadosTabela(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();
 
        System.out.println("Dados: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void criaMostraInterface() {
        //Create and set up the window.
        JFrame frame = new JFrame("Estatisticas Candidaturas Exposicao");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CentroExposicoes ce=new CentroExposicoes();
 
        //Create and set up the content pane.
        EstatisticasCandidaturasExposicaoUI newContentPane = new EstatisticasCandidaturasExposicaoUI(ce);
        //newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                criaMostraInterface();
            }
        });
    }
    
}
