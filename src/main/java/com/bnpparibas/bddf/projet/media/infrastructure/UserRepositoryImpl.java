package com.bnpparibas.bddf.projet.media.infrastructure;

import com.bnpparibas.bddf.projet.media.domain.User;
import com.bnpparibas.bddf.projet.media.domain.UserRepository;
import com.bnpparibas.bddf.projet.media.domain.exception.ErrorCodes;
import com.bnpparibas.bddf.projet.media.domain.exception.ProjectApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserDAO userDAO;

    @Override
    public Long save(User user) {
        UserJPA userJPA = userDAO.save(new UserJPA(user));
        return userJPA.getId();
    }

   @Override
   public Long update(User user) {
       Optional<UserJPA> userJPA = userDAO.findById(user.getId());
       if (userJPA.isPresent()) {
           return userDAO.save(new UserJPA(user, userJPA.get().getMediaNotationsJPA())).getId();
       }
       return null;
   }


    @Override
    public User get(Long id) {
        return userDAO.findById(id)
                .map(userJPA -> userJPA.jpatoUser())
                .orElseThrow(() -> new ProjectApplicationException(ErrorCodes.NOT_FOUND));
    }

    @Override
    public List<User> findAll() {
        return userDAO
                .findAll()
                .stream()
                .map(userJPA -> userJPA.jpatoUser())
                .collect(Collectors.toList());
    }

    @Override
    public User findByLogin(String login) {
        return userDAO.findByLogin(login)
                .map(userJPA -> userJPA.jpatoUser())
                .orElseThrow(() -> new ProjectApplicationException(ErrorCodes.NOT_FOUND));
    }

}
