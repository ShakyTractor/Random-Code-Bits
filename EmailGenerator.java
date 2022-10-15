import java.util.*;

public class EmailGenerator {
	private String firstName;
	private String lastName;
	private String department;
	private String company;
	private String email;

	public EmailGenerator(String firstName, String lastName, String department, String company) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.company = company;
	}
	
	public String createEmail() {
		String output = String.format("%s.%s@%s.%s.com", this.firstName, this.lastName, this.department, this.company);
		return output;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your first name: ");
		String firstName = sc.nextLine().toLowerCase();
		System.out.print("Enter your last name: ");
		String lastName = sc.nextLine().toLowerCase();
		System.out.print("Enter your department: ");
		String department = sc.nextLine().toLowerCase();
		System.out.print("Enter your company name: ");
		String company = sc.nextLine().toLowerCase();

		EmailGenerator e = new EmailGenerator(firstName, lastName, department, company);
		System.out.println(e.createEmail());
	}
}
