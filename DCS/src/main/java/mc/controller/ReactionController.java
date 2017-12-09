package mc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mc.form.ReactionForm;
import mc.model.Patient;
import mc.model.Setting;
import mc.model.User;
import mc.service.PatientService;
import mc.service.ReactionFormService;

@Controller
public class ReactionController {
	
	@Autowired
    private PatientService patientService;
	@Autowired
    private ReactionFormService reactionFormService;
	
	@RequestMapping(value = "/reaction/save",method = RequestMethod.POST)
    public String reg(Model model,@ModelAttribute ReactionForm form) {
		
		Patient patient = patientService.findOne(form.getPatientId());
		//TODO 
		return "welcome";//reg success page
    }

}
