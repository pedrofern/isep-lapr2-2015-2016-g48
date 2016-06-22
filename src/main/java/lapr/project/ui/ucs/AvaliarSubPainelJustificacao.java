
package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import lapr.project.controller.AvaliarCandidaturaController;
import lapr.project.model.Avaliacao;
import lapr.project.model.Candidatura;

/**
 *
 * @author DIana
 */
public class AvaliarSubPainelJustificacao extends JPanel implements Serializable{
    
    private Candidatura candidatura;
    private Avaliacao avaliacao;
    private AvaliarCandidaturaController controllerAC;
    
    private final int CAMPO_LARGURA = 30;
    private JTextArea txt;
    private JRadioButton button1, button2;
    private static JButton btGuardar;
    
    
    public AvaliarSubPainelJustificacao (AvaliarCandidaturaController pController){
        super();
        
        controllerAC=pController;
    }
    
    public void mostrarPainel(){
        setLayout(new BorderLayout());
        
        add(criarPainelAvaliacao(), BorderLayout.CENTER);
        add(criarPainelBotoes(), BorderLayout.SOUTH);
    }
    
    public void setCand(Candidatura c){
        candidatura=c;
    }

    private JPanel criarPainelAvaliacao() {
        JPanel pAvaliacao=new JPanel();
        pAvaliacao.setLayout(new BorderLayout());
        
        pAvaliacao.add(criarPainelJustificacao(), BorderLayout.CENTER);
        pAvaliacao.add(criarPainelDecisao(), BorderLayout.SOUTH);
 
        return pAvaliacao;   
            
    }

    private JPanel criarPainelJustificacao() {
        JPanel pJustificacao=new JPanel();
        pJustificacao.setLayout(new BorderLayout());
        pJustificacao.setBorder(new TitledBorder("Justificação")); 
        
        txt= new JTextArea();
        txt.setPreferredSize(new Dimension(240, 100));

        pJustificacao.add(txt, BorderLayout.CENTER);
        
        return pJustificacao;
    }

    private JPanel criarPainelDecisao() {
       JPanel pDecisao=new JPanel();
        pDecisao.setLayout(new BorderLayout());
        pDecisao.setBorder(new TitledBorder("Avaliação")); 
        
        pDecisao.add(criarPainelRadioButtons());
        
        return pDecisao;
    }
    
    private JPanel criarPainelRadioButtons(){
        
        JPanel p=new JPanel();
        p.setLayout(new BorderLayout());
        
        button1=new JRadioButton("Aceite");
        button2=new JRadioButton("Recusada");
        
        ButtonGroup grupoBotoes=new ButtonGroup();
        grupoBotoes.add(button1);
        grupoBotoes.add(button2);
        
        JPanel painelRadio=new JPanel();
        painelRadio.setLayout(new GridLayout(1,2));
        painelRadio.add(button1);
        painelRadio.add(button2);
     
        p.add(painelRadio);
        return p;
    }
    
    
     /**
     * cria painel botões
     * @return painel botões
     */
    private JPanel criarPainelBotoes() {

        FlowLayout l = new FlowLayout();

        l.setHgap(20);
        l.setVgap(20);

        JPanel p = new JPanel(l);

        JButton bt1 = criarBotaoRegistar();
        JButton bt2 = criarBotaoLimpar();
        
        p.add(bt1);
        p.add(bt2);
        
        return p;
    }
    
    private JButton criarBotaoRegistar() {
        btGuardar = new JButton("Guardar");
        btGuardar.setMnemonic(KeyEvent.VK_R);
        btGuardar.setToolTipText("Introduza todos os dados solicitados para poder guardar");
        btGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if(norte.getTxtNome().getText().isEmpty()==true||
//                    norte.getTxtEmail().getText().isEmpty()==true||
//                    norte.getTxtPassword().getText().isEmpty()==true||
//                    norte.getTxtUsername().getText().isEmpty()==true){
//                        JOptionPane.showMessageDialog(
//                            null,
//                            "Tem de preencher todos os campos!",
//                            "Registar Utilizador",
//                            JOptionPane.ERROR_MESSAGE);                        
//                }else{
                   guardar();

            }
        });

        return btGuardar;
    }
    /**
     * criar botão limpar
     * @return botão limpar
     */
    private JButton criarBotaoLimpar() {
        JButton botao = new JButton("Limpar");
        botao.setMnemonic(KeyEvent.VK_L);
        botao.setToolTipText("Limpa dados gerais do novo utilizador");
        botao.addActionListener((ActionEvent e) -> {
//                norte.getTxtNome().setText("");
//                norte.getTxtEmail().setText("");
//                norte.getTxtPassword().setText("");
//                norte.getTxtUsername().setText("");
        });

        return botao;
    }
        
    private boolean getAvaliacao(){
        return button1.isSelected();
    }

     private void guardar() {

            controllerAC.setAvaliacao(getAvaliacao(),txt.getText());
            if(controllerAC.registarDecisao())
                 JOptionPane.showMessageDialog( null,
                        controllerAC.getInfoAvaliacao(),
                        "Avaliação registada",
                        JOptionPane.INFORMATION_MESSAGE);
            
    }
}
