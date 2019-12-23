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
                null
        );
    }

    public static MediaDTO adaptToMediaDTO(Media media){
        Set<MediaNotationDTOUser> mediaNotationDTOs = null;
        if (media.getMediaNotations() != null) {
            mediaNotationDTOs = media.getMediaNotations().stream()
                    .map(mediaNotation -> new MediaNotationDTOUser(mediaNotation.getId(), mediaNotation.isLiked(),
                            new UserDTO(mediaNotation.getUser().getId(),
                                    mediaNotation.getUser().getLogin(),
                                    mediaNotation.getUser().getPassword(),
                                    mediaNotation.getUser().getUserName(),
                                    mediaNotation.getUser().getUserSurname(),
                                    mediaNotation.getUser().getAvatarImageURL(),
                                    mediaNotation.getUser().getEmail(),
                                    mediaNotation.getUser().isActive(), null)))
                    .collect(Collectors.toSet());
        }
        int likesNumber = media.getLikesNumber();
        return new MediaDTO(media.getId(),
                media.getLabel(),
                media.getCategory(),
                media.getType(),
                media.getAuthorName(),
                media.getAuthorSurname(),
                media.getDescription(),
                media.getMediaImageURL(),
                media.getPublicationDate(),
                likesNumber,
                media.getNotationNumber() - likesNumber,
                mediaNotationDTOs);
    }

    public static List<MediaDTO> adaptToMediaDTOList(List<Media> medias){
        return medias.stream()
                .map(media -> adaptToMediaDTO(media))
                .collect(Collectors.toList());
    }
}
