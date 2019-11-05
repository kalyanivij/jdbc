package jdbcEg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedSt2 {

	@SuppressWarnings("null")
	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "flora");

			String inputSQL = "insert into details values(?, ?, ?, ?,?, ?)";
			statement = connection.prepareStatement(inputSQL);

			for (int i = 1; i < 10; i++) {
				statement.setInt(1, 4+ i);
				statement.setString(2, "raveesh" + i);
				statement.setString(3, "indian" + i);

				statement.setString(4, "#7,kondapur" + i);
				statement.setString(5, "hyderabad" + i);
				statement.setString(6, "hdh" + i);
				statement.addBatch();
			}
			int[] numOfRecAffected = statement.executeBatch();

			
			
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
