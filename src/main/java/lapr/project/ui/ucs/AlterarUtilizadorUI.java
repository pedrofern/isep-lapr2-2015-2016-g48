package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import lapr.project.controller.AlterarUtilizadorController;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;
import lapr.project.ui.Janela;
import lapr.project.ui.PainelInfoUser;

/**
 *
 * @author Diana
 */
public class AlterarUtilizadorUI extends JPanel{
    private static CentroExposicoes ce;
    private static Utilizador user;
    private AlterarUtilizadorController controller;
    private PainelDadosUtilizador norte;
    private static final String pergunta="Pretende cancelar a alteração do registo de utilizador?";
      

    public AlterarUtilizadorUI(CentroExposicoes centroExposicoes, Utilizador utilizador){
         
         super();
         ce=centroExposicoes;
         user=utilizador;
             
         controller=new AlterarUtilizadorController(ce);
        
        setLayout(new BorderLayout());
        add(criarPainel());
        norte.preencherDadosUtilizador(user);
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
                    try {
                        guardar();
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(AlterarUtilizadorUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                        
               Janela.getTabPane().setSelectedIndex(0);
            
            }
        });

        return botao;
    }
    
     private void guardar() throws CloneNotSupportedException {
            String nome,email,pass,username;
            nome = norte.getTxtNome().getText();
            email = norte.getTxtEmail().getText();
            pass = norte.getTxtPassword().getText();
            username = norte.getTxtUsername().getText();
            
            controller.setUtilizador(user);
            controller.alteraDados(nome, username, pass, email);
                JOptionPane.showMessageDialog(
                            null,
                            "Dados novo utilizador registado: \n"
                                    +"\nUsername: "+username
                                    +"\nPassword: "+pass
                                    +"\nNome: "+nome
                                    +"\nEmail: "+email,
                            "Registar Utilizador",
                            JOptionPane.INFORMATION_MESSAGE);  
                
            setLabels(user.getNome(), user.getEmail());
            norte.getTxtNome().setText("");
            norte.getTxtEmail().setText("");
            norte.getTxtPassword().setText("");
            norte.getTxtUsername().setText("");
    }

    private static void setLabels(String nome, String email) {
        PainelInfoUser.setLabels(nome, email);
    }

    
}