package com.hotelbooking.api.config;

import java.util.ArrayList;
import java.util.List;

import com.hotelbooking.api.entity.Guest;
import com.hotelbooking.api.entity.dto.GuestCreateRequest;
import com.hotelbooking.api.entity.dto.GuestResponse;
import com.hotelbooking.api.entity.dto.GuestUpdateRequest;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class MapStructMapperImplementation implements MapStructMapper {

    @Override
    public Guest guestCreateRequest_Guest(GuestCreateRequest guestCreateRequest) {
        if(guestCreateRequest == null) 
            return null;
        
        Guest guest = new Guest();
        guest.setFirstName(guestCreateRequest.getFirstName());
        guest.setLastName(guestCreateRequest.getLastName());
        guest.setPhoneNumber(guestCreateRequest.getPhoneNumber());

        return guest;
    }

    @Override
    public GuestResponse guest_GuestResponse(Guest guest) {
        if(guest == null)
            return null;
        
        GuestResponse guestResponse = new GuestResponse();
        guestResponse.setId(guest.getId());
        guestResponse.setFirstName(guest.getFirstName());
        guestResponse.setLastName(guest.getLastName());
        guestResponse.setPhoneNumber(guest.getPhoneNumber());

        return guestResponse;
    }

    @Override
    public List<GuestResponse> guest_GuestResponseList(List<Guest> guests) {
        List<GuestResponse> guestResponseDTOs = new ArrayList<GuestResponse>();
        
        for(Guest guest : guests){
            GuestResponse guestResponse = this.guest_GuestResponse(guest);
            guestResponseDTOs.add(guestResponse);
        }

        return guestResponseDTOs;
    }

    @Override
    public Guest GuestUpdateRequest_Guest(GuestUpdateRequest guestUpdateRequest) {
        Guest guest = new Guest();
        
        guest.setId(guestUpdateRequest.getId());

        if(guestUpdateRequest.getFirstName() != null) guest.setFirstName(guestUpdateRequest.getFirstName());
        if(guestUpdateRequest.getLastName() != null) guest.setLastName(guestUpdateRequest.getLastName());
        if(guestUpdateRequest.getPhoneNumber() != null) guest.setPhoneNumber(guestUpdateRequest.getPhoneNumber());

        return guest;
    }
    
}
