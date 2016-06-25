package lapr.project.model;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Class to demonstrate a Candidatura simple example.
 * @author Nuno Bettencourt [nmb@isep.ipp.pt] on 29/05/16.
 */
public class CandidaturaExampleTest {
	@Test
	public void ensureAddKeywordIsWorking() throws Exception {
		List<KeywordExample> expectedKeywordExampleList = new ArrayList<>();
		expectedKeywordExampleList.add(new KeywordExample("Doors"));

		CandidaturaExample candidatura = new CandidaturaExample("MyCandidatura", new ArrayList<>());
		candidatura.addKeyword(new KeywordExample("Doors"));

		List<KeywordExample> resultList = candidatura.getKeywordList();

		assertArrayEquals(expectedKeywordExampleList.toArray(), resultList.toArray());

	}

	@Test
	public void ensureSameContentObjectsAreEqual() {
		String description = "MyCandidatura";

		List<KeywordExample> keywords = new ArrayList<>();
		keywords.add(new KeywordExample("Doors"));
		keywords.add(new KeywordExample("Windows"));

		CandidaturaExample expected = new CandidaturaExample(description, keywords);
		CandidaturaExample result = new CandidaturaExample(description, keywords);

		assertEquals(expected, result);
	}

	@Test
	public void ensureSameObjectIsEqual() {
		String description = "MyCandidatura";

		List<KeywordExample> keywords = new ArrayList<>();
		keywords.add(new KeywordExample("Doors"));
		keywords.add(new KeywordExample("Windows"));

		CandidaturaExample expected = new CandidaturaExample(description, keywords);

		assertEquals(expected, expected);
	}

	@Test
	public void ensureDifferentObjectsAreNotEqual() {
		String description = "MyCandidatura";

		List<KeywordExample> keywords = new ArrayList<>();
		keywords.add(new KeywordExample("Doors"));
		keywords.add(new KeywordExample("Windows"));

		CandidaturaExample expected = new CandidaturaExample(description, keywords);

		Object result = new Object();
		assertNotEquals(expected, result);
	}

	@Test
	public void ensureDifferentDescriptionMakeObjectsNotEqual() {
		String description1 = "MyCandidatura1";
		String description2 = "MyCandidatura2";

		List<KeywordExample> keywords = new ArrayList<>();
		keywords.add(new KeywordExample("Doors"));
		keywords.add(new KeywordExample("Windows"));

		CandidaturaExample expected = new CandidaturaExample(description1, keywords);
		CandidaturaExample result = new CandidaturaExample(description2, keywords);

		assertNotEquals(expected, result);
	}

	@Test
	public void ensureHashCodeIsCorrect() {
		String description = "MyCandidatura";

		List<KeywordExample> keywords = new ArrayList<>();
		keywords.add(new KeywordExample("Doors"));
		keywords.add(new KeywordExample("Windows"));

		CandidaturaExample candidaturaExample = new CandidaturaExample(description, keywords);

		int expected = 461375881;
		int result = candidaturaExample.hashCode();
		assertEquals(expected, result);

	}


}