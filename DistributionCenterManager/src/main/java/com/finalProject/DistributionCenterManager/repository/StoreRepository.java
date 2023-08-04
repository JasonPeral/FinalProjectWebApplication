package com.finalProject.DistributionCenterManager.repository;

import com.finalProject.DistributionCenterManager.models.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepository extends CrudRepository<Store,Long> {
    List<Store> findAll();
    Optional<Store> findById(Long id);

}
