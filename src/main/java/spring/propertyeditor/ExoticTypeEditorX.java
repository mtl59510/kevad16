package spring.propertyeditor;

import java.beans.PropertyEditorSupport;

/**
 * NOTE That this would be picked up by Spring automatically if suffixed 
 * with *Editor. Forcing its hand and explicitly defining this in XML!
 * 
 * @author A
 *
 */
public class ExoticTypeEditorX extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		setValue(new ExoticType(text.toUpperCase()));
		
//		super.setAsText(text);	// hardocded illegal-argument for non-strings
	}
	
}
