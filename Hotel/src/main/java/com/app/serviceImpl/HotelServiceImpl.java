package com.app.serviceImpl;

import com.app.entity.Hotel;
import com.app.exception.ResourceNotFound;
import com.app.repository.HotelRepository;
import com.app.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel save(Hotel hotel) {
       Hotel hotel1 =  hotelRepository.save(hotel);
        return hotel1;
    }

    @Override
    public Hotel update(String hotelId, Hotel hotel) throws ResourceNotFound {
        Hotel hotel1 = hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFound());
        return hotel1;
    }

    @Override
    public Hotel delete(String hotelId) throws ResourceNotFound {
        Hotel hotel1 = hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFound());
        if(hotel1!=null)
            hotelRepository.deleteById(hotelId);
        return hotel1;

    }

    @Override
    public Hotel get(String hotelId) throws ResourceNotFound {
        AtomicReference<Hotel> hotel1 = new AtomicReference<>(new Hotel());
                hotelRepository.findById(hotelId).ifPresent(hotel -> hotel1.set(hotel));
        return hotel1.get();
    }

    @Override
    public List<Hotel> getAllHotelDetails() {
        return hotelRepository.findAll();
    }
}
