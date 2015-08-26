package by.expertsoft.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="surname")
	private String surname;
	@Column(name="login")
	private String login;
	@Column(name="email")
	private String email;
	@Column(name="phone_number")
	private int phoneNumb;

	public User() {

	}

	public User(long id, String name, String surname, String login, String email,
			int phoneNumb) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.email = email;
		this.phoneNumb = phoneNumb;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
