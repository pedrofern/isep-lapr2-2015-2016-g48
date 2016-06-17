package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.controller.*;
import lapr.project.model.*;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.lists.ListaKeywords;
import lapr.project.model.lists.ListaProduto;
import lapr.project.model.lists.RegistoExposicoes;
import lapr.project.utils.Utils;


/**
 *
 * @author Pedro Fernandes
 */
public class AlterarCandidaturaUI extends JFrame{
    /**
     * Guarda a dimensão de uma label por omissão
     */
    private static final Dimension LABEL_TAMANHO = new JLabel("Nº Convites:").
                                                        getPreferredSize();
    private static final int MARGEM_SUPERIOR = 5, MARGEM_INFERIOR = 5;
    private static final int MARGEM_ESQUERDA = 5, MARGEM_DIREITA = 5;
    /**
     * Guarda lista produtos em jlist
     */
    private JList lstProdutos;
    /**
     * Guarda o botao adicionar produto
     */
    private JButton botaoAdicionarProduto;
    /**
     * Guarda o botao remover produto
     */
    private JButton botaoRemoverProduto;
    /**
     * Guarda as Demonstracoes da exposicao
     */
    private JCheckBox cbDemo;
    /**
     * Guarda lista com exposições
     */
    private JComboBox comboExp;
    /**
     * Guarda lista com candidaturas
     */
    private JComboBox comboCand;
    private JButton selExp;
    private JButton selCand;
    /**
     * Guarda o nome introduzido da candidatura
     */
    private JTextField txtNome;
    /**
     * Guarda a morada introduzida da candidatura
     */
    private JTextField txtMorada;
    /**
     * Guarda o telemovel introduzido da candidatura
     */
    private JTextField txtTelemovel;
    /**
     * Guarda a area introduzida da candidatura
     */
    private JTextField txtArea;
    /**
     * Guarda o nº convites introduzido da candidatura
     */
    private JTextField txtConvites;
    /**
     * Guarda o keyword1 introduzido da candidatura
     */
    private JTextField txtKey1;
    /**
     * Guarda o keyword1 introduzido da candidatura
     */
    private JTextField txtKey2;
    /**
     * Guarda o keyword1 introduzido da candidatura
     */
    private JTextField txtKey3;
    /**
     * Guarda o keyword1 introduzido da candidatura
     */
    private JTextField txtKey4;
    /**
     * Guarda o keyword1 introduzido da candidatura
     */
    private JTextField txtKey5;
    /**
     * Guarda a lista produtos da candidatura
     */      
    private ListaKeywords listaKeywords;
    /**
     * Guarda a lista produtos da candidatura
     */      
    private ListaProduto listaProdutos;
    /**
     * Guarda a lista demonstrações da candidatura
     */
    private ListaDemonstracoes listaDemonstracoes;
    private JPanel painelWest;
    private JPanel painelPrincipal;    
    /**
     * Guarda a lista de exposicoes
     */
    private RegistoExposicoes listaExposicoes;
    /**
     * Guarda a lista de exposicoes
     */
    private ListaCandidaturas listaCandidaturas;
    /**
     * Guarda objectos candidatura
     */
    private Candidatura candidatura;
    /**
     * Guarda objectos exposição
     */
    private Exposicao exposicao;
    
    private static CentroExposicoes ce;
    private static Utilizador user;
    private static AlterarCandidaturaController controllerAC;


    public AlterarCandidaturaUI(CentroExposicoes centroExposicoes, Utilizador utilizador) {
        
        super("Alterar Candidatura");
        
        user=utilizador;
        
        ce = centroExposicoes;
        user=utilizador;

        criarComponentes();  
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(1100, 500));
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    private void criarComponentes(){
        painelPrincipal=new JPanel();
        painelPrincipal.setLayout(new BorderLayout());
        
        listaExposicoes = ce.getRegistoExposicoes();        
        
        add(criarPainelWest(),BorderLayout.WEST);

        add(painelPrincipal);
    }
    private JPanel criarPainelWest(){
        painelWest= new JPanel(new GridLayout(2,1));

        painelWest.add(criarPainelExposicao(listaExposicoes));        
                
        return painelWest;
    }
    private JPanel criarPainelExposicao(RegistoExposicoes lstExposicoes){
        JPanel painel= new JPanel(new BorderLayout());
        
        painel.setBorder(new TitledBorder("Exposição:"));
        comboExp = Utils.criarComboExpo(lstExposicoes);
                       
        painel.add(comboExp,BorderLayout.NORTH);
        
        JLabel label = new JLabel();
        label.setBounds(100,200,200,100);
        ImageIcon image=new ImageIcon("src/main/resources/images/expo.png");
        Image i=image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);               
        label.setIcon(new ImageIcon(i));
        painel.add(label,BorderLayout.CENTER);
        
