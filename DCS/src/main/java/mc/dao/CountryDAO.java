package mc.dao;

import org.springframework.data.repository.CrudRepository;

import mc.model.Country;

public interface CountryDAO extends CrudRepository<Country, Integer>{

}
