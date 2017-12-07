package mc.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mc.model.Setting;

public interface SettingDAO extends CrudRepository<Setting, Integer>{
	
//	@Query(value = "select * from Patients b where b.Patient_name=?1 and b.pwd=?2", 
//			nativeQuery = true)
//	Patient findByPatientNameAndPwd(String PatientName, String pwd);

	@Query(value = "select * from setting b where b.type=?1 b.var_key=?2", 
			nativeQuery = true)
	Setting findByTypeAndVarKey(String type,String varKey);
}
