package com.photo.webapp.services.impl;

import com.photo.webapp.dao.AnimalDAO;
import com.photo.webapp.entity.Animal;
import com.photo.webapp.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("animalService")
@Transactional
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalDAO animalDAO;

    /**
     *
     * @return
     */
    @Override
    public List<Animal> getAllAnimals(){
        return animalDAO.findAll();
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public List<Animal> getAnimalByName(String name){
        Animal animal = new Animal();
        animal.setName(name);
        return animalDAO.findByName(animal);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Animal getAnimal(int id){
        return animalDAO.findByPrimaryKey(id);
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public Integer createAnimal(Animal animal){
        return animalDAO.createAnimal(animal);
    }

}