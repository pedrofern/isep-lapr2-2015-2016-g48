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
public class CriarCandidaturaUI {
    
    /**
     * A largura da janela em píxeis.
     */
    private static final int JANELA_LARGURA = 800;
    /**
     * A altura da janela em píxeis.
     */
    private static final int JANELA_ALTURA = 600;
    /**
     * Guarda a dimensão de uma label por omissão
     */
    private static final Dimension LABEL_TAMANHO = new JLabel("Nº Convites:").
                                                        getPreferredSize();
    /**
     * Guarda janela anterior
     */
    private JFrame framePai;
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
    private CriarCandidaturaController m_controllerCCC;

    public CriarCandidaturaUI(JFrame framePai, CentroExposicoes ce) {
        e_representante = new Representante();
        m_controllerCCC = new CriarCandidaturaController(e_representante);
        centroExposicoes = ce;
    }

    

}
