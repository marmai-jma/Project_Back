package com.bnpparibas.bddf.projet.media.exposition;

import com.bnpparibas.bddf.projet.media.domain.Media;
import com.bnpparibas.bddf.projet.media.exposition.dto.MediaDTO;
import com.bnpparibas.bddf.projet.media.exposition.dto.MediaLightDTO;
import com.bnpparibas.bddf.projet.media.exposition.dto.MediaNotationDTOUser;
import com.bnpparibas.bddf.projet.media.exposition.dto.UserDTO;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;


public final class MediaAdapter {
    private MediaAdapter() {}

    public static Media transformToMedia (MediaDTO mediaDTO){
        String id = (mediaDTO.getId() == null || mediaDTO.getId().trim().equals(""))? UUID.randomUUID().toString() : mediaDTO.getId();

        return new Media(id,
                mediaDTO.getLabel(),
                mediaDTO.getCategory(),
                mediaDTO.getType(),
                mediaDTO.getAuthorName(),
                mediaDTO.getAuthorSurname(),
                mediaDTO.getDescription(),
                mediaDTO.getMediaImageURL(),
                mediaDTO.getPublicationDate(),
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

    public static MediaLightDTO adaptToMediaLightDTO(Media media){
        int likesNumber = media.getLikesNumber();
        return new MediaLightDTO(media.getId(),
                media.getLabel(),
                media.getCategory(),
                media.getType(),
                media.getAuthorName(),
                media.getAuthorSurname(),
                media.getDescription(),
                media.getMediaImageURL(),
                media.getPublicationDate(),
                likesNumber,
                media.getNotationNumber() - likesNumber);
    }

    public static List<MediaLightDTO> adaptToMediaLightDTOList(List<Media> medias){
        return medias.stream()
                .map(media -> adaptToMediaLightDTO(media))
                .collect(Collectors.toList());
    }
}
