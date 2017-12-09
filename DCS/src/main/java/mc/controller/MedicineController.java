package mc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mc.form.MedForm;
import mc.model.MedicineForm;
import mc.model.Patient;
import mc.service.MedicineFormService;
import mc.service.PatientService;

@Controller
public class MedicineController {
	
	@Autowired
    private PatientService patientService;
	@Autowired
    private MedicineFormService medicineFormService;
	
	@RequestMapping(value = "/medicine/save",method = RequestMethod.POST)
    public String reg(Model model,@ModelAttribute MedForm form) {
		
		Patient patient = patientService.findOne(form.getPatientId());
		if(null != patient) {
			model.addAttribute("error","Patient not exists");
			return "add_reaction";//test//test
		}
		MedicineForm medicineForm = new MedicineForm();
		medicineForm.setMedicineName(form.getMedicineName());
		medicineForm.setInsertDate(new Date());
		medicineForm.setDosage(form.getDosage());
		medicineForm.setPatient(patient);
		medicineForm.setStartDate(form.getStartDate());
		medicineFormService.save(medicineForm);
		return "add_medicine";//reg success page
    }

}
