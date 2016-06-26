package lapr.project.ui;

import lapr.project.model.*;
import lapr.project.model.lists.*;
import lapr.project.model.states.exposicao.*;
import lapr.project.utils.*;

/**
 * @author Pedro Fernandes
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
                Utilizador ut1=new Utilizador("Nuno Bettencourt", "nmb@isep.ipp.pt", "Admin","admin", true,15 );   
                Utilizador ut2= new Utilizador("Ana Silva", "1130155@isep.ipp.pt","Gestor","gestor",true,10);
                Utilizador ut3= new Utilizador("Diana Silva", "1151088@isep.ipp.pt","Organizador","organizador",true,8);
                Utilizador ut4= new Utilizador("Eduângelo Ferreira", "1151094@isep.ipp.pt","Organizador+Fae","orgfae",true, 6);
                Utilizador ut5= new Utilizador("Pedro Fernandes", "1060503@isep.ipp.pt","Fae","fae",true,3);

               RegistoUtilizadores lu = ce.getRegistoUtilizadores();
               lu.addUtilizador(ut1);
               lu.addUtilizador(ut2);
               lu.addUtilizador(ut3);
               lu.addUtilizador(ut4);
               lu.addUtilizador(ut5); 
            }

                System.out.println(ce.getRegistoExposicoes());
                System.out.println(ce.getRegistoUtilizadores());
                Login log = new Login(ce, fichCentroExposicoes);
  
            

        }

}
