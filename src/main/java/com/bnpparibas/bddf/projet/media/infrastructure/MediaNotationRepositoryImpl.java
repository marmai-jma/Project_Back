package com.bnpparibas.bddf.projet.media.infrastructure;

import com.bnpparibas.bddf.projet.media.domain.Media;
import com.bnpparibas.bddf.projet.media.domain.MediaNotation;
import com.bnpparibas.bddf.projet.media.domain.MediaNotationRepository;
import com.bnpparibas.bddf.projet.media.domain.MediaRepository;
import com.bnpparibas.bddf.projet.media.domain.exception.ErrorCodes;
import com.bnpparibas.bddf.projet.media.domain.exception.ProjectApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MediaNotationRepositoryImpl implements MediaNotationRepository {
    @Autowired
    private MediaNotationDAO mediaNotationDAO;
    @Autowired
    private MediaDAO mediaDAO;
    @Autowired
    private UserDAO userDAO;

    @Override
    public void saveOrUpdate(String mediaId, boolean liked, String userId) {
        MediaNotationJPA mediaNotationJPA = mediaNotationDAO.searchByMediaIdUserId(mediaId, userId);
        if (mediaNotationJPA != null) {
            mediaNotationJPA.liked = liked;
            mediaNotationDAO.save(mediaNotationJPA);
        } else {
            mediaNotationDAO.save(new MediaNotationJPA(mediaDAO.findById(mediaId).get(), liked, userDAO.findById(userId).get()));
        }
    }
}
