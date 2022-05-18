package JavaToSqlUsingJdbcApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao {

	public void saveEmployee(Employee employee){

		String s = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/car";
		String user_name ="root";
		String password = "root";
		String query = "Insert into vehicle values(?,?,?)";

		try {
			//1. load and Register Driver
			Class.forName(s);

			//2. Establish Connection
			Connection connection = DriverManager.getConnection(url, user_name, password);

			//3.Create Statement
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			//4.Execute Statement
			preparedStatement.setInt(1, employee.getId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setString(3, employee.getPh());

			preparedStatement.execute();

			//5.Close
			connection.close();
			System.out.println("Data Saved");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}		
	public void getEmployee(int id){

		String s1 = "com.mysql.cj.jdbc.Driver";
		String url1 = "jdbc:mysql://localhost:3306/car";
		String user_name1 ="root";
		String password1 = "root";
		String query1 = "select * from vehicle where id=?";
		try {
			//1. load and Register Driver
			Class.forName(s1);

			//2. Establish Connection
			Connection connection = DriverManager.getConnection(url1, user_name1, password1);

			//3.Create Statement
			PreparedStatement preparedStatement = connection.prepareStatement(query1);

			//4.Execute Statement
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getDouble(3));
			}

			//5.Close
			connection.close();
			System.out.println("Data Saved");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}}
}
