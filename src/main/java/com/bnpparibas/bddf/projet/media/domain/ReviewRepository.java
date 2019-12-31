package com.bnpparibas.bddf.projet.media.domain;

import java.util.List;

public interface ReviewRepository {
    Review saveOrUpdate(String mediaId, String comment, Long userId);
    void removeViaMediaByUser(String mediaId, Long userId);
    List<Review> searchByMediaId(String mediaId);
    long save(Review review);
    Review get(Long id);
    List<Review> findAll();
    void delete(Long id);
}
