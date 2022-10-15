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
		//random example on how it should be used
		EmailGenerator e = new EmailGenerator("Robert", "Rogers", "sales", "tesla");
		System.out.println(e.createEmail());
	}
}