package ProjectTwo;

import javax.swing.Icon;
import javax.swing.JLabel;

public class Card {
	
	int value;
	Icon icon;
	JLabel label;
	
	public Card(int value, Icon icon, JLabel label) {
		this.value = value;
		this.icon = icon;
		this.label = label;
	}
}