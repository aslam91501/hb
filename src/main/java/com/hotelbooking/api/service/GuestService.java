package com.hotelbooking.api.service;

import com.hotelbooking.api.entity.Guest;


public interface GuestService extends Service<Guest>{
    Guest getByPhoneNumber(String phoneNumber);
}
