package lapr.project.ui;

import lapr.project.model.*;

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
            }
    
            Login log = new Login(ce, fichCentroExposicoes);

        }
 
}
