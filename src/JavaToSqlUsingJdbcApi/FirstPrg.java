package JavaToSqlUsingJdbcApi;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FirstPrg {
	public static void main(String[] args) {

		String s = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/car";
		String user_name ="root";
		String password = "root";
		String query = "select * from vehicle";

		try {
			//1. load and Register Driver
			Class.forName(s);

			//2. Establish Connection
			Connection connection = DriverManager.getConnection(url, user_name, password);

			//3.Create Statement
			Statement statement = connection.createStatement();

			//4.Execute Statement
			ResultSet resultSet = 	statement.executeQuery(query);
			while(resultSet.next()){
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println("-------------------");
			}

			//5.Close
			connection.close();
			System.out.println("Data Saved");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		}
	}
}
