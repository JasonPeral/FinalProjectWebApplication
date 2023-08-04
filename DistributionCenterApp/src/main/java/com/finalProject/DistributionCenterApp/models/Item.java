package com.finalProject.DistributionCenterApp.models;

import com.finalProject.DistributionCenterApp.controllers.DistributionCenterController;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private int quantity; //side note quantity field

    @ManyToOne
    @JoinColumn(name = "distribution_center_id")
    private DistributionCenterController distributionCenter;

    public void setDistributionCenter(DistributionCenterController distributionCenter) {
        this.distributionCenter = distributionCenter;
    }

}
