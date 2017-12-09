package mc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mc.model.ReactionForm;

public interface ReactionFormDAO extends CrudRepository<ReactionForm, Integer>{
	
	@Query(value = "select * from reaction_form t where t.patient_id =?1", 
			nativeQuery = true)
	List<ReactionForm> listByPatientId(Integer patientId);

}
