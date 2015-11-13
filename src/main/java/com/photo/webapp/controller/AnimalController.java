package com.photo.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/animal")
public class AnimalController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAnimal(){

        ModelAndView model = new ModelAndView("Animal");
        model.addObject("type", "Hund");
        model.addObject("name", "Bruno");
        model.addObject("breed", "Australian Shepherd");

        return model;
    }
}
