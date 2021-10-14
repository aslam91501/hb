package com.hotelbooking.api.service;

import com.hotelbooking.api.entity.Room;

public interface RoomService extends Service<Room> {
    Room findByRoomNumber(int roomNo);
}
