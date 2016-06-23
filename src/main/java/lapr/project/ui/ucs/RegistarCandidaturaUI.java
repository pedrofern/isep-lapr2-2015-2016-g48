package lapr.project.ui.ucs;

import lapr.project.model.*;
import lapr.project.controller.*;
import lapr.project.model.lists.*;
import lapr.project.utils.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;

/**
 *
 * @author Pedro Fernandes
 */
public class RegistarCandidaturaUI extends JFrame{
    
    /**
     * Guarda a dimensão de uma label por omissão
     */
    private static final Dimension LABEL_TAMANHO = new JLabel("Nº Convites:").
                                                        getPreferredSize();
    private static final int MARGEM_SUPERIOR = 5;
    private static final int MARGEM_INFERIOR = 5;
    private static final int MARGEM_ESQUERDA = 5;
    private static final int MARGEM_DIREITA = 5;
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
    private JButton selExp;
    /**
     * Guarda as Demonstracoes da exposicao
     */
    private JCheckBox cbDemo;
    /**
     * Guarda lista com exposições
     */
    private JComboBox comboExp;
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
    private JPanel painelGeral;
    private String validaFormatoDadosNome = "[^a-z||^A-Z||^ ]";
    private String validaFormatoDadosNum = "[^0-9]";
    private String validaFormatoDadosKey = "[^a-z||^A-Z||^0-9]";

    private RegistarCandidaturaController controllerRCC;

    public RegistarCandidaturaUI(CentroExposicoes ce, Utilizador utilizador) {
        
        super("Registar Candidatura");
        
        controllerRCC = new RegistarCandidaturaController(ce,utilizador); 
        
        add(criarComponentes());

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(1100, 500));
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    public JPanel criarComponentes() {
        painelGeral = new JPanel(new BorderLayout());
        painelGeral.add(criarPainelSul(), BorderLayout.SOUTH);
        painelGeral.add(criarPainelNorte(), BorderLayout.NORTH);

        txtArea.setEnabled(false);
        txtConvites.setEnabled(false);
        txtKey1.setEnabled(false);
        txtKey2.setEnabled(false);
        txtKey3.setEnabled(false);
        txtKey4.setEnabled(false);
        txtKey5.setEnabled(false);
        txtMorada.setEnabled(false);
        txtNome.setEnabled(false);
        txtTelemovel.setEnabled(false);
        
        return painelGeral;
    }

