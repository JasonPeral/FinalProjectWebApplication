package com.finalProject.DistributionCenterManager.controllers;


import com.finalProject.DistributionCenterManager.models.Store;
import com.finalProject.DistributionCenterManager.repository.StoreRepository;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/store")
public class StoreController {

    @Autowired
    StoreRepository storeRepository;

    @GetMapping
    public ResponseEntity<List<Store>> getAllStores(){
        List<Store> stores = storeRepository.findAll();

        return new ResponseEntity<>(stores, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Store> createStore(@RequestBody @Valid Store store, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Store newStore = storeRepository.save(store);
        return new ResponseEntity<>(newStore, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Store> updateStore(@RequestBody @Valid Store store, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Store> updateStore = storeRepository.findById(store.getId());
        if (updateStore.isPresent()){
            updateStore.get().setName(store.getName());
            updateStore.get().setLocation(store.getLocation());
            updateStore.get().setYearOfCreation(store.getYearOfCreation());
            updateStore.get().setBrand(store.getBrand());
            storeRepository.save(updateStore.get());
            return new ResponseEntity<>(updateStore.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStore(@PathVariable Long id){

        storeRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}
