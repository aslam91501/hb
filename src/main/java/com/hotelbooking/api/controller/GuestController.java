package com.hotelbooking.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.hotelbooking.api.config.MapStructMapper;
import com.hotelbooking.api.entity.Guest;
import com.hotelbooking.api.entity.dto.GuestCreateRequest;
import com.hotelbooking.api.entity.dto.GuestResponse;
import com.hotelbooking.api.entity.dto.GuestUpdateRequest;
import com.hotelbooking.api.service.GuestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/guest")
@CrossOrigin(origins = "http://localhost:4200")
public class GuestController {
    @Autowired
    private GuestService guestService;

    @Autowired 
    private MapStructMapper mapper;


    // GET All Guests

    @GetMapping
    public List<GuestResponse> getGuests(){
        List<Guest> guests = guestService.getAllGuests();
        return mapper.guest_GuestResponseList(guests);
    }


    // Create a guest

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GuestResponse createGuest(
        @Valid @RequestBody GuestCreateRequest guestCreateRequest
    ){
        Guest guest = mapper.guestCreateRequest_Guest(guestCreateRequest);
        
        guestService.createGuest(guest);

        Guest guestToReturn = guestService.findGuestByPhoneNumber(guest.getPhoneNumber());

        GuestResponse guestResponse = mapper.guest_GuestResponse(guestToReturn);
        
        return guestResponse;
    }



    @PutMapping
    public GuestResponse updateGuest(
       @Valid @RequestBody GuestUpdateRequest guestUpdateRequest
    ){
        Guest guestToUpdate = mapper.GuestUpdateRequest_Guest(guestUpdateRequest);
        
        guestService.updateGuest(guestToUpdate);

        GuestResponse guestResponse = mapper.guest_GuestResponse(guestService.findById(guestToUpdate.getId()));

        return guestResponse;
    }


    @DeleteMapping("/{id}")
    public void deleteGuest(@PathVariable("id") Long id){
        guestService.deleteGuest(id);
    }


    // Search a guest by phone number
    @GetMapping("/phone/{phoneNumber}")
    public GuestResponse searchGuest(@PathVariable String phoneNumber){
        Guest guest = guestService.findGuestByPhoneNumber(phoneNumber);
        return mapper.guest_GuestResponse(guest);
    }

    @GetMapping("/{id}")
    public GuestResponse getGuestById(@PathVariable("id") Long id){
        Guest guest = guestService.findById(id);

        return mapper.guest_GuestResponse(guest);
    }



}
