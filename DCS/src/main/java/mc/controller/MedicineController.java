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
import mc.service.UserService;

@Controller
public class MedicineController {
	
	@Autowired
    private PatientService patientService;
	@Autowired
    private MedicineFormService medicineFormService;
	@Autowired
    private UserService userService;
	
	@RequestMapping(value = "/medicine/save",method = RequestMethod.POST)
    public String save(Model model,@ModelAttribute MedForm medForm) {
		
		Patient patient = patientService.findOne(medForm.getPatientId());
		if(null == patient) {
			model.addAttribute("error","Patient not exists");
			return "404";
		}
		MedicineForm medicineForm = new MedicineForm();
		medicineForm.setMedicineName(medForm.getMedicineName());
		medicineForm.setInsertDate(new Date());
		medicineForm.setDosage(medForm.getDosage());
		medicineForm.setPatient(patient);
		medicineForm.setStartDate(medForm.getStartDate());
		medicineFormService.save(medicineForm);
		
		return "redirect:/myMedHistory?uid="+patient.getId();
    }
	
	@RequestMapping(value = "/medicine/update",method = RequestMethod.POST)
    public String update(Model model,@ModelAttribute MedForm medForm) {
		
		Patient patient = patientService.findOne(medForm.getPatientId());
		if(null == patient) {
			model.addAttribute("error","Patient not exists");
			return "404";
		}
		MedicineForm medicineForm = medicineFormService.findRf(medForm.getId());
		if(null == medicineForm) {
			model.addAttribute("error","ReactionForm not exists");
			return "404";
		}
		medicineForm.setMedicineName(medForm.getMedicineName());
		medicineForm.setPatient(patient);
		medicineForm.setDosage(medForm.getDosage());
		medicineForm.setStartDate(medForm.getStartDate());
		medicineForm.setId(medForm.getId());
		medicineFormService.save(medicineForm);
		
		return "redirect:/myMedHistory?uid="+patient.getId();
    }
	@RequestMapping(value = "/medicine/del",method = RequestMethod.POST)
    public String delete(Model model,int patientId,int recId) {
		Patient patient = patientService.findOne(patientId);
		if(null == patient) {
			model.addAttribute("error","Patient not exists");
			return "404";
		}
		MedicineForm med = medicineFormService.findRf(recId);
		if(null == med) {
			model.addAttribute("error","MedicineForm not exists");
			return "404";
		}
		medicineFormService.delete(recId);
		return "redirect:/myMedHistory?uid="+patient.getId();
    }
	
	@RequestMapping(value = "/myMedHistory", method = RequestMethod.GET)
	public String home(Model model, Integer uid){
		model.addAttribute("user",userService.findById(uid));
		model.addAttribute("medicines",medicineFormService.listByPatientId(uid));
		return "medicine";
	}

}
