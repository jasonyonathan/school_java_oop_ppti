package SL;

public class User {
	
	protected String name;
	protected String password;
	protected String username;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(String name, String password, String username) {
		super();
		this.name = name;
		this.password = password;
		this.username = username;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean Compare(String username, String password) {
		if(this.username.equals(username)&&this.password.equals(password)) return true;
		else return false;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", username=" + username + "]";
	}

}
