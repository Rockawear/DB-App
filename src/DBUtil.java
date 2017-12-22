import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	
	/* This was created with flexibility in mind 
	 * This connection help to choose which DB 
	 * you want to use(i.e: Oracle, Derby, or 
	 * MYSQL) Make sure you add the DB driver to
	 * your buildpath, otherwise it will fail
	 */
	public static Connection getConnection(DBType dbType) throws SQLException {
		switch (dbType) {
		case MYSQLDB:
			return DriverManager.getConnection(TestMySQLConnection.DBUrl, 
			TestMySQLConnection.username, TestMySQLConnection.password);
		default:
			return null;
		}
	}
	
	/* This function will print descriptive error
	 * if connection failed
	 */
	public static void showErrorMessage(SQLException e) {
		System.err.println("Error : " + e.getMessage());
		System.err.println("Error code: " + e.getErrorCode());
	}
}
