package swing;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {

	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameField;
	private JTextField occupationField;
	private JButton okBtn;
	private FormListener formListener;

	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;

		setPreferredSize(dim);

		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		nameField = new JTextField(10);
		occupationField = new JTextField(10);
		okBtn = new JButton("OK");
		
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=nameField.getText();
				String occupation=occupationField.getText();
				FormEvent ev=new  FormEvent(this,name,occupation);
				
				if(formListener!=null) {
					formListener.formEventOccured(ev);
				}
				
			}
		});

		Border innerBorder = BorderFactory.createTitledBorder("Add Person");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		

		
		
		////////////FIRST ROW///////////
		gc.gridx = 0; 
		gc.gridy = 0;
		gc.weightx = 1;   
		gc.weighty = 0.1;   //WEIGHT FOR SPACE BETWEEN COMPONENTS

		gc.fill = GridBagConstraints.NONE;
		gc.anchor=GridBagConstraints.LAST_LINE_END; //Anchor for control alignment in same line
		gc.insets=new Insets(0, 0, 0, 5); //top,left ,bot,right
		add(nameLabel, gc);
		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets=new Insets(0,0,0,0); //space between controls
		gc.anchor=GridBagConstraints.LAST_LINE_START;
		add(nameField, gc);
		
		//////////SECOND ROW/////////
		
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor=GridBagConstraints.LAST_LINE_END;
		gc.insets=new Insets(0, 0, 0, 5); //top,left ,bot,right
		add(occupationLabel, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		gc.insets=new Insets(0,0,0,0);
		gc.anchor=GridBagConstraints.LAST_LINE_START;
		add(occupationField, gc);
		
		
		/////////THIRD ROW///////
		gc.weightx = 1;
		gc.weighty = 2.0;
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.insets=new Insets(0,0,0,0);
		gc.anchor=GridBagConstraints.FIRST_LINE_START;
		add(okBtn, gc);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public  void setFormListener(FormListener formListener) {
		this.formListener=formListener;
		
	}

}
