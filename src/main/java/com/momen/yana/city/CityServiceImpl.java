package com.momen.yana.city;

import com.momen.yana.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository repository;

    @Override
    public City save(City city) {
        return repository.save(city);
    }

    @Override
    public City update(City city) {
        City savedBefore = findById(city.getId());
        savedBefore.setName(city.getName());
        return repository.save(savedBefore);
    }

    @Override
    public City findById(Long id) {
        Optional<City> cityOptional = repository.findById(id);
        if (cityOptional.isEmpty()) throw new NotFoundException("City Not Found");
        return cityOptional.get();
    }

    @Override
    public void delete(Long id) {
        repository.delete(findById(id));
    }

    @Override
    public List<City> findAll() {
        return repository.findAll();
    }
}
