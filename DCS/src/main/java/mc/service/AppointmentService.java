package mc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import mc.dao.AppointmentDAO;
import mc.model.Appointment;

@Service
@Transactional
public class AppointmentService {

	private final AppointmentDAO appointmentDAO;

	public AppointmentService(AppointmentDAO appointmentDAO) {
		this.appointmentDAO = appointmentDAO;
	}
	
	public List<Appointment> listByPatientId(int patientId){
		return appointmentDAO.listByPatientId(patientId);
	}
	
	public Appointment findRf(int id){
		return appointmentDAO.findOne(id);
	}
	
	public void save(Appointment rf){
		appointmentDAO.save(rf);
	}
	
	public void delete(int id){
		appointmentDAO.delete(id);
	}
}