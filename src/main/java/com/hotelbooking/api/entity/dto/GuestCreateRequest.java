package com.hotelbooking.api.entity.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuestCreateRequest {
    @JsonProperty("firstName")
    private String firstName;

    @NotNull
    @JsonProperty("lastName")
    private String lastName;
    
    @NotNull
    @JsonProperty("phoneNumber")
    private String phoneNumber;
}

