package com.bnpparibas.bddf.projet.media.infrastructure;

import com.bnpparibas.bddf.projet.media.domain.MediaNotationRepository;
import com.bnpparibas.bddf.projet.media.domain.ReviewNotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewNotationRepositoryImpl implements ReviewNotationRepository {
    @Autowired
    private ReviewNotationDAO reviewNotationDAO;
    @Autowired
    private ReviewDAO reviewDAO;
    @Autowired
    private UserDAO userDAO;

    @Override
    public void saveOrUpdate(Long reviewId, boolean useful, Long userId) {
        ReviewNotationJPA reviewNotationJPA = reviewNotationDAO.searchByReviewIdUserId(reviewId, userId);
        if (reviewNotationJPA != null) {
            reviewNotationJPA.useful = useful;
            reviewNotationDAO.save(reviewNotationJPA);
        } else {
            reviewNotationDAO.save(new ReviewNotationJPA(reviewDAO.findById(reviewId).get(), useful, userDAO.findById(userId).get()));
        }
    }
}
