/**
 * 
 */

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Adam
 */
public class Model {
	private static class InstanceHolder {
		private static Model instance = new Model();
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private IPhoneBookDB phoneBookDB;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private Model() {
		// begin-user-code
		phoneBookDB = new PhoneBookH2DB();
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public static Model getInstance() {
		// begin-user-code
		// thread-safe and lazy instantiation
		return InstanceHolder.instance;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public String getPhoneNumber(String firstName, String lastName) {
		// begin-user-code
		PhoneEntry entry = phoneBookDB.getPhoneEntry(firstName, lastName);
		if (entry == null)
			throw new RuntimeException("Not found in the database");
		return entry.phoneNumber;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public boolean isPersonInDB(String firstName, String lastName) {
		// begin-user-code
		return phoneBookDB.getPhoneEntry(firstName, lastName) != null;
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public void addPerson(String firstName, String lastName, String phoneNumber) {
		// begin-user-code
		phoneBookDB.addPhoneEntry(firstName, lastName, phoneNumber);
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public void removePerson(String firstName, String lastName) {
		// begin-user-code
		boolean removed = phoneBookDB.removePhoneEntry(firstName, lastName);
		if (!removed)
			throw new RuntimeException("Not found in the database");
		// end-user-code
	}
}