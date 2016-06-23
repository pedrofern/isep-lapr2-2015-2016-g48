package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.model.Demonstracao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.lists.RegistoExposicoes;
import lapr.project.utils.Utils;

/**
 *
 * @author Pedro Fernandes
 */
public class SubmeterCandidaturaDemoUI extends JFrame {
    private JButton btnSelExposicao;
    private JButton btnSelDemonstracao;
    private JButton btnConfirmar;
    private JButton btnEliminar;
    private JComboBox comboE;
    private JComboBox comboD;
    private JList jlstCandDemo;
    private JPanel painelNorte;
    private JPanel painelCentro;
    /**
     * Guarda a largura mínima da janela em píxeis.
     */
    private static final int JAN_LARGURA = 650;
    /**
     * Guarda a altura mínima da janela em píxeis.
     */
    private static final int JAN_ALTURA = 275;
    private static final int MARGEM_SUP = 5;
    private static final int MARGEM_INF = 5;
    private static final int MARGEM_ESQ = 5;
    private static final int MARGEM_DIR = 5;
    
    private CentroExposicoes ce;
    
    //private SubmeterCandidaturaController controllerSCD;
   
    public SubmeterCandidaturaDemoUI(CentroExposicoes ce, Utilizador utilizador){
        super("Submeter Candidatura a Demonstracao");
        
        this.ce=ce;
        
        criarComponentes();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(JAN_LARGURA, JAN_ALTURA));
        setSize(new Dimension(JAN_LARGURA, JAN_ALTURA));
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public void criarComponentes() {

        add(painelSul(), BorderLayout.SOUTH);
        add(painelNorte(), BorderLayout.NORTH);
        btnConfirmar.setEnabled(false);
        btnEliminar.setEnabled(false);
        
    }
    private JPanel painelCentro(){
        painelCentro = new JPanel(new BorderLayout());
        
        jlstCandDemo = new JList(new ListaDemonstracoes().getArray());
        
        JPanel p = new JPanel(new GridLayout(1,1));       
        p.add(criarPainelLista("Candidaturas Demonstração:",jlstCandDemo));
        
        painelCentro.add(p, BorderLayout.CENTER);
        
        return painelCentro;
    }
    private JPanel criarPainelLista(String tituloLista,JList lstLista)
    {
        lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(lstLista);

        JPanel p = new JPanel(new BorderLayout());
        
        p.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(tituloLista),
                new EmptyBorder(MARGEM_SUP, MARGEM_ESQ,
                MARGEM_INF, MARGEM_DIR)));
        
        p.add(scrPane, BorderLayout.CENTER);

        return p;
    }
    private JPanel painelNorte() {
        painelNorte = new JPanel(new FlowLayout());
        
        painelNorte.add(criarPainelSelecionarExposicao(new RegistoExposicoes()));
        painelNorte.setBorder(new EmptyBorder(MARGEM_SUP, MARGEM_ESQ,
                MARGEM_INF, MARGEM_DIR));

        return painelNorte;
    }
    private JPanel criarPainelSelecionarExposicao(RegistoExposicoes lstExposicoes){
        JPanel painel= new JPanel(new FlowLayout());
        
        painel.setBorder(new TitledBorder("Exposição"));
        comboE = Utils.criarComboExpo(lstExposicoes);
        
        painel.add(comboE);              
        painel.add(criarBtSelectExp());

        return painel;
    }
    private JButton criarBtSelectExp() {
        btnSelExposicao=new JButton("Seleccionar");
        btnSelExposicao.setMnemonic(KeyEvent.VK_E);
        btnSelExposicao.setToolTipText("Selecionar exposição");
        btnSelExposicao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    btnSelExposicao.setEnabled(false);
                    comboE.setEnabled(false);  
                    
//                    controllerDCC.selectExposicao((Exposicao) comboExposicao.getSelectedItem());
                    
                    painelNorte.add(criarPainelSelecionarDemonstracao(new ListaDemonstracoes()));

                    btnSelDemonstracao.setEnabled(true);
                    comboD.setEnabled(true);

                    setVisible(true);
                  
               }catch(Exception ex){
                   JOptionPane.showMessageDialog(
                           SubmeterCandidaturaDemoUI.this, 
                           "Não existem exposições com candidaturas aceites!", 
                           "Submeter Candidatura a Demonstracao", 
                           JOptionPane.ERROR_MESSAGE);
                   dispose();
               }
            }     
        }
        );  
        return btnSelExposicao;
    }
    private JPanel criarPainelSelecionarDemonstracao(ListaDemonstracoes lstDemos){
        JPanel painel= new JPanel(new FlowLayout());
        
        painel.setBorder(new TitledBorder("Demonstracao"));
        comboD = Utils.criarComboDemo(lstDemos);
        
        painel.add(comboD);              
        painel.add(criarBtSelectDemo());
        
        btnSelDemonstracao.setEnabled(false);
        comboD.setEnabled(false);
        
        return painel;
    }
    private JButton criarBtSelectDemo() {
        btnSelDemonstracao=new JButton("Seleccionar");
        btnSelDemonstracao.setMnemonic(KeyEvent.VK_D);
        btnSelDemonstracao.setToolTipText("Selecionar demonstracao");
        btnSelDemonstracao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    btnSelExposicao.setEnabled(false);
                    comboE.setEnabled(false);  
                    
//                    controllerDCC.selectDemonstracao((Demonstracao) comboD.getSelectedItem());

                    add(painelCentro(), BorderLayout.CENTER);

                    btnSelDemonstracao.setEnabled(false);
                    comboD.setEnabled(false);
                    btnConfirmar.setEnabled(true);
                    btnEliminar.setEnabled(true);

                    setVisible(true);
                  
               }catch(Exception ex){
                   JOptionPane.showMessageDialog(
                           SubmeterCandidaturaDemoUI.this, 
                           "Não existem Demonstracoes decididas!", 
                           "Submeter Candidatura a Demonstracao", 
                           JOptionPane.ERROR_MESSAGE);
                   dispose();
               }
            }     
        }
        );  
        return btnSelDemonstracao;
    }
    private JPanel painelSul() {
        JPanel p = new JPanel(new FlowLayout());
        p.setBorder(new TitledBorder("Opções"));
        p.add(criarPainelBtn());
        return p;
    }
    
    private JPanel criarPainelBtn() {

        FlowLayout l = new FlowLayout();

        l.setHgap(20);
        l.setVgap(20);

        JPanel p = new JPanel();

        JButton bt1 = criarBotaoConfirmar();
        JButton bt2 = criarBotaoEliminar();
        JButton bt3 = criarBotaoCancelar();
        
        getRootPane().setDefaultButton(bt1);
        
        p.add(bt1);
        p.add(bt2);
        p.add(bt3);
        
        return p;
    }
    
    private JButton criarBotaoConfirmar() {
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setMnemonic(KeyEvent.VK_C);
        btnConfirmar.setToolTipText("Confirmar submissão candidatura demonstração");
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                String[] opcoes = {"Confirmar", "Cancelar"};
                String pergunta = "Confirma a participação nas demonstrações listadas?";
                int opcao = JOptionPane.showOptionDialog(new Frame(), pergunta,
                        "Confirma?", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                if (opcao == JOptionPane.YES_OPTION) {
                    //mudar de estado a cand demo
                    dispose();
                } else {
                    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                }
            }
        });

        return btnConfirmar;
    }
    private JButton criarBotaoEliminar() {
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setMnemonic(KeyEvent.VK_E);
        btnEliminar.setToolTipText("Elimina candidatura demonstração");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] opcoes = {"Eliminar", "Cancelar"};
                String pergunta = "Eliminar candidatura a demonstracao?\n\n"
                        + "NOTA: Não poderá reverter a eliminação!";
                int opcao = JOptionPane.showOptionDialog(new Frame(), pergunta,
                        "Confirma?", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                if (opcao == JOptionPane.YES_OPTION) {
                    //elimina da lista de cand demos
                } else {
                    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                }
            }
        });

        return btnEliminar;
    }

    private JButton criarBotaoCancelar() {
        JButton b = new JButton("Cancelar");
        b.setMnemonic(KeyEvent.VK_C);
        b.setToolTipText("Cancela a submissão de  candidatura a demonstração");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        return b;
    }
    

}
