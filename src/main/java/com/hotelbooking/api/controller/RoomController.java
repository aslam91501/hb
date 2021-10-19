package com.hotelbooking.api.controller;

import java.util.List;

import com.hotelbooking.api.entity.RoomType;
import com.hotelbooking.api.entity.dto.RoomTypeResponse;
import com.hotelbooking.api.service.RoomTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/room")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {
    @Autowired
    private RoomTypeService roomTypeService;

    // Room type
    // public List<RoomTypeResponse> getRoomTypes(){
        
    // }
}
