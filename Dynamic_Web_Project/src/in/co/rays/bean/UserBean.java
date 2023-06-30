package in.co.rays.bean;

public class UserBean {
	private int Id;
	private String FirstName;
	private String LastName;
	private String LoginId;
	private String Password;
	private String Address;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		this.LastName = lastName;
	}

	public String getLoginId() {
		return LoginId;
	}

	public void setLoginId(String loginId) {
		this.LoginId = loginId;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

}
