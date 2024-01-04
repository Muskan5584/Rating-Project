package com.app.response;

import com.app.Entity.Rating;
import jakarta.persistence.Transient;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class UserResponseApi {
    String id;
    String name;
    String email;
    String about;
    List<Rating> ratings;
}
