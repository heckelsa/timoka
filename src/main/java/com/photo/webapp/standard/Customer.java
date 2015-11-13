package com.photo.webapp.standard;

import com.photo.webapp.dao.OwnerDAO;
import com.photo.webapp.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
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

public class Customer {

    @Autowired
    private OwnerDAO ownerDAO;

    /**
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Owner> getAllCustomer() {
        return ownerDAO.findAll();
    }

    /**
     * @param ownerId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public Owner getCustomer(Integer ownerId) {
        return ownerDAO.findByPrimaryKey(ownerId);
    }

    /**
     * @param name
     * @return
     */
    public Integer createCustomer(String name) {
        Owner owner = new Owner();
        owner.setName(name);

        return create(owner);
    }

    /**
     * @param owner
     * @return
     */
    public Integer create(Owner owner) {
        return ownerDAO.create(owner);
    }

    /**
     * @param owner
     * @return
     */
    public Owner save(Owner owner) {
        ownerDAO.save(owner);
        return owner;
    }
}
