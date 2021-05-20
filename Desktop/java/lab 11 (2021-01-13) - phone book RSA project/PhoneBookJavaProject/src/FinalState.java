/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Adam
 */
public class FinalState implements IState {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private AddPersonWizard wizard;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public FinalState(AddPersonWizard wizard) {
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
		wizard.getView().setVisible(true);
		// end-user-code
	}
}