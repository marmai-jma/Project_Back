package com.bnpparibas.bddf.projet.media.domain;

import java.util.List;

public interface ReviewRepository {
    void saveOrUpdate(String mediaId, String comment, String userId);
    long save(Review review);
    Review get(Long id);
    List<Review> findAll();
    void delete(Long id);
}
