package com.bnpparibas.bddf.projet.media.exposition;

import com.bnpparibas.bddf.projet.media.application.ReviewService;
import com.bnpparibas.bddf.projet.media.exposition.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewResource {
    @Autowired
    private ReviewService reviewService;

    @RequestMapping(method= RequestMethod.GET, path={"/reviews"})
    public List<ReviewDTO> listAllReviews(){
        return ReviewAdapter.adaptToReviewDTOList(this.reviewService.listAll());
    }


    @RequestMapping(method = RequestMethod.GET, path = {"/reviews/{reviewId}"})
    public ReviewDTO detailReview(@PathVariable("reviewId") String reviewId ){
        return ReviewAdapter.adaptToReviewDTO(this.reviewService.obtain(reviewId));
    }
/*
    @RequestMapping(method = RequestMethod.POST, path = {"/reviews"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createReview(@Valid @RequestBody ReviewDTO reviewDTO) {
        this.reviewService.create(ReviewAdapter.transformToReview(reviewDTO));
    }

    @RequestMapping(method = RequestMethod.PUT, path = {"/reviews/{reviewId}"})
    public void updateReview(@PathVariable("reviewId") String reviewId, @RequestBody ReviewDTO reviewDTO) {
        this.reviewService.update(reviewId, ReviewAdapter.transformToReview(reviewDTO));
    }
*/
    @RequestMapping(method = RequestMethod.DELETE, path = {"/reviews/{reviewId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeReview(@PathVariable("reviewId") String reviewId) {
        this.reviewService.remove(reviewId);
    }
}
