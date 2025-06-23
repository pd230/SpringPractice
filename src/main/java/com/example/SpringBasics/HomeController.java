//- Implemented plain text response using @ResponseBody
//- Returned JSP view using simple @RequestMapping
//- Used HttpServletRequest, HttpServletResponse, RequestDispatcher, and HttpSession
//- Demonstrated @RequestParam usage with HttpSession
//- Added ModelAndView example for passing data to JSP
//- Included examples using Model and ModelMap
//- Set up basic controller with multiple request-handling strategies


package com.example.SpringBasics;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
//	1.to return plain text 
	
//	@RequestMapping("/")
//	@ResponseBody  - use when we want method only render plain text
//	public String Home() {	
//		System.out.println("heloo ");
//		return "Hello, World!";
//	}
	
	
//	2.to return JSP file
	
	@RequestMapping("/")
    public String Home() {
	     return "welcome";
    }
	
	
//	3.using Servlet methods
	
//	@RequestMapping("/add")
//	public String add(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		 int i = Integer.parseInt(req.getParameter("no1"));
//		 int j = Integer.parseInt(req.getParameter("no2"));
//		 int no3 = i + j;
//		 
////		 HttpSession session = req.getSession();
////		 session.setAttribute("no3", no3);
//		 
//		 RequestDispatcher dispatcher = req.getRequestDispatcher("result.jsp");
//		 req.setAttribute("no3", no3);
//		 try {
//			dispatcher.forward(req, res);
//		} catch (ServletException e) {
//			e.printStackTrace();
//		} 
//	     return "result";
//   }
	
//	4.Still using HttpSession session and using RequestParam
//	@RequestMapping("/add")
//	public String add(@RequestParam("no1") int i , @RequestParam("no2") int j, HttpSession session) {
//		int no3 = i + j;
//		session.setAttribute("no3", no3);
//		return "result";
//	}
	
//	5.using ModelAndView
//	@RequestMapping("/add")
//	public ModelAndView add(@RequestParam("no1")int i, @RequestParam("no2") int j, ModelAndView mav) {
////		ModelAndView mav = new ModelAndView();
//		mav.setViewName("result");
//		int k = i + j;
//		mav.addObject("no3",k);
//		return mav;
//	}
	
//	6.using model
//	@RequestMapping("/add")
//	public String add(@RequestParam("no1") int i , @RequestParam("no2")int j, Model m){
//		int k = i + j;
//		m.addAttribute("no3", k);
//		return "result";
//	}
	
//	7.using ModelMap
	@RequestMapping("/add")
	public String add(@RequestParam("no1") int i , @RequestParam("no2")int j, ModelMap m){
		int k = i + j;
		m.addAttribute("no3", k);
		return "result";
	}
}
