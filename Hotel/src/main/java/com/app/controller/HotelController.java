package com.app.controller;

import com.app.entity.Hotel;
import com.app.exception.ResourceNotFound;
import com.app.serviceImpl.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelServiceImpl hotelService;

    @PostMapping("/add")
    public Hotel addHotel(@RequestBody Hotel hotel){
      return  hotelService.save(hotel);
    }

    @PutMapping("/update/{hotelId}")
    public Hotel update(@PathVariable String hotelId, @RequestBody Hotel hotel) throws ResourceNotFound{
       return hotelService.update(hotelId,hotel);
    }

    @DeleteMapping("/delete/{hotelId}")
    public Hotel delete(@PathVariable String hotelId) throws ResourceNotFound{
       return hotelService.delete(hotelId);
    }

    @GetMapping("/get/{hotelId}")
    public ResponseEntity<Hotel> get(@PathVariable String hotelId) throws ResourceNotFound{
        Hotel hotel=  hotelService.get(hotelId);
        return new ResponseEntity(hotel, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<Hotel> getAllHotelDetails(){
        return hotelService.getAllHotelDetails();
    }

}
