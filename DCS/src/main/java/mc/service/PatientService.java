package mc.service;

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
}
