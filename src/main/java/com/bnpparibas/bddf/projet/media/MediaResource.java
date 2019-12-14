package com.bnpparibas.bddf.projet.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MediaResource {

    @Autowired
    private MediaService mediaService;

    @RequestMapping(method= RequestMethod.GET, path={"/medias"})
    public List<MediaDTO> listAllMedias(){
        return MediaAdapter.adaptToMediaDTOList(this.mediaService.listAll());
    }
}
