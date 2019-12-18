package com.bnpparibas.bddf.projet.media.exposition;

import com.bnpparibas.bddf.projet.media.domain.Review;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ReviewAdapter {

    public static Review transformToReview (ReviewDTO reviewDTO){
        String id = (reviewDTO.id == null || reviewDTO.id.trim().equals(""))? UUID.randomUUID().toString() : reviewDTO.id;

        return new Review(id,
               reviewDTO.comment,
                reviewDTO.reviewDate);
    }

    public static ReviewDTO adaptToReviewDTO(Review review){
        return new ReviewDTO(review.getId(),
                review.getComment(),
                review.getReviewDate(),
                review.getUsefulTotalNumber(),
                review.getUselessTotalNumber()
        );
    }

    public static List<ReviewDTO> adaptToReviewDTOList(List<Review> reviews){
        return reviews.stream()
                .map(review -> adaptToReviewDTO(review))
                .collect(Collectors.toList());
    }
}
