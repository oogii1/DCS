package mc.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import mc.dao.CountryDAO;
import mc.model.Country;

@Service
@Transactional
public class CountryService {

	private final CountryDAO countryDAO;

	public CountryService(CountryDAO countryDAO) {
		this.countryDAO = countryDAO;
	}
	
	public List<Country> findAll(){
		List<Country> tasks = new ArrayList<>();
		for(Country task : countryDAO.findAll()){
			tasks.add(task);
		}
		return tasks;
	}
	
	public Country findTask(int id){
		return countryDAO.findOne(id);
	}
	
	public void save(Country task){
		countryDAO.save(task);
	}
	
	public void delete(int id){
		countryDAO.delete(id);
	}
}
