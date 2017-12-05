package mc.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "person")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
	private Set<Certificate> certificates;
	
	public Person() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(Set<Certificate> certificates) {
		this.certificates = certificates;
	}
	
}
