/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Edu
 */
public class DefinirFAEUI extends JFrame {
    
    
     private JList lstCompletaUtilizadores, lstUtilizadoresFAE;
    private JButton btnEliminarFAE, btnAdicionarUtilizador, btnConfirmar, btnCancelar;
    private JComboBox comboBoxExposicao;
    private ModeloListaUtilizadores modeloListaUtilizadores;
    private ModeloListaUtilizadores modeloListaFAE;
    private ListaUtilizadores listaCompletaUtilizadores;
    private ListaUtilizadores listaUtilizadoresFAE;
    private static final Dimension LABEL_TAMANHO = new JLabel("Inserir novo utilizador").getPreferredSize();

    public DefinirFAEUI() throws FileNotFoundException {

        super("Definir FAE");

        //criarComponentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
