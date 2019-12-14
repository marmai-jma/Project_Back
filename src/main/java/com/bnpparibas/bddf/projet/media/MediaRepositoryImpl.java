package com.bnpparibas.bddf.projet.media;

import com.bnpparibas.bddf.projet.media.exception.ErrorCodes;
import com.bnpparibas.bddf.projet.media.exception.ProjectApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
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
    public Media get(String id) {
        return mediaDAO.findById(id)
                .map(mediaJPA -> mediaJPA.toMedia())
                .orElseThrow(() -> new ProjectApplicationException(ErrorCodes.NOT_FOUND));
    }

    @Override
    public List<Media> findAll() {
        return mediaDAO
                .findAll()
                .stream()
                .map(mediaJPA -> mediaJPA.toMedia())
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        mediaDAO.deleteById(id);
    }
}