    private JPanel criarPainelNorte() {
        JPanel p = new JPanel(new BorderLayout());
        
//        p.add(criarPainelExposicao(controllerRCC.getExposicoesEstadoCandidaturasAbertas()),BorderLayout.WEST);
        p.add(criarPainelExposicao(controllerRCC.getExposicoes()),BorderLayout.WEST);
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
    private JPanel criarPainelExposicao(RegistoExposicoes lstExposicoes){
        JPanel painel= new JPanel(new BorderLayout());
        
        painel.setBorder(new TitledBorder("Exposição"));
        comboExp = Utils.criarComboExpo(lstExposicoes);
        
        painel.add(comboExp, BorderLayout.NORTH);              
        painel.add(criarBtSelect(),BorderLayout.CENTER);

        return painel;
    }
    /**
     * cria painel para introdução dos dados gerais da candidatura
     * @return painel para introdução dos dados gerais da candidatura
     */
    private JPanel criarPainelDados(){
        JPanel p = new JPanel(new GridLayout(5,1));
        
        p.setBorder(new TitledBorder("Dados"));
        
        txtNome = new JTextField(30);
        txtNome.requestFocusInWindow();
        txtNome.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtNome.setText(txtNome.getText().replaceAll(validaFormatoDadosNome, ""));
            }
        });
        txtNome.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtNome.getText().length() > 40) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        txtMorada = new JTextField(30);
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
                txtTelemovel.setText(txtTelemovel.getText().replaceAll(validaFormatoDadosNum, ""));
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
                txtArea.setText(txtArea.getText().replaceAll(validaFormatoDadosNum, ""));
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
                txtConvites.setText(txtConvites.getText().replaceAll(validaFormatoDadosNum, ""));
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
        
        p.add(criarPainelNomes("Nome:", txtNome,""));
        p.add(criarPainelNomes("Morada:", txtMorada,""));
        p.add(criarPainelNomes("Telemóvel:", txtTelemovel,"9xxxxxxxx"));
        p.add(criarPainelNomes("Área:", txtArea,"m^2"));
        p.add(criarPainelNomes("Nº Convites:", txtConvites,"(máx 999)"));
        
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
                txtKey1.setText(txtKey1.getText().replaceAll(validaFormatoDadosKey, ""));
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
                txtKey2.setText(txtKey2.getText().replaceAll(validaFormatoDadosKey, ""));
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
                txtKey3.setText(txtKey3.getText().replaceAll(validaFormatoDadosKey, ""));
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
                txtKey4.setText(txtKey4.getText().replaceAll(validaFormatoDadosKey, ""));
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
                txtKey5.setText(txtKey5.getText().replaceAll(validaFormatoDadosKey, ""));
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
        p.add(criarPainelNomes("Keyword 1:", txtKey1,"Obrigatório"));
        p.add(criarPainelNomes("Keyword 2:", txtKey2,"Obrigatório"));
        p.add(criarPainelNomes("Keyword 3:", txtKey3,""));
        p.add(criarPainelNomes("Keyword 4:", txtKey4,""));
        p.add(criarPainelNomes("Keyword 5:", txtKey5,""));
        
        
        return p;
    }
    /**
     * cria painel para introduzir label1, campo para introdução dados e label2
     * @param label1 introduzir label1
     * @param texto campo para introdução dados 
     * @param label2 introduzir label1
     * @return painel para introduzir label1, campo para introdução dados e label2
     */
    private JPanel criarPainelNomes(String label1, JTextField texto, String label2) {
        JLabel lb1 = new JLabel(label1, JLabel.RIGHT);
        lb1.setPreferredSize(LABEL_TAMANHO);
        
        JLabel lb2 = new JLabel(label2, JLabel.LEFT);
        lb2.setPreferredSize(new Dimension(80,20));
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));

        p.add(lb1);
        p.add(texto);
        p.add(lb2);

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

        JButton bt1 = criarBotaoRegistar();
        JButton bt2 = criarBotaoLimpar();
        JButton bt3 = criarBotaoCancelar();
        
        getRootPane().setDefaultButton(bt1);
        
        p.add(bt1);
        p.add(bt2);
        p.add(bt3);
        
        return p;
    }
    /**
     * cria paniel botões para lista produtos, recebendo como parametro 2 botoes
     * @param btn1 botão1
     * @param btn2 botão2
     * @return paniel botões para lista produtos, recebendo como parametro 2 botoes
     */
    private JPanel criarPainelBotoesListaProduto(JButton btn1, JButton btn2) {

        final int N_LINHAS = 2;
        final int N_COLUNAS = 1;
        final int INTERVALO_HOR = 0;
        final int INTERVALO_VER = 10;        
        JPanel p = new JPanel(new GridLayout( N_LINHAS, 
                                              N_COLUNAS, 
                                              INTERVALO_HOR,
                                              INTERVALO_VER));
        
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
                DialogoNovoProduto d = new DialogoNovoProduto(RegistarCandidaturaUI.this);
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
                Produto[] opcoes = controllerRCC.getListaProdutos().getArray();
                Produto produto = (Produto) JOptionPane.showInputDialog(
                        RegistarCandidaturaUI.this,
                        "Escolha um Produto:", "Eliminar Produto",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        opcoes,
                        opcoes[0]);
                if (produto != null) {
                    String[] opcoes2 = {"Sim", "Não"};
                    int resposta = JOptionPane.showOptionDialog(
                            RegistarCandidaturaUI.this,
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
    private JButton criarBotaoRegistar() {
        JButton botao = new JButton("Registar Candidatura");
        botao.setMnemonic(KeyEvent.VK_R);
        botao.setToolTipText("Registar Candidatura");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{      
                    
                    int area = Integer.parseInt(txtArea.getText());
                    int convites = Integer.parseInt(txtConvites.getText());                    
                    String morada = txtMorada.getText();
                    String nome = txtNome.getText();
                    int telemovel = Integer.parseInt(txtTelemovel.getText());
                    if (txtKey1.getText().isEmpty()||txtKey2.getText().isEmpty()){
                        JOptionPane.showMessageDialog(
                                null,
                                "Keyword obrigatória por preencher!",
                                "Nova Candidatura",
                                JOptionPane.ERROR_MESSAGE);                        
                    }else{                      
                    Keyword k1 = new Keyword(""+txtKey1.getText());
                    Keyword k2 = new Keyword(""+txtKey2.getText());
                    Keyword k3 = new Keyword(""+txtKey3.getText());
                    Keyword k4 = new Keyword(""+txtKey4.getText());
                    Keyword k5 = new Keyword(""+txtKey5.getText());
                    controllerRCC.addKeyword(k1);
                    controllerRCC.addKeyword(k2);
                    controllerRCC.addKeyword(k3);
                    controllerRCC.addKeyword(k4);
                    controllerRCC.addKeyword(k5);
                    
                    Candidatura c = controllerRCC.registaCandidatura(
                            nome, morada, telemovel, area, convites,
                            controllerRCC.getListaProdutos(),
                            controllerRCC.getListaKeywords());
                    
                    boolean adicionarNovaCandidatura = controllerRCC.valida();
                    if (adicionarNovaCandidatura) {                        
                        if (c == null){
                        JOptionPane.showMessageDialog(
                                null,
                                "Candidatura já registada",
                                "Nova Candidatura",
                                JOptionPane.ERROR_MESSAGE);
                        }else{
                            controllerRCC.getSelectedDemonstacao();
                            controllerRCC.registCandidaturaDemonstracao();
                        JOptionPane.showMessageDialog(
                                null,
                                "Candidatura adicionada: \n"
                                +c.toStringCompleto()
                                +"\nDemonstracoes em interesse: \n"
                                +controllerRCC.getSelectedDemonstacao().toStringCompleto(),
                                "Nova Candidatura",
                                JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        }
                    }
                     
                    else {
                        JOptionPane.showMessageDialog(
                                null,
                                "O registo não é válido!\nVerifique todos os campos",
                                "Nova Candidatura",
                                JOptionPane.ERROR_MESSAGE);
                    }    
                    }
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(
                            null,
                            "Tem de preencher todos os campos!",
                            "Registar Candidatura",
                            JOptionPane.ERROR_MESSAGE);                        
                }
            }
        });

        return botao;
    }
    /**
     * criar botão limpar
     * @return botão limpar
     */
    private JButton criarBotaoLimpar() {
        JButton botao = new JButton("Limpar Candidatura");
        botao.setMnemonic(KeyEvent.VK_L);
        botao.setToolTipText("Limpa dados gerais da candidatura");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.setText("");
                txtConvites.setText("");
                txtMorada.setText("");
                txtNome.setText("");
                txtTelemovel.setText("");
                txtKey1.setText("");
                txtKey2.setText("");
                txtKey3.setText("");
                txtKey4.setText("");
                txtKey5.setText("");
            }
        });

        return botao;
    }
    /**
     * criar botão cancelar e volta menu anterior
     * @return botão cancelar e volta menu anterior 
     */
    private JButton criarBotaoCancelar() {
        JButton botao = new JButton("Cancelar");
        botao.setMnemonic(KeyEvent.VK_C);
        botao.setToolTipText("Cancela o registo candidatura e volta ao menu anterior");
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
        ModeloListaProdutos modeloListaProdutos = new ModeloListaProdutos(controllerRCC.getListaProdutos());
        lstProdutos = new JList(modeloListaProdutos);
        botaoAdicionarProduto = criarBotaoAdicionarProduto();
        botaoRemoverProduto = criarBotaoEliminarProduto();
        p.add(criarPainelListaProduto( "Produtos:",
                                lstProdutos,
                                botaoAdicionarProduto,
                                botaoRemoverProduto));
        p.add(criarPainelListaDemo());

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
     * criar painel lista demonstrações 
     * @return painel lista demonstrações 
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
        
        Demonstracao[] opcoes=controllerRCC.getListaDemonstracoes().getArray();
        int lenght=opcoes.length;
        int LINHAS= lenght+1/2;
        int COL= lenght+1/2;
        
        JPanel pCheck=new JPanel(new GridLayout(LINHAS, COL));

        for(Demonstracao d:opcoes){
            String sDemo=d.toString();
            cbDemo=new JCheckBox(sDemo);
            
            cbDemo.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                   if(cbDemo.isSelected()){
                      controllerRCC.selectDemonstracao(d);
                   }
               }
            });
            pCheck.add(cbDemo);
        }
        return pCheck;
    }
    private JButton criarBtSelect() {
        selExp=new JButton("Seleccionar");
        
        selExp.setMnemonic(KeyEvent.VK_S);
        selExp.setToolTipText("Selecionar exposição da lista");
        
        selExp.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    controllerRCC.selectExposicao((Exposicao) comboExp.getSelectedItem());
                    controllerRCC.novaCandidatura();

                    painelGeral.add(criarPainelListas(), BorderLayout.CENTER);
                    setVisible(true);

                    selExp.setEnabled(false);
                    comboExp.setEnabled(false);

                    txtArea.setEnabled(true);
                    txtConvites.setEnabled(true);
                    txtKey1.setEnabled(true);
                    txtKey2.setEnabled(true);
                    txtKey3.setEnabled(true);
                    txtKey4.setEnabled(true);
                    txtKey5.setEnabled(true);
                    txtMorada.setEnabled(true);
                    txtNome.setEnabled(true);
                    txtTelemovel.setEnabled(true);
                }
                catch (NullPointerException ex){
                    JOptionPane.showMessageDialog(
                            null,
                            "Não existem Exposições com período Candidaturas em aberto.",
                            "Registar Candidatura",
                            JOptionPane.ERROR_MESSAGE);                        
                }
            }     
        }
        );
        
        return selExp;
    }

}