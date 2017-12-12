package mc.dao;

import org.springframework.data.repository.CrudRepository;

import mc.model.Receptionist;
import mc.model.User;

public interface ReceptionDAO extends CrudRepository<Receptionist, Integer>{
	public Receptionist findByUser(User user);
}
