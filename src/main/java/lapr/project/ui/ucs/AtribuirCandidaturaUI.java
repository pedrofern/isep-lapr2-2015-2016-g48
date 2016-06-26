package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import lapr.project.controller.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.model.*;
import lapr.project.model.lists.ListaAtribuicoes;
import lapr.project.model.mechanisms.MecanismoAtribuicao;
import lapr.project.utils.Utils;
/**
 *
 * @author Diana Silva
 */
public class AtribuirCandidaturaUI extends JFrame{

    private static CentroExposicoes ce;
    private static Utilizador user;
    private static AtribuirCandidaturaController controllerAC;
    private JButton btnConfirmar, btnFechar, btnSel1, btnSel2, btGuardar, btLimpar;
    private static final int JANELA_LARGURA = 788;
    private static final int JANELA_ALTURA = 450;
    private JFrame framePai;
    private JPanel pExpo, pMecs,pAtrib;
    private JList jListAtribuicoes;
    private ModeloListaAtribuicoes modeloAtribuicoes;
    private ListaAtribuicoes listaAtribuicoes;
    private static final int MARGEM_SUPERIOR=20, MARGEM_INFERIOR=20, MARGEM_ESQ=20, MARGEM_DIR=20;
    private JComboBox comboExposicoes, comboMec;
      
    public AtribuirCandidaturaUI(CentroExposicoes centroExposicoes, Utilizador utilizador)  {
        super("Atribuição de Candidaturas");
        
        ce = centroExposicoes;
        user=utilizador;
        controllerAC = new AtribuirCandidaturaController(ce, user);

        criarComponentes();
 
        pMecs.setVisible(false);
        pAtrib.setVisible(false);
        btnConfirmar.setEnabled(false);
        
        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setLocationRelativeTo(framePai);
        setVisible(true);
    }
    
    public final void criarComponentes() {
        
        add(criarPainelOeste(), BorderLayout.WEST);
        add(criarPainelSul(), BorderLayout.SOUTH);
        add(criarPainelEste(), BorderLayout.CENTER);
    }
    
    private JPanel criarPainelCentro(){
        pMecs = new JPanel(new BorderLayout());
        pMecs.setBorder(new EmptyBorder(0, 10, 0, 10));
        pMecs.setPreferredSize(new Dimension(80, getHeight()));
        pMecs.setBorder(new TitledBorder("Mecanismo"));
        
        pMecs.add(criarPainelMecanismos(), BorderLayout.NORTH);

        return pMecs;
    }
    
    private JPanel criarPainelEste(){
        pAtrib = new JPanel(new BorderLayout());
        pAtrib.setPreferredSize(new Dimension(300, getHeight()));
        pAtrib.setBorder(new EmptyBorder(0, 10, 0, 10));
        pAtrib.setBorder(new TitledBorder("Candidaturas"));
        pAtrib.setPreferredSize(new Dimension(250, 50));
        
        jListAtribuicoes=new JList();
        
        modeloAtribuicoes=new ModeloListaAtribuicoes(controllerAC.getListaAtribuicoes());

        btGuardar= criarBotaoGuardar();
        btLimpar = criarBotaoVoltar();
        
        pAtrib.add(criarPainelLista("Atribuições geradas", jListAtribuicoes, modeloAtribuicoes, btGuardar, btLimpar));
        
        return pAtrib;
    }
    
    private JPanel criarPainelLista(String titulo, JList jlist, ModeloListaAtribuicoes modelo, JButton btGravar, JButton btLimpar){
        
        JLabel lblTitulo=new JLabel(titulo);
        jlist.setModel(modelo);
        
        JScrollPane jscroll=new JScrollPane(jlist);
        JPanel p=new JPanel(new BorderLayout());
        
        p.setBorder(BorderFactory.createEmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQ,MARGEM_INFERIOR, MARGEM_DIR));
        
        p.add(lblTitulo, BorderLayout.NORTH);
        p.add(jscroll, BorderLayout.CENTER);
        
        JPanel pBotoes = criarPainelBotoes(btGravar, btLimpar);
        p.add(pBotoes, BorderLayout.SOUTH);
        
