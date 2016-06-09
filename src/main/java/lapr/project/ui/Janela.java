package lapr.project.ui;

import lapr.project.ui.ucs.AlterarUtilizadorUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import lapr.project.model.CentroExposicoes;
import lapr.project.ui.ucs.AlterarUtilizadorUI;

/**
 *
 * @author Diana
 */
public class Janela extends JFrame /** implements Serializable**/{
    private final CentroExposicoes m_ce;
    public String m_ut;
    
    private JTabbedPane tabPane;
    private static PainelInfoUser pUser;
 
    private static int WIDTH=550, HEIGHT=500, MINWIDTH=200, MINHEIGHT=250;
 
    public Janela(CentroExposicoes ce, String id_utilizador) {
        
        super("Centro de Exposições");
        this.m_ce=ce;
        this.m_ut=id_utilizador;
        
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
               
        criarComponentes();
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fecharJanela();
            }
        });
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(MINWIDTH, MINHEIGHT));
        setLocationRelativeTo(null);
        
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true); 
    }   
 
    private void criarComponentes(){
        JMenuBar menuBar= criarBarraMenus();
        setJMenuBar(menuBar);

       pUser=new PainelInfoUser(m_ut);
       pUser.criarPainel();
        
        tabPane=criarSeparadores();
        
        add(pUser,BorderLayout.NORTH);
        add(tabPane,BorderLayout.CENTER);
    }
        
    private JMenuBar criarBarraMenus(){
        JMenuBar menuBar=new JMenuBar();
        
        menuBar.add(criarMenuFicheiro());
        menuBar.add(criarMenuOpcoes());
        
        return menuBar;
    }
       
    private JMenu criarMenuFicheiro(){
        JMenu menu=new JMenu("Ficheiro");
        menu.setMnemonic(KeyEvent.VK_F);
        
        menu.addMouseListener(new MouseAdapter() {
           
            
            //criarItemNovo.setEnabled(registoExposicoes.tamanho()!=0);
  
        });
        
        menu.add(criarItemNovo());
        menu.addSeparator();
        menu.add(criarItemImportar());
        menu.addSeparator();
        menu.add(criarItemExportar());
        menu.addSeparator();
        menu.add(criarItemSair());
        
        return menu;
        
    }

    private JMenu criarMenuOpcoes(){
        JMenu menu=new JMenu("Opções");
        menu.setMnemonic(KeyEvent.VK_O);
        
        menu.add(criarSubMenuEstilo());
        menu.addSeparator();
        menu.add(criarItemAcerca());
        
        return menu;
    }
    
    private JMenuItem criarItemNovo(){
        JMenuItem item=new JMenuItem("Novo CE", KeyEvent.VK_N);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));

        //item.setEnabled(registoExposicoes.tamanho() != 0);
        return item; 
    }
    
    private JMenuItem criarItemImportar(){
          JMenuItem item= new JMenuItem("Importar", KeyEvent.VK_I);
          item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
        
          return item; 
    }
    
    private JMenuItem criarItemExportar(){
        JMenuItem item = new JMenuItem("Exportar", KeyEvent.VK_X);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        item.setEnabled(false);

        return item;
    }
    
    private JMenuItem criarItemAcerca(){
        JMenuItem item = new JMenuItem("Acerca", KeyEvent.VK_A);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Janela.this,
                        "@Copyright\nAna, Diana, Eduângelo, Pedro, Tomás - LAPR2 2015/2016",
                        "Acerca",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        return item;
    }
  
    private JMenuItem criarItemSair(){
        JMenuItem item = new JMenuItem("Sair", KeyEvent.VK_S);
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecharJanela();
            }
        });

        return item;
    }
    
    private JMenu criarSubMenuEstilo(){
         JMenu menu = new JMenu("Estilo");
        menu.setMnemonic(KeyEvent.VK_E);

        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            menu.add(criarItemEstilo(info));
        }

        return menu;
    }
    
    private JMenuItem criarItemEstilo(UIManager.LookAndFeelInfo info) {
        JMenuItem item = new JMenuItem(info.getName());

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JMenuItem menuItem = (JMenuItem) e.getSource();
                try {
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if (menuItem.getActionCommand().equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                    SwingUtilities.updateComponentTreeUI(Janela.this);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Janela.this,
                            ex.getMessage(),
                            "Estilo " + menuItem.getActionCommand(),
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        return item;
    }
    
    private JTabbedPane criarSeparadores() {
  
        JTabbedPane tabPane = new JTabbedPane(); 

        if("Fae".equals(m_ut)){
            tabPane.addTab("MenuFae", new PainelFae(m_ce, m_ut));
       }
        
       if("Organizador".equals(m_ut)){
           tabPane.addTab("Home", new PainelInicio());
           tabPane.addTab("MenuOrganizador", new PainelOrganizador(m_ce, m_ut));

       }
       if("Representante".equals(m_ut)){

            tabPane.addTab("MenuRepresentante", new PainelRepresentante(m_ce, m_ut));
       }
       
      if("Organizador+Fae".equals(m_ut)){

            tabPane.addTab("MenuFae", new PainelFae(m_ce, m_ut));
            tabPane.addTab("MenuOrganizador", new PainelOrganizador(m_ce,m_ut));
       }
      
      if("Gestor".equals(m_ut)){
 
           tabPane.addTab("MenuGestor", new PainelGestor(m_ce, m_ut));
          
      }
      if("Admin".equals(m_ut)){
          
        tabPane.addTab("MenuFae", new PainelFae(m_ce, m_ut));

        tabPane.addTab("MenuOrganizador", new PainelOrganizador(m_ce, m_ut));

        tabPane.addTab("MenuRepresentante", new PainelRepresentante(m_ce, m_ut));

        tabPane.addTab("Alterar Utilizador", new AlterarUtilizadorUI(m_ce, m_ut));
      }  
       return tabPane; 
    }
    
    private void fecharJanela() {
        String[] opcoes = {"Sim", "Não"};
        String pergunta = "Pretende fechar a aplicação?";
        int opcao = JOptionPane.showOptionDialog(new Frame(), pergunta,
                "Confirma?", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        if (opcao == JOptionPane.YES_OPTION) {
            terminar();
        } else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }
    
    private void terminar() {
//        this.ficheiroCentroExposicoes.guardar(this.centroExposicoes);
        System.exit(0);
    }
}
