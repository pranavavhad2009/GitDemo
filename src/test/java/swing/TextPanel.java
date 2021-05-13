package swing;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;


//Not tightly coupled with TexTPanel
public class TextPanel extends javax.swing.JPanel {

	private JTextArea textArea;
	public TextPanel() {
		textArea=new JTextArea();
		setLayout(new BorderLayout());
		add(new JScrollPane(textArea),BorderLayout.CENTER);
	}
	
	
	public void appendText(String text) {
		textArea.append(text);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
