/**
 * from youtube https://www.youtube.com/watch?v=Jl9OKQ92SJU
 */
package com.jah.springmvcboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jah.springmvcboot.model.Alien;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * The Controller servlet in the Spring Boot MVC
 */
@Controller
public class HomeController {
	
	
	// ModelAttribute is called before any Spring
	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("username", "Scooby");
		// used in the jsp page AlienResults as Welcome Back ${username}
	}

	
	@RequestMapping("/")
	public String home() {
		System.out.println("home page requested");
		return "index";
	}
	
	
	// add an alien, get data from client, RequestMapping supports both get and post requests
	@RequestMapping("addAlien")
	public String addAlien(@RequestParam("aid") int aid, @RequestParam("name") String name, Model m) {
		System.out.println("Add Alien called...");
		
		Alien al = new Alien();
		al.setAid(aid);
		al.setName(name);
		
		m.addAttribute("alien", al);
		
		return "AlienResults";
		
	}
	
	// using Post method
	@PostMapping("addAlien2")
	public String addAlien2(@RequestParam("aid") int aid, @RequestParam("name") String name, Model m) {
		System.out.println("Add Alien2 called using Post method...");
		
		Alien al = new Alien();
		al.setAid(aid);
		al.setName(name);
		
		m.addAttribute("alien", al);
		
		return "AlienResults";
		
	}
	
	
	@GetMapping("getAliens")
	public String getAliens(Model m) {
		System.out.println("Get Aliens called");
		
		List<Alien> aliens = Arrays.asList( new Alien(101, "Jah"), new Alien(200, "Yoda"));
		
		m.addAttribute("result", aliens);
		
		return "showAliens";
	}
	
	
	
	// -- Calculation add to numbers
	@RequestMapping("add")
	public ModelAndView add(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
		// using MVC pattern here:
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		
		int total = num1+num2;
		
		mv.addObject("total", total);
		
		return mv;
	}
	
	// alternate way to handle the customer data using Spring
//	public String add(@RequestParam("num1") int num1, @RequestParam("num2") int num2, HttpSession session)
//	{
//		int total = num1+num2;
//		
//		session.setAttribute("total", total);
//		
//		return "result.jsp";
//	}
	// this block works, using HttpServletRequest
//	public String add(HttpServletRequest req) {
//		
//		int num1 = Integer.parseInt( req.getParameter("num1"));
//		int num2 = Integer.parseInt( req.getParameter("num2"));
//		int total = num1+num2;
//		
//		HttpSession session = req.getSession();
//		session.setAttribute("total", total);
//		return "result.jsp";
//	}
}
