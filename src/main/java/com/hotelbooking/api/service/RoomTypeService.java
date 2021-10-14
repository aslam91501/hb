package com.hotelbooking.api.service;

import com.hotelbooking.api.entity.RoomType;

public interface RoomTypeService extends Service<RoomType> {
    RoomType getRoomTypeByName(String name);
}
