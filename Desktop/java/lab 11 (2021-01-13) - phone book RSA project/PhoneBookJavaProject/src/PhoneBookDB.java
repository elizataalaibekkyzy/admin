/**
 * 
 */

import java.util.*;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Adam
 */
public class PhoneBookDB implements IPhoneBookDB {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	private Map<PhoneEntry, PhoneEntry> phoneEntries;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public PhoneBookDB() {
		// begin-user-code
		phoneEntries = new HashMap<>();
		PhoneEntry phoneEntry = new PhoneEntry("John", "Smith",
				"+48 22 234 1223");
		phoneEntries.put(phoneEntry, phoneEntry);
		phoneEntry = new PhoneEntry("Adam", "Brown", "+48 81 315 2142");
		phoneEntries.put(phoneEntry, phoneEntry);
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	@Override
	public PhoneEntry getPhoneEntry(String firstName, String lastName) {
		// begin-user-code
		return phoneEntries.get(new PhoneEntry(firstName, lastName, null));
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	@Override
	public void addPhoneEntry(String firstName, String lastName,
			String phoneNumber) {
		// begin-user-code
		PhoneEntry phoneEntry = new PhoneEntry(firstName, lastName, phoneNumber);
		phoneEntries.put(phoneEntry, phoneEntry);
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	@Override
	public boolean removePhoneEntry(String firstName, String lastName) {
		// begin-user-code
		return phoneEntries.remove(new PhoneEntry(firstName, lastName, null)) != null;
		// end-user-code
	}
}