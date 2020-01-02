package com.bnpparibas.bddf.projet.media.exposition;

import com.bnpparibas.bddf.projet.media.domain.Media;
import com.bnpparibas.bddf.projet.media.domain.MediaNotation;
import com.bnpparibas.bddf.projet.media.domain.User;
import com.bnpparibas.bddf.projet.media.exposition.dto.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MediaNotationAdapter {
    public MediaNotationAdapter() {}

    public static MediaNotationLightDTO adaptToMediaNotationDTO(MediaNotation mediaNotation){
        int likesNumber = mediaNotation.getMedia().getLikesNumber();
        int dislikesNumber= mediaNotation.getMedia().getMediaNotationNumber() - likesNumber;
        return new MediaNotationLightDTO(mediaNotation.getId(),
                    mediaNotation.isLiked(),
                    new UserLightDTO(mediaNotation.getUser().getId(),
                            mediaNotation.getUser().getLogin(),
                            mediaNotation.getUser().isActive()),
                    new MediaLightDTO(mediaNotation.getMedia().getId(),
                            mediaNotation.getMedia().getLabel(),
                            mediaNotation.getMedia().getCategory(),
                            mediaNotation.getMedia().getType(),
                            mediaNotation.getMedia().getAuthorName(),
                            mediaNotation.getMedia().getAuthorSurname(),
                            mediaNotation.getMedia().getDescription(),
                            mediaNotation.getMedia().getMediaImageURL(),
                            mediaNotation.getMedia().getPublicationDate(),
                           likesNumber,
                           dislikesNumber));

    }

    public static UserLightDTO adaptToUserLightDTO(User user){
       return new UserLightDTO(user.getId(),
               user.getLogin(),
               user.isActive());
    }
    public static List<UserLightDTO> adaptToUserLightDTOList(List<User> users){
        return users.stream()
                .map(user -> adaptToUserLightDTO(user))
                .collect(Collectors.toList());
    }
}
