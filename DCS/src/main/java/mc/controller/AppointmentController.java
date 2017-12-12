package mc.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mc.model.Patient;
import mc.model.Appointment;
import mc.model.Doctor;
import mc.service.AppointmentService;
import mc.service.DoctorService;
import mc.service.PatientService;

@Controller
public class AppointmentController {
	@Autowired
	PatientService paservice;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private DoctorService docService;
	
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
	@RequestMapping(value = "/appointmentListByPatient", method = RequestMethod.GET)
    public String appointmentList(Model model, HttpServletRequest request) {
		;
		HttpSession session = request.getSession();
		Patient patient = (Patient)session.getAttribute("patient");
		model.addAttribute("appointments",appointmentService.listByPatientId(patient.getId()));
		return "/appointment/appointment_list";
    }
	
	@RequestMapping(value = "/makeAppointment", method = RequestMethod.GET)
    public String createAppointmentView(Model model, Integer uid) {
		//model.addAttribute("appointments",appointmentService.listByPatientId(uid));
		return "/appointment/make_appointment";
    }
	@RequestMapping(value = "/doctorByAppointment", method = RequestMethod.GET)
    public String getDoctorsList(Model model, String date, String time) {
		System.out.println("Date:" + date + " Time:" + time);
		List<Appointment> app = appointmentService.listByTimeAndDate(date, time);
		List<Doctor> doctors = new ArrayList<>();
		for(Appointment apptmnt: app) {
			doctors.add(apptmnt.getDoctor());
		}
		List<Doctor> allDocs = docService.findAll();
		allDocs.removeAll(doctors);
		model.addAttribute("doctors",allDocs);
		
		return "/appointment/doctor_list";
    }
	@RequestMapping(value = "/selectDoctor", method = RequestMethod.GET)
    public String selectDoctor(Model model, Integer id, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Doctor doctor = docService.findById(id);
		if(doctor != null) {
			session.setAttribute("app_doctor", doctor);
		}
		
		return "/appointment/doctor_selected";
    }
	@RequestMapping(value = "/saveAppointment", method = RequestMethod.GET)
    public String saveAppointment(Model model, HttpServletRequest request, String date, String time) {
		HttpSession session = request.getSession();
		Doctor doctor = (Doctor)session.getAttribute("app_doctor");
		Patient patient = (Patient)session.getAttribute("patient");
		String selected_date = date;
		String selected_time = time;
		Date formatted_date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
		formatted_date = format.parse(selected_date);
		}
		catch(Exception e) {
			
		}
		System.out.println("Time:" + selected_time);
		Appointment appointment = new Appointment();
		appointment.setAptmntDate(formatted_date);
		appointment.setAptmntTime(selected_time);
		appointment.setPatient(patient);
		appointment.setDoctor(doctor);
		
		appointmentService.save(appointment);
		model.addAttribute("patient_id",patient.getId());
		return "/appointment/created";
    }
	
	

}
