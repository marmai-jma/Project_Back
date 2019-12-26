package com.bnpparibas.bddf.projet.media.application;

import com.bnpparibas.bddf.projet.media.domain.Review;
import com.bnpparibas.bddf.projet.media.domain.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public long create(Review newReview){
        return this.reviewRepository.save(newReview);
    }

    public Review obtain(long id){
        return this.reviewRepository.get(id);
    }

    public List<Review> listAll(){
        return this.reviewRepository.findAll();
    }

    public void update(long id, Review reviewToUpdate){
        Review review = obtain(id);
        review.update(reviewToUpdate);
        this.reviewRepository.save(review);
    }

    public void remove(long id){
        obtain(id);
        this.reviewRepository.delete(id);
    }
}
