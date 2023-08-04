package com.finalProject.DistributionCenterApp.repository;

import com.finalProject.DistributionCenterApp.models.DistributionCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributionCenterRepository extends JpaRepository<DistributionCenter, Long> {
}
