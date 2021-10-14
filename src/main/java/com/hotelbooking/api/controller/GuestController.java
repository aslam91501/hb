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
   
}
