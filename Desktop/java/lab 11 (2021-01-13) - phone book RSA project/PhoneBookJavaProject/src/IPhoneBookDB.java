/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Adam
 */
public interface IPhoneBookDB {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public PhoneEntry getPhoneEntry(String firstName, String lastName);

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public void addPhoneEntry(String firstName, String lastName,
			String phoneNumber);

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public boolean removePhoneEntry(String firstName, String lastName);
}