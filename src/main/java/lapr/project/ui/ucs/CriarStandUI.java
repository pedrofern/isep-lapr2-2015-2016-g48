/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import lapr.project.model.*;
import lapr.project.controller.*;

/**
 *
 * @author anasilva
 */
public class CriarStandUI extends JFrame{
    
    private static CentroExposicoes ce;
    private transient CriarStandController controller;
    private static JTextArea descricao,area;
    private static Stand s;
    private Utilizador user;
    private JList listaStands;
    private JButton botaoAdicionarStand, botaoRemoverStand;
    
    
    private static final int MARGEM_SUPERIOR = 20;
    private static final int MARGEM_INFERIOR = 20;
    private static final int MARGEM_ESQUERDA = 20;
    private static final int MARGEM_DIREITA  = 20;
  
    
    private static final int WIDTH=400, HEIGHT=400;
    
    
    public CriarStandUI(CentroExposicoes centroExposicoes,Utilizador user) {
       
        ce = centroExposicoes;
        this.user=user;
        controller = new CriarStandController(ce);
       
        criarComponentes();
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        
    }
        
        private void criarComponentes(){
        JPanel p=new JPanel();
        
        this.setTitle("Definir Stand");
        p.setLayout(new FlowLayout());
        //p.add(criarPainelRecurso(), BorderLayout.NORTH);
        p.add(criarPainelListas(),BorderLayout.CENTER);
        //p.add(criarPainelBotoes(), BorderLayout.SOUTH);
        
        add(p);
    } 
        
        private JPanel criarPainelListas() {
        final int NUMERO_LINHAS = 1, NUMERO_COLUNAS = 2;
        final int INTERVALO_HORIZONTAL = 20, INTERVALO_VERTICAL = 0;
        JPanel p = new JPanel(new GridLayout( NUMERO_LINHAS, 
                                              NUMERO_COLUNAS, 
                                              INTERVALO_HORIZONTAL,
                                              INTERVALO_VERTICAL));        
        ModeloListaStands modeloListaStands = new ModeloListaStands(controller.getRegistoStands());
        listaStands = new JList(modeloListaStands);
        botaoAdicionarStand = criarBotaoAdicionarStand();
        botaoRemoverStand = criarBotaoRemoverStand();
        p.add(criarPainelListaStand( "Stands:",
                                listaStands,
                                botaoAdicionarStand,
                                botaoRemoverStand));
        

        return p;
    }
        
        private JPanel criarPainelListaStand(
            String tituloLista,
            JList lstLista,
            JButton btnSuperior,
            JButton btnInferior)
    {
        lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(lstLista);

        JPanel p = new JPanel(new BorderLayout());
        
        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(tituloLista),
                new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA)));
        
        p.add(scrPane, BorderLayout.CENTER);

        JPanel pBotoes = criarPainelBotoesListaStand(btnSuperior,btnInferior);
        p.add(pBotoes, BorderLayout.SOUTH);
        return p;
    }
        
        private JPanel criarPainelBotoesListaStand(JButton btn1, JButton btn2) {

        final int NUMERO_LINHAS = 2;
        final int NUMERO_COLUNAS = 1;
        final int INTERVALO_HORIZONTAL = 0;
        final int INTERVALO_VERTICAL = 10;        
        JPanel p = new JPanel(new GridLayout( NUMERO_LINHAS, 
                                              NUMERO_COLUNAS, 
                                              INTERVALO_HORIZONTAL,
                                              INTERVALO_VERTICAL));
        
        p.setBorder(BorderFactory.createEmptyBorder( MARGEM_SUPERIOR, 
                                                     MARGEM_ESQUERDA,
                                                     MARGEM_INFERIOR, 
                                                     MARGEM_DIREITA));
        
        p.add(btn1);
        p.add(btn2);
        
        return p;
    }
        

      
      private JButton criarBotaoAdicionarStand(){
        botaoAdicionarStand = new JButton("Adicionar Stand");
        botaoAdicionarStand.setMnemonic(KeyEvent.VK_A);
        botaoAdicionarStand.setToolTipText("Adiciona Stand");
        botaoAdicionarStand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DialogoCriarStand(CriarStandUI.this);
            }
        });

        return botaoAdicionarStand;
    }
    /**
     * cria botão eliminar produto
     * @return botão eliminar produto
     */
    public JButton criarBotaoRemoverStand(){
        botaoRemoverStand = new JButton("Eliminar Recurso");
        botaoRemoverStand.setMnemonic(KeyEvent.VK_E);
        botaoRemoverStand.setToolTipText("Elimina recursos");
        botaoRemoverStand.setEnabled(true);
        botaoRemoverStand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Stand[] opcoes = controller.getRegistoStands().getArray();
                Stand stand = (Stand) JOptionPane.showInputDialog(
                        CriarStandUI.this,
                        "Escolha um stand:", "Eliminar stand",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        opcoes,
                        opcoes[0]);
                if (stand != null) {
                    String[] opcoes2 = {"Sim", "Não"};
                    int resposta = JOptionPane.showOptionDialog(
                            CriarStandUI.this,
                            "Eliminar\n" + stand.toString(),
                            "Eliminar Stand",
                            0,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcoes2,
                            opcoes2[1]);
                    final int SIM = 0;
                    if (resposta == SIM) {
                        JList lista = getListaStands();
                        ModeloListaStands modeloListaStands
                                = (ModeloListaStands) lista.getModel();
                        modeloListaStands.removeElement(stand);
                        if (modeloListaStands.getSize() == 0) {
                            getBotaoRemoverStand().setEnabled(false);
                        }
                    }
                }
            }
        });

        return botaoRemoverStand;
    }
    
    public JList getListaStands() {
        return listaStands;
    }
    
    public JButton getBotaoRemoverStand(){
        return botaoRemoverStand;
    }
      
      public JPanel criarPainelBotoes(){
          
        JButton btnCancelar = criarBotaoSair();
        JButton btnLimpar   = criarBotaoLimpar();

        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(btnCancelar);
        p.add(btnLimpar);

        return p;
      }
      
      private JButton criarBotaoLimpar() {

        JButton btn = new JButton("Limpar");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                descricao.setText(null);
                area.setText(null);
                
            }
        });
        return btn;
    }
    
    
    private JButton criarBotaoSair() {
        JButton btn = new JButton("Sair");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                terminar();
                dispose();
            }
        });
        return btn;
    }
    
}
