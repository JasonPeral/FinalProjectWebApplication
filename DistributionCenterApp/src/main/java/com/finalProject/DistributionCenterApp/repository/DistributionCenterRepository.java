package com.finalProject.DistributionCenterApp.repository;

import com.finalProject.DistributionCenterApp.controllers.DistributionCenterController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributionCenterRepository extends JpaRepository<DistributionCenterController, Long> {
}
