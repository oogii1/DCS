package mc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mc.model.Patient;
import mc.service.PatientService;

@Controller
public class AppointmentController {
	@Autowired
	PatientService paservice;
	
	@RequestMapping(value = "/createAppointment",method = RequestMethod.GET)
	public String createAppointment( HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if(session.getAttribute("patient")!=null && session.getAttribute("patient") instanceof Patient) {
			model.addAttribute("patient",session.getAttribute("patient"));
		}
		else {
			System.out.println("adasdasdasdasd");
			model.addAttribute("patientList",paservice.findAll());
		}
		return "/appointment/create_appointment";
	}

}
