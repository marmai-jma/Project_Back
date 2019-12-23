package com.bnpparibas.bddf.projet.media.infrastructure;

import com.bnpparibas.bddf.projet.media.domain.User;
import com.bnpparibas.bddf.projet.media.domain.UserRepository;
import com.bnpparibas.bddf.projet.media.domain.exception.ErrorCodes;
import com.bnpparibas.bddf.projet.media.domain.exception.ProjectApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserDAO userDAO;

    @Override
    public String save(User user) {
        UserJPA userJPA = userDAO.save(new UserJPA(user));
        return userJPA.getId();
    }

    @Override
    public User get(String id) {
        return userDAO.findById(id)
                .map(userJPA -> new User(userJPA))
                .orElseThrow(() -> new ProjectApplicationException(ErrorCodes.NOT_FOUND));
    }

    @Override
    public List<User> findAll() {
        return userDAO
                .findAll()
                .stream()
                .map(userJPA -> new User(userJPA))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
            userDAO.deleteById(id);
        }

}
