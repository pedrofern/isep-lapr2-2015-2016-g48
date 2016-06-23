package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import lapr.project.controller.*;
import lapr.project.model.*;
import lapr.project.utils.*;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
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
import javax.swing.text.MaskFormatter;
import lapr.project.model.lists.ListaOrganizadores;

/**
 *
 * @author Pedro Fernandes
 */
public class CriarExposicaoUI extends JFrame {
    
    private JList lstOrganizadores;
    private ListaOrganizadores listaOrganizadores;
    private JFormattedTextField campoDataInicial, campoDataFinal, campoSubCandDataInicial, campoSubCandDataFinal, campoSubStandsDatainicial, campoSubStandsDataFinal, campoDataConflito, campoDataAlterarConflito, campoDataAvInicio, campoDataAvFim;
    private final CentroExposicoes ce;
    private final CriarExposicaoController controller;
    private static final int JANELA_LARGURA = 700;
    private static final int JANELA_ALTURA = 300;
    private JFrame framePai;
    private static final Dimension LABEL_TAMANHO = new JLabel("Criar Exposicao").getPreferredSize();
    private JButton btnConfirmar, btnFechar, btnAdicionarOrganizador, btnEliminarOrganizador;
    private JTextField txtTitulo, txtDescricao, txtDataInicio, txtDataFim, txtLocal;
    private ModeloListaOrganizadores modeloListaOrganizadores;
    private static final int NUMERO_LINHAS = 1, NUMERO_COLUNAS = 2;
    private static final int INTERVALO_HORIZONTAL = 20, INTERVALO_VERTICAL = 0;
    
    private static final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
    private static final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 0;

    public CriarExposicaoUI(CentroExposicoes centro) throws Exception {
        super("Criar Exposicao");
        ce = centro;
       controller=new CriarExposicaoController(ce); 
       controller.criarExposicao();
       criarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setLocationRelativeTo(null);
        setVisible(true);
        
        
    }

    public void criarComponentes() {

        add(criarPainelSul(), BorderLayout.SOUTH);
        add(criarPainelNorte(), BorderLayout.NORTH);
        add(criarPainelListas(), BorderLayout.CENTER);
    }

    private JPanel criarPainelNorte() {
        JPanel p = new JPanel(new FlowLayout());
        p.add(criarPainelDados());

        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.setBorder(new TitledBorder("Dados"));
        return p;
    }

    private JPanel criarPainelDados() {
        JPanel p = new JPanel(new GridLayout(0, 2, 0, 4));
        txtTitulo = new JTextField(15);
        txtDescricao = new JTextField();
        txtLocal = new JTextField();

        p.add(new JLabel("Titulo"));
        p.add(txtTitulo);
        p.add(new JLabel("Descrição"));
        p.add(txtDescricao);
        p.add(new JLabel("Local"));
        p.add(txtLocal);

        return p;
    }

    private JPanel criarPainelPeriodoData() {
        JPanel painel = new JPanel(new GridLayout(0, 1));
        painel.setBorder(new TitledBorder("Periodo de : "));
        painel.add(criarPainelExposicaoData(criarPainelExposiçãoDataInicial(), criarPainelExposiçãoDataFinal()));
        painel.add(criarPainelCandidaturaData(criarPainelCandidaturaDataInicial(), criarPainelCandidaturaDataFinal()));
        painel.add(criarPainelConflitoDataFinal());
        painel.add(criarPainelAlteracaoConflitoDataFinal());
        painel.add(criarPainelAvaliacaoData(criarPainelAvaliacaoDataInicial(), criarPainelAvaliacaoDataFinal()));
        painel.add(criarPainelStandsData(criarPainelStandsDataInicial(), criarPainelStandsDataFinal()));     
    
        return painel;

    }

    private JPanel criarPainelExposicaoData(JPanel datainicial, JPanel datafinal) {

        JPanel painel = new JPanel(new GridLayout(NUMERO_LINHAS,
                NUMERO_COLUNAS,
                INTERVALO_HORIZONTAL,
                INTERVALO_VERTICAL));

        painel.add(datainicial);
        painel.add(datafinal);

        painel.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        painel.setBorder(new TitledBorder("Exposição"));

        return painel;

    }
    
