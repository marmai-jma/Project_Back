package com.bnpparibas.bddf.projet.media.application;

import com.bnpparibas.bddf.projet.media.domain.Review;
import com.bnpparibas.bddf.projet.media.domain.ReviewNotationRepository;
import com.bnpparibas.bddf.projet.media.domain.ReviewRepository;
import com.bnpparibas.bddf.projet.media.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ReviewNotationRepository reviewNotationRepository;
    @Autowired
    private UserRepository userRepository;

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

    public void addNotation(Long reviewId, Boolean useful, String userLogin){
        reviewNotationRepository.saveOrUpdate(reviewId, useful, userRepository.findByLogin(userLogin).getId());
    }
}
