package lapr.project.ui;

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
import lapr.project.model.Utilizador;
import lapr.project.ui.ucs.AlterarUtilizadorUI;

/**
 *
 * @author Diana
 */
public class Janela extends JFrame /** implements Serializable**/{
    private static CentroExposicoes ce;
    private static Utilizador ut;
    private String tipo_utilizador;
    
    private static JTabbedPane tabPane;
    private static PainelInfoUser pUser;
    /**
     * Guarda objectos do tipo FichCentroExposicoes
     */
    private FichCentroExposicoes fichCentroExposicoes;
 
    private static int WIDTH=625, HEIGHT=500, MINWIDTH=625, MINHEIGHT=480;
 
    public Janela(CentroExposicoes ce,FichCentroExposicoes fichCentroExposicoes, Utilizador id_utilizador) {
        
        super("Centro de Exposições");
        this.fichCentroExposicoes = fichCentroExposicoes;
        this.ce=ce;
        this.ut=id_utilizador;
        
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

       pUser=new PainelInfoUser(ut);
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
        tipo_utilizador=ut.getUsername();
        
        tabPane = new JTabbedPane(); 
        
        if("Fae".equals(tipo_utilizador)){
            tabPane.addTab("MenuFae", new PainelFae(ce, ut));
       }
        
       if("Organizador".equals(tipo_utilizador)){
           tabPane.addTab("Home", new PainelInicio(ce));
           tabPane.addTab("MenuOrganizador", new PainelOrganizador(ce, ut));

       }
       if("Representante".equals(tipo_utilizador)){

            tabPane.addTab("MenuRepresentante", new PainelRepresentante(ce, ut));
       }
       
      if("Organizador+Fae".equals(tipo_utilizador)){
          
            tabPane.addTab("MenuOrganizador", new PainelOrganizador(ce,ut));
            tabPane.addTab("MenuFae", new PainelFae(ce, ut));
            
       }
      
      if("Gestor".equals(tipo_utilizador)){
 
           tabPane.addTab("MenuGestor", new PainelGestor(ce, ut));
          
      }
      if("Admin".equals(tipo_utilizador)){
          
         tabPane.add("Menu Gestor", new PainelGestor(ce,ut));
         
         tabPane.addTab("MenuOrganizador", new PainelOrganizador(ce, ut));

         tabPane.addTab("MenuFae", new PainelFae(ce, ut));

       
        tabPane.addTab("MenuRepresentante", new PainelRepresentante(ce, ut));
        
        
        
      }  
      
      tabPane.addTab("Alterar Utilizador", new AlterarUtilizadorUI(ce, ut));
      
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
        System.out.println(ce.getRegistoUtilizadores());
        System.out.println(ce.getRegistoExposicoes());
        this.fichCentroExposicoes.guardarFichBinario(this.ce);
        dispose();
    }
    
    public static JTabbedPane getTabPane(){
        return tabPane;
    }
  
}
