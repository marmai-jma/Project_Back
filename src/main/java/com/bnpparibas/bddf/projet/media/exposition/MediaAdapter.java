package com.bnpparibas.bddf.projet.media.exposition;

import com.bnpparibas.bddf.projet.media.domain.Media;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public final class MediaAdapter {
    private MediaAdapter() {}

    public static Media transformToMedia (MediaDTO mediaDTO){
        String id = (mediaDTO.id == null || mediaDTO.id.trim().equals(""))? UUID.randomUUID().toString() : mediaDTO.id;

        return new Media(id,
                mediaDTO.label,
                mediaDTO.category,
                mediaDTO.type,
                mediaDTO.authorName,
                mediaDTO.authorSurname,
                mediaDTO.description,
                mediaDTO.mediaImageURL,
                mediaDTO.publicationDate);
    }

    public static MediaDTO adaptToMediaDTO(Media media){
        return new MediaDTO(media.getId(),
                media.getLabel(),
                media.getCategory(),
                media.getType(),
                media.getAuthorName(),
                media.getAuthorSurname(),
                media.getDescription(),
                media.getMediaImageURL(),
                media.getPublicationDate());
    }

    public static List<MediaDTO> adaptToMediaDTOList(List<Media> medias){
        return medias.stream()
                .map(media -> adaptToMediaDTO(media))
                .collect(Collectors.toList());
    }
}
