package com.hotelbooking.api.service;

import java.util.List;

import com.hotelbooking.api.entity.RoomFeature;

public interface RoomService {
    
    // Room Feature Service Functions
    public RoomFeature createRoomFeature(RoomFeature roomFeature);
    public void updateRoomFeature(RoomFeature roomFeature);
    public List<RoomFeature> getAllRoomFeatures();
    public RoomFeature getRoomFeature(Long id);
    public void deleteRoomFeature(Long roomFeatureId);
}
