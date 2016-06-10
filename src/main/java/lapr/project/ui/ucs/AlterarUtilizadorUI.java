package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lapr.project.controller.AlterarUtilizadorController;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;
import lapr.project.ui.Janela;
import lapr.project.utils.Utils;
import lapr.project.ui.ucs.RegistarUtilizadorUI;

/**
 *
 * @author Diana
 */
public class AlterarUtilizadorUI extends JPanel{
    private CentroExposicoes m_ce;
    private Utilizador m_user;
    private AlterarUtilizadorController m_controller;
    private PainelDadosUtilizador norte;
    private String pergunta="Pretende cancelar a alteração do registo de utilizador?";
      

    public AlterarUtilizadorUI(CentroExposicoes ce, Utilizador user){
        
         
         super();
         m_ce=ce;
         m_user=user;
             
         m_controller=new AlterarUtilizadorController(m_ce);
         
         setLayout(new BorderLayout());
        add(criarPainel());
    }
    
    
    private JPanel criarPainel(){
        JPanel p =new JPanel();
        p.setLayout(new BorderLayout());
        norte = new PainelDadosUtilizador();
        norte.desativarUserNamePainelNorte();
        JPanel botoes = criarPainelBotoes();  
        
        p.add(norte, BorderLayout.NORTH);
        p.add(botoes, BorderLayout.SOUTH);
        
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
        JButton bt3 = criarBotaoCancelar(pergunta);
        
        p.add(bt1);
        p.add(bt2);
        p.add(bt3);
        
        return p;
    }
    
    private void preencherDadosUtilizador(Utilizador utilizador){
        norte.preencherDadosUtilizador(utilizador);
    }
    
    private JButton criarBotaoRegistar() {
        JButton botao = new JButton("Registar Utilizador");
        botao.setMnemonic(KeyEvent.VK_R);
        botao.setToolTipText("Registar Utilizador");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(norte.getTxtNome().getText().isEmpty()==true||
                    norte.getTxtEmail().getText().isEmpty()==true||
                    norte.getTxtPassword().getText().isEmpty()==true||
                    norte.getTxtUsername().getText().isEmpty()==true){
                        JOptionPane.showMessageDialog(
                            null,
                            "Tem de preencher todos os campos!",
                            "Registar Utilizador",
                            JOptionPane.ERROR_MESSAGE);                        
                }else{
                    guardar();
                }
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
                norte.getTxtNome().setText("");
                norte.getTxtEmail().setText("");
                norte.getTxtPassword().setText("");
                norte.getTxtUsername().setText("");
            }
        });

        return botao;
    }
    
    /**
     * criar botão cancelar e volta menu anterior
     * @return botão cancelar e volta menu anterior 
     */
    private JButton criarBotaoCancelar(String pergunta) {
        JButton botao = new JButton("Cancelar");
        botao.setMnemonic(KeyEvent.VK_S);
        botao.setToolTipText("Cancela o registo de utilizador e volta ao menu anterior");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] opcoes = {"Sim", "Não"};
                
                int opcao=JOptionPane.showOptionDialog(new Frame(),pergunta,"Alterar Utilizador", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                        JOptionPane.showMessageDialog(AlterarUtilizadorUI.this, "Em construção", "Aviso",JOptionPane.WARNING_MESSAGE);
           
            
            
            }
        });

        return botao;
    }
    
     private void guardar() {
            String nome,email,pass,user;
            nome = norte.getTxtNome().getText();
            email = norte.getTxtEmail().getText();
            pass = norte.getTxtPassword().getText();
            user = norte.getTxtUsername().getText();

            m_controller.alteraUtilizador(nome, email, user, pass);
                JOptionPane.showMessageDialog(
                            null,
                            "Dados novo utilizador registado: \n"
                                    +"\nUsername: "+user
                                    +"\nPassword: "+pass
                                    +"\nNome: "+nome
                                    +"\nEmail: "+email,
                            "Registar Utilizador",
                            JOptionPane.INFORMATION_MESSAGE);    
            norte.getTxtNome().setText("");
            norte.getTxtEmail().setText("");
            norte.getTxtPassword().setText("");
            norte.getTxtUsername().setText("");
    }

    
}