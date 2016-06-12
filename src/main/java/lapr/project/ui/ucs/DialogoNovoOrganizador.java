
package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import lapr.project.controller.CriarExposicaoController;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Organizador;
import lapr.project.model.Produto;
import lapr.project.model.Utilizador;

/**
 * Classe para introduzir um novo Organizador numa exposição através de uma JDialog
 * @author Diana Silva
 */
public class DialogoNovoOrganizador extends JDialog {
   
    /**
     * Guarda o texto introduzido do produto
     */   
    private static JTextField txtField;
    
    /**
     * Guardar a janela anterior
     */
    private static CriarExposicaoUI framePai;
    
    private static CriarExposicaoController controller;
    
    /**
     * Constrói uma caixa dialogo para guardar o organizador na exposição,
     * recebendo a janela e o controller da criação de exposição como parametro
     * @param framePai janela anterior
     */
    
    public DialogoNovoOrganizador(CriarExposicaoUI framePai, CriarExposicaoController pController){  
        
        super(framePai, "Novo Organizador", true);

        this.framePai = framePai;
        
        controller=pController;
        
        PainelDialogoLista p=new PainelDialogoLista();
        add(p);
        txtField=PainelDialogoLista.getTextField();
        
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(framePai);
        setVisible(true);
    }

    public static void setBotaoOK(JButton bt){
        JButton btn = new JButton("OK");
        btn.setMnemonic(KeyEvent.VK_O);
        btn.setToolTipText("Confirma adição organizador");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
//                combo
//                
//                controller.addOrganizador(txtField.getText());
                Utilizador u=new Utilizador();
                
                JList lista = framePai.getLstOrganizadores();
                ModeloListaUtilizadores modeloListaUsers = (ModeloListaUtilizadores) lista.getModel();
                boolean organizadorAdicionado = modeloListaUsers.addElement(u);
                if (organizadorAdicionado) {   
                        framePai.getBotaoRemoverProduto().setEnabled(true);
                        JOptionPane.showMessageDialog(
                                framePai,
                                "Produto adicionado à lista de produtos.",
                                "Novo Produto",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(
                                framePai,
                                "Produto já incluído na lista de produtos!",
                                "Novo Produto",
                                JOptionPane.ERROR_MESSAGE);
                    }
//                dispose();
            }
        });
        DialogoNovoOrganizador.setBotaoOK(btn);
    }
    
    private void setBotaoCancelar(){
        JButton btn = new JButton("Cancelar");
        btn.setMnemonic(KeyEvent.VK_C);
        btn.setToolTipText("Cancelar adição de organizadores");
        
         btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
         
    }
}
