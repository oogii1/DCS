package mc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "appointment")
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String symptom;
	private String treatment;
	private String prescription;
	private String aptmntDate;
	private Date insertDate;
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="source_type")
	private Setting sourceType;
	
	@ManyToOne
	@JoinColumn(name="aptmnt_time")
	private Setting aptmntTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getAptmntDate() {
		return aptmntDate;
	}

	public void setAptmntDate(String aptmntDate) {
		this.aptmntDate = aptmntDate;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Setting getSourceType() {
		return sourceType;
	}

	public void setSourceType(Setting sourceType) {
		this.sourceType = sourceType;
	}

	public Setting getAptmntTime() {
		return aptmntTime;
	}

	public void setAptmntTime(Setting aptmntTime) {
		this.aptmntTime = aptmntTime;
	}
}
