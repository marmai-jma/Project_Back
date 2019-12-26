package com.bnpparibas.bddf.projet.media.exposition;

import com.bnpparibas.bddf.projet.media.domain.Review;
import com.bnpparibas.bddf.projet.media.exposition.dto.ReviewDTO;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ReviewAdapter {

    /*
    public static Review transformToReview (ReviewDTO reviewDTO){
        //String id = (reviewDTO.getId() == null || reviewDTO.getId().trim().equals(""))? UUID.randomUUID().toString() : reviewDTO.getId();

        return new Review(id,
               reviewDTO.getComment(),
                reviewDTO.getReviewDate(),null,null);
    }
*/
    public static ReviewDTO adaptToReviewDTO(Review review){
        return new ReviewDTO(review.getId(),
                review.getComment(),
                review.getReviewDate(),0,0
        );
    }

    public static List<ReviewDTO> adaptToReviewDTOList(List<Review> reviews){
        return reviews.stream()
                .map(review -> adaptToReviewDTO(review))
                .collect(Collectors.toList());
    }
}
