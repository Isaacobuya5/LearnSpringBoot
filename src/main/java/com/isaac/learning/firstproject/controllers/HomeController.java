package com.isaac.learning.firstproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    @RequestMapping("home")
    public String home(HttpServletRequest req) {

        // getting the session object
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        System.out.println("Welcome " + name);
        /**
         * to pass this data to our jsp page, we have two choices
         * a. req.setAttribute()
         * b. req.session()
         *
         * We can also get hold of the response by passing HttpServletResponse as a paramter
         */
        // adding name to the session object
        session.setAttribute("name", name);
        return "home";
    }

}
