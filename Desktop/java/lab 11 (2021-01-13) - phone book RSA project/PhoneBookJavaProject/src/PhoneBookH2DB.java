/**
 * 
 */

import java.sql.*;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Adam
 */
public class PhoneBookH2DB implements IPhoneBookDB {
	private final String url = "jdbc:h2:mem:";
	private Connection connection;

	private void establishConnection() {
		try {
			connection = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void createTable() {
		try {
			DatabaseMetaData md = connection.getMetaData();
			ResultSet rs = md.getTables(null, null, "phone_entries", null);
			if (!rs.next()) {
				Statement s = connection.createStatement();
				s.execute("create table phone_entries(first_name varchar(40), "
						+ "last_name varchar(40), phone_number varchar(30))");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private PhoneEntry findByName(String firstName, String lastName) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("select phone_number from phone_entries "
							+ "where first_name = ? and last_name = ?");
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return new PhoneEntry(firstName, lastName, rs.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void insert(PhoneEntry phoneEntry) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("insert into phone_entries values (?, ?, ?)");
			ps.setString(1, phoneEntry.firstName);
			ps.setString(2, phoneEntry.lastName);
			ps.setString(3, phoneEntry.phoneNumber);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private boolean deleteByName(String firstName, String lastName) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("delete from phone_entries "
							+ "where first_name = ? and last_name = ?");
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void populateTableWithSampleData() {
		PhoneEntry phoneEntry = new PhoneEntry("John", "Smith",
				"+48 22 234 1223");
		if (findByName(phoneEntry.firstName, phoneEntry.lastName) == null)
			insert(phoneEntry);
		phoneEntry = new PhoneEntry("Adam", "Brown", "+48 81 315 2142");
		if (findByName(phoneEntry.firstName, phoneEntry.lastName) == null)
			insert(phoneEntry);
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	public PhoneBookH2DB() {
		// begin-user-code
		establishConnection();
		createTable();
		populateTableWithSampleData();
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	@Override
	public PhoneEntry getPhoneEntry(String firstName, String lastName) {
		// begin-user-code
		return findByName(firstName, lastName);
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
		insert(new PhoneEntry(firstName, lastName, phoneNumber));
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 */
	@Override
	public boolean removePhoneEntry(String firstName, String lastName) {
		// begin-user-code
		return deleteByName(firstName, lastName);
		// end-user-code
	}
}