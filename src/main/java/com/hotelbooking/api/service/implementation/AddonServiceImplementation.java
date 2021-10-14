package com.hotelbooking.api.service.implementation;

import java.util.List;

import com.hotelbooking.api.entity.Addon;
import com.hotelbooking.api.repository.AddonRepository;
import com.hotelbooking.api.service.AddonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddonServiceImplementation implements AddonService{
    @Autowired
    private AddonRepository addonRepository;

    @Override
    public void create(Addon addon) {
       if(!addonRepository.existsByName(addon.getName())) 
            addonRepository.save(addon);
    }

    @Override
    public Addon get(Long id) {
        if(!addonRepository.existsById(id))
            return null;
        
        return addonRepository.findById(id).get();
    }

    @Override
    public List<Addon> getAll() {
        return addonRepository.findAll();
    }

    @Override
    public void update(Addon addon) {
        if(addonRepository.existsById(addon.getId())){
            Addon _addon = addonRepository.findById(addon.getId()).get();
            
            if(addon.getName() != null && addon.getName() != _addon.getName())
                _addon.setName(addon.getName());
            
            addonRepository.save(_addon);
        }
    }

    @Override
    public void delete(Long id) {
        if(addonRepository.existsById(id))
            addonRepository.deleteById(id);
    }

    @Override
    public Addon getAddonByName(String name) {
        if(!addonRepository.existsByName(name))
            return null;
        
        return addonRepository.findByName(name);
    }
    
}
