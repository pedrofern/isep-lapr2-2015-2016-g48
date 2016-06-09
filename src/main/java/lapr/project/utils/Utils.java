package lapr.project.utils;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import lapr.project.model.Candidatura;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.model.Recurso;
import lapr.project.model.Stand;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.RegistoDemonstracoes;
import lapr.project.model.lists.RegistoExposicoes;
import lapr.project.model.lists.RegistoRecursos;
import lapr.project.model.lists.RegistoStands;

/**
 *
 * @author Pedro Fernandes
 */
public class Utils {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^.+@.+\\..+$");

    public static String readLineFromConsole(String strPrompt) {
        try {
            System.out.println(strPrompt);

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            return in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date readDateFromConsole(String strPrompt) {
        do {
            try {
                String strDate = readLineFromConsole(strPrompt);

                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                Date date = df.parse(strDate);

                return date;
            } catch (ParseException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }
    
    /**
     * Obtem uma instancia de Date com a data atual.
     *
     * @return data atual
     */
    static public Date getdataAtual() {
        Calendar hoje = Calendar.getInstance();
        int ano = hoje.get(Calendar.YEAR);
        int mes = hoje.get(Calendar.MONTH) + 1;// janeiro é representado por 0
        int dia = hoje.get(Calendar.DAY_OF_MONTH);
        return new Date(dia, mes, ano);
    }

    public static boolean confirma(String sMessage) {
        String strConfirma;
        do {
            strConfirma = Utils.readLineFromConsole("\n" + sMessage + "\n");
        } while (!strConfirma.equalsIgnoreCase("s") && !strConfirma.equalsIgnoreCase("n"));

        return strConfirma.equalsIgnoreCase("s");
    }

    public static Object apresentaESeleciona(List list, String sHeader) {
        apresentaLista(list, sHeader);
        return selecionaObject(list);
    }

    public static void apresentaLista(List list, String sHeader) {
        System.out.println(sHeader);

        int index = 0;
        for (Object o : list) {
            index++;

            System.out.println(index + ". " + o.toString());
        }
        System.out.println("");
        System.out.println("0 - Cancelar");
    }

    public static Object selecionaObject(List list) {
        String opcao;
        int nOpcao;
        do {
            opcao = Utils.readLineFromConsole("Introduza opção: ");
            nOpcao = new Integer(opcao);
        } while (nOpcao < 0 || nOpcao > list.size());

        if (nOpcao == 0) {
            return null;
        } else {
            return list.get(nOpcao - 1);
        }
    }

    public static boolean isEmailValido(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
    
    
    public void criarComboExpo(RegistoExposicoes lista_exposicao){
        Exposicao[] opcoes=lista_exposicao.getArray();
        JComboBox comboExpos=new JComboBox();
        
        DefaultComboBoxModel combo=new DefaultComboBoxModel(opcoes);
        
        comboExpos.setModel(combo);
    }
    
    public void criarComboCand(ListaCandidaturas lista_candidaturas){
        Candidatura[] opcoes=lista_candidaturas.getArray();
        JComboBox comboCands=new JComboBox();
        
        DefaultComboBoxModel combo=new DefaultComboBoxModel(opcoes);
        
        comboCands.setModel(combo);
    }
    
     public void criarComboDemo(RegistoDemonstracoes lista_demo){
        Demonstracao[] opcoes=lista_demo.getArray();
        JComboBox comboDemos=new JComboBox();
        
        DefaultComboBoxModel combo=new DefaultComboBoxModel(opcoes);
        
        comboDemos.setModel(combo);
    }
     
     
      public void criarComboStand(RegistoStands lista_stands){
        Stand[] opcoes=lista_stands.getArray();
        JComboBox comboStands=new JComboBox();
        
        DefaultComboBoxModel combo=new DefaultComboBoxModel(opcoes);
        
        comboStands.setModel(combo);
    }
      
        public void criarComboRecurso(RegistoRecursos lista_recursos){
        Recurso[] opcoes=lista_recursos.getArray();
        JComboBox comboRecursos=new JComboBox();
        
        DefaultComboBoxModel combo=new DefaultComboBoxModel(opcoes);
        
        comboRecursos.setModel(combo);
    }
}
