/**
 * 
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Adam
 */
@SuppressWarnings("serial")
public class View extends JFrame {
	private JLabel lblTitle = new JLabel("Enter person's name", JLabel.CENTER),
			lblFirstName = new JLabel("First: ", JLabel.RIGHT),
			lblLastName = new JLabel("Last: ", JLabel.RIGHT),
			lblResult = new JLabel("", JLabel.CENTER);
	private JTextField txtFirstName = new JTextField(10),
			txtLastName = new JTextField(10);
	private JButton btnSearch = new JButton("Search"), btnAdd = new JButton(
			"Add"), btnRemove = new JButton("Remove");
	private JPanel pnlName = new JPanel(), pnlButton = new JPanel();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public View() {
		// begin-user-code		
		setTitle("Phone Book");
		setSize(400, 250);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0, 1));
		add(lblTitle);
		pnlName.add(lblFirstName);
		pnlName.add(txtFirstName);
		pnlName.add(lblLastName);
		pnlName.add(txtLastName);
		add(pnlName);
		add(lblResult);
		pnlButton.add(btnSearch);
		pnlButton.add(btnAdd);
		pnlButton.add(btnRemove);
		btnSearch.setPreferredSize(btnRemove.getPreferredSize());
		btnAdd.setPreferredSize(btnRemove.getPreferredSize());
		add(pnlButton);
		getRootPane().setDefaultButton(btnSearch);
		// end-user-code	    
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public static void main(String[] args) {
		// begin-user-code
		View view = new View();
		Model model = Model.getInstance();
		new Controller(view, model);
		view.setVisible(true);
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public String getFirstName() {
		// begin-user-code
		return txtFirstName.getText();
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public String getLastName() {
		// begin-user-code
		return txtLastName.getText();
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public void displayResult(String result) {
		// begin-user-code
		lblResult.setText(result);
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public void addSearchButtonListener(ActionListener listener) {
		// begin-user-code
		btnSearch.addActionListener(listener);
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public void addAddButtonListener(ActionListener listener) {
		// begin-user-code
		btnAdd.addActionListener(listener);
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public void addRemoveButtonListener(ActionListener listener) {
		// begin-user-code
		btnRemove.addActionListener(listener);
		// end-user-code
	}
}