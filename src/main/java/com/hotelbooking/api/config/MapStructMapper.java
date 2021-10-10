package com.hotelbooking.api.config;

import java.util.List;

import com.hotelbooking.api.entity.Guest;
import com.hotelbooking.api.entity.dto.GuestCreateRequest;
import com.hotelbooking.api.entity.dto.GuestResponse;

import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring"
)
public interface MapStructMapper {
    Guest guestCreateRequest_Guest(GuestCreateRequest guestCreateRequest);
    GuestResponse guest_GuestResponse(Guest guest);
    List<GuestResponse> guest_GuestResponseList(List<Guest> guests);
}
