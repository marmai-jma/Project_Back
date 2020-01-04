package com.bnpparibas.bddf.projet.media.infrastructure;

import com.bnpparibas.bddf.projet.media.domain.MediaRepository;
import com.bnpparibas.bddf.projet.media.domain.Media;
import com.bnpparibas.bddf.projet.media.domain.exception.ErrorCodes;
import com.bnpparibas.bddf.projet.media.domain.exception.ProjectApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MediaRepositoryImpl implements MediaRepository {
    @Autowired
    private MediaDAO mediaDAO;

    @Override
    public String save(Media media) {
        MediaJPA mediaJPA = mediaDAO.save(new MediaJPA(media));
        return mediaJPA.getId();
    }

    @Override
    public String update(Media media) {
        Optional<MediaJPA> mediaJPA = mediaDAO.findById(media.getId());
        if (mediaJPA.isPresent()) {
            return mediaDAO.save(new MediaJPA(media, mediaJPA.get().getMediaNotationsJPA())).getId();
        }
        return null;
    }

    @Override
    public Media get(String id) {
        return mediaDAO.findById(id)
                .map(mediaJPA -> mediaJPA.jpaToMedia())
                .orElseThrow(() -> new ProjectApplicationException(ErrorCodes.NOT_FOUND));
    }

    @Override
    public List<Media> findAll() {
        return mediaDAO
                .findAll()
                .stream()
                .map(mediaJPA -> mediaJPA.jpaToMedia())
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        mediaDAO.deleteById(id);
    }

    @Override
    public List<Media> findAllMediaWithNotation(){
        return mediaDAO
                .searchMediaWithNotation()
                .stream()
                .map(mediaJPA -> mediaJPA.jpaToMedia())
                .collect(Collectors.toList());
    }
}
