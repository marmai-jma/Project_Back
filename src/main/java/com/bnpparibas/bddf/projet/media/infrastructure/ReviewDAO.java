package com.bnpparibas.bddf.projet.media.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewDAO extends JpaRepository<ReviewJPA, String> {
    @Query(value = "SELECT * FROM REVIEW WHERE MEDIAJPA_ID = :mediaId AND  USERJPA_ID = :userId", nativeQuery = true)
    ReviewJPA searchByMediaIdUserId(String mediaId, String userId);
}
