package Airline;

public class passenger {
	private String firstName, lastName, email, tel;
	private int id;

	passenger() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void print() {
		System.out.println("id : " + getId());
		System.out.println("Name : " + getFirstName() + " " + getLastName());
		System.out.println("Email :" +getEmail());
		System.out.println("Telephone number " + getTel());
		System.out.println(" ");
	}
}