        painel.add(criarBtSelectExp(),BorderLayout.SOUTH);

        return painel;
    }
      
    private JButton criarBtSelectExp() {
        selExp=new JButton("Seleccionar");
        
        selExp.setMnemonic(KeyEvent.VK_S);
        selExp.setToolTipText("Selecionar exposição da lista");
        
        selExp.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    selExp.setEnabled(false);
                    comboExp.setEnabled(false);  

                    exposicao=(Exposicao) comboExp.getSelectedItem();

                    listaCandidaturas = exposicao.getListaCandidaturas();
                    listaDemonstracoes = exposicao.getListaDemonstracoes();

                    painelWest.add(criarPainelCandidatura(listaCandidaturas));

                    selCand.setEnabled(true);
                    comboCand.setEnabled(true);

                    setVisible(true);
                  
               }catch(Exception ex){
                   JOptionPane.showMessageDialog(
                           AlterarCandidaturaUI.this, 
                           "Não existem exposições com candidaturas alteráveis!", 
                           "Alterar Candidatura", 
                           JOptionPane.ERROR_MESSAGE);
                   dispose();
               }
            }     
        }
        );  
        return selExp;
    }
    private JPanel criarPainelCandidatura(ListaCandidaturas lstCandidaturas){
        JPanel painelCand= new JPanel(new BorderLayout());
        
        painelCand.setBorder(new TitledBorder("Candidatura:"));
        comboCand = Utils.criarComboCand(lstCandidaturas);
        
        painelCand.add(comboCand, BorderLayout.NORTH); 
        
        JLabel label = new JLabel();
        label.setBounds(200,200,200,200);
        ImageIcon image=new ImageIcon("src/main/resources/images/cand_logo.png");
        Image i=image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH); 
        label.setIcon(new ImageIcon(i));
        painelCand.add(label,BorderLayout.CENTER);
        
        painelCand.add(criarBtSelectCand(),BorderLayout.SOUTH);

        return painelCand;
    } 
    private JButton criarBtSelectCand() {
        selCand=new JButton("Seleccionar");
        
        selCand.setMnemonic(KeyEvent.VK_S);
        selCand.setToolTipText("Selecionar candidatura da lista");
        
        selCand.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    selCand.setEnabled(false);
                    comboCand.setEnabled(false);    

                    candidatura =(Candidatura) comboCand.getSelectedItem();
                    controllerAC = new AlterarCandidaturaController(exposicao, candidatura);

                    criarComponentesCandidatura();
                }catch(Exception ex){
                   JOptionPane.showMessageDialog(
                           AlterarCandidaturaUI.this, 
                           "Não existem candidaturas possiveis de alterações na exposição selecionada!", 
                           "Alterar Candidatura", 
                           JOptionPane.ERROR_MESSAGE);
                   dispose();
               }
            }     
        }
        );  
        return selCand;
    }
    public void criarComponentesCandidatura() {
        
        painelPrincipal.add(criarPainelSul(), BorderLayout.SOUTH);
        painelPrincipal.add(criarPainelListas(),BorderLayout.CENTER);
        painelPrincipal.add(criarPainelNorte(), BorderLayout.NORTH);
        
        setVisible(true);
        
        inserirDados();

    }
    public void inserirDados(){
        txtArea.setText(Integer.toString(candidatura.getAreaExposicao()));
        txtConvites.setText(Integer.toString(candidatura.getQuantidadeConvites()));
        txtMorada.setText(candidatura.getMorada());
        txtNome.setText(candidatura.getNomeEmpresa());
        txtTelemovel.setText(Integer.toString(candidatura.getTelemovel()));
        
        int tmp = candidatura.getListaKeywords().tamanho();
        if (tmp >= 1){
            txtKey1.setText(candidatura.getListaKeywords().obterKeyword(0).toString());            
        }
        if (tmp >= 2){
            txtKey2.setText(candidatura.getListaKeywords().obterKeyword(1).toString());
        }
        if (tmp >= 3){
            txtKey2.setText(candidatura.getListaKeywords().obterKeyword(2).toString());
        }
        if (tmp >= 4){
            txtKey3.setText(candidatura.getListaKeywords().obterKeyword(3).toString());
        }
        if (tmp == 5){
            txtKey5.setText(candidatura.getListaKeywords().obterKeyword(4).toString());
        }

    }
    private JPanel criarPainelNorte() {
        JPanel p = new JPanel(new BorderLayout());
        
        p.add(criarPainelDados(),BorderLayout.CENTER);
        p.add(criarPainelKeywords(),BorderLayout.EAST);
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        return p;
    }
    private JPanel criarPainelSul() {
        JPanel p = new JPanel(new FlowLayout());
        p.setBorder(new TitledBorder("Opções"));
        p.add(criarPainelBotoes());
        return p;
    }  
    /**
     * cria painel para introdução dos dados gerais da candidatura
     * @return painel para introdução dos dados gerais da candidatura
     */
    private JPanel criarPainelDados(){
        JPanel p = new JPanel(new GridLayout(5,1));
        
        p.setBorder(new TitledBorder("Dados"));
        
        txtNome = new JTextField(30);
        txtNome.setEditable(false); 
        
        txtMorada = new JTextField(30);
        txtNome.requestFocusInWindow();
        txtMorada.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtMorada.getText().length() > 40) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        });
        
        txtTelemovel = new JTextField(7);
        txtTelemovel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtTelemovel.setText(txtTelemovel.getText().replaceAll("[^0-9]", ""));
            }
        });
        txtTelemovel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtTelemovel.getText().length() > 8) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        txtArea = new JTextField(2);
        txtArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtArea.setText(txtArea.getText().replaceAll("[^0-9]", ""));
            }
        });
        txtArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtArea.getText().length() > 2) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        txtConvites = new JTextField(2);
        txtConvites.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtConvites.setText(txtConvites.getText().replaceAll("[^0-9]", ""));
            }
        });
        txtConvites.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtConvites.getText().length() > 2) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        p.add(criarPainelNome("Nome:", txtNome,""));
        p.add(criarPainelNome("Morada:", txtMorada,""));
        p.add(criarPainelNome("Telemóvel:", txtTelemovel,"9xxxxxxxx"));
        p.add(criarPainelNome("Área:", txtArea,"m^2"));
        p.add(criarPainelNome("Nº Convites:", txtConvites,"(máx 999)"));
        
        return p;
    }
    private JPanel criarPainelKeywords(){        
        JPanel p = new JPanel(new GridLayout(5,1));
        
        p.setBorder(new TitledBorder("Keywords:"));
        
        txtKey1 = new JTextField(15);
        txtKey1.requestFocusInWindow();
        txtKey1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtKey1.setText(txtKey1.getText().replaceAll("[^a-z||^A-Z||^0-9||^ ]", ""));
            }
        });
        txtKey1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtKey1.getText().length() > 20) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        txtKey2 = new JTextField(15);
        txtKey2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtKey2.setText(txtKey2.getText().replaceAll("[^a-z||^A-Z||^0-9||^ ]", ""));
            }
        });
        txtKey2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtKey2.getText().length() > 20) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        txtKey3 = new JTextField(15);
        txtKey3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtKey3.setText(txtKey3.getText().replaceAll("[^a-z||^A-Z||^0-9||^ ]", ""));
            }
        });
        txtKey3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtKey3.getText().length() > 20) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        txtKey4 = new JTextField(15);
        txtKey4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtKey4.setText(txtKey4.getText().replaceAll("[^a-z||^A-Z||^0-9||^ ]", ""));
            }
        });
        txtKey4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtKey4.getText().length() > 20) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        txtKey5 = new JTextField(15);
        txtKey5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtKey5.setText(txtKey5.getText().replaceAll("[^a-z||^A-Z||^0-9||^ ]", ""));
            }
        });
        txtKey5.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtKey5.getText().length() > 20) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        p.add(criarPainelNome("Keyword 1:", txtKey1,"Obrigatório"));
        p.add(criarPainelNome("Keyword 2:", txtKey2,"Obrigatório"));
        p.add(criarPainelNome("Keyword 3:", txtKey3,""));
        p.add(criarPainelNome("Keyword 4:", txtKey4,""));
        p.add(criarPainelNome("Keyword 5:", txtKey5,""));
        
        
        return p;
    }
    /**
     * cria painel para introduzir label1, campo para introdução dados e label2
     * @param label1 introduzir label1
     * @param texto campo para introdução dados 
     * @param label2 introduzir label1
     * @return painel para introduzir label1, campo para introdução dados e label2
     */
    private JPanel criarPainelNome(String label1, JTextField texto, String label2) {
        JLabel lbl1 = new JLabel(label1, JLabel.RIGHT);
        lbl1.setPreferredSize(LABEL_TAMANHO);
        
        JLabel lbl2 = new JLabel(label2, JLabel.LEFT);
        lbl2.setPreferredSize(new Dimension(80,20));
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));

        p.add(lbl1);
        p.add(texto);
        p.add(lbl2);

        return p;
    }
    /**
     * cria painel botões
     * @return painel botões
     */
    private JPanel criarPainelBotoes() {

        FlowLayout l = new FlowLayout();

        l.setHgap(20);
        l.setVgap(20);

        JPanel p = new JPanel();

        JButton bt1 = criarBotaoAlterarCandidatura();
        JButton bt2 = criarBotaoCancelar();
        
        getRootPane().setDefaultButton(bt1);
        
        p.add(bt1);
        p.add(bt2);
        
        return p;
    }
    /**
     * cria paniel botões para lista produtos, recebendo como parametro 2 botoes
     * @param btn1 botão1
     * @param btn2 botão2
     * @return paniel botões para lista produtos, recebendo como parametro 2 botoes
     */
    private JPanel criarPainelBotoesListaProduto(JButton btn1, JButton btn2) {

        final int NUMERO_LINHAS = 2, NUMERO_COLUNAS = 1;
        final int INTERVALO_HORIZONTAL = 0, INTERVALO_VERTICAL = 10;        
        JPanel p = new JPanel(new GridLayout( NUMERO_LINHAS, 
                                              NUMERO_COLUNAS, 
                                              INTERVALO_HORIZONTAL,
                                              INTERVALO_VERTICAL));
        
        p.setBorder(BorderFactory.createEmptyBorder( MARGEM_SUPERIOR, 
                                                     MARGEM_ESQUERDA,
                                                     MARGEM_INFERIOR, 
                                                     MARGEM_DIREITA));
        
        p.add(btn1);
        p.add(btn2);
        
        return p;
    }
    /**
     * cria botão adicionar produto
     * @return botão adicionar produto
     */
    private JButton criarBotaoAdicionarProduto(){
        botaoAdicionarProduto = new JButton("Adicionar Produto");
        botaoAdicionarProduto.setMnemonic(KeyEvent.VK_A);
        botaoAdicionarProduto.setToolTipText("Adiciona produto");
        botaoAdicionarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DialogoProdutoAlterarCandidatura(AlterarCandidaturaUI.this);
            }
        });

        return botaoAdicionarProduto;
    }
    /**
     * cria botão eliminar produto
     * @return botão eliminar produto
     */
    private JButton criarBotaoEliminarProduto(){
        botaoRemoverProduto = new JButton("Eliminar Produto");
        botaoRemoverProduto.setMnemonic(KeyEvent.VK_E);
        botaoRemoverProduto.setToolTipText("Elimina produtos");
        botaoRemoverProduto.setEnabled(false);
        botaoRemoverProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Produto[] opcoes = listaProdutos.getArray();
                Produto produto = (Produto) JOptionPane.showInputDialog(
                        AlterarCandidaturaUI.this,
                        "Escolha um Produto:", "Eliminar Produto",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        opcoes,
                        opcoes[0]);
                if (produto != null) {
                    String[] opcoes2 = {"Sim", "Não"};
                    int resposta = JOptionPane.showOptionDialog(
                            AlterarCandidaturaUI.this,
                            "Eliminar\n" + produto.toString(),
                            "Eliminar Produto",
                            0,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opcoes2,
                            opcoes2[1]);
                    final int SIM = 0;
                    if (resposta == SIM) {
                        JList lista = getLstProdutos();
                        ModeloListaProdutos modeloListaProdutos
                                = (ModeloListaProdutos) lista.getModel();
                        modeloListaProdutos.removeElement(produto);
                        if (modeloListaProdutos.getSize() == 0) {
                            getBotaoRemoverProduto().setEnabled(false);
                        }
                    }
                }
            }
        });

        return botaoRemoverProduto;
    }
    /**
     * Devolve o botão remover produto
     * @return botão remover produto
     */
    public JButton getBotaoRemoverProduto(){
        return botaoRemoverProduto;
    }
    /**
     * criar botão registar
     * @return botão registar
     */
    private JButton criarBotaoAlterarCandidatura() {
        JButton botao = new JButton("Alterar Candidatura");
        botao.setMnemonic(KeyEvent.VK_R);
        botao.setToolTipText("Registar Candidatura");
//        botao.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try{      
                    
//                    int area = Integer.parseInt(txtArea.getText());
//                    int convites = Integer.parseInt(txtConvites.getText());                    
//                    String morada = txtMorada.getText();
//                    String nome = txtNome.getText();
//                    int telemovel = Integer.parseInt(txtTelemovel.getText());
//                    if (txtKey1.getText().isEmpty()||txtKey2.getText().isEmpty()){
//                        JOptionPane.showMessageDialog(
//                                null,
//                                "Keyword obrigatória por preencher!",
//                                "Alterar Candidatura",
//                                JOptionPane.ERROR_MESSAGE);                        
//                    }else{                    
//                    listaKeywords = controllerAC.getCandidatura(candidatura).getListaKeywords();
//                    Keyword k1 = new Keyword(""+txtKey1.getText());
//                    Keyword k2 = new Keyword(""+txtKey2.getText());
//                    Keyword k3 = new Keyword(""+txtKey3.getText());
//                    Keyword k4 = new Keyword(""+txtKey4.getText());
//                    Keyword k5 = new Keyword(""+txtKey5.getText());
//                    listaKeywords.adicionarKeyword(k1);
//                    listaKeywords.adicionarKeyword(k2);
//                    listaKeywords.adicionarKeyword(k3);
//                    listaKeywords.adicionarKeyword(k4);
//                    listaKeywords.adicionarKeyword(k5);
//                    
//                    candidatura = controllerAC.alteraCandidatura(
//                            nome, morada, telemovel, area, convites,
//                            listaProdutos,listaKeywords);
//                    
//                    boolean adicionarNovaCandidatura = controllerAC.valida();
//                    if (adicionarNovaCandidatura == true) {                        
//                        if (candidatura == null){
//                        JOptionPane.showMessageDialog(
//                                null,
//                                "Candidatura já registada",
//                                "Nova Candidatura",
//                                JOptionPane.ERROR_MESSAGE);
//                        }
//                        JOptionPane.showMessageDialog(
//                                null,
//                                "Candidatura adicionada: \n"
//                                +candidatura.toStringCompleto(),
//                                "Nova Candidatura",
//                                JOptionPane.INFORMATION_MESSAGE);
//                        dispose();
//                    }
//                     
//                    else {
//                        JOptionPane.showMessageDialog(
//                                null,
//                                "O registo não é válido!\nVerifique todos os campos",
//                                "Nova Candidatura",
//                                JOptionPane.ERROR_MESSAGE);
//                    }    
//                    }
//                }
//                catch (NumberFormatException ex){
//                    JOptionPane.showMessageDialog(
//                            null,
//                            "Tem de preencher todos os campos!",
//                            "Registar Candidatura",
//                            JOptionPane.ERROR_MESSAGE);                        
//                }
//            }
//        });

        return botao;
    }
    /**
     * criar botão cancelar e volta menu anterior
     * @return botão cancelar e volta menu anterior 
     */
    private JButton criarBotaoCancelar() {
        JButton botao = new JButton("Cancelar");
        botao.setMnemonic(KeyEvent.VK_C);
        botao.setToolTipText("Cancela a alteração candidatura e volta ao menu anterior");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        return botao;
    }
    /**
     * criar painel lista produtos e demonstrações
     * @return painel lista produtos e demonstrações
     */
    private JPanel criarPainelListas() {
        final int NUMERO_LINHAS = 1, NUMERO_COLUNAS = 2;
        final int INTERVALO_HORIZONTAL = 20, INTERVALO_VERTICAL = 0;
        JPanel p = new JPanel(new GridLayout( NUMERO_LINHAS, 
                                              NUMERO_COLUNAS, 
                                              INTERVALO_HORIZONTAL,
                                              INTERVALO_VERTICAL));
        listaProdutos = controllerAC.getCandidatura(candidatura).getListaProdutos();
        ModeloListaProdutos modeloListaProdutos = new ModeloListaProdutos(listaProdutos);
        lstProdutos = new JList(modeloListaProdutos);
        botaoAdicionarProduto = criarBotaoAdicionarProduto();
        botaoRemoverProduto = criarBotaoEliminarProduto();
        p.add(criarPainelListaProduto( "Produtos:",
                                lstProdutos,
                                botaoAdicionarProduto,
                                botaoRemoverProduto));
        p.add(criarPainelListaDemo());//("Demonstrações:",lstDemonstracoes,botaoVerRecursoDemonstracao));

        return p;
    }
    /**
     * criar painel lista produtos recebendo titulo lista, lista produtos e 2 botoes
     * @param tituloLista titulo lista
     * @param lstLista lista produtos
     * @param btnSuperior botao superior
     * @param btnInferior botao inferior
     * @return painel lista produtos recebendo titulo, lista produtos e 2 botoes
     */
    private JPanel criarPainelListaProduto(
            String tituloLista,
            JList lstLista,
            JButton btnSuperior,
            JButton btnInferior)
    {
        lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(lstLista);

        JPanel p = new JPanel(new BorderLayout());
        
        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(tituloLista),
                new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA)));
        
        p.add(scrPane, BorderLayout.CENTER);

        JPanel pBotoes = criarPainelBotoesListaProduto(btnSuperior,btnInferior);
        p.add(pBotoes, BorderLayout.SOUTH);
        return p;
    }
    /**
     * Devolve uma lista de produtos
     * @return lista produtos
     */
    public JList getLstProdutos() {
        return lstProdutos;
    }
    /**
     * criar painel lista demonstrações recebendo titulo lista, lista demonstrações e um botao
     * @param tituloLista titulo lista
     * @param lstLista lista demonstrações
     * @param btn botao
     * @return painel lista demonstrações recebendo titulo lista, lista demonstrações e um botao
     */
    private JPanel criarPainelListaDemo(){

        JPanel p = new JPanel(new BorderLayout());

       p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Demonstrações"),
                new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA)));
        
        p.add(criarPainelCheckBoxDemo(), BorderLayout.CENTER);

        return p;
    }
    private JPanel criarPainelCheckBoxDemo(){
        JPanel pCheck=new JPanel(new FlowLayout());
        
        Demonstracao[] opcoes=listaDemonstracoes.getArray();
        int lenght=opcoes.length;
        int LINHAS= lenght+1/2;

        for(Demonstracao d:opcoes){
            String sDemo=d.toString();
            cbDemo=new JCheckBox(sDemo);
            
            cbDemo.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                   if(cbDemo.isSelected()){
                      
        System.out.println("selecionou");        
                   }
               }
            });
            pCheck.add(cbDemo);
        }
        return pCheck;
    }

}