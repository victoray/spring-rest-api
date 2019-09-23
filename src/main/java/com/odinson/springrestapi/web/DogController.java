package com.odinson.springrestapi.web;

import com.odinson.springrestapi.entity.Dog;
import com.odinson.springrestapi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogController {

    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getDogs(){
        List<Dog> dogs = dogService.retrieveAllDogs();
        return new ResponseEntity<>(dogs, HttpStatus.OK);
    }

    @GetMapping("/breeds")
    public ResponseEntity<List<String>> getDogBreeds(){
        List<String> breeds = dogService.retrieveDogBreed();
        return new ResponseEntity<>(breeds, HttpStatus.OK);
    }

    @GetMapping("/breedsbyid/{id}")
    public ResponseEntity<String> getDogBreedsById(@PathVariable Long id){
        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> getDogNames(){
        List<String> breeds = dogService.retrieveDogNames();
        return new ResponseEntity<>(breeds, HttpStatus.OK);
    }

    @ExceptionHandler
    public String error(){
        return "errorrs o";
    }

}
