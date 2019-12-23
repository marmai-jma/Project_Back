package com.bnpparibas.bddf.projet.media.exposition;

import com.bnpparibas.bddf.projet.media.domain.User;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserAdapter {
    public UserAdapter() {}

    public static User transformToUser (UserDTO userDTO){
        String id = (userDTO.id == null || userDTO.id.trim().equals(""))? UUID.randomUUID().toString() : userDTO.id;

        return new User(id,
                userDTO.login,
                userDTO.password,
                userDTO.userName,
                userDTO.userSurname,
                userDTO.avatarImageURL,
                userDTO.email,
                userDTO.active
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

    public static List<UserDTO> adaptToUserDTOList(List<User> users){
        return users.stream()
                .map(user -> adaptToUserDTO(user))
                .collect(Collectors.toList());
    }
}
