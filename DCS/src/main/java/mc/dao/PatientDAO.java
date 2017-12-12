package mc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mc.model.Patient;
import mc.model.User;

public interface PatientDAO extends CrudRepository<Patient, Integer>{
	
//	@Query(value = "select * from Patients b where b.Patient_name=?1 and b.pwd=?2", 
//			nativeQuery = true)
//	Patient findByPatientNameAndPwd(String PatientName, String pwd);
	public List<Patient> findAll();
	
	public Patient findByUser( User user);
	
}
