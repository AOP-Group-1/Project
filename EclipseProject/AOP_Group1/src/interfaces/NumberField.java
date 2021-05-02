package interfaces;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

import interfaces.NumberField.Numberdocument;

//class for having a textfield only for numbers
//https://stackoverflow.com/a/20979484
public class NumberField extends JTextField {

	
	public NumberField(int i) {
		super(i);
	}

@Override
protected Document createDefaultModel() {
 return new Numberdocument();
}

class Numberdocument extends PlainDocument {
 String numbers="1234567890-";
 @Override
 public void insertString(int offs, String str, AttributeSet a)
         throws BadLocationException {
     if(numbers.contains(str)) {
     	super.insertString(offs, str, a);
     }
    
 }
}}