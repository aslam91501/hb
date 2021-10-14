package com.hotelbooking.api.service.implementation;

import java.util.List;

import com.hotelbooking.api.entity.RoomFeature;
import com.hotelbooking.api.repository.RoomFeatureRepository;
import com.hotelbooking.api.service.RoomFeatureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomFeatureServiceImplementation implements RoomFeatureService{
    @Autowired
    private RoomFeatureRepository roomFeatureRepository;

    @Override
    public void create(RoomFeature roomFeature) {
        if(!roomFeatureRepository.existsByName(roomFeature.getName()))
            roomFeatureRepository.save(roomFeature);
    }

    @Override
    public RoomFeature get(Long id) {
        if(!roomFeatureRepository.existsById(id))
            return null;
        
        return roomFeatureRepository.findById(id).get();
    }

    @Override
    public List<RoomFeature> getAll() {
        return roomFeatureRepository.findAll();
    }

    @Override
    public void update(RoomFeature roomFeature) {
        if(roomFeatureRepository.existsById(roomFeature.getId())){
            RoomFeature _roomFeature = roomFeatureRepository.findById(roomFeature.getId()).get();

            if(roomFeature.getName() != null && roomFeature.getName() != _roomFeature.getName())
                _roomFeature.setName(roomFeature.getName());
            
            roomFeatureRepository.save(_roomFeature);
        }
    }

    @Override
    public void delete(Long id) {
        if(roomFeatureRepository.existsById(id))
            roomFeatureRepository.deleteById(id);        
    }

    @Override
    public RoomFeature getRoomFeatureByName(String name) {
        if(!roomFeatureRepository.existsByName(name))
            return null;
        
        return roomFeatureRepository.findByName(name);
    }

}
