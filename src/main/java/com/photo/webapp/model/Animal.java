package com.photo.webapp.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(schema = "timoka")
@Access(AccessType.FIELD)
@NamedQueries({@NamedQuery(name = Animal.FIND_ALL, query = "from Animal p"),
               @NamedQuery(name = Animal.FIND_BY_NAME, query = "from Animal p where name = :p_name")})  // Damit
               // kann man eigene SQL-Queries zusammen bauen. Das hier ist nur ein sehr einfaches Beispiel, welches
               // auch sehr einfach mit Hibernate aufgerufen werden kann.
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {

    // Constant for named query
    public static final String FIND_ALL = "Animal.findAll";
    public static final String FIND_BY_NAME = "Animal.findByName";


    @Column(nullable = false)
    @Id
    @GeneratedValue
    @Basic(optional = false)
    private int animalId;

    @Column
    private String type; // PFERD, HUND, KATZE, MAUS

    @Column
    @Basic(optional = false)
    private String name;

    @Column
    private String breed;

    @Column
    private String color;

    @Column
    private int gender;

    @Column
    private Date birthdate;

    @Column
    private String photo;

    @ManyToOne
    private Owner owner;


/* ===============================
   ======  GETTER / SETTER =======
   =============================== */

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }


/* ===============================
   =====  EQUALS & HASHCODE ======
   =============================== */

    /**
     * This method needs to be checked! Probably isn't correct.
     * @return
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /**
     * This method needs to be checked! Probably isn't correct.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Animal other = (Animal) obj;
        if (animalId >= 0) {
            if (other.animalId >= 0)
                return false;
        } else if (!(animalId == other.animalId))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
