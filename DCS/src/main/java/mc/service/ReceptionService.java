package mc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mc.dao.ReceptionDAO;
import mc.model.Receptionist;
import mc.model.User;

@Service
@Transactional
public class ReceptionService {

	
	@Autowired
	ReceptionDAO rdao;
	
	public Receptionist findByUser(User user) {
		return rdao.findByUser(user);
	}
	
	
	

}
