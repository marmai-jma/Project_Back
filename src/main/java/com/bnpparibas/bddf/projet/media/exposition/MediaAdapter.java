package com.bnpparibas.bddf.projet.media.exposition;

import com.bnpparibas.bddf.projet.media.domain.Media;
import com.bnpparibas.bddf.projet.media.domain.MediaNotation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                mediaDTO.publicationDate,
                mediaDTO.likesTotalNumber,
                mediaDTO.dislikesTotalNumber,
                null
        );
    }

    public static MediaDTO adaptToMediaDTO(Media media){
        Set<MediaNotationDTOMedia> notationDTOMedias = null;
        if (media.getMediaNotations() != null) {
            notationDTOMedias = media.getMediaNotations().stream()
                    .map(mediaNotation -> new MediaNotationDTOMedia(mediaNotation.getId(), mediaNotation.isLiked(), mediaNotation.getUser().getId()))
                    .collect(Collectors.toSet());
        }
        return new MediaDTO(media.getId(),
                media.getLabel(),
                media.getCategory(),
                media.getType(),
                media.getAuthorName(),
                media.getAuthorSurname(),
                media.getDescription(),
                media.getMediaImageURL(),
                media.getPublicationDate(),
                media.getLikesTotalNumber(),
                media.getDislikesTotalNumber(),
                notationDTOMedias);
    }

    public static List<MediaDTO> adaptToMediaDTOList(List<Media> medias){
        return medias.stream()
                .map(media -> adaptToMediaDTO(media))
                .collect(Collectors.toList());
    }
}
