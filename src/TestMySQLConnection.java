import java.util.Scanner;

/* This class was designed for testing purposes
 * Please read the comments before you run it.
 */
public class TestMySQLConnection {
	static String DBUrl = null;
	static String username = null;
	static String password = null;
	public static void main(String[] args) throws Exception{
		SQLOperation start = new SQLOperation();
		Scanner input = new Scanner(System.in);
		
				System.out.println("What's the DATABASE URL that you'd like to use? ");
				DBUrl = SQLOperation.requestInfo(input); //"jdbc:mysql://localhost:3306/Contacts"

				System.out.println("What's the DATABASE username? ");
				username = SQLOperation.requestInfo(input); //"root";

				System.out.println("What's the password for " + username + " username? ");
				password = SQLOperation.requestInfo(input); //"sqlPass!";
		
		start.connect();
//		start.insertInto(); //Check and change Primary keys and check other values to avoid duplicate 
		//start.writeResultSet();
//		start.deleteRows(8); //Check DB or run writeresultSet to see the updated DB
		//start.update();
	}

}
