/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Adam
 */
public class AddPersonWizard {
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
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private IState state;
	private IState initialState;
	private IState processingNameState;
	private IState processingPhoneNumberState;
	private IState finalState;

	private String firstName;
	private String lastName;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public AddPersonWizard(View view, Model model) {
		// begin-user-code
		this.view = view;
		this.model = model;
		initialState = new InitialState(this);
		processingNameState = new ProcessingNameState(this);
		processingPhoneNumberState = new ProcessingPhoneNumberState(this);
		finalState = new FinalState(this);
		state = initialState;
		firstName = view.getFirstName();
		lastName = view.getLastName();
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public void handleState() {
		// begin-user-code
		state.handle();
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public void setState(IState state) {
		// begin-user-code
		this.state = state;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public IState getInitialState() {
		// begin-user-code
		return initialState;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public IState getProcessingNameState() {
		// begin-user-code
		return processingNameState;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public IState getProcessingPhoneNumberState() {
		// begin-user-code
		return processingPhoneNumberState;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public IState getFinalState() {
		// begin-user-code
		return finalState;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public View getView() {
		// begin-user-code
		return view;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public Model getModel() {
		// begin-user-code
		return model;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public String getFirstName() {
		// begin-user-code
		return firstName;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public void setFirstName(String firstName) {
		// begin-user-code
		this.firstName = firstName;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public String getLastName() {
		// begin-user-code
		return lastName;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public void setLastName(String lastName) {
		// begin-user-code
		this.lastName = lastName;
		// end-user-code
	}
}