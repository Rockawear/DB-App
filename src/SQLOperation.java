import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLOperation {
	/* These were set for more flexibility and less code.
	 */
	PreparedStatement preparedStatement = null;
	String sqlQuery = null;
	Connection conn = null;
	ResultSet rs = null;
	
	public static String requestInfo(Scanner in) {
		return in.nextLine();		
	}
	
	/* This will Connect to the given DB connection that
	 * is currently on the DBUtil class.
	 */
	public void connect() {
		sqlQuery = "SELECT * FROM Contacts.person";
		try {
			//Class.forName("com.mysql.jdbc.Driver").newInstance(); 
			conn = DBUtil.getConnection(DBType.MYSQLDB);
				Statement stmt = conn.createStatement();
					 rs = stmt.executeQuery(sqlQuery);
					 System.err.println("Success!");
			} catch (SQLException e) {
			DBUtil.showErrorMessage(e);
		}
	}
	
	/* This will loop through your table and print each row
	 * the output can be modify at your will.
	 */
	public void writeResultSet() throws SQLException {
		while (rs.next()) {
			//int count = rs.getInt("count(person_last_name)");
			int person_id = rs.getInt("person_id");
			String person_first_name = rs.getString("person_first_name");
			String person_last_name = rs.getString("person_last_name");
			String person_date_last_contacted = rs.getString("person_date_last_contacted");
			int person_contacted_number = rs.getInt("person_contacted_number");
			String person_date_added = rs.getString("person_date_added");
			System.out.println("Person #" + person_id + "\t FN: " + person_first_name + " \tLN: " 
			+ person_last_name + " \t#" + person_contacted_number +  " \tLast Contacted: " 
			+ person_date_last_contacted + " \tDate Added: " + person_date_added);
			//System.out.println(count);
		}
}
	
	/* This method will insert new rows to your table, 
	 * however you need to modify the statements with 
	 * new values, otherwise you will get Primary Key 
	 * already exist or duplicates.
	 */
	@SuppressWarnings("deprecation")
	public void insertInto() throws SQLException {
		preparedStatement = conn.prepareStatement("INSERT INTO Contacts.person values (?, ?, ?, ?, ?, ?)");
		preparedStatement.setInt(1, 8);
		preparedStatement.setString(2, "Joe");
		preparedStatement.setString(3, "Hart");
		preparedStatement.setInt(4, 7);
		preparedStatement.setDate(5, new java.sql.Date(2017, 12, 21));
		preparedStatement.setDate(6, new java.sql.Date(2017, 12, 20));
		preparedStatement.executeUpdate();
	}
	
	/* This will delete rows from the Contacts DB if person 
	 * ID is set to a specific number, it won't show until 
	 * the next time you run it. Check the DB after running
	 * it for the first time.
	 */
	public void deleteRows(int id) throws SQLException {
		String sqlSts = "Delete From Contacts.person where person_id = ?";
		preparedStatement = conn.prepareStatement(sqlSts);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		writeResultSet();
	}
	
	public void update() throws SQLException {
		String sqlSts = "UPDATE Contacts.person SET person_date_last_contacted = ? WHERE person_id = 6";
		preparedStatement = conn.prepareStatement(sqlSts);
		preparedStatement.setString(1, "2017-12-22 3:47:54");
		preparedStatement.executeUpdate();
	}
}
