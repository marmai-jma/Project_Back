package com.bnpparibas.bddf.projet.media.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MediaDAO extends JpaRepository<MediaJPA, String> {
    @Query(value = "SELECT ID, AUTHOR_NAME, AUTHOR_SURNAME, CATEGORY, DESCRIPTION, LABEL, MEDIA_IMAGE_URL, PUBLICATION_DATE, TYPE  FROM MEDIA join MEDIA_NOTATION on media.id=media_notation.mediajpa_id group by media.id", nativeQuery = true)
    List<MediaJPA> searchMediaWithNotation();
}
