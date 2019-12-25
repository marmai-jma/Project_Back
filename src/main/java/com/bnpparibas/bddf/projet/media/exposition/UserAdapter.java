package com.bnpparibas.bddf.projet.media.exposition;

import com.bnpparibas.bddf.projet.media.domain.User;
import com.bnpparibas.bddf.projet.media.exposition.dto.MediaDTO;
import com.bnpparibas.bddf.projet.media.exposition.dto.MediaNotationDTOMedia;
import com.bnpparibas.bddf.projet.media.exposition.dto.UserDTO;
import com.bnpparibas.bddf.projet.media.exposition.dto.UserLightDTO;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserAdapter {
    public UserAdapter() {}

    public static User transformToUser (UserDTO userDTO){
        String id = (userDTO.getId() == null || userDTO.getId().trim().equals(""))? UUID.randomUUID().toString() : userDTO.getId();

        return new User(id,
                userDTO.getLogin(),
                userDTO.getPassword(),
                userDTO.getUserName(),
                userDTO.getUserSurname(),
                userDTO.getAvatarImageURL(),
                userDTO.getEmail(),
                userDTO.isActive()
        );
    }

    public static UserDTO adaptToUserDTO(User user){
        Set<MediaNotationDTOMedia> mediaNotationDTOMedia = null;
        if (user.getMediaNotations() != null) {
            mediaNotationDTOMedia = user.getMediaNotations().stream()
                    .map(mediaNotation -> new MediaNotationDTOMedia(mediaNotation.getId(), mediaNotation.isLiked(),
                            new MediaDTO(mediaNotation.getMedia().getId(),
                                    mediaNotation.getMedia().getLabel(),
                                    mediaNotation.getMedia().getCategory(),
                                    mediaNotation.getMedia().getType(),
                                    mediaNotation.getMedia().getAuthorName(),
                                    mediaNotation.getMedia().getAuthorSurname(),
                                    mediaNotation.getMedia().getDescription(),
                                    mediaNotation.getMedia().getMediaImageURL(),
                                    mediaNotation.getMedia().getPublicationDate(),
                                    0,
                                    0,
                                    null)))
                    .collect(Collectors.toSet());
        }

        return new UserDTO(user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getUserName(),
                user.getUserSurname(),
                user.getAvatarImageURL(),
                user.getEmail(),
                user.isActive(),
                mediaNotationDTOMedia);
    }

    public static UserLightDTO adaptToUserLightDTO(User user){
       return new UserLightDTO(user.getId(),
                user.getLogin());
    }
    public static List<UserLightDTO> adaptToUserLightDTOList(List<User> users){
        return users.stream()
                .map(user -> adaptToUserLightDTO(user))
                .collect(Collectors.toList());
    }
}
