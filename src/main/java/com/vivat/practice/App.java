package com.vivat.practice;

import com.vivat.practice.model.Movie;
import com.vivat.practice.model.Producer;
import com.vivat.practice.model.Score;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App {

    private static EntityManager entityManager;

    public static void main(String[] args) {

        //Let's create Entity Manager to do things with ORM
        EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("ProducerPersistenceUnit");

        entityManager = entityManagerFactory.createEntityManager();

        // Cool, lets create and save first movie
        entityManager.getTransaction().begin();
        Movie Aladin = new Movie("Aladin", 2019,Score.Fair);
        entityManager.persist(Aladin);
        entityManager.getTransaction().commit();


        // ok, one more
        entityManager.getTransaction().begin();
        Movie snatch = new Movie("Snatch", 2000,Score.Excellent);
        entityManager.persist(snatch);
        entityManager.getTransaction().commit();


        // lets find already created investigations by id, to make sure that we have them
        entityManager.getTransaction().begin();
        Movie movie = entityManager.find(Movie.class, Aladin.getId());

        System.out.println(movie.toString());


        // Lets create detective and assign investigations
        Producer ritchie = new Producer("Guy", "Ritchie");

        ritchie.addInvestigation(Aladin);
        ritchie.addInvestigation(snatch);
        entityManager.persist(ritchie);
        entityManager.getTransaction().commit();


        // Aaaand print him out to the console
        entityManager.getTransaction().begin();

        Producer foundProducer = entityManager.find(Producer.class, ritchie.getId());

        System.out.println("Ritchie movies:");
        foundProducer.getMovies()
            .forEach(x -> System.out.println(x.toString()));

        entityManager.getTransaction().commit();

    }


}
