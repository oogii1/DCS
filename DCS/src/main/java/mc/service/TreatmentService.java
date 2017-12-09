package mc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import mc.dao.TreatmentDAO;
import mc.model.Treatment;

@Service
@Transactional
public class TreatmentService {

	private final TreatmentDAO treatmentDAO;

	public TreatmentService(TreatmentDAO treatmentDAO) {
		this.treatmentDAO = treatmentDAO;
	}
	
	public List<Treatment> listByPatientId(int patientId){
		return treatmentDAO.listByPatientId(patientId);
	}
	
	public Treatment findRf(int id){
		return treatmentDAO.findOne(id);
	}
	
	public void save(Treatment rf){
		treatmentDAO.save(rf);
	}
	
	public void delete(int id){
		treatmentDAO.delete(id);
	}
}
