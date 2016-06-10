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
import java.util.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import lapr.project.model.*;
import lapr.project.ui.*;
import lapr.project.utils.Utils;

/**
 *
 * @author Diana Silva
 */
public class AvaliarCandidaturaUI extends JFrame{

    private CentroExposicoes m_centroDeExposicoes;
    private AvaliarCandidaturaController m_controllerAC;
    private Utilizador m_user;
    
     /**
     * Guarda a largura mínima da janela em píxeis.
     */
    private static final int JANELA_LARGURA_MINIMO = 650;
    /**
     * Guarda a altura mínima da janela em píxeis.
     */
    private static final int JANELA_ALTURA_MINIMO = 275; 
    
    private CentroExposicoes m_ce;
    
    private String pergunta="Pretende cancelar a avaliação da candidatura?";
    
    private JPanel painelNorte;
    private JPanel painelCentro;
    
    private JComboBox comboExpos;
    
    private JComboBox comboCands;

    public AvaliarCandidaturaUI(CentroExposicoes ce, Utilizador user) {
        
        super("Avaliar Candidatura");
        
        m_ce = ce;
        m_controllerAC = new AvaliarCandidaturaController(m_centroDeExposicoes);
        user=m_user;
        
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
        painelNorte=new JPanel();
        painelNorte.setLayout(new BorderLayout());
        
        criarPainelNorte();
        criarPainelCentro();
        
        add(painelNorte,BorderLayout.NORTH);
        add(painelCentro, BorderLayout.CENTER);
        add(criarPainelBotoes(),BorderLayout.SOUTH);
        
    }
    
    private void criarPainelNorte(){
        painelNorte=new JPanel();
        painelNorte.add(criarComboExposicoes());
    }
    
    private JPanel criarComboExposicoes(){
        JPanel p=new JPanel();
        
        p.setLayout(new BorderLayout());
        
        comboExpos=Utils.criarComboExpo(m_controllerAC.getRegistoExposicoes());
        
        p.add(comboExpos, BorderLayout.CENTER);
        p.add(criarPainelBtsExpo(), BorderLayout.SOUTH);
        
        return p;
    }
    
    
    private JPanel criarPainelBtsExpo(){
        JPanel painelBts=new JPanel();
        JButton btSelect= new JButton("Seleccionar");
        JButton btVoltar= new JButton("Voltar");
        
        painelBts.add(btSelect);
        painelBts.add(btVoltar);
        
        return painelBts;
    }
    
    private void criarPainelCentro(){
        painelCentro=new JPanel();
        
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
        JButton bt3 = criarBotaoCancelar();
        
        p.add(bt1);
        p.add(bt2);
        p.add(bt3);
        
        return p;
    }
    
    private JButton criarBotaoRegistar() {
        JButton botao = new JButton("Guardar");
        botao.setMnemonic(KeyEvent.VK_R);
        botao.setToolTipText("Guardar avaliação de candidatura");
        botao.addActionListener(new ActionListener() {
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
//                }
            }
        });

        return botao;
    }
    /**
     * criar botão limpar
     * @return botão limpar
     */
    private JButton criarBotaoLimpar() {
        JButton botao = new JButton("Limpar");
        botao.setMnemonic(KeyEvent.VK_L);
        botao.setToolTipText("Limpa dados gerais do novo utilizador");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                norte.getTxtNome().setText("");
//                norte.getTxtEmail().setText("");
//                norte.getTxtPassword().setText("");
//                norte.getTxtUsername().setText("");
            }
        });

        return botao;
    }
    
    /**
     * criar botão cancelar e volta menu anterior
     * @return botão cancelar e volta menu anterior 
     */
    private JButton criarBotaoCancelar() {
        JButton botao = new JButton("Cancelar");
        botao.setMnemonic(KeyEvent.VK_S);
        botao.setToolTipText("Cancela o registo de utilizador e volta ao menu anterior");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecharJanela(pergunta);
            }
        });

        return botao;
    }
    
     private void guardar() {
            String nome,email,pass,user;
//            nome = norte.getTxtNome().getText();
//            email = norte.getTxtEmail().getText();
//            pass = norte.getTxtPassword().getText();
//            user = norte.getTxtUsername().getText();
//            m_controllerRU.novoUtilizador();
//            m_controllerRU.criaUtilizador(nome, email, user, pass);
                JOptionPane.showMessageDialog(
                            null,
//                            "Dados novo utilizador registado: \n"
//                                    +"\nUsername: "+user
//                                    +"\nPassword: "+pass
//                                    +"\nNome: "+nome
//                                    +"\nEmail: "+email,
//                            "Registar Utilizador",
                            JOptionPane.INFORMATION_MESSAGE);    
            dispose();
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
    }
        
 
    
    

    
//    public void run() {
//
//        List<Exposicao> le = m_controllerDC.iniciarAvaliacao();
//
//        apresentaExposicoes(le);
//
//        Exposicao e = selecionaExposicao(le);
//
//        if (e != null) {
//            m_controllerDC.selectExposicao(e);
//
//            String strResposta = Utils.readLineFromConsole("Introduza a Resposta à Candidatura: ");
//            String strJustificacao = Utils.readLineFromConsole("Introduza a Justificação dessa Resposta: ");
//
//            m_controllerDC.setAvaliacao(strResposta, strJustificacao);
//
//            String strQuestao = "Confirma a decisao da candidatura com a seguinte informação: \n" + m_controllerDC.getInfoResumo() + "\n Opção (S/N):";
//            boolean bConfirma = confirma(strQuestao);
//
//            if (bConfirma) {
//                if (m_controllerDC.registarDecisao()) {
//                    System.out.println("Decisao concluida com sucesso.");
//                } else {
//                    System.out.println("Decisao cancelada devido a erros.");
//                }
//
//            } else {
//                System.out.println("Decisao de candidatura cancelada.");
//            }
//
//            System.out.println("Terminado.");
//        } else {
//            System.out.println("Decisao de candidatura cancelada.");
//        }
//
//    }

//    private Exposicao selecionaExposicao(List<Exposicao> le) {
//        String opcao;
//        int nOpcao;
//        do {
//            opcao = Utils.readLineFromConsole("Introduza opção: ");
//            nOpcao = new Integer(opcao);
//        } while (nOpcao < 0 || nOpcao > le.size());
//
//        if (nOpcao == 0) {
//            return null;
//        } else {
//            return le.get(nOpcao - 1);
//        }
//    }
//
//    private void apresentaExposicoes(List<Exposicao> le) {
//        System.out.println("Exposicoes: ");
//
//        int index = 0;
//        for (Exposicao e : le) {
//            index++;
//
//            System.out.println(index + ". " + e.toString());
//        }
//        System.out.println("");
//        System.out.println("0 - Cancelar");
//    }
//
//    private boolean confirma(String questao) {
//        String strConfirma;
//        do {
//            strConfirma = Utils.readLineFromConsole(questao);
//        } while (!strConfirma.equalsIgnoreCase("s") && !strConfirma.equalsIgnoreCase("n"));
//
//        return strConfirma.equalsIgnoreCase("s");
//    }
