package com.app.Entity;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rating {
    int ratingId;
    int rating;
    String feedback;
    String userId;
    int hotelId;
    Hotel hotel;
}