  private JPanel criarPainelPeriodo(JPanel periodo
    ) {

        JPanel p = new JPanel(new BorderLayout());

        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        p.add(periodo, BorderLayout.CENTER);

        return p;
    }

    private JPanel criarPainelListaOrganizador(
            String tituloLista,
            JList lstLista) {
        JLabel lblTitulo = new JLabel(tituloLista, JLabel.LEFT);

//        lstLista.setModel(modeloLista);
        lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrPane = new JScrollPane(lstLista);

        JPanel p = new JPanel(new BorderLayout());

        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        p.add(lblTitulo, BorderLayout.NORTH);
        p.add(scrPane, BorderLayout.CENTER);

        JPanel pBotoes = criarPainelBotoes(criarBotaoAdicionarOrganizador(), criarBotaoEliminarOrganizador(lstLista));
        p.add(pBotoes, BorderLayout.SOUTH);
        return p;
    }

    private JPanel criarPainelBotoes(JButton btn1, JButton btn2) {

        JPanel p = new JPanel(new GridLayout(2, 1, 0, 10));

        p.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        p.add(btn1);
        p.add(btn2);

        return p;
    }

    private JPanel criarPainelCandidaturaData(JPanel datainicial, JPanel datafinal) {
        JPanel painel = new JPanel(new GridLayout(NUMERO_LINHAS,
                NUMERO_COLUNAS,
                INTERVALO_HORIZONTAL,
                INTERVALO_VERTICAL));

        painel.add(datainicial);
        painel.add(datafinal);
;
        painel.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        painel.setBorder(new TitledBorder("Submissão de candidaturas"));

        return painel;

    }

