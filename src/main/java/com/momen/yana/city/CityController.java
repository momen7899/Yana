package com.momen.yana.city;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/city")
@AllArgsConstructor
public class CityController {

    private final CityService service;
    private final CityMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CityDTO cityDTO) {
        City city = mapper.toCity(cityDTO);
        service.save(city);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<CityDTO> update(@RequestBody CityDTO cityDTO) {
        City city = mapper.toCity(cityDTO);
        CityDTO savedBefore = mapper.toCityDTO(service.update(city));
        return ResponseEntity.ok(savedBefore);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll() {
        List<City> cityPage = service.findAll();

        return ResponseEntity.ok(mapper.toCityDTOs(cityPage));
    }

}
