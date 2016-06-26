package lapr.project.ui;

import lapr.project.model.*;
import lapr.project.model.lists.*;
import lapr.project.model.states.exposicao.*;
import lapr.project.utils.*;
import lapr.project.model.states.exposicao.*;
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

            ce.getRegistoExposicoes().getExposicoes().get(1).alterarEstado(new ExposicaoCandidaturasDecididas());
             Candidatura c1 = new Candidatura();
        c1.setNomeEmpresa("Candidatura1");
        Candidatura c2 = new Candidatura();
        c2.setNomeEmpresa("Candidatura2");
        Candidatura c3 = new Candidatura();
        c3.setNomeEmpresa("Candidatura3");
        Candidatura c4 = new Candidatura();
        c4.setNomeEmpresa("Candidatura4");
        Candidatura c5 = new Candidatura();
        c5.setNomeEmpresa("Candidatura5");
         Avaliacao a1=new Avaliacao();
        
        a1.setJustificacao("Empresa de renome que revela enquadrar-se ao tema, apresentando produtos adequados.");
        a1.setResposta(true);
        a1.setAvaliada();
        a1.setMedia(3);
        c1.getListaAvaliacoes().add(a1);
        
        Avaliacao a2=new Avaliacao();
        a2.setJustificacao("Uma mais-valia para a exposição, sendo que o prestígio e a competência da empresa são pontos marcantes");
        a2.setResposta(true);
        a2.setAvaliada();
        a2.setMedia(1);
        c1.getListaAvaliacoes().add(a2);
        
        Avaliacao a3=new Avaliacao();
        a3.setJustificacao(("Poderia enquadrar melhor os produtos apresentados e verificar a quantidade de convites"));
        a3.setResposta(false);
        a3.setMedia(3);
        a3.setAvaliada();
        
        c1.setDecisao(true);
        c2.setDecisao(false);
        c3.setDecisao(true);
        
        c2.getListaAvaliacoes().add(a2);
        c2.getListaAvaliacoes().add(a1);
        
        c3.getListaAvaliacoes().add(a1);
        c3.getListaAvaliacoes().add(a3);
        ce.getRegistoExposicoes().getExposicoes().get(1).getListaCandidaturas().addCandidatura(c1);
        ce.getRegistoExposicoes().getExposicoes().get(1).getListaCandidaturas().addCandidatura(c2);
        ce.getRegistoExposicoes().getExposicoes().get(1).getListaCandidaturas().addCandidatura(c3);
        ce.getRegistoExposicoes().getExposicoes().get(1).getListaCandidaturas().addCandidatura(c4);
        ce.getRegistoExposicoes().getExposicoes().get(1).getListaCandidaturas().addCandidatura(c5);
        
        Login log = new Login(ce, fichCentroExposicoes);
  
            

        }

}
