package com.bnpparibas.bddf.projet.media.domain;

import java.util.List;
import java.util.Optional;

public interface MediaNotationRepository {
    void saveOrUpdate(String mediaId, boolean liked, Long userId);
    MediaNotation getByMediaIdUserId(String mediaId, Long userId);
}
