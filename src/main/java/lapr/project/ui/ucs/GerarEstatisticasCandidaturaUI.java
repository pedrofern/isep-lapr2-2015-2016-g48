/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import lapr.project.controller.*;
import lapr.project.model.Candidatura;
import lapr.project.model.CentroExposicoes;
import lapr.project.utils.Utils;
import lapr.project.model.*;
import lapr.project.model.lists.*;

/**
 *
 * @author anasilva
 */
public class GerarEstatisticasCandidaturaUI extends JFrame{
    
    private static CentroExposicoes ce;
    private JComboBox combolistaExposicoes;
    private final GerarEstatisticasCandidaturaController controller;
    private JPanel painel,pExpo;
    private List<Candidatura> lst;
    private static Utilizador user;
    private Exposicao expo;
    private JLabel lblValorMedioExposicao, lblValorMedioGlobal;
    private JTable table;
    private DefaultTableModel modeloEstatistica;
   
   
   public GerarEstatisticasCandidaturaUI(CentroExposicoes ce, Utilizador user) {
        
        super("Estatisticas");
        this.ce=ce;
        this.user=user;
        controller= new GerarEstatisticasCandidaturaController(ce,user);
        
        criarComponentes();
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(800, 100));
        setLocationRelativeTo(null);
        setVisible(true);
        
   }
        
        public JPanel criarTabela(){
            
            painel.setBorder(new TitledBorder("Exposicoes:"));
            
            String[] columnNames = {"Candidaturas",
                                    "Aceitacao",
                                    "Valor medio Submissao",
                                    };
            
             String[][] data={{"sem candidaturas","seleccione a exposição",""}};
             table = new JTable(data, columnNames);
        
             modeloEstatistica=new DefaultTableModel();
    
             table.setModel(modeloEstatistica);
        
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setFillsViewportHeight(true);
 
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

        add(criarPainelWest(), BorderLayout.SOUTH);
        add(criarTabela(),BorderLayout.NORTH);
    }
    
    private JPanel criarPainelLabels(){
        JPanel p=new JPanel();
        p.setLayout(new BorderLayout());
        lblValorMedioExposicao=new JLabel();
        lblValorMedioExposicao.setText("Valor médio submissão (Exposição): seleccione a exposição");
        
        lblValorMedioGlobal=new JLabel();
        lblValorMedioGlobal.setText("Valor médio submissão (CentroExposições): "+  controller.getValorMedioSubmissaoGlobal());
        
        p.add(lblValorMedioExposicao, BorderLayout.WEST);
        p.add(lblValorMedioGlobal, BorderLayout.EAST);
        
        return p;
    }
    
    private JPanel criarPainelWest(){
        pExpo= new JPanel(new BorderLayout());

        pExpo.add(criarPainelExposicoes());
                
        return pExpo;
    }
    
    
    public JPanel criarPainelExposicoes(){
        JPanel p= new JPanel(new BorderLayout());
        
        painel.setBorder(new TitledBorder("Exposicões"));
        combolistaExposicoes = Utils.criarComboExpo(controller.getRegistoExposicoesOrganizador());
        
        combolistaExposicoes.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
         
                controller.setExposicao((Exposicao)combolistaExposicoes.getSelectedItem());
                
                
                String[] columnNames = {"Candidaturas",
                                    "Aceitacao",
                                    "Valor medio Submissao",
                                    };
                for (String columnName : columnNames) {
                    modeloEstatistica.addColumn(columnName);
                }
               for(Candidatura c:controller.getListaCandidaturas().getListaCandidaturas()){
                        modeloEstatistica.addRow(c.toStringEstatistica());
  
                }   

               lblValorMedioExposicao.setText("Valor médio submissão (Exposição): " + controller.getValorMedioSubmissaoExposicao());

               lblValorMedioGlobal.setText("Valor médio submissão (CentroExposições): " + controller.getValorMedioSubmissaoGlobal());
           
                combolistaExposicoes.setEnabled(false);
            }
            
            
        });
        
        painel.add(combolistaExposicoes,BorderLayout.NORTH);
        painel.add(criarPainelLabels(), BorderLayout.SOUTH);
        return painel;
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
 
        //Create and set up the content pane.
        GerarEstatisticasCandidaturaUI newContentPane = new GerarEstatisticasCandidaturaUI(ce,user);
        //newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                criaMostraInterface();
            }
        });
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
}
    
    
}
