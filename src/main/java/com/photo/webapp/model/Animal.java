package com.photo.webapp.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "timoka")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Access(AccessType.FIELD)
public class Animal {

    @Column(nullable = false)
    @Id
    @GeneratedValue
    private int animalId;

    @Column
    private String name;

    @Column
    private int gender;

    @Column
    private String photo;

    @ManyToOne
    private Owner owner;


    /*
    @Column
    private enum type {PFERD, HUND, KATZE, MAUS};

    private Owner ownerId;
    private Enum type;
    private Enum breed;
    private Date birthdate;
    private int gender;
    private Enum color;
    */

/* ===============================
   ======  GETTER / SETTER =======
   =============================== */

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
