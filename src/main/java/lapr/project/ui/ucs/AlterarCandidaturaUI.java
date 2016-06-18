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
    private JTextField txtNomeA;
    /**
     * Guarda a morada introduzida da candidatura
     */
    private JTextField txtMoradaA;
    /**
     * Guarda o telemovel introduzido da candidatura
     */
    private JTextField txtTelemovelA;
    /**
     * Guarda a area introduzida da candidatura
     */
    private JTextField txtAreaA;
    /**
     * Guarda o nº convites introduzido da candidatura
     */
    private JTextField txtConvitesA;
    /**
     * Guarda o keyword1 introduzido da candidatura
     */
    private JTextField txtKey1A;
    /**
     * Guarda o keyword1 introduzido da candidatura
     */
    private JTextField txtKey2A;
    /**
     * Guarda o keyword1 introduzido da candidatura
     */
    private JTextField txtKey3A;
    /**
     * Guarda o keyword1 introduzido da candidatura
     */
    private JTextField txtKey4A;
    /**
     * Guarda o keyword1 introduzido da candidatura
     */
    private JTextField txtKey5A;
    private JPanel painelWest;
    private JPanel painelPrincipal;    
    
    private static CentroExposicoes ce;
    private static Utilizador utilizador;
    private static AlterarCandidaturaController controllerAC;


    public AlterarCandidaturaUI(CentroExposicoes ce, Utilizador utilizador) {
        
        super("Alterar Candidatura");
        
        this.ce = ce;
        this.utilizador=utilizador;
        
        controllerAC = new AlterarCandidaturaController(ce, utilizador);        

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

        add(criarPainelWest(),BorderLayout.WEST);

        add(painelPrincipal);
    }
    private JPanel criarPainelWest(){
        painelWest= new JPanel(new GridLayout(2,1));

        painelWest.add(criarPainelExposicao(controllerAC.getRegistoExposicoes()));        
                
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
                    
                    controllerAC.selectExposicao((Exposicao) comboExp.getSelectedItem());

                    painelWest.add(criarPainelCandidatura(controllerAC.getListaCandidaturasRepresentante(utilizador)));

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
        label.setBounds(160,200,200,160);
        ImageIcon image2=new ImageIcon("src/main/resources/images/cand_logo.png");
        Image i2=image2.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH); 
        label.setIcon(new ImageIcon(i2));
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

                    controllerAC.selectCandidatura((Candidatura) comboCand.getSelectedItem());

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
        txtAreaA.setText(Integer.toString(controllerAC.getInfoCandidatura().getAreaExposicao()));
        txtConvitesA.setText(Integer.toString(controllerAC.getInfoCandidatura().getQuantidadeConvites()));
        txtMoradaA.setText(controllerAC.getInfoCandidatura().getMorada());
        txtNomeA.setText(controllerAC.getInfoCandidatura().getNomeEmpresa());
        txtTelemovelA.setText(Integer.toString(controllerAC.getInfoCandidatura().getTelemovel()));
        
        int tmp = controllerAC.getInfoCandidatura().getListaKeywords().tamanho();
        if (tmp >= 1){
            txtKey1A.setText(controllerAC.getInfoCandidatura().getListaKeywords().obterKeyword(0).toString());            
        }
        if (tmp >= 2){
            txtKey2A.setText(controllerAC.getInfoCandidatura().getListaKeywords().obterKeyword(1).toString());
        }
        if (tmp >= 3){
            txtKey2A.setText(controllerAC.getInfoCandidatura().getListaKeywords().obterKeyword(2).toString());
        }
        if (tmp >= 4){
            txtKey3A.setText(controllerAC.getInfoCandidatura().getListaKeywords().obterKeyword(3).toString());
        }
        if (tmp == 5){
            txtKey5A.setText(controllerAC.getInfoCandidatura().getListaKeywords().obterKeyword(4).toString());
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
        
        txtNomeA = new JTextField(30);
        txtNomeA.setEditable(false); 
        
        txtMoradaA = new JTextField(30);
        txtNomeA.requestFocusInWindow();
        txtMoradaA.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtMoradaA.getText().length() > 40) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        });
        
        txtTelemovelA = new JTextField(7);
        txtTelemovelA.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtTelemovelA.setText(txtTelemovelA.getText().replaceAll("[^0-9]", ""));
            }
        });
        txtTelemovelA.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtTelemovelA.getText().length() > 8) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        txtAreaA = new JTextField(2);
        txtAreaA.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtAreaA.setText(txtAreaA.getText().replaceAll("[^0-9]", ""));
            }
        });
        txtAreaA.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtAreaA.getText().length() > 2) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        txtConvitesA = new JTextField(2);
        txtConvitesA.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtConvitesA.setText(txtConvitesA.getText().replaceAll("[^0-9]", ""));
            }
        });
        txtConvitesA.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtConvitesA.getText().length() > 2) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        p.add(criarPainelNome("Nome:", txtNomeA,""));
        p.add(criarPainelNome("Morada:", txtMoradaA,""));
        p.add(criarPainelNome("Telemóvel:", txtTelemovelA,"9xxxxxxxx"));
        p.add(criarPainelNome("Área:", txtAreaA,"m^2"));
        p.add(criarPainelNome("Nº Convites:", txtConvitesA,"(máx 999)"));
        
        return p;
    }
    private JPanel criarPainelKeywords(){        
        JPanel p = new JPanel(new GridLayout(5,1));
        
        p.setBorder(new TitledBorder("Keywords:"));
        
        txtKey1A = new JTextField(15);
        txtKey1A.requestFocusInWindow();
        txtKey1A.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtKey1A.setText(txtKey1A.getText().replaceAll("[^a-z||^A-Z||^0-9||^ ]", ""));
            }
        });
        txtKey1A.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtKey1A.getText().length() > 20) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        txtKey2A = new JTextField(15);
        txtKey2A.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtKey2A.setText(txtKey2A.getText().replaceAll("[^a-z||^A-Z||^0-9||^ ]", ""));
            }
        });
        txtKey2A.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtKey2A.getText().length() > 20) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        txtKey3A = new JTextField(15);
        txtKey3A.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtKey3A.setText(txtKey3A.getText().replaceAll("[^a-z||^A-Z||^0-9||^ ]", ""));
            }
        });
        txtKey3A.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtKey3A.getText().length() > 20) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        txtKey4A = new JTextField(15);
        txtKey4A.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtKey4A.setText(txtKey4A.getText().replaceAll("[^a-z||^A-Z||^0-9||^ ]", ""));
            }
        });
        txtKey4A.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtKey4A.getText().length() > 20) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        txtKey5A = new JTextField(15);
        txtKey5A.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtKey5A.setText(txtKey5A.getText().replaceAll("[^a-z||^A-Z||^0-9||^ ]", ""));
            }
        });
        txtKey5A.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtKey5A.getText().length() > 20) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        p.add(criarPainelNome("Keyword 1:", txtKey1A,"Obrigatório"));
        p.add(criarPainelNome("Keyword 2:", txtKey2A,"Obrigatório"));
        p.add(criarPainelNome("Keyword 3:", txtKey3A,""));
        p.add(criarPainelNome("Keyword 4:", txtKey4A,""));
        p.add(criarPainelNome("Keyword 5:", txtKey5A,""));
        
        
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
                Produto[] opcoes = controllerAC.getInfoCandidatura().getListaProdutos().getArray();
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
                    
