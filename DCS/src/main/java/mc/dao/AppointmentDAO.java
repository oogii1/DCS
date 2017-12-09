package mc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mc.model.Appointment;

public interface AppointmentDAO extends CrudRepository<Appointment, Integer>{
	
	@Query(value = "select * from appointment t where t.patient_id =?1", 
			nativeQuery = true)
	List<Appointment> listByPatientId(Integer patientId);
}
