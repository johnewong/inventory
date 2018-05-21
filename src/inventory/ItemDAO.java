package inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ItemDAO {

	public ItemDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/inventory?charaterEncoding=UTF-8",
				"root","admin");
		return c;
	}
	
	public void add() {
		
	}
	
	public void update() {
		
	}
	
	public Item get() {
		return null;
	}
	
}
