package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * CalculatorExample Class Unit Testing.
 *
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 * 
 * alterado por Diana Silva <1151088@isep.ipp.pt> on 11/06/16.
 * 
 */
public class CalculatorExampleTest {
	/**
	 * Ensure second operand can assume a negative value.
	 */
	@Test
	public void ensureSecondNegativeOperandWorks() {
		int expected = 5;
		int firstOperand = 10;
		int secondOperand = -5;
		CalculatorExample calculator = new CalculatorExample();
		int result = calculator.sum(firstOperand, secondOperand);
		assertEquals(expected, result);
	}
        
        /**
	 * Ensure average  it´s calculated with success receiving the sum and number of values
	 */
	@Test
	public void ensureAverageWorks() {
		double expected = 5;
		double firstOperand = 10;
		double secondOperand = 2;
		
		double result = CalculatorExample.average((int)firstOperand, (int)secondOperand);
		
                assertEquals(expected, result, result);

	}
        
        /**
	 * Ensure the count of questions array 
	 */
	@Test
        public void countQuestions(){
            
            int expected=2;
            
            List questoes =new ArrayList<Questao>();
            
            questoes.add(new Questao());
            questoes.add(new Questao());
            
            int result= CalculatorExample.countQuestions(questoes);
            
            assertEquals(expected, result);
            
        }
        
        
        /**
	 * Ensure the count of integers array 
	 */
	@Test
        public void countRespostas(){
            
            int expected=3;
            
            List integers =new ArrayList<Integer>();
            
            integers.add(1);
            integers.add(2);
            integers.add(3);
            
            int result= CalculatorExample.countRespostas(integers);
            
            assertEquals(expected, result);
            
        }
}
