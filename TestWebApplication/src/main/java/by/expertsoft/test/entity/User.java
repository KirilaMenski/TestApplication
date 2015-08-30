package by.expertsoft.test.entity;

public class User {

	private long id;
	private String name;
	private String surname;
	private String login;
	private String email;
	private int phoneNumb;
	
	public User(){
		
	}

	public User(long id, String name, String surname, String login,
			String email, int phoneNumb) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.email = email;
		this.phoneNumb = phoneNumb;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumb() {
		return phoneNumb;
	}

	public void setPhoneNumb(int phoneNumb) {
		this.phoneNumb = phoneNumb;
	}

}
