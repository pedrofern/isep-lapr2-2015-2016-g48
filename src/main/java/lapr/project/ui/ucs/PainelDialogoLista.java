package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author DianaSilva
 */
public class PainelDialogoLista extends JPanel{
    
    
    /**
     * Guarda o texto introduzido no JTextField
     */
    private static JTextField txtField;
    
    
    /**
     * Guarda os botões OK e Cancelar
     */
    private static JButton btOk, btCancel;
    

    /**
     * Define um tamanho standard para as label
     */
    private static final Dimension LABEL_TAMANHO = new JLabel("Produto: ").
                                                        getPreferredSize();
    
    
    
    public PainelDialogoLista(){
        super();
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
        txtField = new JTextField(CAMPO_LARGURA);
        txtField.requestFocusInWindow();

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 0;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(lbl);
        p.add(txtField);

        return p;
    }
    /**
     * cria painel com os botões OK e Cancelar
     * @return painel com os botões OK e Cancelar
     */
    private JPanel criarPainelBotoes() {
        JButton btOkOK = criarBotaoOK();
        getRootPane().setDefaultButton(btOkOK);

        JButton btOkCancelar = criarBotaoCancelar();

        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(btOkOK);
        p.add(btOkCancelar);

        return p;
    }
    
        
    /**
     * cria botão OK
     * @return botão OK
     */
    private JButton criarBotaoOK() {
        JButton btOk = new JButton("OK");
        btOk.setMnemonic(KeyEvent.VK_O);
        btOk.setToolTipText("Confirma adição produto");
       
        return btOk;
    }
    
    
    
    /**
     * cria botão Cancelar
     * @return botão Cancelar
     */
    private JButton criarBotaoCancelar() {
        btCancel = new JButton("Cancelar");
       
        return btCancel;
    }  
    
    public static void setBotaoOK(JButton bt){
        btOk=bt;
    }
    
    public static void setBotaoCancelar(JButton bt){
        btCancel=bt;
    }
    
    public static JTextField getTextField(){
        return txtField;
    }     
}
