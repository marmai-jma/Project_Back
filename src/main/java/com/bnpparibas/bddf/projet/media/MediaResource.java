package com.bnpparibas.bddf.projet.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MediaResource {

    @Autowired
    private MediaService mediaService;

    @RequestMapping(method= RequestMethod.GET, path={"/medias"})
    public List<MediaDTO> listAllMedias(){
        return MediaAdapter.adaptToMediaDTOList(this.mediaService.listAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/medias/{mediaId}"})
    public MediaDTO detailMedia(@PathVariable("mediaId") String mediaId ){
       return MediaAdapter.adaptToMediaDTO(this.mediaService.obtain(mediaId));
    }
}
