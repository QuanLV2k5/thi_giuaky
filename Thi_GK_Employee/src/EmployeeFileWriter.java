import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class EmployeeFileWriter {
	public static void writeEmployeesToFile(List<Employee> employees, String fileName) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			objectOutputStream.writeObject(employees);
			System.out.println("Employees have been written to the file successfully.");
		} catch (IOException e) {
			System.out.println("Error occurred while writing employees to file: " + e.getMessage());
		}
	}
}
