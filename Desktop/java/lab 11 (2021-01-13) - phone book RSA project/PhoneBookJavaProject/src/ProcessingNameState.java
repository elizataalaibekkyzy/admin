/**
 * 
 */

import java.awt.event.*;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Adam
 */
public class ProcessingNameState implements IState {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private AddPersonWizard wizard;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private NameView nameView;

	private class NextButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			handleNextButton();
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
	public ProcessingNameState(AddPersonWizard wizard) {
		// begin-user-code
		this.wizard = wizard;
		nameView = new NameView(wizard.getView());
		nameView.addNextButtonListener(new NextButtonListener());
		nameView.addCancelButtonListener(new CancelButtonListener());
		nameView.addWindowListener(new WindowListener());
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public void handle() {
		// begin-user-code
		nameView.setFirstName(wizard.getFirstName());
		nameView.setLastName(wizard.getLastName());
		nameView.setVisible(true);
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private void handleNextButton() {
		// begin-user-code
		try {
			String firstName = nameView.getFirstName();
			String lastName = nameView.getLastName();
			Lib.checkName(firstName, lastName);
			if (wizard.getModel().isPersonInDB(firstName, lastName))
				throw new RuntimeException("Already in the database");
			wizard.setFirstName(firstName);
			wizard.setLastName(lastName);
			nameView.setVisible(false);
			wizard.setState(wizard.getProcessingPhoneNumberState());
			wizard.handleState();
		} catch (RuntimeException e) {
			nameView.displayResult(e.getMessage());
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
		nameView.setVisible(false);
		wizard.setState(wizard.getFinalState());
		wizard.handleState();
		// end-user-code
	}
}