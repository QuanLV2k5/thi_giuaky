import java.util.Date;

public class Fresher extends Employee {
	private Date graduationDate;
	private String graduationRank;
	private String education;

	public Fresher(String fullName, String birthDay, String phone, String email, String employeeType,
			Date graduationDate, String graduation_rank, String education) {
		super(fullName, birthDay, phone, email, employeeType);
		this.graduationDate = graduationDate;
		this.graduationRank = graduation_rank;
		this.education = education;
	}

	public void showInfo() {
		super.showInfo();
		System.out.println("Graduation Date: " + graduationDate);
		System.out.println("Graduation Rank: " + graduationRank);
		System.out.println("Education: " + education);
	}
}
