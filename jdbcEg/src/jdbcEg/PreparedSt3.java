package jdbcEg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedSt3 {

	@SuppressWarnings("null")
	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "flora");

			PreparedStatement preparedStatement = connection.prepareStatement("delete from details where sportsId=?");

			preparedStatement.setInt(1, 9);

			int numOfRecAffected = preparedStatement.executeUpdate();

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
