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
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;
import lapr.project.ui.ucs.AlterarUtilizadorUI;
import lapr.project.utils.XML;

/**
 *
 * @author Diana
 */
public class Janela extends JFrame /** implements Serializable**/{
    private static CentroExposicoes ce;
    private static Utilizador ut;
    private String tipo_utilizador;
    private JFileChooser fileChooser;
    private static JTabbedPane tabPane;
    private static PainelInfoUser pUser;
    private JMenuItem itemExp;
    private JMenuItem itemImp;
    /**
     * Guarda objectos do tipo FichCentroExposicoes
     */
    private FichCentroExposicoes fichCentroExposicoes;
 
    private static int WIDTH=650, HEIGHT=500, MINWIDTH=650, MINHEIGHT=500;
 
    public Janela(CentroExposicoes ce,FichCentroExposicoes fichCentroExposicoes, Utilizador id_utilizador) {
        
        super("Centro de Exposições");
        this.fichCentroExposicoes = fichCentroExposicoes;
        this.ce=ce;
        this.ut=id_utilizador;
        
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        
        fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        definirFiltroExtensaoXML(fileChooser);
        personalizarFileChooserEmPortugues();
               
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

        return item; 
    }
    
    private JMenuItem criarItemImportar(){
          itemImp= new JMenuItem("Importar", KeyEvent.VK_I);
          itemImp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
          itemImp.setEnabled(false);
          itemImp.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  try{
                    int resposta = fileChooser.showOpenDialog(Janela.this);

                    if (resposta == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();                        
                        XML imp = new XML();
                        imp.importFromXML(file);                        
                    }
                }catch (FileNotFoundException ex){
                        JOptionPane.showMessageDialog(Janela.this, ex.getMessage());
                }
              }
          });       
          return itemImp; 
    }
    
    private JMenuItem criarItemExportar(){
        itemExp = new JMenuItem("Exportar", KeyEvent.VK_X);
        itemExp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        itemExp.setEnabled(false);
        itemExp.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              XML export = new XML();
              export.exportToXML(ce);
                JOptionPane.showMessageDialog(Janela.this, 
                    "Exportado com sucesso!\n\nLocalização: "
                            + "'Pasta do projecto'\\CentroExposicoes.xml",
                    "Exportar XML",
                    JOptionPane.PLAIN_MESSAGE);
          }
      });       
      return itemExp; 
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
        tabPane = new JTabbedPane(); 
        tipo_utilizador=ut.getUsername();
        if(tipo_utilizador.equals("Admin")){
            tabPane.addTab("Menu Gestor", new PainelGestor(ce,ut));
            tabPane.addTab("MenuOrganizador", new PainelOrganizador(ce, ut));
            tabPane.addTab("MenuFae", new PainelFae(ce, ut));
            tabPane.addTab("MenuRepresentante", new PainelRepresentante(ce, ut));
            tabPane.addTab("Alterar Utilizador", new AlterarUtilizadorUI(ce, ut));
            itemImp.setEnabled(true);
            itemExp.setEnabled(true);
        }else{
            if(tipo_utilizador.equals("Gestor")){
                tabPane.addTab("MenuGestor", new PainelGestor(ce, ut));
                tabPane.addTab("Alterar Utilizador", new AlterarUtilizadorUI(ce, ut));
                itemImp.setEnabled(true);
                itemExp.setEnabled(true);
            }
            else{
                if(ce.getRegistoExposicoes().getExposicoesDoFAE(ut)!=null &&
                        ce.getRegistoExposicoes().getExposicoesOrganizador(ut)!= null ){
                    tabPane.addTab("MenuOrganizador", new PainelOrganizador(ce,ut));
                    tabPane.addTab("MenuFae", new PainelFae(ce, ut)); 
                    tabPane.addTab("Alterar Utilizador", new AlterarUtilizadorUI(ce, ut));
                }else{
                    if(ce.getRegistoExposicoes().getExposicoesDoFAE(ut)!=null){
                        tabPane.addTab("MenuFae", new PainelFae(ce, ut));
                        tabPane.addTab("Alterar Utilizador", new AlterarUtilizadorUI(ce, ut));
                    }else{
                        if(ce.getRegistoExposicoes().getExposicoesOrganizador(ut)!= null){
                            tabPane.addTab("MenuOrganizador", new PainelOrganizador(ce,ut));
                            tabPane.addTab("Alterar Utilizador", new AlterarUtilizadorUI(ce, ut));
                        }else{
                            tabPane.addTab("MenuRepresentante", new PainelRepresentante(ce, ut));
                            tabPane.addTab("Alterar Utilizador", new AlterarUtilizadorUI(ce, ut));
                        }
                    }
                }
            }
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
        this.fichCentroExposicoes.guardarFichBinario(this.ce);
        dispose();
    }
    
    public static JTabbedPane getTabPane(){
        return tabPane;
    }
    private static void personalizarFileChooserEmPortugues() {

        // Títulos das Caixas de Diálogo
        UIManager.put("FileChooser.openDialogTitleText", "Importar Ficheiro");
        UIManager.put("FileChooser.saveDialogTitleText", "Exportar Ficheiro");

        // Botão "Importar"
        UIManager.put("FileChooser.openButtonText", "Importar");
        UIManager.put("FileChooser.openButtonMnemonic", "I");
        UIManager.put("FileChooser.openButtonToolTipText", "Importar Ficheiro");

        // Botão "Exportar"
        UIManager.put("FileChooser.saveButtonText", "Exportar");
        UIManager.put("FileChooser.saveButtonMnemonic", "E");
        UIManager.put("FileChooser.saveButtonToolTipText", "Exportar Ficheiro");

        // Botão "Cancelar"
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.cancelButtonMnemonic", "C");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");

        // Botão "Ajuda"
        UIManager.put("FileChooser.helpButtonText", "Ajuda");
        UIManager.put("FileChooser.helpButtonMnemonic", "A");
        UIManager.put("FileChooser.helpButtonToolTipText", "Ajuda");

        // Legenda "Procurar em:"
        UIManager.put("FileChooser.lookInLabelMnemonic", "E");
        UIManager.put("FileChooser.lookInLabelText", "Procurar em:");

        // Legenda "Guardar em:"
        UIManager.put("FileChooser.saveInLabelText", "Guardar em:");
        UIManager.put("FileChooser.saveInLabelMnemonic", "G");

        // Legenda "Tipo de ficheiros:"
        UIManager.put("FileChooser.filesOfTypeLabelText", "Ficheiros do tipo:");
        UIManager.put("FileChooser.filesOfTypeLabelMnemonic", "F");

        // Legenda "Nome do ficheiro:"
        UIManager.put("FileChooser.fileNameLabelMnemonic", "N");
        UIManager.put("FileChooser.fileNameLabelText", "Nome do ficheiro:");

        // Filtro "Todos os Ficheiros"
        UIManager.put("FileChooser.acceptAllFileFilterText", "Todos os Ficheiros");

        // Botão "Um nível acima"
        UIManager.put("FileChooser.upFolderToolTipText", "Um nível acima");
        UIManager.put("FileChooser.upFolderAccessibleName", "Um nível acima");

        // Botão "Ambiente de Trabalho"
        UIManager.put("FileChooser.homeFolderToolTipText", "Ambiente");
        UIManager.put("FileChooser.homeFolderToolTipText", "Ambiente de Trabalho");
        UIManager.put("FileChooser.homeFolderAccessibleName", "Ambiente de Trabalho");

        // Botão "Nova Pasta"
        UIManager.put("FileChooser.newFolderToolTipText", "Criar nova pasta");
        UIManager.put("FileChooser.newFolderAccessibleName", "Criar nova pasta");

        // Botão "Vista Lista"
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.listViewButtonAccessibleName", "Lista");

        // Botão "Vista Detalhada"
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalhes");
        UIManager.put("FileChooser.detailsViewButtonAccessibleName", "Detalhes");

        // Cabeçalhos da "Vista Lista Detalhada"
        UIManager.put("FileChooser.fileNameHeaderText", "Nome");
        UIManager.put("FileChooser.fileSizeHeaderText", "Tamanho");
        UIManager.put("FileChooser.fileTypeHeaderText", "Tipo");
        UIManager.put("FileChooser.fileDateHeaderText", "Data");
        UIManager.put("FileChooser.fileAttrHeaderText", "Atributos");
    }
    
    private void definirFiltroExtensaoXML(JFileChooser fileChooser) {
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }
                String extensao = extensao(f);
                if (extensao != null) {
                    return extensao.equals("xml");
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "*.xml";
            }

            private String extensao(File f) {
                String ext = null;
                String s = f.getName();
                int i = s.lastIndexOf(".");
                if (i != -1) {
                    ext = s.substring(i + 1).toLowerCase();
                }
                return ext;
            }
        });
    }
}
