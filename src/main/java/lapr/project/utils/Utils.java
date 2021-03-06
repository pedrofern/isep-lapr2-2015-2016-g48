package lapr.project.utils;

import java.awt.Dimension;
import java.io.Serializable;
import java.util.Calendar;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lapr.project.model.Candidatura;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.model.FAE;
import lapr.project.model.Recurso;
import lapr.project.model.Stand;
import lapr.project.model.Utilizador;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaDemonstracoes;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.RegistoExposicoes;
import lapr.project.model.lists.RegistoRecursos;
import lapr.project.model.lists.RegistoStands;
import lapr.project.model.lists.RegistoUtilizadores;

/**
 *
 * @author Pedro Fernandes
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Utils implements Serializable{

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^.+@.+\\..+$");

    /**
     * Obtem uma instancia de Date com a data atual.
     *
     * @return data atual
     */
    static public Data getdataAtual() {
        Calendar hoje = Calendar.getInstance();
        int ano = hoje.get(Calendar.YEAR);
        int mes = hoje.get(Calendar.MONTH) + 1;// janeiro é representado por 0
        int dia = hoje.get(Calendar.DAY_OF_MONTH);
        return new Data(dia, mes, ano);
    }

    public static boolean isEmailValido(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public static JComboBox criarComboExpo(RegistoExposicoes lista_exposicao) {
        Exposicao[] opcoes = lista_exposicao.getArray();
        JComboBox comboExpos = new JComboBox();
        comboExpos.setSelectedIndex(-1);
        comboExpos.setEditable(false);
        comboExpos.setPreferredSize(new Dimension(200, 20));
        DefaultComboBoxModel combo = new DefaultComboBoxModel(opcoes);

        comboExpos.setModel(combo);

        return comboExpos;
    }

    public static JComboBox criarComboCand(ListaCandidaturas lista_candidaturas) {
        Candidatura[] opcoes = lista_candidaturas.getArray();
        JComboBox comboCands = new JComboBox();

        DefaultComboBoxModel combo = new DefaultComboBoxModel(opcoes);

        comboCands.setModel(combo);

        return comboCands;
    }

    public static JComboBox criarComboUser(RegistoUtilizadores lista_users) {
        Utilizador[] opcoes = lista_users.getArray();
        JComboBox comboUsers = new JComboBox();

        DefaultComboBoxModel combo = new DefaultComboBoxModel(opcoes);

        comboUsers.setModel(combo);

        return comboUsers;
    }

    public static JComboBox criarComboDemo(ListaDemonstracoes lista_demo) {
        Demonstracao[] opcoes = lista_demo.getArray();
        JComboBox comboDemos = new JComboBox();

        DefaultComboBoxModel combo = new DefaultComboBoxModel(opcoes);

        comboDemos.setModel(combo);

        return comboDemos;
    }

    public static JComboBox criarComboStand(RegistoStands lista_stands) {
        Stand[] opcoes = lista_stands.getArray();
        JComboBox comboStands = new JComboBox();

        DefaultComboBoxModel combo = new DefaultComboBoxModel(opcoes);

        comboStands.setModel(combo);

        return comboStands;
    }

    public static JComboBox criarComboRecurso(RegistoRecursos lista_recursos) {
        Recurso[] opcoes = lista_recursos.getArray();
        JComboBox comboRecursos = new JComboBox();

        DefaultComboBoxModel combo = new DefaultComboBoxModel(opcoes);

        comboRecursos.setModel(combo);

        return comboRecursos;
    }
    
    public static JComboBox criarComboFaes(ListaFAE listaFaes){
        FAE[] opcoes= listaFaes.getArray();
        JComboBox comboFaes=new JComboBox();
        
        DefaultComboBoxModel combo = new DefaultComboBoxModel(opcoes);

        comboFaes.setModel(combo);

        return comboFaes;
    }
    
    
    

    public static Data converterStringParaData(String data) {

        String[] convertida = data.split("/");

        int diainicial = Integer.parseInt(convertida[0]);
        int mesinicial = Integer.parseInt(convertida[1]);
        int anoinicial = Integer.parseInt(convertida[2]);

        Data data_convertida = new Data(anoinicial, mesinicial, diainicial);

        return data_convertida;

    }

    public static boolean validaDatasString(String data) {

        String[] convertida = data.split("/");
        int diainicial = Integer.parseInt(convertida[0]);
        int mesinicial = Integer.parseInt(convertida[1]);
        int anoinicial = Integer.parseInt(convertida[2]);

        if (mesinicial >= 1 && mesinicial <= 12 && diainicial >= 1 && diainicial <= 31) {
            return true;
        }

        return false;
    }

    /**
     * Retrivied from
     * https://www.vivaolinux.com.br/script/JCriptoCesar-a-cifra-de-Cesar-em-Java/
     * dia 17/06/2016//////////////////////////////////////////////////////////////
     * Metodo que criptografa um texto, utilizando a famosa cifra
     * de Cesar.
     */
    public static String encriptar(String texto) {
        // Variavel que ira guardar o texto crifrado
        StringBuilder textoCifrado = new StringBuilder();
        // Variavel com tamanho do texto a ser encriptado
        int tamanhoTexto = texto.length();

        // Criptografa cada caracter por vez 
        for (int c = 0; c < tamanhoTexto; c++) {
            // Transforma o caracter em codigo ASCII e faz a criptografia
            int letraCifradaASCII = ((int) texto.charAt(c)) + 26;

            // Verifica se o codigo ASCII esta no limite dos caracteres imprimiveis
            while (letraCifradaASCII > 126) {
                letraCifradaASCII -= 94;
            }

            // Transforma codigo ASCII criptografado em caracter ao novo texto
            textoCifrado.append((char) letraCifradaASCII);
        }

        // Por fim retorna a mensagem criptografada por completo
        return textoCifrado.toString();
    }

    /**
     * Retrivied from
     * https://www.vivaolinux.com.br/script/JCriptoCesar-a-cifra-de-Cesar-em-Java/
     * dia 17/06/2016///////////////////////////////////////////////////////////////
     * Metodo que descriptografa um texto, utilizando a famosa
     * cifra Cesar.
     */
    public static String desencriptar(String textoCifrado) {
        // Variavel que ira guardar o texto decifrado
        StringBuilder texto = new StringBuilder();
        // Variavel com tamanho do texto a ser decriptado
        int tamanhoTexto = textoCifrado.length();

        // Descriptografa cada caracter por vez
        for (int c = 0; c < tamanhoTexto; c++) {
            // Transforma o caracter em codigo ASCII e faz a descriptografia
            int letraDecifradaASCII = ((int) textoCifrado.charAt(c)) - 26;

            // Verifica se o codigo ASCII esta no limite dos caracteres imprimiveis
            while (letraDecifradaASCII < 32) {
                letraDecifradaASCII += 94;
            }

            // Transforma codigo ASCII descriptografado em caracter ao novo texto
            texto.append((char) letraDecifradaASCII);
        }

        // Por fim retorna a mensagem descriptografada por completo
        return texto.toString();
    }
}