    private JPanel criarPainelStandsData(JPanel datainicial, JPanel datafinal) {
        JPanel painel = new JPanel(new GridLayout(NUMERO_LINHAS,
                NUMERO_COLUNAS,
                INTERVALO_HORIZONTAL,
                INTERVALO_VERTICAL));

        painel.add(datainicial);
        painel.add(datafinal);
   
        painel.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        painel.setBorder(new TitledBorder("Atribuição de stands"));

        return painel;

    }
    
    
    private JPanel criarPainelAvaliacaoData(JPanel datainicial, JPanel datafinal) {
        JPanel painel = new JPanel(new GridLayout(NUMERO_LINHAS,
                NUMERO_COLUNAS,
                INTERVALO_HORIZONTAL,
                INTERVALO_VERTICAL));

        painel.add(datainicial);
        painel.add(datafinal);
   
        painel.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));

        painel.setBorder(new TitledBorder("Avaliação de candidaturas"));

        return painel;

    }
    
    


    private JPanel criarPainelExposiçãoDataInicial() {
        JPanel painel = new JPanel(new FlowLayout());
        try {
            JLabel labelData = new JLabel("Data inicial :");

            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            campoDataInicial = new JFormattedTextField(mascara);
            campoDataInicial.setPreferredSize(new Dimension(80, 20));
            painel.add(labelData);
            painel.add(campoDataInicial);
        } catch (ParseException e) {
        }

        return painel;
    }

    private JPanel criarPainelExposiçãoDataFinal() {
        JPanel painel = new JPanel(new FlowLayout());
        try {
            JLabel labelData = new JLabel("Data final :");

            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            campoDataFinal = new JFormattedTextField(mascara);
            campoDataFinal.setPreferredSize(new Dimension(80, 20));

            painel.add(labelData);
            painel.add(campoDataFinal);
        } catch (ParseException e) {
        }

        return painel;
    }

    private JPanel criarPainelCandidaturaDataInicial() {
        JPanel painel = new JPanel(new FlowLayout());
        try {
            JLabel labelData = new JLabel("Data inicial :");

            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            campoSubCandDataInicial = new JFormattedTextField(mascara);
            campoSubCandDataInicial.setPreferredSize(new Dimension(80, 20));
            painel.add(labelData);
            painel.add(campoSubCandDataInicial);
        } catch (ParseException e) {
        }

        return painel;
    }

    private JPanel criarPainelCandidaturaDataFinal() {
        JPanel painel = new JPanel(new FlowLayout());
        try {
            JLabel labelData = new JLabel("Data final :");

            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            campoSubCandDataFinal = new JFormattedTextField(mascara);
            campoSubCandDataFinal.setPreferredSize(new Dimension(80, 20));
            painel.add(labelData);
            painel.add(campoSubCandDataFinal);
        } catch (ParseException e) {
        }

        return painel;
    }

    private JPanel criarPainelStandsDataInicial() {
        JPanel painel = new JPanel(new FlowLayout());
        try {
            JLabel labelData = new JLabel("Data inicial :");

            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            campoSubStandsDatainicial = new JFormattedTextField(mascara);
            campoSubStandsDatainicial.setPreferredSize(new Dimension(80, 20));
            painel.add(labelData);
            painel.add(campoSubStandsDatainicial);
        } catch (ParseException e) {
        }

        return painel;
    }

    private JPanel criarPainelStandsDataFinal() {
        JPanel painel = new JPanel(new FlowLayout());
        try {
            JLabel labelData = new JLabel("Data final :");

            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            campoSubStandsDataFinal = new JFormattedTextField(mascara);
            campoSubStandsDataFinal.setPreferredSize(new Dimension(80, 20));
            painel.add(labelData);
            painel.add(campoSubStandsDataFinal);
        } catch (ParseException e) {
        }

        return painel;
    }
    
       private JPanel criarPainelAvaliacaoDataInicial() {
        JPanel painel = new JPanel(new FlowLayout());
        try {
            JLabel labelData = new JLabel("Data inicial :");

            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            campoDataAvInicio = new JFormattedTextField(mascara);
            campoDataAvInicio.setPreferredSize(new Dimension(80, 20));
            painel.add(labelData);
            painel.add(campoDataAvInicio);
        } catch (ParseException e) {
        }

        return painel;
    }

    private JPanel criarPainelAvaliacaoDataFinal() {
        JPanel painel = new JPanel(new FlowLayout());
        try {
            JLabel labelData = new JLabel("Data final :");

            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            campoDataAvFim = new JFormattedTextField(mascara);
            campoDataAvFim.setPreferredSize(new Dimension(80, 20));
            painel.add(labelData);
            painel.add(campoDataAvFim);
        } catch (ParseException e) {
        }

        return painel;
    }
    
    private JPanel criarPainelAlteracaoConflitoDataFinal() {
        JPanel painel = new JPanel(new FlowLayout());
        try {
            JLabel labelData = new JLabel("Data :");

            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            campoDataAlterarConflito = new JFormattedTextField(mascara);
            campoDataAlterarConflito.setPreferredSize(new Dimension(80, 20));
            painel.add(labelData);
            painel.add(campoDataAlterarConflito);

            painel.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                    MARGEM_INFERIOR, MARGEM_DIREITA));

            painel.setBorder(new TitledBorder("Limite Alteração De Conflitos"));

        } catch (ParseException e) {
        }

        return painel;
    }
    
    private JPanel criarPainelConflitoDataFinal() {
        JPanel painel = new JPanel(new FlowLayout());
        try {
            JLabel labelData = new JLabel("Data :");

            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            campoDataConflito = new JFormattedTextField(mascara);
            campoDataConflito.setPreferredSize(new Dimension(80, 20));
            painel.add(labelData);
            painel.add(campoDataConflito);

            painel.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                    MARGEM_INFERIOR, MARGEM_DIREITA));

            painel.setBorder(new TitledBorder("Deteção De Conflitos"));

        } catch (ParseException e) {
        }

        return painel;
    }

    private JPanel criarPainelSul() {
        JPanel p = new JPanel(new FlowLayout());
        p.setBorder(new TitledBorder("Opções"));
        p.add(criarPainelBotoes());
        return p;
    }

    private JPanel criarPainelBotoes() {
        JButton btnOK = criarBotaoConfirmar();
        getRootPane().setDefaultButton(btnOK);
        JButton btnClose = criarBotaoFechar();
        JButton btnClear = criarBotaoLimpar();
        JPanel p = new JPanel();
        p.add(btnOK);
        p.add(btnClose);
        p.add(btnClear);
        return p;

    }

    private void setDados() {
        
            Data dataInicialPrimeiro = Utils.converterStringParaData(campoDataInicial.getText());
            Data dataFinalUltimo = Utils.converterStringParaData(campoDataFinal.getText());
            Data dataInicioSubm= Utils.converterStringParaData(campoSubCandDataInicial.getText());
            Data dataFimSubm= Utils.converterStringParaData(campoSubCandDataFinal.getText());
            Data dataInicioStands= Utils.converterStringParaData(campoSubStandsDatainicial.getText());
            Data dataFimStands=Utils.converterStringParaData(campoSubStandsDataFinal.getText());
            Data dataConflitos=Utils.converterStringParaData(campoDataAlterarConflito.getText());
            Data dataInicioAv=Utils.converterStringParaData(campoDataAvInicio.getText());
            Data dataFimAv=Utils.converterStringParaData(campoDataAvFim.getText());
            Data dataAConflitos=Utils.converterStringParaData(campoDataAlterarConflito.getText());
            
            controller.setDados(txtTitulo.getText(), txtDescricao.getText(), dataInicialPrimeiro, dataFinalUltimo, txtLocal.getText(), dataInicioSubm, dataFimSubm, dataInicioAv, dataFimAv, dataConflitos, dataInicioStands, dataFimStands, dataAConflitos);
            controller.setListaOrganizadores(listaOrganizadores);
  
    }
    
    private JPanel criarPainelListas() {

        JPanel p = new JPanel(new GridLayout(NUMERO_LINHAS,
                NUMERO_COLUNAS,
                INTERVALO_HORIZONTAL,
                INTERVALO_VERTICAL));
        
        listaOrganizadores = controller.getListaOrganizadores();
        
         ModeloListaOrganizadores modeloListaOrganizador = new ModeloListaOrganizadores(listaOrganizadores);
        
        lstOrganizadores = new JList(modeloListaOrganizador);
        
        p.add(criarPainelPeriodo(criarPainelPeriodoData()));
        p.add(criarPainelListaOrganizador("Lista de Organizador",
                lstOrganizadores));

        return p;
    }

    private JButton criarBotaoConfirmar() {
        btnConfirmar = new JButton("Confirmar");
             
        btnConfirmar.addActionListener((ActionEvent e) -> {
            
           
            String base="__/__/____";
            
            if (txtTitulo.getText().isEmpty() == true || txtDescricao.getText().isEmpty() == true
                    || txtLocal.getText().isEmpty() == true || campoDataInicial.getText().equals(base) || campoDataFinal.getText().equals(base) || campoDataAvInicio.getText().equals(base) 
                || campoDataAvFim.getText().equals(base) || campoSubCandDataInicial.getText().equals(base) || campoSubCandDataFinal.getText().equals(base) ||
                campoSubStandsDataFinal.getText().equals(base) || campoDataAlterarConflito.getText().equals(base) || campoDataConflito.getText().equals(base)){
                    
                        JOptionPane.showMessageDialog(
                            null,
                            "Tem de preencher todos os campos!",
                            "Criar Exposoção",
                            JOptionPane.ERROR_MESSAGE);
            }else{
                  try{
                    controller.validaDatas(campoDataInicial.getText(), campoDataFinal.getText(), campoSubCandDataInicial.getText(), campoSubCandDataFinal.getText(), 
                    campoSubStandsDatainicial.getText(), campoSubStandsDataFinal.getText(), campoDataAlterarConflito.getText(), 
                    campoDataAvInicio.getText(), campoDataAvFim.getText(), campoDataAlterarConflito.getText());
                           
                    setDados();

                    if(!controller.validaDataFimSuperiorInicio() || !controller.validaMinOrganizadores() || !controller.validaSeguimentoDatas()){
                        if (!controller.validaDataFimSuperiorInicio()){
                            JOptionPane.showMessageDialog(null, "A data fim tem de ser superior à data de início correspondente.", "Criar Exposição",JOptionPane.ERROR_MESSAGE);
                        }if (!controller.validaMinOrganizadores()){
                            JOptionPane.showMessageDialog(null, "Introduza pelo menos 2 organizadores", "Criar Exposição", JOptionPane.ERROR_MESSAGE);
                        }if (!controller.validaSeguimentoDatas()){
                            JOptionPane.showMessageDialog(null, "As datas não têm o seguimento devido (por exemplo: data avaliação de candidaturas ser superior à data de submissão", "Criar Exposição", JOptionPane.ERROR_MESSAGE);
                        }if (!controller.validaTituloEDescricao()){
                            JOptionPane.showMessageDialog(null, "O título, o texto e o local devem estar devidamente preenchidos", "Criar Exposição", JOptionPane.ERROR_MESSAGE);
                       
                        }
                    }  else{
                        if(controller.registaExposicao()){
                                                        
                            ce.setRegistoExposicoes(controller.getRegistoExposicoes());
                            try {
                                controller.setCriada();
                            } catch (ParseException ex) {
                                Logger.getLogger(CriarExposicaoUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            JOptionPane.showMessageDialog(
                                    null,
                                    controller.getExposicaoString(),
                                    "Nova Exposição",
                                    JOptionPane.INFORMATION_MESSAGE);  
                             
                            dispose();
                        }else{
                            JOptionPane.showMessageDialog(null, "A exposição já se encontra registada no sistema", "Nova Exposição", JOptionPane.ERROR_MESSAGE);
  
                        }

                    }
                 }catch (Exception e1){
                   JOptionPane.showMessageDialog(null, "Data inválida encontrada", "Criar Exposição", JOptionPane.ERROR_MESSAGE);
                        
                }
            }
        });
        return btnConfirmar;
    }

    private JButton criarBotaoFechar() {
        btnFechar = new JButton("Fechar");
        btnFechar.addActionListener((ActionEvent e) -> {
            dispose();
        });
        return btnFechar;
    }

    private JButton criarBotaoAdicionarOrganizador() {
        btnAdicionarOrganizador = new JButton("Adicionar Organizador");

        btnAdicionarOrganizador.addActionListener((ActionEvent e) -> {
            if(controller.getListaUtilizadores().countUtilizadores()==0){
                 JOptionPane.showMessageDialog(
                                       null,
                                       "Não há utilizadores disponíveis, volte mais tarde.",
                                       "Nova Exposição",
                                       JOptionPane.INFORMATION_MESSAGE);   
                        
                dispose();
            }else{
                DialogoNovoOrganizador dialogo=new DialogoNovoOrganizador(this, controller, ce);
            }
        });

        return btnAdicionarOrganizador;
    }

    private JButton criarBotaoEliminarOrganizador(JList lstLista) {
        btnEliminarOrganizador = new JButton("Eliminar Organizador");
        btnEliminarOrganizador.addActionListener((ActionEvent e) -> {
        });
        return btnEliminarOrganizador;
    }

    private JButton criarBotaoLimpar() {

        JButton btn = new JButton("Limpar");
        btn.addActionListener((ActionEvent ae) -> {
            txtDescricao.setText(null);
            txtTitulo.setText(null);
            campoDataInicial.setText(null);
            campoDataFinal.setText(null);
            campoDataAlterarConflito.setText(null);
            campoSubCandDataFinal.setText(null);
            campoSubCandDataInicial.setText(null);
            campoSubStandsDatainicial.setText(null);
            campoSubStandsDataFinal.setText(null);
        });
        return btn;

    }
    
   
    /**
     * Devolve uma lista de produtos
     * @return lista produtos
     */
    public JList getLstOrganizadores() {
        return lstOrganizadores;
    }
    
    /**
     * Devolve o botão remover produto
     * @return botão remover produto
     */
    public JButton getBotaoRemoverProduto(){
        return btnEliminarOrganizador;
    }
    
    public JButton getBotaoAdicionar(){
        return btnAdicionarOrganizador;
    }
}
