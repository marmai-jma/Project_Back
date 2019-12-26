package com.bnpparibas.bddf.projet.media.domain;

public interface ReviewNotationRepository {
    void saveOrUpdate(Long reviewId, boolean useful, Long userId);
}
