package com.hotelbooking.api.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuestResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
