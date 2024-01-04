package com.app.service;

import com.app.entity.Hotel;
import com.app.exception.ResourceNotFound;

import java.util.List;

public interface HotelService {

    public Hotel save(Hotel hotel);

    public Hotel update(String hotelId, Hotel hotel) throws ResourceNotFound;

    public Hotel delete(String hotelId) throws ResourceNotFound;

    public Hotel get(String hotelId) throws ResourceNotFound;

    public List<Hotel> getAllHotelDetails();

}
