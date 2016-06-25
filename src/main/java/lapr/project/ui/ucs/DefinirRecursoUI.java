package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import lapr.project.controller.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.model.*;


/**
 *
 * @author Ana
 */
public class DefinirRecursoUI extends JFrame {

    private static CentroExposicoes ce;
    private DefinirRecursoController controller;
    private static JTextArea text;
    private static Recurso r;
    private JList listaRecursos;
    private JButton botaoAdicionarRecurso, botaoRemoverRecurso;
    
    
    private static final int MARGEM_SUPERIOR = 20;
    private static final int MARGEM_INFERIOR = 20;
    private static final int MARGEM_ESQUERDA = 20;
    private static final int MARGEM_DIREITA  = 20;
  
    
    private static final int WIDTH=400, HEIGHT=400;
    
    
    public DefinirRecursoUI(CentroExposicoes centroExposicoes) {
       
        ce = centroExposicoes;
        controller = new DefinirRecursoController(ce);
       
        criarComponentes();
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        
    }
        
        private void criarComponentes(){
        JPanel p=new JPanel();
        
        this.setTitle("Definir Recurso");
        p.setLayout(new FlowLayout());
        p.add(criarPainelListas(),BorderLayout.CENTER);
        p.add(criarPainelBotoes(), BorderLayout.SOUTH);
        
        add(p);
    } 
        
        private JPanel criarPainelListas() {
        final int NUMERO_LINHAS = 1, NUMERO_COLUNAS = 2;
        final int INTERVALO_HORIZONTAL = 20, INTERVALO_VERTICAL = 0;
        JPanel p = new JPanel(new GridLayout( NUMERO_LINHAS, 
                                              NUMERO_COLUNAS, 
                                              INTERVALO_HORIZONTAL,
                                              INTERVALO_VERTICAL));        
        ModeloListaRecursos modeloListaRecursos = new ModeloListaRecursos(controller.getRegistoRecursos());
        listaRecursos = new JList(modeloListaRecursos);
        botaoAdicionarRecurso = criarBotaoAdicionarRecurso();
        botaoRemoverRecurso = criarBotaoRemoverRecurso();
        p.add(criarPainelListaRecurso( "Recursos:",
                                listaRecursos,
                                botaoAdicionarRecurso,
                                botaoRemoverRecurso));
        

        return p;
    }
        
        private JPanel criarPainelListaRecurso(
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

        JPanel pBotoes = criarPainelBotoesListaRecurso(btnSuperior,btnInferior);
        p.add(pBotoes, BorderLayout.SOUTH);
        return p;
    }
        
        private JPanel criarPainelBotoesListaRecurso(JButton btn1, JButton btn2) {

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
        
        
        
      
      private JButton criarBotaoAdicionarRecurso(){
        botaoAdicionarRecurso = new JButton("Adicionar Recurso");
        botaoAdicionarRecurso.setMnemonic(KeyEvent.VK_A);
        botaoAdicionarRecurso.setToolTipText("Adiciona recurso");
        botaoAdicionarRecurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DialogoNovoRecurso(DefinirRecursoUI.this);
            }
        });

        return botaoAdicionarRecurso;
    }
    /**
     * cria botão eliminar produto
     * @return botão eliminar produto
     */
    public JButton criarBotaoRemoverRecurso(){
        botaoRemoverRecurso = new JButton("Eliminar Recurso");
        botaoRemoverRecurso.setMnemonic(KeyEvent.VK_E);
        botaoRemoverRecurso.setToolTipText("Elimina recursos");
        botaoRemoverRecurso.setEnabled(true);
        botaoRemoverRecurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Recurso[] opcoes = controller.getRegistoRecursos().getArray();
                Recurso recurso = (Recurso) JOptionPane.showInputDialog(
                        DefinirRecursoUI.this,
                        "Escolha um recurso:", "Eliminar recurso",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        opcoes,
                        opcoes[0]);
                if (recurso != null) {
                    String[] opcoes2 = {"Sim", "Não"};
                    int resposta = JOptionPane.showOptionDialog(
                            DefinirRecursoUI.this,
                            "Eliminar\n" + recurso.toString(),
                            "Eliminar Recurso",
                            0,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcoes2,
                            opcoes2[1]);
                    final int SIM = 0;
                    if (resposta == SIM) {
                        JList lista = getListaRecursos();
                        ModeloListaRecursos modeloListaRecuros
                                = (ModeloListaRecursos) lista.getModel();
                        modeloListaRecuros.removeElement(recurso);
                        if (modeloListaRecuros.getSize() == 0) {
                            getBotaoRemoverRecurso().setEnabled(false);
                        }
                    }
                }
            }
        });

        return botaoRemoverRecurso;
    }
    
    public JList getListaRecursos() {
        return listaRecursos;
    }
    
    public JButton getBotaoRemoverRecurso(){
        return botaoRemoverRecurso;
    }
      
      public JPanel criarPainelBotoes(){
          
        JButton btnOK = criarBotaoConfirmar();
        getRootPane().setDefaultButton(btnOK);

        JButton btnCancelar = criarBotaoSair();
        JButton btnLimpar   = criarBotaoLimpar();

        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(btnOK);
        p.add(btnCancelar);
        p.add(btnLimpar);

        return p;
      }
      
      private JButton criarBotaoLimpar() {

        JButton btn = new JButton("Limpar");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                text.setText(null);
                text.setText(null);
                
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
    
    private JButton criarBotaoConfirmar() {
        JButton btn = new JButton("Confirmar");
   
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(text.getText()==null|| text.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Não introduziu dados.");
                }else{
                    JOptionPane.showMessageDialog(null, "Operação efectuada com sucesso.");
                    guardar();
            }
              dispose();  
            }
        });
        return btn;
    }
    
    private void guardar(){
        
        String descricao;
        descricao=text.getText();
        controller.novoRecurso();
        controller.setRecurso(descricao);
        
        for(Recurso r: ce.getRegistoRecursos().getListaRecursos()){
             System.out.println(r.toString());
        }
       
        
    }
        
}