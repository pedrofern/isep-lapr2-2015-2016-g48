package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lapr.project.controller.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import lapr.project.model.*;
import lapr.project.utils.Utils;
/**
 *
 * @author Diana Silva
 */
public class AtribuirCandidaturaUI extends JFrame{

    private static CentroExposicoes ce;
    private static Utilizador user;
    private static AtribuirCandidaturaController controllerAC;
    private JButton btnConfirmar, btnLimpar, btnFechar;
    private static final int JANELA_LARGURA = 788;
    private static final int JANELA_ALTURA = 320;
    private JFrame framePai;
    private static final Dimension LABEL_TAMANHO = new JLabel("Area de Stand").getPreferredSize();
    private JComboBox comboboxExposicao;
      
    public AtribuirCandidaturaUI(CentroExposicoes centroExposicoes, Utilizador utilizador)  {
        super("Atribuição de Candidaturas");
        
        ce = centroExposicoes;
        user=utilizador;
        controllerAC = new AtribuirCandidaturaController(ce);

        criarComponentes();
        setSize(JANELA_LARGURA, JANELA_ALTURA);
        setLocationRelativeTo(framePai);
        setVisible(true);
    }
    
    public void criarComponentes() {
        add(criarPainelCentro(), BorderLayout.CENTER);
        add(criarPainelOeste(), BorderLayout.WEST);
        add(criarPainelSul(), BorderLayout.SOUTH);
        add(criarPainelEste(), BorderLayout.EAST);
    }
    
    private JPanel criarPainelCentro(){
        JPanel p = new JPanel(new FlowLayout());
        p.setBorder(new EmptyBorder(0, 10, 0, 10));
        p.setBorder(new TitledBorder("Mecanismos"));

        return p;
    }
    
    private JPanel criarPainelEste(){
        JPanel p = new JPanel(new FlowLayout());
        p.setBorder(new EmptyBorder(0, 10, 0, 10));
        p.setBorder(new TitledBorder("Atribuições"));
        p.setPreferredSize(new Dimension(250, 50));

        return p;
    }
    
    private JPanel criarPainelOeste(){
    JPanel p = new JPanel(new FlowLayout());
        p.add(criarPainelExposicao());
        p.setBorder(new EmptyBorder(0, 10, 0, 10));
        p.setBorder(new TitledBorder("Exposição"));

        return p;
    }
    
    private JPanel criarPainelExposicao() {

        JPanel p = new JPanel(new FlowLayout());
        p.setBorder(new EmptyBorder(0, 10, 0, 10));
        p.add(getListaExposicao());
        return p;

    }
    
    private JComboBox getListaExposicao() {
        
        comboboxExposicao = Utils.criarComboExpo(ce.getRegistoExposicoes());
      
        return comboboxExposicao;
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
        JButton btnClear = criarBotaoLimpar();
        JButton btnClose = criarBotaoFechar();
        JPanel p = new JPanel();
        p.add(btnOK);
        p.add(btnClose);
        p.add(btnClear);
        return p;

    }

    private JButton criarBotaoConfirmar() {
        btnConfirmar = new JButton("Confirmar");
        return btnConfirmar;
    }

    private JButton criarBotaoFechar() {
        btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        return btnFechar;
    }

