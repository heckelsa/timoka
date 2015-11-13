package com.photo.webapp.dao;

import com.photo.webapp.dao.util.AbstractGenericJpaDAO;
import com.photo.webapp.entity.Animal;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

@Repository
public class AnimalDAO extends AbstractGenericJpaDAO<Animal, Integer> {

    /**
     * {@inheritDoc}
     *
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
    public List<Animal> findByName(Animal animal){
        String name = animal.getName();
        return getEntityManager().createNamedQuery(Animal.FIND_BY_NAME, Animal.class).setParameter("name", name)
                       .getResultList();
    }

    /**
     * Search for all Animals.
     *
     * @return a List of all Animals
     */
    public List<Animal> findAll() {
        return getEntityManager().createNamedQuery(Animal.FIND_ALL, Animal.class).getResultList();
    }

    /**
     * @param animalId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public Animal getAnimalById(Integer animalId) {
        return findByPrimaryKey(animalId);
    }

    /**
     *
     * @param animal
     * @return
     */
    public Integer createAnimal(Animal animal) {
        return create(animal);
    }
}