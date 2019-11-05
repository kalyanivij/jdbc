package jdbcEg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StaEg3 {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "flora");

			statement = connection.createStatement();
			int numOfRecAffected = statement.executeUpdate("delete from customers where id=8");

			System.out.println("numOfRecAffected:" + numOfRecAffected);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
