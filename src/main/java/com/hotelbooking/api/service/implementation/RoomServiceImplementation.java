package com.hotelbooking.api.service.implementation;

import java.util.List;

import com.hotelbooking.api.entity.Room;
import com.hotelbooking.api.repository.RoomRepository;
import com.hotelbooking.api.service.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImplementation  implements RoomService{
    @Autowired
    private RoomRepository roomRepository;
    
    @Override
    public void create(Room room) {
        if(!roomRepository.existsByRoomNumber(room.getRoomNumber()))
            roomRepository.save(room);
    }

    @Override
    public Room get(Long id) {
        if(!roomRepository.existsById(id))
            return null;
        
        return roomRepository.findById(id).get();
    }

    @Override
    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    @Override
    public void update(Room room) {
        if(roomRepository.existsById(room.getId())){
            Room _room = roomRepository.findById(room.getId()).get();

            if(room.getPrice() != _room.getPrice())
                _room.setPrice(room.getPrice());
            
            if(room.getRoomNumber() != _room.getRoomNumber())
                _room.setRoomNumber(room.getRoomNumber());
            
            if(room.getRoomType() != null && _room.getRoomType() != room.getRoomType())
                _room.setRoomType(room.getRoomType());
            
            if(room.getStatus() != null && room.getStatus() != _room.getStatus())
                _room.setStatus(room.getStatus());
            
            roomRepository.save(_room);
        }
    }

    @Override
    public void delete(Long id) {
        if(roomRepository.existsById(id))
            roomRepository.deleteById(id);
    }

    @Override
    public Room findByRoomNumber(int roomNo) {
        if(roomRepository.existsByRoomNumber(roomNo))
            return roomRepository.findByRoomNumber(roomNo);
        else
            return null;
    }
    
}
