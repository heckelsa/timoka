package com.photo.webapp.dao;

import com.photo.webapp.dao.util.AbstractGenericJpaDAO;
import com.photo.webapp.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalDAO extends AbstractGenericJpaDAO<Animal, Integer> {

    /**
     * {@inheritDoc}
     * @see com.photo.webapp.dao.util.GenericDAO#getPrimaryKey(java.lang.Object)
     */
    @Override
    public Integer getPrimaryKey(Animal persistentObject) {
        return persistentObject.getAnimalId();
    }


    /**
     * Search all Animals.
     * @return all Animals
     */
    public List<Animal> findAll() {
        return getEntityManager().createNamedQuery(Animal.FIND_ALL, Animal.class).getResultList();
    }


    // #############################################

    //@Autowired
    //SessionFactory sessionFactory;
    @Autowired
    JpaTransactionManager transactionManager;
    //private DriverManagerDataSource dataSource;
    private DataSource dataSource;

    List<Animal> animals;

    public AnimalDAO(){
        animals = new ArrayList<Animal>();

    }


    public List<Animal> getAllAnimals(){
        //Session currentSession = sessionFactory.getCurrentSession();

        dataSource = transactionManager.getDataSource();
        try {
            Connection connection = dataSource.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Connection con = DriverManager.getConnection("jdbc:mysql://localhost/strutsdb", "root", "mukesh");



        return null;
    }


    public Animal getAnimal(int animalId){
        return null;
    }

    public void insertnimal(Animal animal){
        String sql = "INSERT INTO ANIMAL (NAME) VALUES (?)";
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
        }catch (Exception e){

        }
    }

    public void updateAnimal(Animal animal){
    }

    public void deleteAnimal(Animal animal){
    }
}
