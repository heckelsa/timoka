package com.photo.webapp.services;

import com.photo.webapp.entity.Animal;

import java.util.Date;
import java.util.List;


public interface AnimalService {

    /**
     * @return
     */
    public List<Animal> getAllAnimals();

    /**
     *
     * @param name
     * @return
     */
    public List<Animal> getAnimalByName(String name);

    /**
     * @param id
     * @return
     */
    public Animal getAnimal(int id);

    /**
     *
     * @param name
     * @return
     */
    public Integer createAnimal(Animal animal);

}
