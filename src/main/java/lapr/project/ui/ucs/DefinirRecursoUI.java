package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lapr.project.controller.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
    
    private static final int WIDTH=350, HEIGHT=350;
    
    
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
        p.add(criarPainelRecurso(), BorderLayout.NORTH);
        p.add(criarPainelBotoes(), BorderLayout.SOUTH);
        
        add(p);
    }  
        
      public JPanel criarPainelRecurso(){
       
         JPanel p = new JPanel(new FlowLayout());

        text = new JTextArea();
        text.setPreferredSize(new Dimension(250, 200));
        text.setBorder(new TitledBorder("Insira o recurso pretendido"));
        text.requestFocus();

        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA, MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(text);
        
        return p;
  
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
    
//    private void terminar() {
//        this.ficheiroCentroExposicoes.guardar(this.centroExposicoes);
//        dispose();
//    }
    
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
        controller.setDescricao(descricao);
        
        for(Recurso r: ce.getRegistoRecursos().getListaRecursos()){
             System.out.println(r.toString());
        }
       
        
    }
        
}