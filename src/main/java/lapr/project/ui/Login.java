package lapr.project.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.border.*;
import lapr.project.model.CentroExposicoes;
import lapr.project.ui.ucs.RegistarUtilizadorUI;
import lapr.project.model.*;
import javax.swing.filechooser.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.utils.XML;


/**
 *
 * @author Diana
 * Modificado por Pedro Fernandes 23/06/2016
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Login extends JFrame {
    
    private CentroExposicoes ce;
    private Exposicao expo;
    private static final int WIDTH=300, HEIGHT=250;
    private static final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0, MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;

    private JTextField username;
    private JPasswordField password;
    private Login framePai;
    private Utilizador user;
    private JButton btnOK;
    /**
     * Guarda objectos do tipo FichCentroExposicoes
     */
    private FichCentroExposicoes fichCentroExposicoes;
    private JFileChooser fileChooser;

    private static final Dimension LABEL_TAMANHO = new JLabel("Username").getPreferredSize();        
    
    public Login(CentroExposicoes ce,FichCentroExposicoes fichCentroExposicoes){
        
        super("Menu Login");
        this.fichCentroExposicoes = fichCentroExposicoes;
        this.ce=ce;

        framePai = Login.this;

        criarComponentes();
        criarPainelBotoes();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                fecharJanela();
            }
        });
        
        fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        definirFiltroExtensaoXML(fileChooser);
        personalizarFileChooserEmPortugues();
        
        setMinimumSize(new Dimension(350,300));
        setLocationRelativeTo(null);
        setVisible(true);

    }
        
    private void criarComponentes(){
        
        add(criarPainelNorte(), BorderLayout.CENTER);
        add(criarPainelSul(),BorderLayout.SOUTH);

    }
    
    private JPanel criarPainelNorte(){
        
        JPanel p = new JPanel(new GridLayout(0, 1));
         
        p.add(criarPainelUsername());
        p.add(criarPainelPassword());
        p.add(criarPainelBotoes());

        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        
        p.setBorder(new TitledBorder("Login"));
        return p;
    }
    
    private JPanel criarPainelSul(){
        
        JPanel p = new JPanel(new GridLayout(3, 1));
         
        p.add(criarBotaoRegistar());
        p.add(criarBotaoImportar());
        p.add(criarBotaoExportar());
        
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        
        p.setBorder(new TitledBorder("Outras Opções"));
        return p;
    }
        
    private JPanel criarPainelUsername(){
        
        JPanel p = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Username", SwingConstants.LEFT);

        lbl.setPreferredSize(LABEL_TAMANHO);

        final int CAMPO_LARGURA = 10;
        username = new JTextField(CAMPO_LARGURA);
        username.requestFocus();


        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(lbl);
        p.add(username);

        return p;
        
    }  
    
    private JPanel criarPainelPassword(){
        
        JPanel p = new JPanel(new FlowLayout());
        JLabel lbl = new JLabel("Password", SwingConstants.LEFT);
        lbl.setPreferredSize(LABEL_TAMANHO);

        final int CAMPO_LARGURA = 10;
        password = new JPasswordField(CAMPO_LARGURA);
        password.requestFocus();

        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(lbl);
        p.add(password);

        return p;
    
        
    }
    
    private JButton criarBotaoRegistar(){
        
        JButton btn = new JButton("Registar Novo Utilizador");
   
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                new RegistarUtilizadorUI(ce,fichCentroExposicoes);  
                
            }
        });
        return btn;

    }
    private JButton criarBotaoImportar() {
        JButton btn = new JButton("Importar Ficheiro XML");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int resposta = fileChooser.showOpenDialog(framePai);

                if (resposta == JFileChooser.APPROVE_OPTION) {
                    //import
//                    XML imp = new XML();
//                    imp.importFromXML();
                }
            }
        }
        );
        return btn;
    }
    
    private JButton criarBotaoExportar(){
        
        JButton btn = new JButton("Exportar Ficheiro XML");
   
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                //exporta xml
                XML export = new XML();
                export.exportToXML(ce);
            }
        });
        return btn;

    }
    
    private JPanel criarPainelBotoes() {
        
        btnOK = criarBotaoLogin();
        

        JButton btnCancelar = criarBotaoSair();
        JButton btnLimpar   = criarBotaoLimpar();

        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        p.add(btnOK);
        p.add(btnCancelar);
        p.add(btnLimpar);
        
        getRootPane().setDefaultButton(btnOK);
        
        return p;
    }
    
    private JButton criarBotaoLimpar() {

        JButton btn = new JButton("Limpar");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                username.setText(null);
                password.setText(null);
                
            }
        });
        return btn;
    }
    
    
    
    private JButton criarBotaoSair() {
        JButton btn = new JButton("Sair");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecharJanela();
            }
        });
        return btn;
    }
    
    private JButton criarBotaoLogin() {
        JButton btn = new JButton("Login");
   
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (username.getText().isEmpty() || password.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Tem de preencher todos os campos.");
                } else {
                    for (Utilizador u : ce.getRegistoUtilizadores().getListaUtilizadores()) {
                        if (username.getText().equals(u.getUsername()) && password.getText().equals(u.getPassword())) {
                            if (u.getRegistado()) {
                                user = u;                                
                            }
                        }
                    }
                    if (user==null){
                        JOptionPane.showMessageDialog(null, "Utilizador não registado no sistema. Por favor registe-se.");     
                    }else{
                        JOptionPane.showMessageDialog(null, "Utilizador válido. Bem vindo!");
                        Janela j = new Janela(ce, fichCentroExposicoes, user);
                        dispose();
                    }
                    
                }  
            }
        });
        return btn;
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
        System.exit(0);
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
