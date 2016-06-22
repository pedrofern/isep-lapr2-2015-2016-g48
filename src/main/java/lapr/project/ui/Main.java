package lapr.project.ui;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.RegistoUtilizadores;

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
            
            FichCentroExposicoes fichCentroExposicoes = new FichCentroExposicoes();

            CentroExposicoes ce = fichCentroExposicoes.lerFichBinario();
            
            if (ce == null) {
            ce = new CentroExposicoes();
            
            
            //Para teste
                     Utilizador ut1=new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin", true,15 );
//                     
                    Utilizador ut2= new Utilizador("Ana Silva", "1130155@isep.ipp.pt","Gestor",true,10);
                    Utilizador ut3= new Utilizador("Diana Silva", "1151088@isep.ipp.pt","Organizador",true,8);
                    Utilizador ut4= new Utilizador("Eduângelo Ferreira", "1151094@isep.ipp.pt","Organizador+Fae",true, 6);
                    Utilizador ut5= new Utilizador("Pedro Fernandes", "1060503@isep.ipp.pt","Fae",true,3);
//                    Utilizador ut6= new Utilizador("Tomás Magalhães" , "1151182@isep.ipp.pt","Representante",true,1);
                   
            
                   RegistoUtilizadores lu = ce.getRegistoUtilizadores();
                   lu.addUtilizador(ut1);
                   lu.addUtilizador(ut2);
                   lu.addUtilizador(ut3);
                   lu.addUtilizador(ut4);
                   lu.addUtilizador(ut5);
            }
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
//             ce = new CentroExposicoes();        
//        }
                System.out.println(ce.getRegistoExposicoes());
                System.out.println(ce.getRegistoUtilizadores());
                Login log = new Login(ce, fichCentroExposicoes);
//		CalculatorExample calculatorExample = new CalculatorExample();
//		System.out.println(calculatorExample.sum(3, 5));
	}

}
