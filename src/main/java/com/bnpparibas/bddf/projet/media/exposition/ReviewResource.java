package com.bnpparibas.bddf.projet.media.exposition;

import com.bnpparibas.bddf.projet.media.application.ReviewService;
import com.bnpparibas.bddf.projet.media.exposition.dto.ReviewDTO;
import com.bnpparibas.bddf.projet.media.exposition.dto.ReviewNotationFormDTO;
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
    public ReviewDTO detailReview(@PathVariable("reviewId") Long reviewId ){
        return ReviewAdapter.adaptToReviewDTO(this.reviewService.obtain(reviewId));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = {"/reviews/{reviewId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeReview(@PathVariable("reviewId") Long reviewId) {
        this.reviewService.remove(reviewId);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/reviews/{reviewId}/notation/{userLogin}"})
    public void addNotation(@PathVariable("reviewId") Long reviewId, @RequestBody ReviewNotationFormDTO reviewNotationFormDTO, @PathVariable("userLogin") String userLogin) {
        this.reviewService.addNotation(reviewId, reviewNotationFormDTO.isUseful(), userLogin);
    }
}
