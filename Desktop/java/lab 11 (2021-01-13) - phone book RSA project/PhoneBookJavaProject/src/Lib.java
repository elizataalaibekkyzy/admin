/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Adam
 */
public class Lib {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public static void checkName(String firstName, String lastName) {
		// begin-user-code
		if (firstName == null || lastName == null || firstName.isEmpty()
				|| lastName.isEmpty())
			throw new RuntimeException("Incomplete person's name");
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public static void checkPhoneNumber(String phoneNumber) {
		// begin-user-code
		if (phoneNumber == null || phoneNumber.isEmpty())
			throw new RuntimeException("Missing telephone number");
		// end-user-code
	}
}