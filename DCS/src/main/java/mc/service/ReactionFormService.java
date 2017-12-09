package mc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import mc.dao.ReactionFormDAO;
import mc.model.ReactionForm;

@Service
@Transactional
public class ReactionFormService {

	private final ReactionFormDAO reactionFormDAO;

	public ReactionFormService(ReactionFormDAO reactionFormDAO) {
		this.reactionFormDAO = reactionFormDAO;
	}
	
	public List<ReactionForm> listByPatientId(int patientId){
		return reactionFormDAO.listByPatientId(patientId);
	}
	
	public ReactionForm findRf(int id){
		return reactionFormDAO.findOne(id);
	}
	
	public void save(ReactionForm rf){
		reactionFormDAO.save(rf);
	}
	
	public void delete(int id){
		reactionFormDAO.delete(id);
	}
}
