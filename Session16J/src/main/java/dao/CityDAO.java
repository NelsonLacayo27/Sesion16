package dao;

import models.City;

import javax.persistence.*;
import java.util.List;

public class CityDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public void save(City city) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(city);
        em.getTransaction().commit();
        em.close();
    }

    public City getCityByName(String name) {
        EntityManager em = emf.createEntityManager();
        City city = em.find(City.class, name);
        em.close();
        return city;
    }

    public List<City> getAllCities() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<City> query = em.createQuery("SELECT c FROM City c", City.class);
        List<City> cities = query.getResultList();
        em.close();
        return cities;
    }

    public void update(City city) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(city);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(City city) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(city) ? city : em.merge(city));
        em.getTransaction().commit();
        em.close();
    }
}
