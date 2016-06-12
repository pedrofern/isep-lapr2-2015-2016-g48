
package lapr.project.ui.ucs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import lapr.project.utils.Utils;
import lapr.project.controller.CriarExposicaoController;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;

/**
 * Classe para introduzir um novo Organizador numa exposição através de uma JDialog
 * @author Diana Silva
 */
public class DialogoNovoOrganizador extends JDialog {
   
    /**
     * ComboBox que permite seleccionar utilizador para organizador
     */   
    private static JComboBox combo;
    
    /**
     * Guardar a janela anterior
     */
    private static CriarExposicaoUI framePai;
    
    private static CriarExposicaoController controller;
    
    private CentroExposicoes ce;
    
    /**
     * Constrói uma caixa dialogo para guardar o organizador na exposição,
     * recebendo a janela e o controller da criação de exposição como parametro
     * @param framePai janela anterior
     */
    
    public DialogoNovoOrganizador(CriarExposicaoUI framePai, CriarExposicaoController pController, CentroExposicoes cExpo){  
        
        super(framePai, "Novo Organizador", true);

        this.framePai = framePai;
        ce=cExpo;
        controller=pController;
        
        PainelDialogoLista p=new PainelDialogoLista(ce);
        alterarOk();
        add(p);
    
        combo=p.getComboBoxUtilizadores();
        
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(framePai);
        setVisible(true);
    }

    public static void setBotaoOK(JButton bt){
        
        PainelDialogoLista.setBotaoOK(bt);
    }
    
    private void alterarOk(){
        setBotaoOK(recriarBotaoOK());
    }
    
    public JButton recriarBotaoOK(){
        JButton btn = new JButton("OK");
        btn.setMnemonic(KeyEvent.VK_O);
        btn.setToolTipText("Confirma adição organizador");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Utilizador u= (Utilizador) combo.getSelectedItem();
                
                controller.addOrganizador(u);
             
                JList lista = framePai.getLstOrganizadores();
                ModeloListaUtilizadores modeloListaUsers = (ModeloListaUtilizadores) lista.getModel();
                boolean organizadorAdicionado = modeloListaUsers.addElement(u);
                if (organizadorAdicionado) {   
                        framePai.getBotaoRemoverProduto().setEnabled(true);
                        JOptionPane.showMessageDialog(
                                framePai,
                                "Organizador adicionado à exposição.",
                                "Novo Organizador",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(
                                framePai,
                                "Organizador já incluído na lista de organizadores!",
                                "Novo Organizador",
                                JOptionPane.ERROR_MESSAGE);
                    }
                dispose();
            }
            
        });
        return btn;
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