        return p;
        
    }
    
    private JPanel criarPainelBotoes(JButton btn1, JButton btn2) {

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
    
    
    private JPanel criarPainelOeste(){
        pExpo = new JPanel(new BorderLayout());
        pExpo.setPreferredSize(new Dimension(200, getHeight()));
        pExpo.setBorder(new EmptyBorder(0, 10, 0, 10));
        pExpo.setBorder(new TitledBorder("Exposição"));
        pExpo.add(criarPainelExposicao(), BorderLayout.NORTH);
        pExpo.add(criarPainelCentro(), BorderLayout.CENTER);
        return pExpo;
    }
    
    private JPanel criarPainelExposicao() {

        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(new EmptyBorder(0, 10, 0, 10));
        p.add(getComboExposicao(), BorderLayout.NORTH);
        
        p.add(criarPainelSeleccionar1(), BorderLayout.SOUTH);
        return p;
    }
    
    
    private JPanel criarPainelMecanismos() {

        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(new EmptyBorder(0, 10, 0, 10));
        pMecs.setBorder(new TitledBorder("Mecanismo"));
        
        p.add(getComboMecanismos(), BorderLayout.NORTH);
        p.add(criarPainelSeleccionar2(), BorderLayout.CENTER);
        return p;
    }

    private JComboBox getComboExposicao() {
        comboExposicoes=Utils.criarComboExpo(ce.getRegistoExposicoes());
        return  comboExposicoes;
    }
    

    private JComboBox getComboMecanismos() {
        MecanismoAtribuicao[] opcoes=ce.getMecanismosAtribuicao().getArray();
        comboMec=new JComboBox();
        DefaultComboBoxModel combo=new DefaultComboBoxModel(opcoes);
        comboMec.setModel(combo);
        return comboMec;
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
        JPanel p = new JPanel();
        p.add(btnOK);
        p.add(btnClose);
        return p;

    }
   
    private JButton criarBotaoConfirmar() {
        btnConfirmar = new JButton("Confirmar");
        return btnConfirmar;
    }

    private JPanel criarPainelSeleccionar1() {
        JPanel p=new JPanel();
        p.setLayout(new FlowLayout());
        btnSel1 = new JButton("Seleccionar");
        btnSel1.addActionListener((ActionEvent e) -> {
           
            btnSel2.setEnabled(true);
            controllerAC.setExposicao((Exposicao)comboExposicoes.getSelectedItem());
            if(controllerAC.getListaCandidaturas().getListaCandidaturas().size()==0){
                JOptionPane.showMessageDialog(
                                            new JFrame(),
                                            "Não existem candidaturas para atribuir.",
                                            "Atribuição de candidaturas",
                                            JOptionPane.ERROR_MESSAGE);
            }else{
            
            comboExposicoes.setEnabled(false);
            btnSel1.setEnabled(false);
            
            pMecs.setVisible(true);
            }     
        });
        
        p.add(btnSel1);
        return p;
    }
    
    private JPanel criarPainelSeleccionar2() {
        JPanel p=new JPanel();
        p.setLayout(new FlowLayout());
        btnSel2 = new JButton("Seleccionar");
        btnSel2.addActionListener((ActionEvent e)->{
            
            pAtrib.setVisible(true);
            modeloAtribuicoes.gerarAtribuicoes((MecanismoAtribuicao)comboMec.getSelectedItem(), controllerAC.getExposicao());
           
            try{
                boolean atribuicoesNaoGeradas=controllerAC.getListaAtribuicoes().getListaAtribuicoes().isEmpty();

                if(atribuicoesNaoGeradas){

                    listaAtribuicoes=modeloAtribuicoes.getAtribuicoes();

                    JOptionPane.showMessageDialog(
                                    new JFrame(),
                                    "Atribuições geradas.",
                                    "Atribuição de candidaturas",
                                    JOptionPane.INFORMATION_MESSAGE);

                    }else{
                         JOptionPane.showMessageDialog(
                                    new JFrame(),
                                    "Não foi possível gerar as atribuições.",
                                    "Atribuição de candidaturas",
                                    JOptionPane.ERROR_MESSAGE);
                  } 
                }catch(IllegalArgumentException ex){
                    JOptionPane.showMessageDialog(new JFrame(), "Não foi possível gerar o mecanismo.\n",
                        "Atribuição de candidaturas", JOptionPane.WARNING_MESSAGE);
                }
        });
        
        p.add(btnSel2, BorderLayout.SOUTH);
        return p;
    }

    private JButton criarBotaoFechar() {
        btnFechar = new JButton("Fechar");
        btnFechar.addActionListener((ActionEvent e) -> {
            dispose();
        });
        return btnFechar;
    }
    
    private JButton criarBotaoGuardar(){
        JButton bt = new JButton("Guardar");
        
        bt.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                listaAtribuicoes=controllerAC.getListaAtribuicoes();
                controllerAC.guardaAtribuicoes(modeloAtribuicoes.getAtribuicoes());
                for(Exposicao e2: ce.getRegistoExposicoes().getExposicoes()){
                        System.out.println(e2);
                        for (Atribuicao a1: e2.getListaAtribuicoes().getListaAtribuicoes()){
                            System.out.println(a1);
                        }
                    }
                
                if(listaAtribuicoes!=null){
                    JOptionPane.showMessageDialog(
                                new JFrame(),
                                "Atribuições guardadas.",
                                "Atribuição de candidaturas",
                                JOptionPane.INFORMATION_MESSAGE);
                    
                    
                 
                }else{
                     JOptionPane.showMessageDialog(
                                new JFrame(),
                                "Não foi possível guardar as atribuições.",
                                "Atribuição de candidaturas",
                                JOptionPane.ERROR_MESSAGE);
                } 
                
                JOptionPane.showMessageDialog(new JFrame(), "Atribuições geradas guardadas com sucesso", "Atribuição de Candidaturas a Faes", JOptionPane.INFORMATION_MESSAGE); 
            }
        });
        return bt;
    }
    
    private JButton criarBotaoVoltar(){
        JButton bt = new JButton("Limpar");
        
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
       
               modeloAtribuicoes.removeAll();
            }
        });
        return bt;
    }
}