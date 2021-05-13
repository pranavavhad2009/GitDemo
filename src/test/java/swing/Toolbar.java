package swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Toolbar extends JPanel implements ActionListener{
	private JButton helloButton;
	private JButton goodbyrButton;
	private TextPanel textPanel;
	private StringListener textListener;
	
	public Toolbar() {
		helloButton=new  JButton("Hello");
		goodbyrButton=new JButton("GoodBye");
			
		
		helloButton.addActionListener(this);
		goodbyrButton.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(helloButton);
		add(goodbyrButton);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void setStringListener(StringListener listener) {
		this.textListener=listener;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button is clicked");
		
		JButton clicked=(JButton)e.getSource();
		
		if(clicked==helloButton) {
			System.out.println("Hello");
			if(textListener!=null) {
				textListener.stringEmitted("Hello\n");
			}
			//textPanel.appendText("Hello\n");
		}else {
			System.out.println("Good Bye");
			if(textListener!=null) {
				textListener.stringEmitted("Good Bye\n");
			}
			//textPanel.appendText("Good Bye\n");
		}
		
	}

}
