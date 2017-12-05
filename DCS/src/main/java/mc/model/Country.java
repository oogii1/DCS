package mc.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "country")
public class Country implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String code;
	private String name;
	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
	private Set<City> cities ;
	
	public Country() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<City> getCities() {
		return cities;
	}
	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
	
	
	
	
	
	
}
