package com.photo.webapp.standard;

import com.photo.webapp.dao.AnimalDAO;
import com.photo.webapp.model.Animal;
import com.photo.webapp.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
@Service("animalModel")
@Transactional
public class AnimalModel {

    @Autowired
    private AnimalDAO animalDAO;

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Animal> getAllAnimals(){
        return animalDAO.findAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Animal getAnimal(Integer animalId) {
        return animalDAO.findByPrimaryKey(animalId);
    }


    public Integer createAnimal(String name) {
        Animal animal = new Animal();
        animal.setName(name);

        return create(animal);
    }


    public Integer create(Animal animal) {
        return animalDAO.create(animal);
    }

    public Animal save(Animal animal) {
        animalDAO.save(animal);
        return animal;
    }


    public Animal addOwnerToAnimal(Integer animalId, Owner owner) {
        Animal animal = animalDAO.findByPrimaryKey(animalId);
        //animal.getOwner.add(owner);

        return save(animal);
   	}



}
