package lapr.project.ui;

//import javax.swing.UIManager;
import lapr.project.model.CentroExposicoes;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
public class Main {

	/**
	 * Private constructor to hide implicit public one.
	 */
	private Main(){

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
            CentroExposicoes ce;
//            for(UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
//                if ("Nimbus".equals(info.getName())){
//                    try {
//                        UIManager.setLookAndFeel(info.getClassName());
//                    }catch(Exception e){ 
//                           e.printStackTrace();
//                    }
//                    break;
//                 }
//            }
        // FicheiroCentroExposicoes fce= new FicheiroCentroExposicoes();
         
        //ce = fce.ler(FicheiroCentroExposicoes.NOME);
        
//        if (ce == null) {
             ce = new CentroExposicoes();        
//        }
                Login log = new Login(ce);
//		CalculatorExample calculatorExample = new CalculatorExample();
//		System.out.println(calculatorExample.sum(3, 5));
	}

}
