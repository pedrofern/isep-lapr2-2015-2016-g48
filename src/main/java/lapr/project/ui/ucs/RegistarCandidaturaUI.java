package lapr.project.ui.ucs;

import lapr.project.model.*;
import lapr.project.controller.*;
import lapr.project.ui.*;
import lapr.project.model.lists.*;
import lapr.project.utils.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro Fernandes
 */
public class RegistarCandidaturaUI extends JFrame{
    
    /**
     * A largura da janela em píxeis.
     */
    private static final int JANELA_LARGURA = 800;
    /**
     * A altura da janela em píxeis.
     */
    private static final int JANELA_ALTURA = 700;
    /**
     * Guarda a dimensão de uma label por omissão
     */
    private static final Dimension LABEL_TAMANHO = new JLabel("Nº Convites:").
                                                        getPreferredSize();
    /**
     * Guarda lista produtos em jlist
     */
    private JList lstProdutos;
    /**
     * Guarda lista demonstrações em jlist
     */
    private JList lstDemonstracoes;
    /**
     * Guarda o botao adicionar produto
     */
    private JButton botaoAdicionarProduto;
    /**
     * Guarda o botao remover produto
     */
    private JButton botaoRemoverProduto;
    /**
     * Guarda o botao ver demonstrações
     */
    private JButton botaoVerRecursoDemonstracao;
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
     * Guarda a lista produtos da candidatura
     */      
    private ListaProduto listaProdutos;
    /**
     * Guarda a lista demonstrações da candidatura
     */
    private ListaDemonstracoes listaDemonstracoes;
    /**
     * Guarda a lista recursos da candidatura
     */
    private RegistoRecursos listaRecursos;
    /**
     * Guarda objectos candidatura
     */
    private Candidatura candidatura;
    /**
     * Guarda objectos exposição
     */
    private Exposicao exposicao;
    /**
     * Guarda objectos centro exposições
     */
    private CentroExposicoes centroExposicoes;

    private Representante e_representante;
    private RegistarCandidaturaController m_controllerCCC;

