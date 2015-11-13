package com.photo.webapp.dao;

import com.photo.webapp.dao.util.AbstractGenericJpaDAO;
import com.photo.webapp.model.Animal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnimalDAO extends AbstractGenericJpaDAO<Animal, Integer> {

    /**
     * {@inheritDoc}
     * @see com.photo.webapp.dao.util.GenericDAO#getPrimaryKey(java.lang.Object)
     */
    @Override
    public Integer getPrimaryKey(Animal persistentObject) {
        return persistentObject.getAnimalId();
    }


    /**
     *
     * @param name
     * @return
     */
    public List<Animal> findByName(String name){
        return getEntityManager().createNamedQuery(Animal.FIND_ALL, Animal.class).setParameter("name", name)
                       .getResultList();
    }

    /**
     *
     * @param breed
     * @return
     */
    public List<Animal> findByBreed(String breed){
        return getEntityManager().createNamedQuery(Animal.FIND_ALL, Animal.class).setParameter("breed", breed)
                       .getResultList();
    }


    /**
     * Search for all Animals.
     * @return a List of all Animals
     */
    public List<Animal> findAll() {
        return getEntityManager().createNamedQuery(Animal.FIND_ALL, Animal.class).getResultList();
    }
}
