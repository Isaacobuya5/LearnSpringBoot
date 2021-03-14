package com.isaac.learning.firstproject.controllers;

import com.isaac.learning.firstproject.Alien;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    @RequestMapping("home")
    public ModelAndView home(Alien alien) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("obj", alien);
        mv.setViewName("home");
        return mv;
    }

    // passing a single value
//    @RequestMapping("home")
//    public ModelAndView home(@RequestParam("name") String myName) {
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("name", myName);
//        mv.setViewName("home");
//        return mv;
//    }

//    @RequestMapping("home")
//    public String home(@RequestParam("name") String myName, HttpSession session) {
//        // HttpSession gets injected automatically via dependency injection
//        System.out.println("Welcome " + myName);
//        // adding name to the session object
//        session.setAttribute("name", myName);
//        /**
//         * All these goes to RequestDispatcher object
//         * it needs two things i.e. view and data
//         */
//        return "home";
//    }

}
