package com.bnpparibas.bddf.projet.media.domain;

import java.util.List;

public interface UserRepository {
    Long save(User user);
    Long update(User user);
    User get(Long id);
    List<User> findAll();
    User findByLogin(String login);
}
