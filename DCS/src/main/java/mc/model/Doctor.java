package mc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "doctor")
public class Doctor implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String workingYears;
	private Date startWorking;
	private String about;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="person_id")
	private Person person; 
	
	public Doctor() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWorkingYears() {
		return workingYears;
	}

	public void setWorkingYears(String workingYears) {
		this.workingYears = workingYears;
	}
	
	public Date getStartWorking() {
		return startWorking;
	}

	public void setStartWorking(Date startWorking) {
		this.startWorking = startWorking;
	}
	
	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
