/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Adam
 */
public class InitialState implements IState {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private AddPersonWizard wizard;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public InitialState(AddPersonWizard wizard) {
		// begin-user-code
		this.wizard = wizard;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	@Override
	public void handle() {
		// begin-user-code
		wizard.getView().setVisible(false);
		wizard.setState(wizard.getProcessingNameState());
		wizard.handleState();
		// end-user-code
	}
}