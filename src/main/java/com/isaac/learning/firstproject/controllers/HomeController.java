package com.isaac.learning.firstproject.controllers;

import com.isaac.learning.firstproject.model.Alien;
import com.isaac.learning.firstproject.repository.AlienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@RestController
public class HomeController {

    @Autowired
    AlienRepository alienRepo;

//    @RequestMapping("/")
//    public String home() {
//        return "home";
//    }
//
//    @RequestMapping("/addAlien")
//    public String addAlien(Alien alien) {
//        alienRepo.save(alien);
//        return "home";
//    }
//
//    @RequestMapping("/getAlien")
//    public ModelAndView getAlien(@RequestParam("aid") String id){
//        ModelAndView mv = new ModelAndView("showAlien");
//        Alien alien = alienRepo.findById(Integer.parseInt(id)).orElse(new Alien());
//        mv.addObject(alien);
//        System.out.println(alienRepo.findByLang("java"));
//        System.out.println(alienRepo.findByAidGreaterThan(Integer.parseInt(id)));
//        System.out.println(alienRepo.findByLangSorted("java"));
//        return mv;
//    }

//@RequestMapping(path="/aliens",produces = {"application/xml"})
//    @ResponseBody
//    public List<Alien> getAliens() {
//        return alienRepo.findAll();
//    }

    @GetMapping(path="/aliens")
    public List<Alien> getAliens() {
        return alienRepo.findAll();
    }

    @GetMapping("/aliens/{aid}")
    public Optional<Alien> fetchAlien(@PathVariable("aid") Integer aid) {
        return alienRepo.findById(aid);
    }

    @DeleteMapping("/alien/{aid}")
    public String deleteAlien(@PathVariable Integer aid) {
        // first get the alien with that id
        Alien alien = alienRepo.getOne(aid);
        alienRepo.delete(alien);
        return "deleted";
    }

    @PostMapping(path="/alien",consumes = {"application/json"})
    public Alien addAlien(@RequestBody Alien alien) {
        alienRepo.save(alien);
        return alien;
    }

    @PutMapping(path="/alien",consumes = {"application/json"})
    public Alien saveOrUpdate(@RequestBody Alien alien) {
        alienRepo.save(alien);
        return alien;
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

    /**
     * Avoid this class by using spring data rest
     * Mark repository class with
     * @RepositoryRestResource(collectionResourceRel="alien",path="alien")
     *
     */

}
