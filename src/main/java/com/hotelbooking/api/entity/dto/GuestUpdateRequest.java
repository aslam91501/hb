package com.hotelbooking.api.entity.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuestUpdateRequest {
    @NotNull
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
