package com.photo.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * The first sentence should be a meaningful summary of the class since it will be displayed as the class summary on the
 * Javadoc package page.
 * <p/>
 * Other notes, including guaranteed invariants, usage instructions and/or examples, reminders about desired
 * improvements, etc. should be described here.
 *
 * @author heckelsa
 * @version $Revision$ $Date$ $Author$
 */

@Controller
@RequestMapping("/animal")
public class AnimalController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAnimal(){

        ModelAndView model = new ModelAndView("Animal");
        model.addObject("name", "Bruno");

        return model;
    }
}
