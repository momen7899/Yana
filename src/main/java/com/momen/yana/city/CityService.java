package com.momen.yana.city;

import java.util.List;

public interface CityService {
    City save(City city);

    City update(City city);

    City findById(Long id);

    void delete(Long id);

    List<City> findAll();

}
