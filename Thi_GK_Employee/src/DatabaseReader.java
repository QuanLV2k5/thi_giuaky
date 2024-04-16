import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseReader {
	private static final String DATABASE_URL = "jdbc:sqlserver://quanlv\\\\SQLEXPRESS:1433;databaseName=QuanLyTienDien";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "12345678";

	public static List<Employee> readEmployeesFromDatabase() {
		List<Employee> employees = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
			String sql = "SELECT * FROM Employee";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String fullName = resultSet.getString("fullName");
				String birthDay = resultSet.getString("birthday");
				String phone = resultSet.getString("phone");
				String email = resultSet.getString("email");
				String employeeType = resultSet.getString("employeeType");
			}
			System.out.println("Successfully!");
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return employees;
	}
}
