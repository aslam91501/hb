package com.hotelbooking.api.repository;

import com.hotelbooking.api.entity.RoomFeature;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomFeatureRepository extends JpaRepository<RoomFeature, Long>{
    boolean existsByName(String name);
    RoomFeature findByName(String name);
}
