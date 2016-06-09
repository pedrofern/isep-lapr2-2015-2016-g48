/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.ucs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;

/**
 *
 * @author Pedro Fernandes
 */
public class DialogoSelecionarExposicao extends JDialog{

    private Exposicao e;
    private CentroExposicoes m_centroExposicoes;
    /**
     * cria um painel para selecinar a exposição
     */
    public DialogoSelecionarExposicao(CentroExposicoes ce){
        m_centroExposicoes = ce;
        
// PARA QUANDO EXPOSICOES ESTIVEREM A FUNCIONAR
        //-------------------------------------------------------
//        try{                
//            String[] opcoes = new String[m_centroExposicoes.getListaExposicoes().getArray().length];
//            for (int i =0; i<opcoes.length;i++) {
//                 opcoes[i] = m_centroExposicoes.getListaExposicoes().getExposicao().get(i).getTitulo();
//            }
//            e = null;
//            try{
//                String candidatura = (String) JOptionPane.showInputDialog(
//                    null,
//                    "Escolha uma Exposição:", "Escolher Exposição",
//                    JOptionPane.PLAIN_MESSAGE,
//                    null,
//                    opcoes,
//                    opcoes[0]);
//                for (int i = 0; i < m_centroExposicoes.getListaExposicoes().getArray().length; i++) {
//                    if(candidatura.matches(m_centroExposicoes.getListaExposicoes().getExposicao().get(i).getTitulo())){
//                    e = m_centroExposicoes.getListaExposicoes().getExposicao().get(i);
//                    }
//                }
//                if (e != null) {
    //-------------------------------------------------------
                    new RegistarCandidaturaUI(ce,e);
    //-------------------------------------------------------
//                }
//            }
//            catch (NullPointerException ex){
//                JOptionPane.showMessageDialog(
//                        null,
//                        "Não selecionou candidatura!",
//                        "Selecionar Exposição",
//                        JOptionPane.INFORMATION_MESSAGE);                        
//            }
//        }
//        catch (ArrayIndexOutOfBoundsException ex){
//            JOptionPane.showMessageDialog(
//                    null,
//                    "Não existem exposições criadas",
//                    "Selecionar Exposição",
//                    JOptionPane.ERROR_MESSAGE);                            
//        }
    //-------------------------------------------------------
    }
}
