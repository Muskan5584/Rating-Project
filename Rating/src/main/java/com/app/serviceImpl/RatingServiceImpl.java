package com.app.serviceImpl;

import com.app.entity.Rating;
import com.app.exception.ResourceNotFound;
import com.app.repository.RatingRepository;
import com.app.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    RatingRepository ratingRepository;

    @Override
    public Rating save(Rating hotel) {
        Rating hotel1 =  ratingRepository.save(hotel);
        return hotel1;
    }

    @Override
    public Rating update(String ratingId, Rating rating) throws ResourceNotFound {
        Rating rating1 = ratingRepository.findById(ratingId).orElseThrow(()->new ResourceNotFound());
        return rating1;
    }

    @Override
    public Rating delete(String ratingId) throws ResourceNotFound {
        Rating rating1 = ratingRepository.findById(ratingId).orElseThrow(()->new ResourceNotFound());
        if(rating1!=null)
            ratingRepository.deleteById(ratingId);
        return rating1;

    }

    @Override
    public Rating get(String ratingId) throws ResourceNotFound {
        Rating rating1 = ratingRepository.findById(ratingId).orElseThrow(()->new ResourceNotFound());
        return rating1;
    }

    @Override
    public List<Rating> getAllHotelDetails() {
        return ratingRepository.findAll();
    }


    public List<Rating> getRatingByUser(String userId){
       return ratingRepository.findByUserId(userId);
    }

    public List<Rating> getRatingByHotel(int hotelId){
        return ratingRepository.findByHotelId(hotelId);
    }
}
