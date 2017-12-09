package mc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import mc.dao.MedicineFormDAO;
import mc.model.MedicineForm;

@Service
@Transactional
public class MedicineFormService {

	private final MedicineFormDAO medicineFormDAO;

	public MedicineFormService(MedicineFormDAO medicineFormDAO) {
		this.medicineFormDAO = medicineFormDAO;
	}
	
	public List<MedicineForm> listByPatientId(int patientId){
		return medicineFormDAO.listByPatientId(patientId);
	}
	
	public MedicineForm findRf(int id){
		return medicineFormDAO.findOne(id);
	}
	
	public void save(MedicineForm rf){
		medicineFormDAO.save(rf);
	}
	
	public void delete(int id){
		medicineFormDAO.delete(id);
	}
}
