package com.photo.webapp.controller;

import com.photo.webapp.entity.Animal;
import com.photo.webapp.services.AnimalService;
import com.photo.webapp.services.impl.AnimalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sun.util.calendar.Gregorian;
import sun.util.calendar.LocalGregorianCalendar;

import java.util.Date;

@Controller
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showAnimal(){

        ModelAndView model = new ModelAndView("Animal");

        Animal animal = new Animal();
        animal.setName("Mahal");
        animal.setBreed("");
        animal.setColor("");
        animal.setGender(1);
        animal.setBirthdate(new Date());
        animal.setPhoto("");


        animalService.createAnimal(animal);
        animalService.getAnimalByName("Mahal");
        model.addObject(animalService);

        return model;
    }
}
