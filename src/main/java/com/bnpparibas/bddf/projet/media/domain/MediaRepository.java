package com.bnpparibas.bddf.projet.media.domain;

import java.util.List;

public interface MediaRepository {
    String save(Media media);
    String update(Media media);
    Media get(String id);
    List<Media> findAll();
    List<Media> findByCategory(Category category);
    void delete(String id);
    List<Media> findAllMediaWithNotation();
}
