package com.hotelbooking.api.repository;

import com.hotelbooking.api.entity.Room;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    boolean existsByRoomNumber(int roomNumber);
    Room findByRoomNumber(int roomNumber);
}
