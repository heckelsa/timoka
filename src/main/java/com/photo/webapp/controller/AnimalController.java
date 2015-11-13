package com.photo.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/animal")
public class AnimalController {

    // @Autowired
    //private AnimalDAO animalDAO; // Das ist NICHT schön!, Da greifen wir jetzt ohne Business-Schicht von der DAO
    // direkt auf den View zu! Es gibt keinen Service-Layer. Nur in seltenen Fällen zu verwenden.

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAnimal(){

        ModelAndView model = new ModelAndView("Animal");
        model.addObject("type", "Hund");
        model.addObject("name", "Bruno");
        model.addObject("breed", "Australian Shepherd");

        return model;
    }
}
