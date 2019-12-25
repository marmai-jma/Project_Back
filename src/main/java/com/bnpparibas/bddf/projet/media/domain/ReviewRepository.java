package com.bnpparibas.bddf.projet.media.domain;

import java.util.List;

public interface ReviewRepository {
    String save(Review review);
    String update(Review review);
    Review get(String id);
    List<Review> findAll();
    void delete(String id);
}
