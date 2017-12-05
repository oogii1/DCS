package mc.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Treatment {
	
	private String condition;
	private String treatment;
	private String prescription;
	private String advice;
	private Double price;
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
	
	

}
