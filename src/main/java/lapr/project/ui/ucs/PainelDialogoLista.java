package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;
import lapr.project.utils.Utils;

/**
 *
 * @author DianaSilva
 */
public class PainelDialogoLista extends JPanel{
    
    
    /**
     * ComboBox que permite seleccionar objeto pretendido
     */ 
    private JComboBox combo;
    
    
    /**
     * Guarda os botões OK e Cancelar
     */
    private JButton btOk, btCancel;
    

    /**
     * Define um tamanho standard para as label
     */
    private static final Dimension LABEL_TAMANHO = new JLabel("Produto: ").
                                                        getPreferredSize();
    
   private CentroExposicoes ce;
   
    public PainelDialogoLista(CentroExposicoes cExposicoes, JButton btOk, JButton btCancel){
        super();
        ce=cExposicoes;
        this.btOk=btOk;
        this.btCancel=btCancel;
        setLayout(new BorderLayout());
        
        criarComponentes();
        
    }
    
    /**
     * cria os componentes da janela
     */
    private void criarComponentes(){
        JPanel p1 = criarPainelNome();
        JPanel p2 = criarPainelBotoes();

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.SOUTH);
    }
    /**
     * cria painel para colocar o nome do produto
     * @return painel para colocar o nome do produto
     */
    private JPanel criarPainelNome() {
        JLabel lbl = new JLabel("Produto: ", JLabel.RIGHT);
        lbl.setPreferredSize(LABEL_TAMANHO);

        final int CAMPO_LARGURA = 10;
                 
        combo=Utils.criarComboUser(ce.getRegistoUtilizadores());
      
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 0;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(lbl);
        p.add(combo);

        return p;
    }
    /**
     * cria painel com os botões OK e Cancelar
     * @return painel com os botões OK e Cancelar
     */
    private JPanel criarPainelBotoes() {
    
        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(btOk);
        p.add(btCancel);

        return p;
    }
    
//        
//    /**
//     * cria botão OK
//     * @return botão OK
//     */
//    private JButton criarBotaoOK() {
//        JButton btOk = new JButton("OK");
//        btOk.setMnemonic(KeyEvent.VK_O);
//        btOk.setToolTipText("Confirma adição");
//       
//        return btOk;
//    }
//    
//    
//    
//    /**
//     * cria botão Cancelar
//     * @return botão Cancelar
//     */
//    private JButton criarBotaoCancelar() {
//        btCancel = new JButton("Cancelar");
//       
//         btCancel.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                dispose();
//            }
//        });
//        
//        return btCancel;
//    }  
//    
//    public JButton getBotaoCancelar(){
//        return btCancel;
//    }
//    
//    public JButton getBotaoOk(){
//        return btOk;
//    }
    
    public JComboBox getComboBoxUtilizadores(){
        return combo;
    }     
}
