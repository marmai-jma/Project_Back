package com.bnpparibas.bddf.projet.media.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewDAO extends JpaRepository<ReviewJPA, Long> {
    @Query(value = "SELECT * FROM REVIEW WHERE MEDIAJPA_ID = :mediaId AND  USERJPA_ID = :userId", nativeQuery = true)
    ReviewJPA searchByMediaIdUserId(String mediaId, Long userId);

    @Query(value = "SELECT * FROM REVIEW WHERE MEDIAJPA_ID = :mediaId", nativeQuery = true)
    List<ReviewJPA> searchByMediaId (String mediaId);
}
