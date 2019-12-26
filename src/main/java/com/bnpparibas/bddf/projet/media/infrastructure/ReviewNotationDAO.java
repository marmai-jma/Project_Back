package com.bnpparibas.bddf.projet.media.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewNotationDAO extends JpaRepository<ReviewNotationJPA, String> {

    @Query(value = "SELECT * FROM REVIEW_NOTATION WHERE REVIEWJPA_ID = :reviewId AND  USERJPA_ID = :userId", nativeQuery = true)
    ReviewNotationJPA searchByReviewIdUserId(Long reviewId, Long userId);
}
