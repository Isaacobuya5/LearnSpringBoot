package com.isaac.learning.firstproject.controllers;

import com.isaac.learning.firstproject.model.Alien;
import com.isaac.learning.firstproject.repository.AlienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

    @Autowired
    AlienRepository alienRepo;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/addAlien")
    public String addAlien(Alien alien) {
        alienRepo.save(alien);
        return "home";
    }

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam("aid") String id){
        ModelAndView mv = new ModelAndView("showAlien");
        Alien alien = alienRepo.findById(Integer.parseInt(id)).orElse(new Alien());
        mv.addObject(alien);
        System.out.println(alienRepo.findByLang("java"));
        System.out.println(alienRepo.findByAidGreaterThan(Integer.parseInt(id)));
        System.out.println(alienRepo.findByLangSorted("java"));
        return mv;
    }
//    @RequestMapping("home")
//    public ModelAndView home(Alien alien) {
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("obj", alien);
//        mv.setViewName("home");
//        return mv;
//    }

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
