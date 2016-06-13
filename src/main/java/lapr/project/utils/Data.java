package lapr.project.utils;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Representa uma data através do dia, mês e ano.
 */
public class Data implements Comparable<Data>, Serializable {

    /**
     * O ano da data.
     */
    private int ano;

    /**
     * O mês da data.
     */
    private int mes;

    /**
     * O dia da data.
     */
    private int dia;

    /**
     * Nomes dos dias da semana.
     */
    private static String[] nomeDiaDaSemana = {"Domingo", "Segunda-feira",
        "Terça-feira", "Quarta-feira",
        "Quinta-feira", "Sexta-feira",
        "Sábado"};

    /**
     * Número de dias de cada mês do ano.
     */
    private static int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30,
        31, 30, 31};

    /**
     * Nomes dos meses do ano.
     */
    private static String[] nomeMes = {"Inválido", "Janeiro", "Fevereiro",
        "Março", "Abril", "Maio", "Junho",
        "Julho", "Agosto", "Setembro",
        "Outubro", "Novembro", "Dezembro"};
    /**
     * O dia por omissão.
     */
    private static final int DIA_POR_OMISSAO = 1;

    /**
     * O mês por omissão.
     */
    private static final int MES_POR_OMISSAO = 1;

    /**
     * O ano por omissão.
     */
    private static final int ANO_POR_OMISSAO = 1;

    /**
     * Constrói uma instância de Data recebendo o ano, o mês e o dia.
     *
     * @param ano o ano da data.
     * @param mes o mês da data.
     * @param dia o dia da data.
     */
    public Data(int ano, int mes, int dia) {
        this.setData(ano, mes, dia);
    }

    /**
     * Constrói uma instância de Data com a data por omissão.
     */
    public Data() {
        this(Data.ANO_POR_OMISSAO, Data.MES_POR_OMISSAO, Data.DIA_POR_OMISSAO);
    }

    /**
     * Constrói uma instância de Data com as mesmas caraterísticas da data
     * recebida por parâmetro.
     *
     * @param outraData a data com as características a copiar.
     */
    public Data(Data outraData) {
        this(outraData.getAno(), outraData.getMes(), outraData.getDia());
    }

    /**
     * Devolve o ano da data.
     *
     * @return ano da data
     */
    public int getAno() {
        return this.ano;
    }

    /**
     * Devolve o mês da data.
     *
     * @return mês da data.
     */
    public int getMes() {
        return this.mes;
    }

    /**
     * Devolve o dia da data.
     *
     * @return dia da data.
     */
    public int getDia() {
        return this.dia;
    }

    /**
     * Modifica o ano, o mês e o dia da data.
     *
     * @param ano o novo ano da data.
     * @param mes o novo mês da data.
     * @param dia o novo dia da data.
     */
    public final void setData(int ano, int mes, int dia) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
    }

    /**
     * Devolve a descrição textual da data no formato: diaDaSemana, dia de mês
     * de ano.
     *
     * @return caraterísticas da data.
     */
    @Override
    public String toString() {
        return diaDaSemana() + ", " + this.dia + " de " + Data.nomeMes[this.mes]
                + " de " + this.ano;
    }

    /**
     * Compara a data com o objeto recebido.
     *
     * @param outroObjeto o objeto a comparar com a data.
     * @return true se o objeto recebido representar uma data equivalente à
     * data. Caso contrário, retorna false.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }
        Data outraData = (Data) outroObjeto;
        return this.ano == outraData.ano && this.mes == outraData.mes
                && this.dia == outraData.dia;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.ano;
        hash = 47 * hash + this.mes;
        hash = 47 * hash + this.dia;
        return hash;
    }

    /**
     * Compara a data com a outra data recebida por parâmetro.
     *
     * @param outraData a data a ser comparada.
     * @return o valor 0 se a outraData recebida é igual à data; o valor -1 se a
     * outraData for posterior à data; o valor 1 se a outraData for anterior à
     * data.
     */
    @Override
    public int compareTo(Data outraData) {
        return (outraData.isMaior(this)) ? -1 : (this.isMaior(outraData)) ? 1 : 0;
    }

    /**
     * Devolve o dia da semana da data.
     *
     * @return dia da semana da data.
     */
    public String diaDaSemana() {
        int totalDias = this.contaDias();
        totalDias = totalDias % 7;

        return Data.nomeDiaDaSemana[totalDias];
    }

    /**
     * Devolve o número de dias desde o dia 1/1/1 até à data.
     *
     * @return número de dias desde o dia 1/1/1 até à data.
     */
    private int contaDias() {
        int totalDias = 0;

        for (int i = 1; i < this.ano; i++) {
            totalDias += Data.isAnoBissexto(i) ? 366 : 365;
        }
        for (int i = 1; i < this.mes; i++) {
            totalDias += Data.diasPorMes[i];
        }
        totalDias += (Data.isAnoBissexto(this.ano) && this.mes > 2) ? 1 : 0;
        totalDias += this.dia;

        return totalDias;
    }

    /**
     * Devolve a data no formato:%04d/%02d/%02d.
     *
     * @return caraterísticas da data.
     */
    public String toAnoMesDiaString() {
        return String.format("%04d/%02d/%02d", this.ano, this.mes, this.dia);
    }
    

    /**
     * Devolve a data no formato:02d%/%02d/%04d/.
     *
     * @return caraterísticas da data.
     */
    public String toDiaMesAnoString() {
        return dia+"/"+mes+"/"+ano;
    }
    

    /**
     * Devolve true se a data for maior do que a data recebida por parâmetro. Se
     * a data for menor ou igual à data recebida por parâmetro, devolve false.
     *
     * @param outraData a outra data com a qual se compara a data.
     * @return true se a data for maior do que a data recebida por parâmetro,
     * caso contrário devolve false.
     */
    public boolean isMaior(Data outraData) {
        int totalDias = this.contaDias();
        int totalDias1 = outraData.contaDias();

        return totalDias > totalDias1;
    }

    /**
     * Devolve true se o ano passado por parâmetro for bissexto. Se o ano
     * passado por parâmetro não for bissexto, devolve false.
     *
     * @param ano o ano a validar.
     * @return true se o ano passado por parâmetro for bissexto, caso contrário
     * devolve false.
     */
    public static boolean isAnoBissexto(int ano) {
        return ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;
    }

    /**
     * Devolve a data atual do sistema.
     *
     * @return a data atual do sistema.
     */
    public static Data dataAtual() {
        Calendar hoje = Calendar.getInstance();
        int ano = hoje.get(Calendar.YEAR);
        int mes = hoje.get(Calendar.MONTH) + 1;    // janeiro é representado por 0
        int dia = hoje.get(Calendar.DAY_OF_MONTH);
        return new Data(ano, mes, dia);
    }
    
    public static Date converterParaDate(Data d) throws Exception{
        
        String data=d.toAnoMesDiaString();
            if(data==null || data.equals("")) 
                return null;
        Date convertida=null;
        try{
            DateFormat formatter=new SimpleDateFormat("yyyy/MM/dd");
            convertida=(java.util.Date)formatter.parse(data);
            
        }catch(ParseException e){
            throw e;
        }
        return convertida;
        
    }
    
     public static Date getDataAtualDate() throws Exception{
    
        Date d=converterParaDate(dataAtual());
        return d;
        
    }
 
}
