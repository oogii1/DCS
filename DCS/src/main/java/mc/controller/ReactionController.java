package mc.controller;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mc.form.ReaForm;
import mc.model.Patient;

import mc.model.ReactionForm;

import mc.service.PatientService;
import mc.service.ReactionFormService;
import mc.service.UserService;

@Controller
public class ReactionController {
	
	@Autowired
    private PatientService patientService;
	@Autowired
    private ReactionFormService reactionFormService;
	@Autowired
    private UserService userService;
	
	@RequestMapping(value = "/reaction/save",method = RequestMethod.POST)
    public String save(Model model,@ModelAttribute ReaForm form) {
		
		Patient patient = patientService.findOne(form.getPatientId());
		if(null == patient) {
			model.addAttribute("error","Patient not exists");
			return "404";
		}
		ReactionForm reaction = new ReactionForm();
		reaction.setMedicineName(form.getMedicineName());
		reaction.setInsertDate(new Date());
		reaction.setPatient(patient);
		reaction.setReaction(form.getReaction());
		reactionFormService.save(reaction);
		//model.addAttribute("user",userService.findById(patient.getId()));
		//model.addAttribute("reactions",reactionFormService.listByPatientId(patient.getId()));
		return "redirect:/myReactions?uid="+patient.getId();
    }
	
	@RequestMapping(value = "/reaction/update",method = RequestMethod.POST)
    public String update(Model model,@ModelAttribute ReaForm form) {
		
		Patient patient = patientService.findOne(form.getPatientId());
		if(null != patient) {
			model.addAttribute("error","Patient not exists");
			return "add_reaction";
		}
		
		ReactionForm reaction = new ReactionForm();
		reaction.setMedicineName(form.getMedicineName());
		//reaction.setInsertDate(new Date());
		reaction.setPatient(patient);
		reaction.setReaction(form.getReaction());
		reaction.setId(form.getId());
		reactionFormService.save(reaction);
		return "add_reaction";//reg success page
    }
	
	@RequestMapping(value = "/myReactions", method = RequestMethod.GET)
	public String home(Model model, Integer uid){
		model.addAttribute("user",userService.findById(uid));
		model.addAttribute("reactions",reactionFormService.listByPatientId(uid));
		return "reaction";
	}

}
