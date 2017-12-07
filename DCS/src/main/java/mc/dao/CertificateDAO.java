package mc.dao;

import org.springframework.data.repository.CrudRepository;

import mc.model.Certificate;

public interface CertificateDAO extends CrudRepository<Certificate, Integer>{
	
//	@Query(value = "select * from Patients b where b.Patient_name=?1 and b.pwd=?2", 
//			nativeQuery = true)
//	Patient findByPatientNameAndPwd(String PatientName, String pwd);

}
