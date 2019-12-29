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
    @Autowired
    private MediaDAO mediaDAO;
    @Autowired
    private UserDAO userDAO;

    @Override
    public Review saveOrUpdate(String mediaId, String comment, Long userId) {
            ReviewJPA reviewJPA = reviewDAO.searchByMediaIdUserId(mediaId, userId);
            if (reviewJPA != null) {
                reviewJPA.setComment(comment);
                return reviewDAO.save(reviewJPA).jpaToReview();
            } else {
                return reviewDAO.save(new ReviewJPA(comment, mediaDAO.findById(mediaId).get(), userDAO.findById(userId).get())).jpaToReview();
            }
    }


    @Override
    public long save(Review review) {
        ReviewJPA reviewJPA = reviewDAO.save(new ReviewJPA(review));
        return reviewJPA.getId();
    }


    @Override
    public Review get(Long id) {
        return reviewDAO.findById(id)
                .map(reviewJPA -> reviewJPA.jpaToReview())
                .orElseThrow(() -> new ProjectApplicationException(ErrorCodes.NOT_FOUND));
    }

    @Override
    public List<Review> findAll() {
        return reviewDAO
                .findAll()
                .stream()
                .map(reviewJPA -> reviewJPA.jpaToReview())
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        reviewDAO.deleteById(id);
    }
}
