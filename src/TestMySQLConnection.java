/* This class was designed for testing purposes
 * Please read the comments before you run it.
 */
public class TestMySQLConnection {

	public static void main(String[] args) throws Exception{
		SQLOperation start = new SQLOperation();
		start.connect();
//		start.insertInto(); //Check and change Primary keys and check other values to avoid duplicate 
		start.writeResultSet();
//		start.deleteRows(8); //Check DB or run writeresultSet to see the updated DB
		//start.update();
	}

}
