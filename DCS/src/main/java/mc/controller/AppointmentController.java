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
	@RequestMapping(value = "/selPatient",method = RequestMethod.GET)
	public String patientList( HttpServletRequest request, Model model) {
		
			model.addAttribute("patientList",paservice.findAll());
		
		return "/appointment/select_patient";
	}
	@RequestMapping(value = "/selectPatient",method = RequestMethod.GET)
	public String selectPatient( HttpServletRequest request, Model model) {
		if(request.getParameter("id")!=null) {
			int id = Integer.parseInt(request.getParameter("id"));
			HttpSession session = request.getSession();
			Patient patient = paservice.findOne(id);
			if(patient != null) {
				session.setAttribute("patient", patient);
			}
			
		}
		return "/appointment/patient_selected";
	}
	

}
