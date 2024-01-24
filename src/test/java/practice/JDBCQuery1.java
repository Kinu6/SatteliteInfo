package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCQuery1 {

	public static void main(String[] args) throws SQLException {
		Driver driverref = new Driver();

		// Register the driver
		DriverManager.registerDriver(driverref);

		// connect to DB
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classic", "root", "TIGER");

		// Issue create statement:
		Statement issue = con.createStatement();

		// Query:
		int query = issue.executeUpdate("update employees set first_name='Ravish' where last_name='Keshri'");
		System.out.println("Updated" + query);
		con.close();

	}

}
