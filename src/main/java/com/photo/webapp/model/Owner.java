package com.photo.webapp.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(schema = "timoka")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Access(AccessType.FIELD)
public class Owner {

    // Constant for named query
    public static final String FIND_ALL = "Owner.findAll";

    @Column(nullable = false)
    @Id
    private int ownerId;

    @Column
    private String name;

    @Column
    private String street;

    @Column
    private String city;

    @Column
    private int postcode;

    @Column
    private String country;

    @Column
    private int phone;

    @OneToMany(mappedBy = "owner")
    private Collection<Animal> animals = new ArrayList<Animal>();


/* ===============================
   ======  GETTER / SETTER =======
   =============================== */

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Collection<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Collection<Animal> animals) {
        this.animals = animals;
    }
}
