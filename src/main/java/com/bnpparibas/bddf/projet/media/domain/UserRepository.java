package com.bnpparibas.bddf.projet.media.domain;

import java.util.List;

public interface UserRepository {
    String save(User user);
    String update(User user);
    User get(String id);
    List<User> findAll();
    User findByLogin(String login);
    void delete(String id);
}
