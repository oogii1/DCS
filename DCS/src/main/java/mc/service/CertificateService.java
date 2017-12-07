package mc.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import mc.dao.CertificateDAO;
import mc.model.Certificate;

@Service
@Transactional
public class CertificateService {

	private final CertificateDAO certificateDAO;
	public CertificateService(CertificateDAO certificateDAO) {
		this.certificateDAO = certificateDAO;
	}
	public Certificate findById(Integer id){
		return certificateDAO.findOne(id);
	}
}
