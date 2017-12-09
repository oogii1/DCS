package mc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mc.model.MedicineForm;

public interface MedicineFormDAO extends CrudRepository<MedicineForm, Integer>{
	
	@Query(value = "select * from medicine_form t where t.patient_id =?1", 
			nativeQuery = true)
	List<MedicineForm> listByPatientId(Integer patientId);

}
