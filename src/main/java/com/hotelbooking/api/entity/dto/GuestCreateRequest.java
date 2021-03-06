package com.hotelbooking.api.entity.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuestCreateRequest {
    private String firstName;

    @NotNull
    private String lastName;
    
    @NotNull
    private String phoneNumber;
}

