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
    public void saveOrUpdate(String mediaId, String comment, String userId) {
            ReviewJPA reviewJPA = reviewDAO.searchByMediaIdUserId(mediaId, userId);
            if (reviewJPA != null) {
                reviewJPA.setComment(comment);
                reviewDAO.save(reviewJPA);
            } else {
                reviewDAO.save(new ReviewJPA(comment, mediaDAO.findById(mediaId).get(), userDAO.findById(userId).get()));
            }
    }

    @Override
    public String save(Review review) {
        ReviewJPA reviewJPA = reviewDAO.save(new ReviewJPA(review));
        return reviewJPA.getId();
    }

    @Override
    public String update(Review review) {
        return null;
    }

    @Override
    public Review get(String id) {
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
    public void delete(String id) {
        reviewDAO.deleteById(id);
    }
}
