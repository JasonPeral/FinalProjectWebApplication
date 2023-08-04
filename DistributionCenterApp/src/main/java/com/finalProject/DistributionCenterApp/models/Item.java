package com.finalProject.DistributionCenterApp.models;

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
    private DistributionCenter distributionCenter;

    public void setDistributionCenter(DistributionCenter distributionCenter) {
        this.distributionCenter = distributionCenter;
    }

}
