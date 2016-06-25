package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import lapr.project.controller.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.TitledBorder;
import lapr.project.model.*;
import lapr.project.utils.Utils;

/**
 *
 * @author Diana Silva
 */
public class AvaliarCandidaturaUI extends JFrame{

    
    private static CentroExposicoes ce;
    private static AvaliarCandidaturaController controllerAC;
    private static Utilizador user;
    private static Exposicao exposicao;
    private static Candidatura candidatura;
    
     /**
     * Guarda a largura mínima da janela em píxeis.
     */
    private static final int JANELA_LARGURA_MINIMO = 700;
    /**
     * Guarda a altura mínima da janela em píxeis.
     */
    private static final int JANELA_ALTURA_MINIMO = 400; 
        
    private static final String PERGUNTA="Pretende cancelar a avaliação da candidatura?";
    
    private static AvaliarSubPainelAvaliar pAvaliar;
    private AvaliarSubPainelCands pCands;
    private static AvaliarSubPainelJustificacao pJustificacao;
    private JPanel pExpos, painel;
    
    private JComboBox comboExpos;
    private JButton selExpo, btGuardar;
    
    public AvaliarCandidaturaUI(CentroExposicoes centroExposicoes, Utilizador utilizador) {
        
        super("Avaliar Candidatura");
        
        ce = centroExposicoes;
        controllerAC = new AvaliarCandidaturaController(ce);
        user=utilizador;
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fecharJanela("Pretende voltar ao menu principal?");
            }
        });

        criarComponentes();
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setSize(new Dimension(JANELA_LARGURA_MINIMO, JANELA_ALTURA_MINIMO));
        setMinimumSize(new Dimension(JANELA_LARGURA_MINIMO, JANELA_ALTURA_MINIMO));
        setLocationRelativeTo(null);
        setVisible(true);     
    }
    
    private void criarComponentes(){
        painel=new JPanel();
        painel.setLayout(new BorderLayout());
        
        pCands=new AvaliarSubPainelCands(controllerAC, this);
        pAvaliar=new AvaliarSubPainelAvaliar(controllerAC,this);
        
        criarPainelExpos();
        
        JPanel painelOeste=new JPanel();
        painelOeste.setLayout(new BorderLayout());
        painelOeste.add(pExpos, BorderLayout.CENTER);
        painelOeste.add(pCands, BorderLayout.NORTH);
        
        painel.add(painelOeste, BorderLayout.NORTH);
        painel.add(pAvaliar, BorderLayout.CENTER);
      
        painel.add(criarPainelBotoes(), BorderLayout.SOUTH);
        
        btGuardar.setEnabled(false);

        add(painel);
    }
    
    private void criarPainelExpos(){
        pExpos=new JPanel();
        pExpos.setLayout(new FlowLayout());
        pExpos.setBorder(new TitledBorder("Seleccione a exposição: "));
        
        comboExpos=Utils.criarComboExpo(controllerAC.getExposicoesAtribuidasFAE());
        
        pExpos.add(comboExpos);
        pExpos.add(criarBtSelect());
    }
    
    private JButton criarBtSelect(){
        selExpo=new JButton("Selecionar");
        selExpo.setMnemonic(KeyEvent.VK_S);
        selExpo.setToolTipText("Selecionar exposição da lista");
        
        selExpo.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {

                controllerAC.selectExposicao((Exposicao) comboExpos.getSelectedItem());               
                
                pCands.mostrarPainel();
                
                pExpos.setVisible(false);
                pCands.setVisible(true);
                
               selExpo.setEnabled(false);
            }     
        }
        );
        
        return selExpo;
    
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
        
        JButton bt2=criarBotaoRegistar();
        JButton bt3 = criarBotaoCancelar();
        
        p.add(bt2);
        p.add(bt3);
        
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
    
    private void guardar() {
            
            if(controllerAC.registarDecisao())
                 JOptionPane.showMessageDialog( null,
                        controllerAC.getInfoAvaliacao(),
                        "Avaliação registada",
                        JOptionPane.INFORMATION_MESSAGE);
            dispose();
    }
    
    /**
     * criar botão cancelar e volta menu anterior
     * @return botão cancelar e volta menu anterior 
     */
    private JButton criarBotaoCancelar() {
        JButton botao = new JButton("Cancelar");
        botao.setMnemonic(KeyEvent.VK_S);
        botao.setToolTipText("Cancela o registo de utilizador e volta ao menu anterior");
        botao.addActionListener((ActionEvent e) -> {
            fecharJanela(PERGUNTA);
        });

        return botao;
    }
        
        private void fecharJanela(String pergunta){
//        if (norte.getTxtNome().getText()!=""||
//                norte.getTxtEmail().getText()!=""||
//                norte.getTxtPassword().getText()!=""||
//                norte.getTxtUsername().getText()!=""){
            String[] opcoes = {"Sim", "Não"};
            
            int opcao = JOptionPane.showOptionDialog(new Frame(), pergunta,
                    "Registar utilizador", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
            if (opcao == JOptionPane.YES_OPTION) {                        
                dispose();
            } else {
                 setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);                       
            }
        }
        
        public static AvaliarSubPainelAvaliar getPainelAvaliar(){
            return pAvaliar;
        }
        
        public static AvaliarSubPainelJustificacao getPainelJustificar() {
            return pJustificacao;
        }
     
        public void setBotaoGuardarEnable(){
            btGuardar.setEnabled(true);
        }
    }