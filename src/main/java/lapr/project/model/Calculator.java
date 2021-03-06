package lapr.project.model;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 * 
 * alterado por Diana Silva <1151088@isep.ipp.pt> on 11/06/16.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Calculator implements Serializable{

        public Calculator(){
            
        }
        /**
         * Calculate the sum of five int numbers.
         * 
         * @param v1 First number to be added
         * @param v2 Second number to be added

         * @return Return the sum of all operands
         */
	public static int sum(int v1, int v2)
	{
		return v1+v2;
	}
    
    
        /**
         * Calculate the sum of five int numbers.
         * 
         * @param v1 First number to be added
         * @param v2 Second number to be added
         * @param v3 Three number to be added
         * @param v4 Fourth number to be added
         * @param v5 Fifth number to be added
         * @return Return the sum of all operands
         */
	public static int sum(int valor1, int valor2, int valor3, int valor4, int valor5)
	{
		return valor1+valor2+valor3+valor4+valor5;
	}
        
        /**
         * Calculate the average receiving the sum and number of values
         * @param sum sum of values to calculate average
         * @param number_of_values number of values to consider
         * @return Return the average
         */
        
        public static double average(double sum, double numberOfValues){
            return (double)sum/numberOfValues;
        }
        
        /**
         * Calculator the rate receiving the number to calculate the rate and the total
     * @param number the divisor
     * @param totalNumber the total
         * @return rate
         */
        public static double calculateRate(int number, int totalNumber){
            return (double)number/totalNumber;
        }
        
        /**
         * Calculate the sum of a list of integers 
         * 
         * @param array the list with the integers
         * @return sum of list of integers
         */
        
        public static int sum(List<Integer> array){
            int soma=0;
            int nValues=countRespostas(array);
            for(int i=0; i<nValues; i++){
                soma+=array.get(i);
            }
            
            return soma;
        }
        
        /**
         * Count the questions in a questions list
         * @param array_questoes the list with questions
         * @return number of questions in the list
         */
        
        public static int countQuestions(List<Questao> arrayQuestoes){
            return arrayQuestoes.size();
        }
        
        /**
         * Count the numbers of integers list
         * @param array the list with integers
         * @return number of integers in the list
         */
        
        public static int countRespostas(List<Integer> array){
            return array.size();
        }
        
}