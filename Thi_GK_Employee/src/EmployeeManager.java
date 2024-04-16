import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
	private List<Employee> employees = new ArrayList<>();

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public void removeEmployee(Employee employee) {
		employees.remove(employee);
	}

	public void updateEmployee(Employee updatedEmployee) {
		for (int i = 0; i < employees.size(); i++) {
			Employee employee = employees.get(i);
			if (employee.getID() == updatedEmployee.getID()) {
				employees.set(i, updatedEmployee);
				System.out.println("Updated successfully!");
				return;
			}
		}
		System.out.println("Employee not found with ID: " + updatedEmployee.getID());
	}

	public void showAllEmployees() {
		for (Employee employee : employees) {
			employee.showInfo();
			System.out.println();
		}
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees2) {
		this.employees = employees2;
	}
}
