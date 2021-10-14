package com.hotelbooking.api.service.implementation;

import java.util.List;

import com.hotelbooking.api.entity.RoomType;
import com.hotelbooking.api.repository.RoomTypeRepository;
import com.hotelbooking.api.service.RoomTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomTypeServiceImplementation implements RoomTypeService {
    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public void create(RoomType roomType) {
        if(!roomTypeRepository.existsByRoomType(roomType.getRoomType())){
            roomTypeRepository.save(roomType);
        }
    }

    @Override
    public RoomType get(Long id) {
        if(roomTypeRepository.existsById(id)) return roomTypeRepository.findById(id).get();
        else return null;
    }

    @Override
    public List<RoomType> getAll() {
        return roomTypeRepository.findAll();
    }

    @Override
    public void update(RoomType roomType) {
        if(roomTypeRepository.existsById(roomType.getId())){
            RoomType _roomType = roomTypeRepository.getById(roomType.getId());

            if(roomType.getRoomType() != null && roomType.getRoomType() != _roomType.getRoomType())
                _roomType.setRoomType(roomType.getRoomType());
            
            roomTypeRepository.save(_roomType);
        }
    }

    @Override
    public void delete(Long id) {
        if(roomTypeRepository.existsById(id))
            roomTypeRepository.deleteById(id);
    }

    @Override
    public RoomType getRoomTypeByName(String name) {
        return roomTypeRepository.findByRoomType(name);
    }
    
}
