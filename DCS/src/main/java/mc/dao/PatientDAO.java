package mc.dao;

import org.springframework.data.repository.CrudRepository;

import mc.model.Patient;

public interface PatientDAO extends CrudRepository<Patient, Integer>{
	
//	@Query(value = "select * from Patients b where b.Patient_name=?1 and b.pwd=?2", 
//			nativeQuery = true)
//	Patient findByPatientNameAndPwd(String PatientName, String pwd);

}