//                    int area = Integer.parseInt(txtAreaA.getText());
//                    int convites = Integer.parseInt(txtConvitesA.getText());                    
//                    String morada = txtMoradaA.getText();
//                    String nome = txtNomeA.getText();
//                    int telemovel = Integer.parseInt(txtTelemovelA.getText());
//                    if (txtKey1A.getText().isEmpty()||txtKey2A.getText().isEmpty()){
//                        JOptionPane.showMessageDialog(
//                                null,
//                                "Keyword obrigatória por preencher!",
//                                "Alterar Candidatura",
//                                JOptionPane.ERROR_MESSAGE);                        
//                    }else{                    
//                    listaKeywords = controllerAC.getCandidatura(candidatura).getListaKeywords();
//                    Keyword k1 = new Keyword(""+txtKey1A.getText());
//                    Keyword k2 = new Keyword(""+txtKey2A.getText());
//                    Keyword k3 = new Keyword(""+txtKey3A.getText());
//                    Keyword k4 = new Keyword(""+txtKey4A.getText());
//                    Keyword k5 = new Keyword(""+txtKey5A.getText());
//                    listaKeywords.adicionarKeyword(k1);
//                    listaKeywords.adicionarKeyword(k2);
//                    listaKeywords.adicionarKeyword(k3);
//                    listaKeywords.adicionarKeyword(k4);
//                    listaKeywords.adicionarKeyword(k5);
//                    
//                    candidatura = controllerAC.setDadosCandidatura(
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
        final int NUMERO_LINHAS = 1;
        final int NUMERO_COLUNAS = 2;
        final int INTERVALO_HORIZONTAL = 20;
        final int INTERVALO_VERTICAL = 0;
        JPanel p = new JPanel(new GridLayout( NUMERO_LINHAS, 
                                              NUMERO_COLUNAS, 
                                              INTERVALO_HORIZONTAL,
                                              INTERVALO_VERTICAL));
        ModeloListaProdutos modeloListaProdutos = new ModeloListaProdutos(controllerAC.getInfoCandidatura().getListaProdutos());
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
        
        Demonstracao[] opcoes=controllerAC.getListaDemonstracoes().getArray();
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