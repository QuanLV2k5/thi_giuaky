import java.util.List;
import java.util.Scanner;

public class Main {
	private static final String FILE_NAME = "employee.txt";

	public static void main(String[] args) {
		EmployeeManager employeeManager = new EmployeeManager();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("-----Employee Management System-----");
			System.out.println("1.Add Employee");
			System.out.println("2.Remove Employee");
			System.out.println("3.Update Employee");
			System.out.println("4.Show All Employees");
			System.out.println("5.Save Employees to File");
			System.out.println("6.Load Employees from File");
			System.out.println("7.Save Employees to Database");
			System.out.println("8.Load Employees from Database");
			System.out.println("9.Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				add(employeeManager, scanner);
				break;
			case 2:
				delete(employeeManager, scanner);
				break;
			case 3:
				updateEmployee(employeeManager, scanner);
				break;
			case 4:
				employeeManager.showAllEmployees();
				break;
			case 5:
				EmployeeFileWriter.writeEmployeesToFile(employeeManager.getEmployees(), FILE_NAME);
				break;
			case 6:
				List<Employee> employees = EmployeeFileReader.readEmployeesFromFile(FILE_NAME);
				if (employees != null) {
					employeeManager.setEmployees(employees);
				}
				break;
			case 7:
				DatabaseWriter.writeEmployeesToDatabase(employeeManager.getEmployees());
				break;
			case 8:
				List<Employee> employeesFromDatabase = DatabaseReader.readEmployeesFromDatabase();
				employeeManager.setEmployees(employeesFromDatabase);
				break;
			case 9:
				System.out.println("Exiting program...");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 9.");
			}
		}
	}

	private static void add(EmployeeManager employeeManager, Scanner scanner) {
		System.out.println("Enter employee:");
		System.out.print("Full Name: ");
		String fullName = scanner.nextLine();
		System.out.print("Birth Day: ");
		String birthDay = scanner.nextLine();
		System.out.print("Phone: ");
		String phone = scanner.nextLine();
		System.out.print("Email: ");
		String email = scanner.nextLine();
		System.out.print("Employee Type (Experience/Fresher/Intern): ");
		String employeeType = scanner.nextLine();

		switch (employeeType.toLowerCase()) {
		case "experience":
			System.out.print("Experience in year: ");
			int expInYear = scanner.nextInt();
			scanner.nextLine();
			System.out.print("Professional Skill: ");
			String proSkill = scanner.nextLine();
			employeeManager.addEmployee(new Experience(fullName, birthDay, phone, email, expInYear, proSkill));
			break;
		case "fresher":
			System.out.print("Graduation Date: ");
			String graduationDate = scanner.nextLine();
			System.out.print("Graduation Rank: ");
			String graduationRank = scanner.nextLine();
			System.out.print("Education: ");
			String education = scanner.nextLine();
			employeeManager.addEmployee(
					new Fresher(fullName, birthDay, phone, email, graduationDate, null, graduationRank, education));
			break;
		case "intern":
			System.out.print("Majors: ");
			String majors = scanner.nextLine();
			System.out.print("Semester: ");
			String semester = scanner.nextLine();
			System.out.print("University Name: ");
			String universityName = scanner.nextLine();
			employeeManager.addEmployee(new Intern(fullName, birthDay, phone, email, majors, semester, universityName));
			break;
		default:
			System.out.println("Invalid employee type.");
		}
	}

	private static void delete(EmployeeManager employeeManager, Scanner scanner) {
		System.out.print("Enter employee ID to remove: ");
		int id = scanner.nextInt();
		Employee employeeToRemove = null;
		for (Employee employee : employeeManager.getEmployees()) {
			if (employee.getID() == id) {
				employeeToRemove = employee;
				break;
			}
		}
		if (employeeToRemove != null) {
			employeeManager.removeEmployee(employeeToRemove);
			System.out.println("Employee removed successfully.");
		} else {
			System.out.println("Employee not found with ID: " + id);
		}
	}

	private static void updateEmployee(EmployeeManager employeeManager, Scanner scanner) {
		System.out.print("Enter employee ID to update: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		Employee foundEmployee = null;
		for (Employee employee : employeeManager.getEmployees()) {
			if (employee.getID() == id) {
				foundEmployee = employee;
				break;
			}
		}

		if (foundEmployee != null) {
			System.out.println("Enter new information:");
			System.out.print("Full Name: ");
			String fullName = scanner.nextLine();
			System.out.print("Birth Day: ");
			String birthDay = scanner.nextLine();
			System.out.print("Phone: ");
			String phone = scanner.nextLine();
			System.out.print("Email: ");
			String email = scanner.nextLine();

			Employee updatedEmployee = new Employee(fullName, birthDay, phone, email, foundEmployee.getEmployeeType());
			updatedEmployee.setID(id);

			employeeManager.updateEmployee(updatedEmployee);
		} else {
			System.out.println("Employee not found with ID: " + id);
		}
	}
}
