/**
 * 
 */
package challenge1.question2;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * @author SAP
 *
 */
public class CountHtmlCharacters {

	private String _htmlCharacterMessage = null;
	
	private String getHtmlCharacterMessage() {
		return this._htmlCharacterMessage;
	}

	private void setHtmlCharacterMessage(String htmlCharacterMessage) {
		this._htmlCharacterMessage = htmlCharacterMessage;
	}

	public CountHtmlCharacters(String htmlCharacterMessage) {
		this.setHtmlCharacterMessage(htmlCharacterMessage);
	}

	public Object getCount() throws UnsupportedEncodingException {
		return StringEscapeUtils.unescapeHtml(this.getHtmlCharacterMessage()).length();
	}

}
