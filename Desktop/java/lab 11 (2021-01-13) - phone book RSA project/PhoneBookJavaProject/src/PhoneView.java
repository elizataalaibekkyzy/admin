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
public class PhoneView extends JFrame {
	private JLabel lblTitle = new JLabel("Please enter a telephone number",
			JLabel.CENTER), lblPhoneNumber = new JLabel("Telephone number: ",
			JLabel.RIGHT), lblResult = new JLabel("", JLabel.CENTER);
	private JTextField txtPhoneNumber = new JTextField(10);
	private JButton btnPrevious = new JButton("Previous"),
			btnFinish = new JButton("Finish"),
			btnCancel = new JButton("Cancel");
	private JPanel pnlPhone = new JPanel(), pnlButton = new JPanel();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public PhoneView(View view) {
		// begin-user-code		
		setTitle("Telephone number");
		setSize(350, 200);
		setResizable(false);
		setLocationRelativeTo(view.getRootPane());
		setLayout(new GridLayout(0, 1));
		add(lblTitle);
		pnlPhone.add(lblPhoneNumber);
		pnlPhone.add(txtPhoneNumber);
		add(pnlPhone);
		add(lblResult);
		pnlButton.add(btnPrevious);
		pnlButton.add(btnFinish);
		pnlButton.add(btnCancel);
		btnFinish.setPreferredSize(btnPrevious.getPreferredSize());
		btnCancel.setPreferredSize(btnPrevious.getPreferredSize());
		add(pnlButton);
		getRootPane().setDefaultButton(btnFinish);
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public String getPhoneNumber() {
		// begin-user-code
		return txtPhoneNumber.getText();
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
	public void addFinishButtonListener(ActionListener listener) {
		// begin-user-code
		btnFinish.addActionListener(listener);
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public void addPreviousButtonListener(ActionListener listener) {
		// begin-user-code
		btnPrevious.addActionListener(listener);
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