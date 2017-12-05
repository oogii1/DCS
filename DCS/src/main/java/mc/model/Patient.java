package mc.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "patient")
public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String insuranceNum;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="person_id")
	private Person person; 

	public Patient() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInsuranceNum() {
		return insuranceNum;
	}

	public void setInsuranceNum(String insuranceNum) {
		this.insuranceNum = insuranceNum;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
