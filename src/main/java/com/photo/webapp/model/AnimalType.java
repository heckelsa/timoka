package com.photo.webapp.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(schema = "timoka")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Access(AccessType.FIELD)
public class AnimalType {

    @Column(nullable = false)
    @Id
    @GeneratedValue
    private int animalTypeId;

    @Column
    private String animalType;

/* ===============================
   ======  GETTER / SETTER =======
   =============================== */

    public int getAnimalTypeId() {
        return animalTypeId;
    }

    public void setAnimalTypeId(int animalTypeId) {
        this.animalTypeId = animalTypeId;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
}
