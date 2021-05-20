/**
 * 
 */

import java.awt.event.*;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Adam
 */
public class ProcessingPhoneNumberState implements IState {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private AddPersonWizard wizard;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private PhoneView phoneView;

	private class PreviousButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			handlePreviousButton();
		}
	}

	private class FinishButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			handleFinishButton();
		}
	}

	private class CancelButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			handleCancelButton();
		}
	}

	private class WindowListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			handleCancelButton();
		}
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public ProcessingPhoneNumberState(AddPersonWizard wizard) {
		// begin-user-code
		this.wizard = wizard;
		phoneView = new PhoneView(wizard.getView());
		phoneView.addPreviousButtonListener(new PreviousButtonListener());
		phoneView.addFinishButtonListener(new FinishButtonListener());
		phoneView.addCancelButtonListener(new CancelButtonListener());
		phoneView.addWindowListener(new WindowListener());
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public void handle() {
		// begin-user-code
		phoneView.setVisible(true);
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private void handlePreviousButton() {
		// begin-user-code
		phoneView.setVisible(false);
		wizard.setState(wizard.getProcessingNameState());
		wizard.handleState();
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private void handleFinishButton() {
		// begin-user-code
		try {
			String phoneNumber = phoneView.getPhoneNumber();
			Lib.checkPhoneNumber(phoneNumber);
			String firstName = wizard.getFirstName();
			String lastName = wizard.getLastName();
			wizard.getModel().addPerson(firstName, lastName, phoneNumber);
			wizard.getView().displayResult("Person added to the database");
			phoneView.setVisible(false);
			wizard.setState(wizard.getFinalState());
			wizard.handleState();
		} catch (RuntimeException e) {
			phoneView.displayResult(e.getMessage());
		}
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private void handleCancelButton() {
		// begin-user-code
		wizard.getView().displayResult("Operation canceled");
		phoneView.setVisible(false);
		wizard.setState(wizard.getFinalState());
		wizard.handleState();
		// end-user-code
	}
}