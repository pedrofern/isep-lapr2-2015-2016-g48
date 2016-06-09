/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import lapr.project.model.lists.RegistoRecursos;

/**
 *
 * @author Edu
 */
public class DefinirDemonstracaoUI extends JFrame {

    private JButton btnConfirmar, btnCancelar, btnAdicionarRecurso;
    private JComboBox comboBoxExposicao,comboBoxDemonstracao;
    private JFrame framepai;
    private ModeloListaRecursos modeloListaRecurso;
    private JList listaCompletaRecurso;
    private JTable tableListaRecurso;
    private static final Dimension LABEL_TAMANHO = new JLabel("Descrição").getPreferredSize();
    private static final int JANELA_LARGURA = 900;
    private static final int JANELA_ALTURA = 400;

    public DefinirDemonstracaoUI() throws FileNotFoundException {

        super("Definir Demonstração");
        //criarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void criarComponentes() throws FileNotFoundException {

    }

//    private JPanel criarPainelListas() {
//        final int NUMERO_LINHAS = 1, NUMERO_COLUNAS = 2;
//        final int INTERVALO_HORIZONTAL = 20, INTERVALO_VERTICAL = 0;
//        JPanel p = new JPanel(new GridLayout(NUMERO_LINHAS,
//                NUMERO_COLUNAS,
//                INTERVALO_HORIZONTAL,
//                INTERVALO_VERTICAL));
//
//        listaCompletaRecurso = new JList();
//        listaRecurso = new RegistoRecursos();
//        modeloListaRecurso = new ModeloListaRecursos(listaRecurso);
//
//        p.add(criarPainelListaRecurso("Lista de Recurso",
//                listaCompletaRecurso,
//                modeloListaRecurso, criarBotaoAdicionarRecurso()));
//
//        p.add(criarPainelDescricao("Descrição ", txtDescricao));
//
//        return p;
//    }

    private JPanel criarPainelCombobox(
            String titulo,
            JComboBox combobox
    ) {
        JLabel lblTitulo = new JLabel(titulo, JLabel.LEFT);

        JPanel p = new JPanel(new BorderLayout());

        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        p.add(lblTitulo, BorderLayout.NORTH);
        p.add(combobox, BorderLayout.CENTER);

        return p;
    }

}
