package com.odinson.springrestapi.service;

import com.odinson.springrestapi.entity.Dog;
import com.odinson.springrestapi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    DogRepository dogRepository;

    @Override
    public List<Dog> retrieveAllDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public List<String> retrieveDogBreed() {

        return dogRepository.getAllBreeds();
    }

    @Override
    public String retrieveDogBreedById(Long id) {

        return dogRepository.getBreedById(id);
    }

    @Override
    public List<String> retrieveDogNames() {
        return dogRepository.getDogNames();
    }
}
