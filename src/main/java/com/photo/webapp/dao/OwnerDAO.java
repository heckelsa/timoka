package com.photo.webapp.dao;

import com.photo.webapp.dao.util.AbstractGenericJpaDAO;
import com.photo.webapp.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OwnerDAO extends AbstractGenericJpaDAO<Owner, Integer> {

    @Autowired
    private OwnerDAO ownerDAO;

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

    /**
     * @param ownerId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public Owner getOwnerById(Integer ownerId) {
        return ownerDAO.findByPrimaryKey(ownerId);
    }

    /**
     * @param name
     * @return
     */
    public Integer createOwner(String name) {
        Owner owner = new Owner();
        owner.setName(name);

        return create(owner);
    }
}
