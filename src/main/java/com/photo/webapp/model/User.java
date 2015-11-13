package com.photo.webapp.model;

import org.hibernate.annotations.Type;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(schema = "myschema")
@Access(AccessType.FIELD)
@NamedQueries({@NamedQuery(name = User.FIND_ALL, query = "from User p"),
                      @NamedQuery(name = User.FIND_BY_NAME, query = "from User p where name = :p_name")})
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    /**
     *
     */
    private static final long serialVersionUID = -7286807458462446188L;

    // Constant for Named Query
    public static final String FIND_ALL = "User.findAll";
    public static final String FIND_BY_NAME = "User.findByName";

    @Basic(optional = false)
    @Column(nullable = false)
    private String name;

    @Basic
    private String firstname;

    @Basic(optional = false)
    @Column(nullable = false)
    @Type(type = "encryptedString")
    private String password;

    @Basic(optional = false)
    @Column(nullable = false)
    private String email;

    @Basic
    private boolean active;

/* ===============================
   ======  GETTER / SETTER =======
   =============================== */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


/* ===============================
   =====  EQUALS & HASHCODE ======
   =============================== */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (firstname == null) {
            if (other.firstname != null)
                return false;
        } else if (!firstname.equals(other.firstname))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
