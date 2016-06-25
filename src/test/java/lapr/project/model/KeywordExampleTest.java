package lapr.project.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Example of a domain class that is used in Candidatura.
 * Created by Nuno Bettencourt [NMB] on 29/05/16.
 */
public class KeywordExampleTest {
	@Test
	public void ensureSameContentObjectsAreEqual() {
		KeywordExample expected = new KeywordExample("Doors");
		KeywordExample result = new KeywordExample("Doors");
		assertEquals(expected, result);
	}

	@Test
	public void ensureSameObjectIsEqual() {
		KeywordExample expected = new KeywordExample("Doors");
		assertEquals(expected, expected);
	}

	@Test
	public void ensureDifferentObjectsAreNotEqual() {
		KeywordExample expected = new KeywordExample("Doors");
		Object result = new Object();
		assertNotEquals(expected, result);
	}

	@Test
	public void ensureHashCodeIsCorrect() {
		KeywordExample firstKeywordExample = new KeywordExample("Doors");

		int expected = 66216549;
		int result = firstKeywordExample.hashCode();
		assertEquals(expected, result);
	}
}