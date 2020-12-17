package com.example.demo.service;

import com.example.demo.model.City;
import com.example.demo.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService implements GeneralService<City> {
    @Autowired
    ICityRepository cityRepository;

    @Override
    public Iterable<City> findAll(){
        return cityRepository.findAll();
    }

    @Override
    public City save(City city){
        return  cityRepository.save(city);
    }

    @Override
    public Optional<City> findById(Long id){
        return cityRepository.findById(id);
    }

    @Override
    public void remove(Long id){
        cityRepository.deleteById(id);
    }

}
