package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JdbcQuery {

	public static void main(String[] args) throws SQLException {

		Driver driverref = new Driver();
		// Step 1: Register the driver;
		DriverManager.registerDriver(driverref);

		// Step 2: Connect to Data Base
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classic", "root", "TIGER");

		// Step 3: Issue create statement
		Statement state = con.createStatement();

		// Step 4: query
		ResultSet result = state.executeQuery("select first_name from employees");
		while (result.next()) {
			System.out.println(result.getString(1));
		}

		// Step 5: close db
		con.close();
		System.out.println("Close DB");

	}

}
