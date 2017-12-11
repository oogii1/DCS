package mc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mc.model.Doctor;
import mc.model.User;

public interface DoctorDAO extends CrudRepository<Doctor, Integer>{
	
//	@Query(value = "select * from Patients b where b.Patient_name=?1 and b.pwd=?2", 
//			nativeQuery = true)
//	Patient findByPatientNameAndPwd(String PatientName, String pwd);
	public Doctor findByUser(User user);
	
	public List<Doctor> findAll();
	public Doctor findById(int id);
}
