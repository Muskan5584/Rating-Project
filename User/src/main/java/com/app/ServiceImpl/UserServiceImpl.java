package com.app.ServiceImpl;

import com.app.Entity.Hotel;
import com.app.Entity.Rating;
import com.app.Entity.User;
import com.app.Repository.UserRepo;
import com.app.Service.UserService;
import com.app.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User save(User user) {
        String id=UUID.randomUUID().toString();
        user.setId(id);
        return userRepo.save(user);
    }

    @Override
    public User update(User user, String id) throws ResourceNotFound {
        User user1=userRepo.findById(id).orElseThrow(()->new ResourceNotFound());
        if(user1!=null) {
           return  userRepo.save(user);
        }
        return user1;
    }

    @Override
    public User delete(String id) throws ResourceNotFound {
        User user1=userRepo.findById(id).orElseThrow(()->new ResourceNotFound());
        if(user1!=null) {
            userRepo.deleteById(id);
        }
        return user1;
    }

    @Override
    public User get(String id) throws ResourceNotFound {
        User user1=userRepo.findById(id).orElseThrow(()->new ResourceNotFound());
        if(user1!=null){
            Rating[] rating = restTemplate.getForObject("http://localhost:8093/rating/rating/users/"+id, Rating[].class);
            //("http://localhost:8092/get/"+);
             Arrays.stream(rating).map((rating1)->{
                Hotel hotel= restTemplate.getForObject("http://localhost:8092/hotel/get/"+rating1.getHotelId(), Hotel.class);
                rating1.setHotel(hotel);
                return rating1;
             }).collect(Collectors.toList());
            user1.setRatings(List.of(rating));
        }
        return user1;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();

    }
}
