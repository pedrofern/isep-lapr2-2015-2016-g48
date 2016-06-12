package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.text.ParseException;
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
import lapr.project.model.lists.RegistoUtilizadores;

/**
 *
 * @author Pedro Fernandes
 */
public class CriarExposicaoUI extends JFrame {
    
    private JList listaCompletaUtilizador;
    private RegistoUtilizadores listaUtilizadores;
    private JFormattedTextField campoDataInicial, campoDataFinal, campoSubCandDataInicial, campoSubCandDataFinal, campoSubStandsDatainicial, campoSubStandsDataFinal, campoDataConflito, campoDataAlterarConflito, campoDataAvInicio, campoDataAvFim;
    private static CentroExposicoes ce;
    private CriarExposicaoController controller;
    private static final int JANELA_LARGURA = 700;
    private static final int JANELA_ALTURA = 300;
    private JFrame framePai;
    private static final Dimension LABEL_TAMANHO = new JLabel("Criar Exposicao").getPreferredSize();
    private JButton btnConfirmar, btnFechar, btnAdicionarOrganizador, btnEleminarOrganizador;
    private JTextField txtTitulo, txtDescricao, txtDataInicio, txtDataFim, txtLocal;
    private ModeloListaUtilizadores modelolistautilizador;
    private static final int NUMERO_LINHAS = 1, NUMERO_COLUNAS = 2;
    private static final int INTERVALO_HORIZONTAL = 20, INTERVALO_VERTICAL = 0;
    
    private static final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
    private static final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 0;

    public CriarExposicaoUI(CentroExposicoes centro) {
        super("Criar Exposicao");
        ce = centro;
        criarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setLocationRelativeTo(null);
        setVisible(true);
        
        controller=new CriarExposicaoController(ce);
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
        painel.add(criarPainelAvaliacaoData(criarPainelAvaliacaoDataInicial(), criarPainelAvaliacaoDataFinal()));
        painel.add(criarPainelStandsData(criarPainelStandsDataInicial(), criarPainelStandsDataFinal()));     
        painel.add(criarPainelConflitoDataFinal());
        painel.add(criarPainelAlteracaoConflitoDataFinal());
        
        
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

    private JPanel criarPainelListas() {

        JPanel p = new JPanel(new GridLayout(NUMERO_LINHAS,
                NUMERO_COLUNAS,
                INTERVALO_HORIZONTAL,
                INTERVALO_VERTICAL));

        listaCompletaUtilizador = new JList();
        listaUtilizadores = new RegistoUtilizadores();
        modelolistautilizador = new ModeloListaUtilizadores(listaUtilizadores);
        p.add(criarPainelPeriodo(criarPainelPeriodoData()));
        p.add(criarPainelListaOrganizador("Lista de Organizador",
                listaCompletaUtilizador,
                modelolistautilizador));

        return p;
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
            JList lstLista,
            ModeloListaUtilizadores modeloLista) {
        JLabel lblTitulo = new JLabel(tituloLista, JLabel.LEFT);

        lstLista.setModel(modeloLista);
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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
            e.printStackTrace();
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

    private void guardar() {
        
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
        
        controller.criarExposicao();

        
        controller.setDados(txtTitulo.getText(), txtDescricao.getText(), dataInicialPrimeiro, dataFinalUltimo, txtLocal.getText(), dataInicioSubm, dataFimSubm, dataInicioAv, dataFimAv, dataConflitos, dataInicioStands, dataFimStands, dataAConflitos);
        
        controller.registaExposicao();
        
        JOptionPane.showMessageDialog(
                            null,
                            "Nova Exposição: \n" + controller.getExposicaoString(),
                            "Nova Exposição",
                            JOptionPane.INFORMATION_MESSAGE);    
        dispose();

    }

    private JButton criarBotaoConfirmar() {
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener((ActionEvent e) -> {
            if (txtTitulo.getText().isEmpty() == true
                    || txtDescricao.getText().isEmpty() == true
                    || txtLocal.getText().isEmpty() == true) {
//                        JOptionPane.showMessageDialog(
//                            null,
//                            "Tem de preencher todos os campos!",
//                            "Criar Exposoção",
//                            JOptionPane.ERROR_MESSAGE);
            } else {
                guardar();
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
        });

        return btnAdicionarOrganizador;
    }

    private JButton criarBotaoEliminarOrganizador(JList lstLista) {
        btnEleminarOrganizador = new JButton("Eliminar Organizador");
        btnEleminarOrganizador.addActionListener((ActionEvent e) -> {
        });
        return btnEleminarOrganizador;
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
        return listaCompletaUtilizador;
    }
    
    /**
     * Devolve o botão remover produto
     * @return botão remover produto
     */
    public JButton getBotaoRemoverProduto(){
        return btnEleminarOrganizador;
    }
    
    public JButton getBotaoAdicionar(){
        return btnAdicionarOrganizador;
    }
}
