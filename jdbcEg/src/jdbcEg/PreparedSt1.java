package jdbcEg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedSt1 {

	@SuppressWarnings("null")
	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "flora");

			String inputSQL = "insert into details values(1, 'Raveesh', 'Indian', ?,'Hyderabad', 'hdh')";
			

			statement = connection.prepareStatement(inputSQL);
			statement.setString(1, "#7,kondapur");
			int numOfRecAffected = statement.executeUpdate();

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