    private JButton criarBotaoLimpar() {
        btnLimpar = new JButton("Limpar");
        return btnLimpar;

    }
}

    
//    public void run() {
//
//        novaAtribuicaoCandidatura();
//
//        List<Exposicao> le = m_controllerAC.iniciarAtribuicaoCandidatura();
//
//        apresentaExposicoes(le);
//
//        Exposicao e = selecionaExposicao(le);
//
//        if (e != null) {
//
//            List<Candidatura> lc = m_controllerAC.getListaCandidaturas();
//
//            apresentaCandidaturas(lc);
//
//            Candidatura c = selecionaCandidatura(lc);
//
//            if (c != null) {
//
//                List<FAE> lf = m_controllerAC.getListaFAE();
//
//                apresentaFAE(lf);
//
//                FAE f = selecionaFAE(lf);
//
//                m_controllerAC.setAtribuicao();
//
//                String strQuestao = "Confirma a decisao da atribuição de candidatura com a seguinte informação: \n" + m_controllerAC.getInfoResumo() + "\n Opção (S/N):";
//                boolean bConfirma = confirma(strQuestao);
//
//                if (bConfirma) {
//                    if (m_controllerAC.registarDecisao()) {
//                        System.out.println("Decisao concluida com sucesso.");
//                    } else {
//                        System.out.println("Decisao cancelada devido a erros.");
//                    }
//
//                } else {
//                    System.out.println("Decisao de atribuição de candidatura cancelada.");
//                }
//
//                System.out.println("Terminado.");
//
//            } else {
//                System.out.println("Decisao de candidatura cancelada.");
//            }
//
//        } else {
//            System.out.println("Decisao de candidatura cancelada.");
//        }
//    }
//
//    private void novaAtribuicaoCandidatura() {
//        controllerAC.novaAtribuicaoCandidatura();
//    }
//
//    private void apresentaExposicoes(List<Exposicao> le) {
//        System.out.println("Exposicoes: ");
//
//        int index = 0;
//        for (Exposicao e : le) {
//            index++;
//
//            System.out.println(index + ". " + e.toString());
//        }
//        System.out.println("");
//        System.out.println("0 - Cancelar");
//    }
//
//    private Exposicao selecionaExposicao(List<Exposicao> le) {
//        String opcao;
//        int nOpcao;
//        do {
//            opcao = Utils.readLineFromConsole("Introduza opção: ");
//            nOpcao = new Integer(opcao);
//        } while (nOpcao < 0 || nOpcao > le.size());
//
//        if (nOpcao == 0) {
//            return null;
//        } else {
//            return le.get(nOpcao - 1);
//        }
//    }
//
//    private void apresentaCandidaturas(List<Candidatura> lc) {
//        System.out.println("Candidaturas: ");
//
//        int index = 0;
//        for (Candidatura c : lc) {
//            index++;
//
//            System.out.println(index + ". " + c.toString());
//        }
//        System.out.println("");
//        System.out.println("0 - Cancelar");
//    }
//
//    private Candidatura selecionaCandidatura(List<Candidatura> lc) {
//        String opcao;
//        int nOpcao;
//        do {
//            opcao = Utils.readLineFromConsole("Introduza opção: ");
//            nOpcao = new Integer(opcao);
//        } while (nOpcao < 0 || nOpcao > lc.size());
//
//        if (nOpcao == 0) {
//            return null;
//        } else {
//            return lc.get(nOpcao - 1);
//        }
//    }
//
//    private void apresentaFAE(List<FAE> lf) {
//        System.out.println("FAE's: ");
//
//        int index = 0;
//        for (FAE f : lf) {
//            index++;
//
//            System.out.println(index + ". " + f.toString());
//        }
//        System.out.println("");
//        System.out.println("0 - Cancelar");
//    }
//
//    private FAE selecionaFAE(List<FAE> lf) {
//        String opcao;
//        int nOpcao;
//        do {
//            opcao = Utils.readLineFromConsole("Introduza opção: ");
//            nOpcao = new Integer(opcao);
//        } while (nOpcao < 0 || nOpcao > lf.size());
//
//        if (nOpcao == 0) {
//            return null;
//        } else {
//            return lf.get(nOpcao - 1);
//        }
//    }
//
//    private boolean confirma(String questao) {
//        String strConfirma;
//        do {
//            strConfirma = Utils.readLineFromConsole(questao);
//        } while (!strConfirma.equalsIgnoreCase("s") && !strConfirma.equalsIgnoreCase("n"));
//
//        return strConfirma.equalsIgnoreCase("s");
//    }
//
//}
