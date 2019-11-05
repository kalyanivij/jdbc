package jdbcEg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedSt4 {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "flora");
			statement = connection.prepareStatement("select* from details where sportsId=?");

			statement.setInt(1, 3);
			

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int sportsId = resultSet.getInt(1);
				String fathersName = resultSet.getString(2);
				String nationality = resultSet.getString(3);
				String address = resultSet.getString(4);
				String city = resultSet.getString(5);
				String catergory = resultSet.getString(6);
				System.out.println(sportsId + "," + fathersName + "," + nationality + "," + address + "," + city + ","
						+ catergory);
			}

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
