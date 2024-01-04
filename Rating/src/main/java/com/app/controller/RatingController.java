package com.app.controller;

import com.app.entity.Rating;
import com.app.exception.ResourceNotFound;
import com.app.serviceImpl.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    RatingServiceImpl ratingService;

    @PostMapping("/add")
    public Rating addHotel(@RequestBody Rating rating){
      return  ratingService.save(rating);
    }

    @PutMapping("/update/{hotelId}")
    public Rating update(@PathVariable String ratingId, @RequestBody Rating rating) throws ResourceNotFound{
       return ratingService.update(ratingId,rating);
    }

    @DeleteMapping("/delete/{hotelId}")
    public Rating delete(@PathVariable String ratingId) throws ResourceNotFound{
       return ratingService.delete(ratingId);
    }

    @GetMapping("/get/{hotelId}")
    public Rating get(@PathVariable String ratingId) throws ResourceNotFound{
        return ratingService.get(ratingId);
    }

    @GetMapping("/getAll")
    public List<Rating> getAllHotelDetails(){
        return ratingService.getAllHotelDetails();
    }

    @GetMapping("/rating/users/{userId}")
    public List<Rating> getRatingByUsers(@PathVariable String userId){
         return ratingService.getRatingByUser(userId);
    }

    @GetMapping("/rating/hotels/{hotelId}")
    public List<Rating> getRatingByHotel(@PathVariable int hotelId){
        return ratingService.getRatingByHotel(hotelId);
    }

}
