package com.bnpparibas.bddf.projet.media;

import java.util.List;

public interface MediaRepository {
    String save(Media media);
    Media get(String id);
    List<Media> findAll();
    void delete(String id);
}
