import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class EmployeeFileReader {
	@SuppressWarnings("unchecked")
	public static List<Employee> readEmployeesFromFile(String fileName) {
		List<Employee> employees = null;
		try (FileInputStream fileInputStream = new FileInputStream(fileName);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
			employees = (List<Employee>) objectInputStream.readObject();
			System.out.println("Employees have been read from the file successfully.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error occurred while reading employees from file: " + e.getMessage());
		}
		return employees;
	}
}
