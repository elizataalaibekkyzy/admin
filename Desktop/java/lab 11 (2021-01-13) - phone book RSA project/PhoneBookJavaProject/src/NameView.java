/**
 * 
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Adam
 */
@SuppressWarnings("serial")
public class NameView extends JFrame {
	private JLabel lblTitle = new JLabel("Please enter a name", JLabel.CENTER),
			lblFirstName = new JLabel("First: ", JLabel.RIGHT),
			lblLastName = new JLabel("Last: ", JLabel.RIGHT),
			lblResult = new JLabel("", JLabel.CENTER);
	private JTextField txtFirstName = new JTextField(10),
			txtLastName = new JTextField(10);
	private JButton btnNext = new JButton("Next"), btnCancel = new JButton(
			"Cancel");
	private JPanel pnlName = new JPanel(), pnlButton = new JPanel();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public NameView(View view) {
		// begin-user-code
		setTitle("Name");
		setSize(350, 200);
		setResizable(false);
		setLocationRelativeTo(view.getRootPane());
		setLayout(new GridLayout(0, 1));
		add(lblTitle);
		pnlName.add(lblFirstName);
		pnlName.add(txtFirstName);
		pnlName.add(lblLastName);
		pnlName.add(txtLastName);
		add(pnlName);
		add(lblResult);
		pnlButton.add(btnNext);
		pnlButton.add(btnCancel);
		btnNext.setPreferredSize(btnCancel.getPreferredSize());
		add(pnlButton);
		getRootPane().setDefaultButton(btnNext);
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
	public void setFirstName(String firstName) {
		// begin-user-code
		txtFirstName.setText(firstName);
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
	public void setLastName(String lastName) {
		// begin-user-code
		txtLastName.setText(lastName);
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
	public void addNextButtonListener(ActionListener listener) {
		// begin-user-code
		btnNext.addActionListener(listener);
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public void addCancelButtonListener(ActionListener listener) {
		// begin-user-code
		btnCancel.addActionListener(listener);
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public void addWindowListener(WindowAdapter listener) {
		// begin-user-code
		super.addWindowListener(listener);
		// end-user-code
	}
}