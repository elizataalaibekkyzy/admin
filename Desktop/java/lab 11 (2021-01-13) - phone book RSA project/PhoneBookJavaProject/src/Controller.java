/**
 * 
 */

import java.awt.event.*;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Adam
 */
public class Controller {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private View view;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private Model model;

	private class SearchButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			handleSearchButton();
		}
	}

	private class AddButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			handleAddButton();
		}
	}

	private class RemoveButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			handleRemoveButton();
		}
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public Controller(View view, Model model) {
		// begin-user-code
		this.view = view;
		this.model = model;
		view.addSearchButtonListener(new SearchButtonListener());
		view.addAddButtonListener(new AddButtonListener());
		view.addRemoveButtonListener(new RemoveButtonListener());
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private void handleSearchButton() {
		// begin-user-code
		try {
			String firstName = view.getFirstName();
			String lastName = view.getLastName();
			Lib.checkName(firstName, lastName);
			String phoneNumber = model.getPhoneNumber(firstName, lastName);
			view.displayResult("Tel: " + phoneNumber);
		} catch (RuntimeException e) {
			view.displayResult(e.getMessage());
		}
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private void handleAddButton() {
		// begin-user-code
		AddPersonWizard wizard = new AddPersonWizard(view, model);
		wizard.handleState();
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private void handleRemoveButton() {
		// begin-user-code
		try {
			String firstName = view.getFirstName();
			String lastName = view.getLastName();
			Lib.checkName(firstName, lastName);
			model.removePerson(firstName, lastName);
			view.displayResult("Person removed from the database");
		} catch (RuntimeException e) {
			view.displayResult(e.getMessage());
		}
		// end-user-code
	}
}