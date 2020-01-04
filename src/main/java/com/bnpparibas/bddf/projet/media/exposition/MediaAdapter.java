package com.bnpparibas.bddf.projet.media.exposition;

        import com.bnpparibas.bddf.projet.media.domain.Media;
        import com.bnpparibas.bddf.projet.media.exposition.dto.*;

        import java.util.*;
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
                null,
                null);
    }

    public static MediaDTO adaptToMediaDTO(Media media){
        Set<MediaNotationDTOUser> mediaNotationDTOs = null;
        if (media.getMediaNotations() != null) {
            mediaNotationDTOs = media.getMediaNotations().stream()
                    .map(mediaNotation -> new MediaNotationDTOUser(mediaNotation.getId(), mediaNotation.isLiked(),
                            new UserLightDTO(mediaNotation.getUser().getId(),
                                    mediaNotation.getUser().getLogin(),
                                    mediaNotation.getUser().isActive())))
                    .collect(Collectors.toSet());
        }
        Set<ReviewDTO> reviewDTOS = null;
        if (media.getReviews() != null) {
            reviewDTOS = media.getReviews().stream()
                    .map(review -> new ReviewDTO(review.getId(), review.getComment(), review.getReviewDate(), review.getUsefulNumber(), review.getUselessNumber(),
                            new UserLightDTO(review.getUser().getId(),
                                    review.getUser().getLogin(),
                                    review.getUser().isActive())))
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
                media.getMediaNotationNumber() - likesNumber,
                mediaNotationDTOs,
                reviewDTOS);
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
                media.getMediaNotationNumber() - likesNumber);
    }

    public static MediaRecoLightDTO adaptToMediaRecoLightDTO(Media media){
        float likesNumber = media.getLikesNumber();
        float mediaNotationNumber = media.getMediaNotationNumber();
        int notation =  Math.round(likesNumber * likesNumber / mediaNotationNumber*100);
        System.out.println(likesNumber);
        System.out.println(mediaNotationNumber);
        System.out.println(notation);
        return new MediaRecoLightDTO(1,
                media.getLabel(),
                media.getCategory(),
                media.getType(),
                notation);
    }

    public static List<MediaRecoLightDTO> adaptToMediaRecoLightDTOList (List<Media> medias){
        List<MediaRecoLightDTO> mediaRecos = medias.stream()
                .map(media -> adaptToMediaRecoLightDTO(media))
                .collect(Collectors.toList());

        mediaRecos.sort(Comparator.comparing(MediaRecoLightDTO::getNotation).reversed());

        for ( int i = 0; i < mediaRecos.size (); i++) { mediaRecos.get(i).setNumReco(i+1);} ;

        return mediaRecos;
    }

    public static List<MediaLightDTO> adaptToMediaLightDTOList(List<Media> medias){
        return medias.stream()
                .map(media -> adaptToMediaLightDTO(media))
                .collect(Collectors.toList());
    }
}
