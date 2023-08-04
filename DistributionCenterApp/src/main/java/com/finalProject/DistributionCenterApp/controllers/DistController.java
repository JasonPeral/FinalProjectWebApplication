package com.finalProject.DistributionCenterApp.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.finalProject.DistributionCenterApp.models.Item;
import com.finalProject.DistributionCenterApp.models.DistributionCenter;
import com.finalProject.DistributionCenterApp.repository.DistributionCenterRepository;
import com.finalProject.DistributionCenterApp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/distributionCenters")
public class DistController {
    @Autowired
    private DistributionCenterRepository distributionCenterRepository;
    @Autowired
    private ItemRepository itemRepository;

    //ADD
    @PostMapping("/{id}/items")
    public ResponseEntity<String> addItemToCenter(
            @PathVariable Long id,
            @RequestBody Item item
    ) {
        DistributionCenter center = distributionCenterRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Distribution Center not found with id: " + id));


        //item to the right distribution center
        item.setDistributionCenter(center);

        //saving
        itemRepository.save(item);
        //or log.info really could be interchangable reponseEntity.ok will show a message on the client side
        return ResponseEntity.ok("Item added to distribution center.");
    }

    //DELETE ITEM
    @DeleteMapping("/{id}/items/{itemId}")
    public ResponseEntity<String> deleteItemFromCenter(
            @PathVariable Long id,
            @PathVariable Long itemId
    ) {
        DistributionCenter center = distributionCenterRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Distribution Center not found with id: " + id));

        //logic loading

        return ResponseEntity.ok("Item deleted from distribution center.");
    }

    //All Distribution center
    @GetMapping
    public List<DistributionCenter> getAllCenters() {
        return distributionCenterRepository.findAll();
    }

    // Request item by brand and name
    @GetMapping("/items")
    public List<Item> getItemsByBrandAndName(
            @RequestParam String brand,
            @RequestParam String name
    ) {
        return itemRepository.findByBrandAndName(brand, name);
    }
}
