import java.io.Serializable;

public class Employee implements IEmployee, Serializable {
	private static final long serialVersionUID = 1L;

	private static int employeeCount = 0;

	private int ID;
	private String fullName;
	private String birthDay;
	private String phone;
	private String email;
	private String employeeType;

	public Employee(String fullName, String birthDay, String phone, String email, String employeeType) {
		this.ID = ++employeeCount;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.phone = phone;
		this.email = email;
		this.employeeType = employeeType;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getID() {
		return ID;
	}

	public String getFullName() {
		return fullName;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public static int getEmployeeCount() {
		return employeeCount;
	}

	public void showInfo() {
		System.out.println("ID: " + ID);
		System.out.println("Full Name: " + fullName);
		System.out.println("Birth Day: " + birthDay);
		System.out.println("Phone: " + phone);
		System.out.println("Email: " + email);
		System.out.println("Employee Type: " + employeeType);
	}
}
