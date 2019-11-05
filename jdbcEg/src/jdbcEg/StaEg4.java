package jdbcEg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaEg4 {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "flora");

			statement = connection.createStatement();
			String query = "select* from customers";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String customer_name = resultSet.getString(2);
				String phone_number = resultSet.getString(3);
				String address = resultSet.getString(4);
				String city = resultSet.getString(5);
				System.out.println(id + "," + customer_name + "," + phone_number + "," + address + "," + city);
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
