import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DatabaseWriter {
	private static final String DATABASE_URL = "jdbc:sqlserver://quanlv\\\\SQLEXPRESS:1433;databaseName=Employee";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "12345678";

	public static void writeEmployeesToDatabase(List<Employee> employees) {
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
			for (Employee employee : employees) {
				String sql = "INSERT INTO Employee (id, fullName, birthday, phone, email, employeeType) VALUES (?, ?, ?, ?, ?, ?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, employee.getID());
				preparedStatement.setString(2, employee.getFullName());
				preparedStatement.setString(3, employee.getBirthDay());
				preparedStatement.setString(4, employee.getPhone());
				preparedStatement.setString(5, employee.getEmail());
				preparedStatement.setString(6, employee.getEmployeeType());
				preparedStatement.executeUpdate();
			}
			System.out.println("Employees have been written to the database successfully.");
		} catch (SQLException e) {
			System.out.println("Error occurred while writing employees to the database: " + e.getMessage());
		}
	}
}
