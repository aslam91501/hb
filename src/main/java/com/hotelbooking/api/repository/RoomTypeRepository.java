package com.hotelbooking.api.repository;

import com.hotelbooking.api.entity.RoomType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
    boolean existsByRoomType(String roomType);
    RoomType findByRoomType(String roomType);
}
