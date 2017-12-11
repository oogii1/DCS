package mc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "appointment")
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String symptom;
	private String treatment;
	private String prescription;
	
	@Temporal(TemporalType.DATE)
	private Date aptmntDate;
	
	
	
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
	
	
	private String aptmntTime;

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

	

	public Date getAptmntDate() {
		return aptmntDate;
	}

	public void setAptmntDate(Date aptmntDate) {
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

	public String getAptmntTime() {
		return aptmntTime;
	}

	public void setAptmntTime(String aptmntTime) {
		this.aptmntTime = aptmntTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aptmntDate == null) ? 0 : aptmntDate.hashCode());
		result = prime * result + ((aptmntTime == null) ? 0 : aptmntTime.hashCode());
		result = prime * result + id;
		result = prime * result + ((insertDate == null) ? 0 : insertDate.hashCode());
		result = prime * result + ((prescription == null) ? 0 : prescription.hashCode());
		result = prime * result + ((symptom == null) ? 0 : symptom.hashCode());
		result = prime * result + ((treatment == null) ? 0 : treatment.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		if (aptmntDate == null) {
			if (other.aptmntDate != null)
				return false;
		} else if (!aptmntDate.equals(other.aptmntDate))
			return false;
		if (aptmntTime == null) {
			if (other.aptmntTime != null)
				return false;
		} else if (!aptmntTime.equals(other.aptmntTime))
			return false;
		if (id != other.id)
			return false;
		if (insertDate == null) {
			if (other.insertDate != null)
				return false;
		} else if (!insertDate.equals(other.insertDate))
			return false;
		if (prescription == null) {
			if (other.prescription != null)
				return false;
		} else if (!prescription.equals(other.prescription))
			return false;
		if (symptom == null) {
			if (other.symptom != null)
				return false;
		} else if (!symptom.equals(other.symptom))
			return false;
		if (treatment == null) {
			if (other.treatment != null)
				return false;
		} else if (!treatment.equals(other.treatment))
			return false;
		return true;
	}

		
	
}
