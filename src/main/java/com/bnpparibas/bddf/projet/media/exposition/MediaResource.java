package com.bnpparibas.bddf.projet.media.exposition;

import com.bnpparibas.bddf.projet.media.application.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @RequestMapping(method = RequestMethod.POST, path = {"/medias"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createMedia(@Valid @RequestBody MediaDTO mediaDTO) {
        this.mediaService.create(MediaAdapter.transformToMedia(mediaDTO));
    }

    @RequestMapping(method = RequestMethod.PUT, path = {"/medias/{mediaId}"})
    public void updateMedia(@PathVariable("mediaId") String mediaId, @RequestBody MediaDTO mediaDTO) {
        this.mediaService.update(mediaId, MediaAdapter.transformToMedia(mediaDTO));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = {"/medias/{mediaId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeMedia(@PathVariable("mediaId") String mediaId) {
        this.mediaService.remove(mediaId);
    }
}
