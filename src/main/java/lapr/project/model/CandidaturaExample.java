package lapr.project.model;

import java.io.Serializable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Candidatura class.
 *
 * @author by Nuno Bettencourt [nmb@isep.ipp.pt] on 29/05/16.
 */
public class CandidaturaExample implements Serializable{
	private static final String ROOT_ELEMENT_NAME = "candidatura";
	private static final String DESCRIPTION_ELEMENT_NAME = "description";
	private static final String KEYWORDS_ELEMENT_NAME = "keywords";
	private final List<KeywordExample> keywordList = new ArrayList<>();
	private String description = "";

	/**
	 * Constructor for CandidaturaExample
	 *
	 * @param description CandidaturaDescription
	 * @param keywordList Keyword List
	 */
	public CandidaturaExample(String description, List<KeywordExample> keywordList) {
		this.description = description;
		this.keywordList.addAll(keywordList);
	}

	/**
	 * Default public constructor.
	 */
	public CandidaturaExample() {

	}

	/**
	 * Obtain Candidatura's description.
	 *
	 * @return Candidatura description
	 */
	private String getDescription() {
		return description;
	}

	/**
	 * Add a keyword to Candidatura.
	 *
	 * @param keyword Keyword to be added.
	 */
	public void addKeyword(KeywordExample keyword) {
		getKeywordList().add(keyword);
	}

	/**
	 * Obtain the list of existing keywords.
	 *
	 * @return A list of existing keywords.
	 */
	public List<KeywordExample> getKeywordList() {
		return keywordList;

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof CandidaturaExample)) {
			return false;
		}

		CandidaturaExample that = (CandidaturaExample) o;

		if (!getDescription().equals(that.getDescription())) {
			return false;
		}
		return getKeywordList().equals(that.getKeywordList());

	}

	@Override
	public int hashCode() {
		int result = getDescription().hashCode();
		result = 31 * result + getKeywordList().hashCode();
		return result;
	}
}
