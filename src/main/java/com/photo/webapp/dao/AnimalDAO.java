package com.photo.webapp.dao;

import com.photo.webapp.dao.util.AbstractGenericJpaDAO;
import com.photo.webapp.model.Animal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnimalDAO extends AbstractGenericJpaDAO<Animal, Integer> {

    public List<Animal> findAll(){
        return null;
    }

    @Override
    public Integer getPrimaryKey(Animal persistentObject) {
        return null;
    }
}
