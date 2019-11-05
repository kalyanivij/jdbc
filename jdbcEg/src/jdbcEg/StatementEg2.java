package jdbcEg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementEg2 {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "flora");

			statement = connection.createStatement();
			int numOfRecAffected = statement.executeUpdate(
					"update customers set customer_name='john', address='#10 6th cross, ameerpet', city='hyderabad' where id=11");

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
