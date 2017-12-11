package mc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mc.model.Appointment;
import mc.model.Treatment;

public interface AppointmentDAO extends CrudRepository<Appointment, Integer>{
	
	@Query(value = "select * from appointment t where t.patient_id =?1", 
			nativeQuery = true)
	List<Appointment> listByPatientId(Integer patientId);
	
	@Query(value = "select * from appointment t where t.aptmnt_date =?1 and t.aptmnt_time =?2 group by doctor_id", 
			nativeQuery = true)
	List<Appointment> listByTimeAndDate(String date, String time);
}
