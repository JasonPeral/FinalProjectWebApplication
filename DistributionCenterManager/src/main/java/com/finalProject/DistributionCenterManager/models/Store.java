package com.finalProject.DistributionCenterManager.models;


import com.finalProject.DistributionCenterManager.models.enums.Brand;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "name cannot be blank")
    private String name;
    @NotBlank(message = "Location can not be blank")
    private String location;
    @Min(2021)
    private int yearOfCreation;
    private Brand brand;
}
