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
public class PainelDialogoListaRecurso extends JPanel {

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

    public PainelDialogoListaRecurso(CentroExposicoes cExposicoes, JButton btOk, JButton btCancel) {
        super();
        ce = cExposicoes;
        this.btOk = btOk;
        this.btCancel = btCancel;
        setLayout(new BorderLayout());

        criarComponentes();

    }

    /**
     * cria os componentes da janela
     */
    private void criarComponentes() {
        JPanel p1 = criarPainelRecurso();
        JPanel p2 = criarPainelBotoes();

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.SOUTH);
    }

   
    
     private JPanel criarPainelRecurso() {
        JLabel lbl = new JLabel("Recurso: ", JLabel.RIGHT);
        lbl.setPreferredSize(new Dimension(50, 30));

        final int CAMPO_LARGURA = 10;

        combo = Utils.criarComboRecurso(ce.getRegistoRecursos());

        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));

        p.setBorder(new EmptyBorder(10, 10,
                0, 0));

        p.add(lbl);
        p.add(combo);

        return p;
    }

    /**
     * cria painel com os botões OK e Cancelar
     *
     * @return painel com os botões OK e Cancelar
     */
    private JPanel criarPainelBotoes() {

        JPanel p = new JPanel();
        p.setBorder(new EmptyBorder(0, 10,
                10, 10));

        p.add(btCancel);

        return p;
    }

    public JComboBox getComboBoxUtilizadores() {
        return combo;
    }

    public JComboBox getComboBoxRecursos() {
        return combo;
    }
}
