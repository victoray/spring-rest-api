package com.odinson.springrestapi.service;

import com.odinson.springrestapi.entity.Dog;

import java.util.List;

public interface DogService {

    List<Dog> retrieveAllDogs();
    List<String> retrieveDogBreed();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();


}
