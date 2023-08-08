package com.finalProject.DistributionCenterApp.controllers;

import com.finalProject.DistributionCenterApp.models.DistributionCenter;
import com.finalProject.DistributionCenterApp.models.Item;
import com.finalProject.DistributionCenterApp.models.Item.Brand;
import com.finalProject.DistributionCenterApp.repository.DistributionCenterRepository;
import com.finalProject.DistributionCenterApp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private DistributionCenterRepository distributionCenterRepository;

    @GetMapping("/distribution")
    public String adminDistributionPage(Model model) {
        List<DistributionCenter> distributionCenters = distributionCenterRepository.findAll();
        model.addAttribute("distributionCenters", distributionCenters);

        double warehouseLat = 43.772094;
        double warehouseLon = -79.400279;
        model.addAttribute("warehouseLat", warehouseLat);
        model.addAttribute("warehouseLon", warehouseLon);

        return "admin/distribution";
    }

    // Mapping to handle item requests
    @PostMapping("/requestItem")
    public String requestItem(@RequestParam String brand, @RequestParam String name, Model model) {
        List<Item> requestedItems = requestItemsFromClosestCenter(brand, name);
        model.addAttribute("requestedItems", requestedItems);
        return "admin/requested_items";
    }


    //Method to use in requestItems method
    private List<Item> requestItemsFromClosestCenter(String brandStr, String name) {
        List<Item> requestedItems = new ArrayList<>();

        // Getting all distribution centers with available items
        List<DistributionCenter> centersWithAvailableItems = distributionCenterRepository.findCentersWithAvailableItems();

        //get distance and sort by distance closest -> far
        centersWithAvailableItems.sort(Comparator.comparingDouble(center ->
                calculateDistance(center.getLatitude(), center.getLongitude(), 43.772094, -79.400279)));

        //itemsfrom closest center
        if (!centersWithAvailableItems.isEmpty()) {
            DistributionCenter closestCenter = centersWithAvailableItems.get(0);
            Brand brand = Brand.valueOf(brandStr); // Convert String to Brand enum
            requestedItems = itemRepository.findByBrandAndNameAndDistributionCenter(brand, name, closestCenter);
        }

        return requestedItems;
    }

    // Method to calculate distance between two points using Haversine formula
    //https://stackoverflow.com/questions/27928/calculate-distance-between-two-latitude-longitude-points-haversine-formula
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371; // Radius of the earth in kilometers
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}