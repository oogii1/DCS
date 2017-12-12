package mc.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import mc.service.TreatmentService;
import mc.service.UserService;

@Controller
public class TreatmentController {
	
	@Autowired
    private PatientService patientService;
	@Autowired
    private MedicineFormService medicineFormService;
	@Autowired
    private UserService userService;
	@Autowired
    private TreatmentService tService;
	
	@RequestMapping(value = "/treatment/save",method = RequestMethod.POST)
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
	
	
	
	
	@RequestMapping(value = "/treatmentListByPatient", method = RequestMethod.GET)
    public String appointmentList(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Patient patient = (Patient)session.getAttribute("patient");
		System.out.println("Patient Id:" + patient.getId());
		model.addAttribute("treatments",tService.listByPatientId(patient.getId()));
		return "/treatment/treatment_list";
    }

}
