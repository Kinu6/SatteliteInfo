package practice;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadDarafromCmdLine {

	public static void main(String[] args) {

		// SQL query to execute
		String query = "SELECT * FROM your_table_name";

		try (
				// Establish a connection
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classic", "root",
						"TIGER");

				// Create a statement
				Statement statement = connection.createStatement();

				// Execute the query and get the result set
				ResultSet resultSet = statement.executeQuery("select * from employees");) {
			// Process the result set
			while (resultSet.next()) {
				// Retrieve data by column name or index
				String column1Value = resultSet.getString("first_name");

				// Print or process the retrieved data
				System.out.println("Column1: " + column1Value);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
