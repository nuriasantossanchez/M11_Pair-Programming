package com.floristeria.project.view.frames;

import com.floristeria.project.application.Controller;
import com.floristeria.project.domain.Florist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

/**
 * Clase de la capa View
 * Implementa el patron Singleton
 */
public class FloristView extends JFrame implements ActionListener {

	private JLabel labelTittle;
	private JTextField textFloristName;
	private JLabel floristName;
	private JButton buttonCreate;
	private JComboBox comboBoxFlorists;
	private Controller controller;
	private static FloristView instance;

	private Florist florist;

	private FloristView(Controller controller) {
		this.controller= controller;

		labelTittle = new JLabel();
		labelTittle.setText("<html>" +
				"<h3>Please Type a Florist Name to Create or Search your Florist </h3>" +
				"</html>");
		labelTittle.setBounds(40, 20, 300, 40);
		add(labelTittle);

		floristName = new JLabel();
		floristName.setText("FLORIST NAME");
		floristName.setBounds(40, 90, 150, 30);
		add(floristName);

		textFloristName = new JTextField();
		textFloristName.setBounds(140, 90, 160, 30);
		add(textFloristName);

		comboBoxFlorists = new JComboBox();
		comboBoxFlorists.setBounds(140,130,180,30);
		comboBoxFlorists.addItem("Select Florist");
		add(comboBoxFlorists);

		buttonCreate = new JButton();
		buttonCreate.setBounds(120, 250, 100, 30);
		buttonCreate.setText("Set Up");
		add(buttonCreate);

		buttonCreate.addActionListener(this);
		comboBoxFlorists.addActionListener(this);

		setSize(380, 380);
		setTitle("Florist Management");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static FloristView getInstance(Controller controller){
		if (instance==null){
			instance=new FloristView(controller);
		}
		return instance;

	}

	private void clear() {
		textFloristName.setText("");
		comboBoxFlorists.setSelectedIndex(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(buttonCreate)) {
			createFloristAction();
		}
		else if(e.getSource().equals(comboBoxFlorists)){
			populateComboFlorists();

			comboBoxFlorists.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange()==ItemEvent.SELECTED){
						if(comboBoxFlorists.getSelectedIndex()!=0){
							textFloristName.setText(comboBoxFlorists.getSelectedItem().toString());
							setUpCatalogView();
						}
					}
				}
			});
		}
	}

	private void createFloristAction() {
		try {
			if (textFloristName.getText().trim().isEmpty()) {
				throw new EmptyFieldException("Empty Fields Not Allowed");
			}
			florist = controller.createFlorist(textFloristName.getText());
		}catch (EmptyFieldException ex) {
			JOptionPane.showMessageDialog(null,
					"Please Fill In the Florist Name", "Empty Fields Not Allowed",
					JOptionPane.WARNING_MESSAGE);
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null,
					"Data Entry Error", "Error",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			setUpCatalogView();

		}
	}

	private void setUpCatalogView() {
		if(null!=controller.getFlorist() && !textFloristName.getText().trim().equalsIgnoreCase("")){
			controller.findFlorist(textFloristName.getText().trim());
			clear();
			this.setVisible(false);
			CatalogView catalog = new CatalogView(controller);
			catalog.setVisible(true);
		}
	}

	private void populateComboFlorists(){
		comboBoxFlorists.removeAllItems();
		comboBoxFlorists.addItem("Select Florist");
		List<Florist> florist = controller.getAllFlorists();
		florist.stream().distinct().forEach(f -> comboBoxFlorists.addItem(f.getName()));
	}


}
