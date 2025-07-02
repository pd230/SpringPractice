//A
//- Implemented plain text response using @ResponseBody
//- Returned JSP view using simple @RequestMapping
//- Used HttpServletRequest, HttpServletResponse, RequestDispatcher, and HttpSession
//- Demonstrated @RequestParam usage with HttpSession
//- Added ModelAndView example for passing data to JSP
//- Included examples using Model and ModelMap
//- Set up basic controller with multiple request-handling strategies

//B - @ModelAttribute

//C - Mapping Request Types
//      -GetMapping -PostMapping -RequestMapping
//


package com.example.SpringBasics;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.SpringBasics.Repo.UserHibRepo;
import com.example.SpringBasics.model.User;
import com.example.SpringBasics.model.UserHib;

import jakarta.servlet.*;

@Controller
public class HomeController {
	
	@Autowired
	UserHibRepo repo;
	
//------------------------------------------------ A ------------------------------------------------
//	1.to return plain text 
	
//	@RequestMapping("/")
//	@ResponseBody  - use when we want method only render plain text
//	public String Home() {	
//		System.out.println("heloo ");
//		return "Hello, World!";
//	}
	
	
//	2.to return JSP file
	
//	@RequestMapping("/")
//    public String Home() {
//	     return "welcome";
//    }
	
	
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
////	ModelAndView mav = new ModelAndView();(or)
////	ModelAndView mav = new ModelAndView;(or)
//		mav.setViewName("result");
//		int k = i + j;
//		mav.addObject("no3",k);
//		return mav;
//	}
	
//	6.using model - because ModelAndView returns object of ModelAndView which we dont want
//	@RequestMapping("/add")
//	public String add(@RequestParam("no1") int i , @RequestParam("no2")int j, Model m){
//		int k = i + j;
//		m.addAttribute("no3", k);
//		return "result";
//	}
	
////	7.using ModelMap
//	@RequestMapping("/add")
//	public String add(@RequestParam("no1") int i , @RequestParam("no2")int j, ModelMap m){
//		int k = i + j;
//		m.addAttribute("no3", k);
//		return "result";
//	}
	
	
//-------------------------B----------------@ModelAttribute---------------------B--------------------
	
//	1. working with login page 
	@RequestMapping("/")
	public String getLogin(){
		return "Login";
	}
	
	
//	2.using @RequestParam - one by one passing data to LoginResult
//	@RequestMapping("/addUser")
//	public String addUser(@RequestParam("uid")int id,@RequestParam("uname")String uname, Model m) {
//		User user = new User();
//		user.setUid(id);
//		user.setUname(uname);
//		m.addAttribute(user);
//		return "LoginResult";
//	}
	
//	3 using ModelAttribute with adding data in the Model manually
//	@RequestMapping("/addUser")
//	public String addUser(@ModelAttribute User user, Model m) {
//		m.addAttribute("user", user);
//		return "LoginResult";
//	}
	
//	4 @ModelAttribute is responsible to add data in the Model , don't need add it manually
//	@RequestMapping("/addUser")
//	public String addUser(@ModelAttribute User user) {
//		return "LoginResult";
//	}
	
//	5 @ModelAttribute also accept the parameter , if we want to use different name for property. 
//	  use that parameter name in jsp also
//	@RequestMapping("/addUser")
//	public String addUser(@ModelAttribute("u") User user) {
//		return "LoginResult";
//	}
	
//	 7 -------ModelAttribute on method level : all controllers which initialize after this method can
//	          user name parameter will get the value of name as Queen , if multiple methods calling
//	          LoginResult. like following methods addUser & addNum both are calling LoginResult if assign
//	          name in only one method than when it called by another method it will not render the same name 
	@ModelAttribute 
//	public void addName(Model m) {
//		m.addAttribute("name", "Queen");
//	}

//	6 code will work without passing @ModelAttribute . we can call it by "user" attribute in jsp
//	@RequestMapping("/addUser")
//	public String addUser(User u) {
//		return "LoginResult";
//	}
	
//	@RequestMapping("/add")
//	public String addNum(@RequestParam("no1") int i, @RequestParam("no2") int j, Model m) {
//		int k = i + j;
//		m.addAttribute("no3", k);
//		return "LoginResult";
//	}
//	

	
//	------------------C----------------------Mapping Request Types-----------------C---------------------
	
//	RequestMapping - works with post and get both type of requests
//	@RequestMapping("/addUser")
//	public String getUser() {
//		return "LoginResult";
//	}
	
//	PostMapping - works only with post requests
//	@PostMapping("/addUser")
//	public String postUser(@ModelAttribute User u ) {
//		return "LoginResult";
//	}
	
//	GetMapping - works only with Get Request
//	@GetMapping("/getAllUsers/{id}")
//	public String getAllUsers(Model m, @PathVariable("id") int id) {
//		List<User> user = Arrays.asList(new User(102,"PD"), new User(103, "RD"));
//		List<User> list = user.stream().filter(a -> a.getUid() == id).toList();
//		m.addAttribute("user", list);
//		return "DisplayAll";
//	}
	
//	HIbernate , JPA
	
	@RequestMapping("/getUsers")
	public String getAll(Model m) {
		m.addAttribute("AllUsers", repo.findAll());
		return "DisplayAll";
	}
	
	@RequestMapping("/getuser")
	public String getUser(Model m, @RequestParam int uid) {
		Optional<UserHib> user = repo.findById(uid);
		
		if(!user.isEmpty()) {
		m.addAttribute("singleUser", user.get());
		}else {
			m.addAttribute("notFoundMessage",
                    "No user found for id " + uid);
		}
		return "DisplayAll";
	}
	
	@RequestMapping("/addUser")
	public String addUser(@ModelAttribute UserHib u){
		repo.save(u);
		return "LoginResult";
	}
	
	
}
