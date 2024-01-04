package com.app.service;

import com.app.entity.Rating;
import com.app.exception.ResourceNotFound;
import java.util.List;

public interface RatingService {

    public Rating save(Rating hotel);

    public Rating update(String hotelId, Rating hotel) throws ResourceNotFound;

    public Rating delete(String hotelId) throws ResourceNotFound;

    public Rating get(String hotelId) throws ResourceNotFound;

    public List<Rating> getAllHotelDetails();

}
