package com.bnpparibas.bddf.projet.media.infrastructure;

        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;

        import java.util.Optional;

public interface MediaNotationDAO extends JpaRepository<MediaNotationJPA, String> {

    @Query(value = "SELECT * FROM MEDIA_NOTATION WHERE MEDIAJPA_ID = :mediaId AND  USERJPA_ID = :userId", nativeQuery = true)
    MediaNotationJPA searchByMediaIdUserId(String mediaId, String userId);
}
