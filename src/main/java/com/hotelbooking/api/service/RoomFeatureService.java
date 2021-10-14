package com.hotelbooking.api.service;

import com.hotelbooking.api.entity.RoomFeature;

public interface RoomFeatureService extends Service<RoomFeature> {
    RoomFeature getRoomFeatureByName(String name);
}
