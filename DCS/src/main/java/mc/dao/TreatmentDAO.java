package mc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mc.model.Treatment;

public interface TreatmentDAO extends CrudRepository<Treatment, Integer>{
	
	@Query(value = "select * from treatment t where t.patient_id =?1", 
			nativeQuery = true)
	List<Treatment> listByPatientId(Integer patientId);
}
