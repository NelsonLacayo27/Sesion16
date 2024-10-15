package services;

import dao.CityDAO;
import models.City;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CityService {
    private CityDAO cityDAO = new CityDAO();

    public void registerCity(String name) {
        City city = new City();
        city.setName(name);
        city.setState(true); // Por defecto activa
        cityDAO.save(city);
    }

    public City getCityByName(String name) {
        return cityDAO.getCityByName(name);
    }

    public List<City> getAllCities() {
        return cityDAO.getAllCities();
    }

    public void updateCity(City city) {
        cityDAO.update(city);
    }

    public void deleteCity(City city) {
        cityDAO.delete(city);
    }
}
