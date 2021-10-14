package com.hotelbooking.api.service;

import java.util.List;

import com.hotelbooking.api.entity.Guest;


public interface GuestService extends Service<Guest>{
    Guest getByPhoneNumber(String phoneNumber);
}
