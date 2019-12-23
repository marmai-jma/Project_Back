package com.bnpparibas.bddf.projet.media.application;

import com.bnpparibas.bddf.projet.media.domain.Media;
import com.bnpparibas.bddf.projet.media.domain.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MediaService {
    @Autowired
    private MediaRepository mediaRepository;

    public String create(Media newMedia){
        return this.mediaRepository.save(newMedia);
    }

    public Media obtain(String id){
        return this.mediaRepository.get(id);
    }

    public List<Media> listAll(){
        return this.mediaRepository.findAll();
    }

    public void update(String id, Media mediaToUpdate){
        Media media = obtain(id);
        media.update(mediaToUpdate);
        this.mediaRepository.update(media);
    }

    public void remove(String id){
        obtain(id);
        this.mediaRepository.delete(id);
    }
}
