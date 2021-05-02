package interfaces;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;


//class for having a textfield only with numbers
// credit to: https://stackoverflow.com/a/20979484
public class NumberField extends JTextField {

	private static final long serialVersionUID = 7966779295557610144L;

	public NumberField(int i) {
		super(i);
	}

@Override
protected Document createDefaultModel() {
 return new Numberdocument();
}

class Numberdocument extends PlainDocument {

	private static final long serialVersionUID = -3739705134251280898L;
String numbers="1234567890-";
 @Override
 public void insertString(int offs, String str, AttributeSet a)
         throws BadLocationException {
     if(numbers.contains(str)) {
     	super.insertString(offs, str, a);
     }
    
 }
}}