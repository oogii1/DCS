package mc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import mc.dao.PatientDAO;
import mc.dao.UserDAO;
import mc.model.Patient;
import mc.model.User;

@Service
@Transactional
public class PatientService {

	private final UserDAO userDAO;
	private final PatientDAO patientDAO;
	
	public PatientService(UserDAO userDAO,PatientDAO patientDAO) {
		this.userDAO = userDAO;
		this.patientDAO = patientDAO;
	}
	
	public void regPatient(User user, Patient patient){
		user = userDAO.save(user);
		patient.setUser(user);
		patientDAO.save(patient);
	}
	public Patient findOne(int patientId) {
		return patientDAO.findOne(patientId);
	}
	public List<Patient> findAll(){
		return patientDAO.findAll();
	}
}