    public RegistarCandidaturaUI(CentroExposicoes ce) {
        
        super("Registar Candidatura");
        

        
        e_representante = new Representante();
        m_controllerCCC = new RegistarCandidaturaController(e_representante);
        centroExposicoes = ce;
//        listaDemonstracoes = ce.getRegistoExposicoes().getDe
        
        JPanel norte = criarPainelNorte();
        JPanel centro = criarPainelListas();
        JPanel botoes = criarPainelBotoes();        
        
        add(norte, BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(JANELA_LARGURA, JANELA_ALTURA));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);  
        
        
        
    }
    /**
     * Devolve uma lista de produtos
     * @return lista produtos
     */
    public JList getLstProdutos() {
        return lstProdutos;
    }
    /**
     * Devolve uma lista demonstrações
     * @return lista demonstrações
     */
    public JList getLstDemonstracoes() {
        return lstDemonstracoes;
    }
    private JPanel criarPainelExposicao(){
        JPanel painelExp = new JPanel(new FlowLayout());
        
        comboExp = new JComboBox();
        comboExp.addItem("teste");
        
        return painelExp;
        
    }
    /**
     * cria painel para introdução dos dados gerais da candidatura
     * @return painel para introdução dos dados gerais da candidatura
     */
    private JPanel criarPainelNorte(){
        JPanel painelNorte = new JPanel( new GridLayout(5,1));
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 25, MARGEM_DIREITA = 0;
        painelNorte.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Dados Empresa"),
                new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA)));
        
        txtNome = new JTextField(40);
        txtNome.requestFocusInWindow();
        txtNome.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtNome.setText(txtNome.getText().replaceAll("[^a-z||^A-Z||^ ]", ""));
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
        
        txtMorada = new JTextField(40);
        txtMorada.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtMorada.getText().length() > 40) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        });
        
        txtTelemovel = new JTextField(9);
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
        
        txtArea = new JTextField(4);
        txtArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ev){
                txtArea.setText(txtArea.getText().replaceAll("[^0-9]", ""));
            }
        });
        txtArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent ev) {
                if (txtArea.getText().length() > 3) {
                    ev.setKeyChar((char) KeyEvent.VK_CLEAR);
                } 
            }
        }); 
        
        txtConvites = new JTextField(4);
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
        
        painelNorte.add(criarPainelExposicao());
        painelNorte.add(criarPainelNome("Nome:", txtNome,""));
        painelNorte.add(criarPainelNome("Morada:", txtMorada,""));
        painelNorte.add(criarPainelNome("Telemóvel:", txtTelemovel,""));
        painelNorte.add(criarPainelNome("Área:", txtArea,"m^2"));
        painelNorte.add(criarPainelNome("Nº Convites:", txtConvites,"(máx 999)"));
        
        return painelNorte;
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
        lbl2.setPreferredSize(new Dimension(150,20));
        
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 0;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

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

        JPanel p = new JPanel(l);

        JButton bt1 = criarBotaoRegistar();
        JButton bt2 = criarBotaoLimpar();
        JButton bt3 = criarBotaoCancelar();
        
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

        final int NUMERO_LINHAS = 2, NUMERO_COLUNAS = 1;
        final int INTERVALO_HORIZONTAL = 0, INTERVALO_VERTICAL = 10;        
        JPanel p = new JPanel(new GridLayout( NUMERO_LINHAS, 
                                              NUMERO_COLUNAS, 
                                              INTERVALO_HORIZONTAL,
                                              INTERVALO_VERTICAL));
        
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 0, MARGEM_DIREITA = 0;
        p.setBorder(BorderFactory.createEmptyBorder( MARGEM_SUPERIOR, 
                                                     MARGEM_ESQUERDA,
                                                     MARGEM_INFERIOR, 
                                                     MARGEM_DIREITA));
        
        p.add(btn1);
        p.add(btn2);
        
        return p;
    }
    /**
     * cria painel botão lista demonstraões, recebendo um botão por parametro
     * @param btn botão
     * @return painel botão lista demonstraões, recebendo um botão por parametro
     */
    private JPanel criarPainelBotaoListaDemo(JButton btn) {

        final int NUMERO_LINHAS = 1, NUMERO_COLUNAS = 1;
        final int INTERVALO_HORIZONTAL = 0, INTERVALO_VERTICAL = 10;        
        JPanel p = new JPanel(new GridLayout( NUMERO_LINHAS, 
                                              NUMERO_COLUNAS, 
                                              INTERVALO_HORIZONTAL,
                                              INTERVALO_VERTICAL));
        
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 0, MARGEM_DIREITA = 0;
        p.setBorder(BorderFactory.createEmptyBorder( MARGEM_SUPERIOR, 
                                                     MARGEM_ESQUERDA,
                                                     MARGEM_INFERIOR, 
                                                     MARGEM_DIREITA));
        
        p.add(btn);
        
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
                new DialogoNovoProduto(RegistarCandidaturaUI.this);
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
     * criar botão para ver demonstrações
     * @return botão para ver demonstrações
     */
    private JButton criarBotaoRecursosDemonstracao(){
        botaoVerRecursoDemonstracao = new JButton("Ver Recursos Demonstração");
        botaoVerRecursoDemonstracao.setMnemonic(KeyEvent.VK_V);
        botaoVerRecursoDemonstracao.setToolTipText("Mostra os recursos da demonstração");
        botaoVerRecursoDemonstracao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
//                    int select = lstDemonstracoes.getSelectedIndex();
//                    listaRecursos = listaDemonstracoes.obterDemonstracao(select).getListaRecursos();
//                    Recurso[] opcoes = listaRecursos.getArray();
//                        JOptionPane.showInputDialog(
//                            RegistarCandidaturaUI.this,
//                            "Recursos :", 
//                            "Recursos",
//                            JOptionPane.PLAIN_MESSAGE,
//                            null,
//                            opcoes,
//                            opcoes[0]);
                }catch (ArrayIndexOutOfBoundsException ex){
                    JOptionPane.showMessageDialog(
                        null,
                        "Não selecionou demonstração!",
                        "Ver Recursos",
                        JOptionPane.INFORMATION_MESSAGE);                        
                }
            }
        });

        return botaoVerRecursoDemonstracao;
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
//                    int area = Integer.parseInt(txtArea.getText());
//                    int convites = Integer.parseInt(txtConvites.getText());
//                    String morada = txtMorada.getText();
//                    String nome = txtNome.getText();
//                    int telemovel = Integer.parseInt(txtTelemovel.getText());
//                    candidatura = new Candidatura(nome, morada,
//                            area, convites, telemovel, listaProdutos, 
//                            listaDemonstracoes, centroExposicoes);
//
//                    boolean candidaturaAdicionada = exposicao.addCandidatura(candidatura);
//                    if (candidaturaAdicionada) {                      
//                        JOptionPane.showMessageDialog(
//                                framePai,
//                                "Candidatura adicionada.",
//                                "Nova Candidatura",
//                                JOptionPane.INFORMATION_MESSAGE);
//                        dispose();
//                        framePai.setVisible(true);
//                    } else {
//                        JOptionPane.showMessageDialog(
//                                framePai,
//                                "Candidatura já registada!",
//                                "Nova Candidatura",
//                                JOptionPane.ERROR_MESSAGE);
//                    }
//                    dispose();
//                    framePai.setVisible(true);                        
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
        botao.setMnemonic(KeyEvent.VK_S);
        botao.setToolTipText("Cancela a atribuição e volta ao menu anterior");
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
//        listaProdutos = candidatura.getM_listaProdutos();
        ModeloListaProdutos modeloListaProdutos = new ModeloListaProdutos(listaProdutos);
        lstProdutos = new JList(modeloListaProdutos);
        botaoAdicionarProduto = criarBotaoAdicionarProduto();
        botaoRemoverProduto = criarBotaoEliminarProduto();
        p.add(criarPainelListaProduto( "Produtos:",
                                lstProdutos,
                                botaoAdicionarProduto,
                                botaoRemoverProduto));
        
        ModeloListaDemonstracoes modeloListaDemo = new ModeloListaDemonstracoes(listaDemonstracoes);
        lstDemonstracoes = new JList(modeloListaDemo);
        botaoVerRecursoDemonstracao = criarBotaoRecursosDemonstracao();
        p.add(criarPainelListaDemo("Demonstrações:",
                                lstDemonstracoes,                            
                                botaoVerRecursoDemonstracao));
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
        
        final int MARGEM_SUPERIOR = 5, MARGEM_INFERIOR = 5;
        final int MARGEM_ESQUERDA = 5, MARGEM_DIREITA = 5;
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
     * criar painel lista demonstrações recebendo titulo lista, lista demonstrações e um botao
     * @param tituloLista titulo lista
     * @param lstLista lista demonstrações
     * @param btn botao
     * @return painel lista demonstrações recebendo titulo lista, lista demonstrações e um botao
     */
    private JPanel criarPainelListaDemo(
            String tituloLista,
            JList lstLista,
            JButton btn)
    {
        lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(lstLista);

        JPanel p = new JPanel(new BorderLayout());
        
        final int MARGEM_SUPERIOR = 5, MARGEM_INFERIOR = 5;
        final int MARGEM_ESQUERDA = 5, MARGEM_DIREITA = 5;
        p.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(tituloLista),
                new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA)));
        
        p.add(scrPane, BorderLayout.CENTER);

        JPanel pBotoes = criarPainelBotaoListaDemo(btn);
        p.add(pBotoes, BorderLayout.SOUTH);
        return p;
    }

    

}
