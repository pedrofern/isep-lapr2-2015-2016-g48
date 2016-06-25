package lapr.project.model;

import java.io.Serializable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Represents a keyword.
 *
 * @author by Nuno Bettencourt [nmb@isep.ipp.pt] on 29/05/16.
 */
public class KeywordExample implements Serializable {

	private static final String ROOT_ELEMENT_NAME = "keyword";
	private static final String VALUE_ELEMENT_NAME = "value";

	/**
	 * Keyword representation.
	 */
	private String value = "";

	/**
	 * Default empty constructor.
	 */
	public KeywordExample() {

	}

	/**
	 * Constructor for KeywordExample Class.
	 *
	 * @param keyword Keyword being used.
	 */
	public KeywordExample(String keyword) {
		this.value = keyword;
	}

	/**
	 * Obtain keyword value.
	 *
	 * @return Keyword Value
	 */
	private String getValue() {
		return this.value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof KeywordExample)) {
			return false;
		}

		KeywordExample that = (KeywordExample) o;

		return getValue().equals(that.getValue());

	}

	@Override
	public int hashCode() {
		return getValue().hashCode();
	}
}
