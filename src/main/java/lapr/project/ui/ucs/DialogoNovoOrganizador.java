
package lapr.project.ui.ucs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import lapr.project.controller.CriarExposicaoController;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Organizador;
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
    
     /**
     * Guarda o botão ok e cancelar
     */   
    private static JButton btOk, btCancel;
    
    
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
        
        btOk=recriarBotaoOK();
        btCancel=recriarBotaoCancelar();
        
      
        PainelDialogoLista p=new PainelDialogoLista(ce, btOk, btCancel);
       
        combo=p.getComboBoxUtilizadores();
        add(p);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(framePai);
        setVisible(true);
    }
    
  
    
    public JButton recriarBotaoOK(){
        JButton btn = new JButton("OK");
        btn.setMnemonic(KeyEvent.VK_O);
        btn.setToolTipText("Confirma adição organizador");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
               Utilizador u= (Utilizador) combo.getSelectedItem();
               
               controller.criaOrganizador(u);
                
               JList lista = framePai.getLstOrganizadores();
               ModeloListaOrganizadores modeloListaUsers = (ModeloListaOrganizadores) lista.getModel();
                
                boolean organizadorAdicionado = modeloListaUsers.addElement(controller.getOrganizador());
                if (organizadorAdicionado) {
                        controller.setListaOrganizadores(modeloListaUsers.getListaOrganizadores());
                        
                        framePai.getBotaoRemoverProduto().setEnabled(true);
                        JOptionPane.showMessageDialog(
                                framePai,
                                "Organizador adicionado à exposição.",
                                "Novo Organizador",
                                JOptionPane.INFORMATION_MESSAGE);
                        
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(
                                framePai,
                                "Organizador já incluído na lista de organizadores!",
                                "Novo Organizador",
                                JOptionPane.ERROR_MESSAGE);
                    }
               
            }
            
        });
        return btn;
    }
    
    private JButton recriarBotaoCancelar(){
        JButton btn = new JButton("Cancelar");
        btn.setMnemonic(KeyEvent.VK_C);
        btn.setToolTipText("Cancelar adição de organizadores");
        
         btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
         return btn;
    }
}
