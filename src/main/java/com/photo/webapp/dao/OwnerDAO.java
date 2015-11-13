package com.photo.webapp.dao;

import com.photo.webapp.dao.util.AbstractGenericJpaDAO;
import com.photo.webapp.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OwnerDAO extends AbstractGenericJpaDAO<Owner, Integer> {

    /**
     * {@inheritDoc}
     * @see com.photo.webapp.dao.util.GenericDAO#getPrimaryKey(java.lang.Object)
     */
    @Override
    public Integer getPrimaryKey(Owner persistentObject) {
        return persistentObject.getOwnerId();
    }

    /**
    * Search for all Animals.
    * @return a List of all Animals
    */
    public List<Owner> findAll() {
       return getEntityManager().createNamedQuery(Owner.FIND_ALL, Owner.class).getResultList();
    }
}
