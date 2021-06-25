package org.example.controllers;

import org.apache.log4j.Logger;
import org.example.services.RegisService;
import org.example.entity.RegisForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/newuser")
public class RegistrationController {

    private final Logger logger = Logger.getLogger(LoginController.class);
    private RegisService regisService;



    @Autowired
    public RegistrationController(RegisService regisService) {
        this.regisService = regisService;
    }


    @GetMapping
    public String error(Model model){
        logger.info("GET /newuser returns registration_page.html");
        model.addAttribute("regisForm", new RegisForm());
        return "registration_page";
    }

    @PostMapping
    public String connector(Model model){
        logger.info("POST /newuser returns registration_page.html");
        model.addAttribute("regisForm", new RegisForm());
        return "registration_page";
    }

    @PostMapping("/registration")
    public String addnewUser(RegisForm regisForm) {
        if(regisForm.getPassword_first().equals(regisForm.getPassword_second())){
            regisService.saveUser(regisForm);
            logger.info("Users:" + regisService.getAllUsers());

            return "redirect:/login";
        }else {
            return "redirect:/newuser";
        }



    }



}