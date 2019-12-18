package com.bnpparibas.bddf.projet.media.infrastructure;

import com.bnpparibas.bddf.projet.media.domain.Review;
import com.bnpparibas.bddf.projet.media.domain.ReviewRepository;
import com.bnpparibas.bddf.projet.media.domain.exception.ErrorCodes;
import com.bnpparibas.bddf.projet.media.domain.exception.ProjectApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {
    @Autowired
    private ReviewDAO reviewDAO;

    @Override
    public String save(Review review) {
        ReviewJPA reviewJPA = reviewDAO.save(new ReviewJPA(review));
        return reviewJPA.getId();
    }

    @Override
    public Review get(String id) {
        return reviewDAO.findById(id)
                .map(reviewJPA -> reviewJPA.toReview())
                .orElseThrow(() -> new ProjectApplicationException(ErrorCodes.NOT_FOUND));
    }

    @Override
    public List<Review> findAll() {
        return reviewDAO
                .findAll()
                .stream()
                .map(reviewJPA -> reviewJPA.toReview())
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        reviewDAO.deleteById(id);
    }
}
