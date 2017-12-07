package mc.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import mc.dao.SettingDAO;
import mc.model.Setting;

@Service
@Transactional
public class SettingService {

	private final SettingDAO settingDAO;
	public SettingService(SettingDAO settingDAO) {
		this.settingDAO = settingDAO;
	}
	public Setting findById(Integer id){
		return settingDAO.findOne(id);
	}
	
	public Setting findByTypeAndKey(String type, String key) {
		return settingDAO.findByTypeAndVarKey(type,key);
	}
}
