package lapr.project.ui.ucs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Diana Silva
 */
public class AvaliarCandidaturaRadioButton {
    private JRadioButton button1;
    private JRadioButton button2;
    private JRadioButton button3;
    private JRadioButton button4;
    private JRadioButton button5;
    
    public AvaliarCandidaturaRadioButton(){
        
        button1=new JRadioButton("1");
        button2=new JRadioButton("2");
        button3=new JRadioButton("3");
        button4=new JRadioButton("4");
        button5=new JRadioButton("5");
     
        ButtonGroup grupoBotoes=new ButtonGroup();
        grupoBotoes.add(button1);
        grupoBotoes.add(button2);
        grupoBotoes.add(button3);
        grupoBotoes.add(button4);
        grupoBotoes.add(button5);   

    }

    /**
     * @return the button1
     */
    public JRadioButton getButton1() {
        return button1;
    }

    /**
     * @return the button2
     */
    public JRadioButton getButton2() {
        return button2;
    }

    /**
     * @return the button3
     */
    public JRadioButton getButton3() {
        return button3;
    }

    /**
     * @return the button4
     */
    public JRadioButton getButton4() {
        return button4;
    }

    /**
     * @return the button5
     */
    public JRadioButton getButton5() {
        return button5;
    }
    
    
}
