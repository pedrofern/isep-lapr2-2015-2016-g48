package lapr.project.ui;

import java.io.IOException;
import javax.swing.UIManager;
import lapr.project.model.CentroExposicoes;

/**
 *
 * @author Diana
 */
public class Main_2 {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        CentroExposicoes ce;
        for(UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
            if ("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                }catch(Exception e){ 
                       e.printStackTrace();
                }
                break;
             }
        }
        // FicheiroCentroExposicoes fce= new FicheiroCentroExposicoes();
         
        //ce = fce.ler(FicheiroCentroExposicoes.NOME);
        
//        if (ce == null) {
             ce = new CentroExposicoes();        
//        }
        new Login(ce);       

    }
}
